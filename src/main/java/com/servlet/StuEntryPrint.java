package com.servlet;

import com.dao.ReginfoDao;
import com.dao.impl.ReginfoDaoImpl;
import com.entity.Reginfo;
import com.util.EntryGenXlsx;
import com.util.HttpServletInit;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xtaod
 */
@WebServlet("/stu/entryPrint.do")
public class StuEntryPrint extends HttpServletInit {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String username = req.getSession().getAttribute("username").toString();
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        Reginfo reginfo = reginfoDao.findByUser(username);
        if (reginfo.getPhoto() != null && !reginfo.getPhoto().isEmpty()) {
            ServletContext context = req.getServletContext();
            EntryGenXlsx entryGenXlsx = new EntryGenXlsx(context.getRealPath("/"), null, username);
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "inline;filename=" + username + ".pdf");
            ServletOutputStream outputStream = response.getOutputStream();
            entryGenXlsx.get(outputStream);
            outputStream.close();
        }
    }
}
