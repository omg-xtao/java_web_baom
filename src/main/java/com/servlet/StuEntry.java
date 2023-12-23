package com.servlet;

import com.dao.ReginfoDao;
import com.dao.StuDao;
import com.dao.impl.ReginfoDaoImpl;
import com.dao.impl.StuDaoImpl;
import com.entity.Reginfo;
import com.entity.Stu;
import com.util.BeanUtil;
import com.util.EntryGenXlsx;
import com.util.HttpServletInit;
import com.util.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xtaod
 */
@WebServlet("/stu/entry.do")
public class StuEntry extends HttpServletInit {
    private void updateOrInsert(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        StuDao stuDao = new StuDaoImpl();
        String username = request.getSession().getAttribute("username").toString();
        Stu stu = stuDao.findByUsername(username);
        Reginfo reginfo = reginfoDao.findByUser(username);
        boolean insert = false;
        if (reginfo == null) {
            insert = true;
            reginfo = new Reginfo();
            reginfo.setUserid(stu.getUserid());
            reginfo.setUsername(stu.getUsername());
        }
        BeanUtil.beanToBean(reginfo, request.getParameterMap());
        reginfo.setIsconfirm(false);
        int result;
        if (insert) {
            result = reginfoDao.add(reginfo);
        } else {
            result = reginfoDao.update(reginfo);
        }
        HttpSession session = request.getSession();
        if (result != 0) {
            initMajor(request);
            session.setAttribute("mess", new Message("stuEntryMess", "修改信息成功！"));
        } else {
            session.setAttribute("mess", new Message("stuEntryMess", "修改信息失败！"));
        }
        request.setAttribute("reginfo", reginfoDao.findByUser(username));
        request.getRequestDispatcher("/stu/entry.jsp").forward(request, resp);
        if (result != 0 && reginfo.getPhoto() != null && !reginfo.getPhoto().isEmpty()) {
            EntryGenXlsx entryGenXlsx = new EntryGenXlsx(getServletContext().getRealPath("/"), reginfo.getPhoto(), username);
            entryGenXlsx.gen(reginfo, request);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("entry".equals(action)) {
            updateOrInsert(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReginfoDao reginfo = new ReginfoDaoImpl();
        String username = req.getSession().getAttribute("username").toString();
        req.setAttribute("reginfo", reginfo.findByUser(username));
        req.getRequestDispatcher("/stu/entry.jsp").forward(req, resp);
    }
}
