package com.servlet;

import com.dao.ReginfoDao;
import com.dao.impl.ReginfoDaoImpl;
import com.entity.Reginfo;
import com.util.CardGenXlsx;
import com.util.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author xtaod
 */
@WebServlet("/jadmin/room.do")
public class JAdminRoomNum extends HttpServlet {

    private void assign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("perRoom"));
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        ArrayList<Reginfo> regs = reginfoDao.findAll(true);
        int totalNumber = regs.size();
        request.getSession().setAttribute("perRoom", number);
        int remain = totalNumber % number;
        int roomNum = remain == 0 ? totalNumber / number : totalNumber / number + 1;
        request.setAttribute("room", roomNum);
        request.setAttribute("perroom", number);
        request.setAttribute("remain", remain == 0 ? number : remain);
        request.getRequestDispatcher("/jadmin/assignroom.jsp").forward(request, response);
    }

    private void assure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReginfoDao reginfoDao = new ReginfoDaoImpl();
        ArrayList<Reginfo> regsAssure = reginfoDao.findAll(true);
        int number = (Integer) request.getSession().getAttribute("perRoom");
        String[] rooms = request.getParameterValues("rooms");
        Iterator<Reginfo> regIter = regsAssure.iterator();
        int exameNum = 1;
        for (String room : rooms) {
            for (int i = 1; i <= number; i++) {
                if (!regIter.hasNext()) {
                    break;
                }
                Reginfo tempReg = regIter.next();
                tempReg.setExamroom(exameNum + "-" + room);
                tempReg.setSeatnum(i);
                reginfoDao.update(tempReg);
            }
            exameNum++;
        }
        (new CardGenXlsx(request.getServletContext().getRealPath("/"), null, null)).deleteAll();
        request.getSession().setAttribute("mess", new Message("assignRoomMess", "分配成功"));
        request.getRequestDispatcher("/jadmin/assignroom.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "assign":
                assign(req, resp);
                break;
            case "assure":
                assure(req, resp);
                break;
            default:
                break;
        }
    }
}
