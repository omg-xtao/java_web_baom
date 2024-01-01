package com.servlet;

import com.dao.ReginfoDao;
import com.dao.impl.ReginfoDaoImpl;
import com.entity.Reginfo;
import com.util.CardGenXlsx;
import com.util.HttpServletInit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xtaod
 */
@WebServlet("/stu/cardPrint.do")
public class StuCardPrint extends HttpServletInit {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
        String realPath = req.getServletContext().getRealPath("/");
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        Reginfo reginfo = reginfoDao.findByUser(username);
        if (reginfo == null) {
            return;
        }
        CardGenXlsx cardGenXlsx = new CardGenXlsx(realPath, reginfo.getPhoto(), username);
        cardGenXlsx.gen(reginfo, req);
        cardGenXlsx.get(resp.getOutputStream());
    }
}
