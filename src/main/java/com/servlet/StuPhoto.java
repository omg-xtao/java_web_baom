package com.servlet;

import com.dao.ReginfoDao;
import com.dao.impl.ReginfoDaoImpl;
import com.entity.Reginfo;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author xtaod
 */
@WebServlet("/stu/photo.do")
public class StuPhoto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filePath = getServletContext().getRealPath("/") + "upload";
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        SmartUpload upload = new SmartUpload();
        upload.initialize(this.getServletConfig(), request, response);
        upload.setAllowedFilesList("jpg, JPG");
        try {
            upload.upload();
            String filename = "/upload/" + username + ".jpg";
            Files files = upload.getFiles();
            files.getFile(0).saveAs(filename, SmartUpload.SAVE_VIRTUAL);
        } catch (SmartUploadException e1) {
            e1.printStackTrace();
        }
        ReginfoDao regDao = new ReginfoDaoImpl();
        Reginfo reginfo = regDao.findByUser(username);
        if (reginfo != null) {
            reginfo.setPhoto(username + ".jpg");
            regDao.update(reginfo);
        }
        request.getRequestDispatcher("/stu/photo.jsp").forward(request, response);
    }
}
