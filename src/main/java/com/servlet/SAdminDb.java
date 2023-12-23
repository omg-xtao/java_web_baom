package com.servlet;


import com.db.ConnectionFactory;
import com.jspsmart.upload.SmartUpload;
import com.util.HttpServletInit;
import com.util.Message;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xtaod
 */
@WebServlet("/sadmin/db.do")
public class SAdminDb extends HttpServletInit {
    private void backUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = request.getServletContext();
        String path = context.getRealPath("/sadmin/backup/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        HttpSession session = request.getSession();
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = format.format(date);
        Runtime runtime = Runtime.getRuntime();
        String command = "cmd /c mysqldump -u" + ConnectionFactory.USER + " -p" + ConnectionFactory.PASSWORD + " -h" + ConnectionFactory.HOST + " --column-statistics=0 eers > " + file.getAbsolutePath() + "\\" + time + ".sql";
        Process process = runtime.exec(command);
        try {
            int tag = process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            if (tag == 0) {
                session.setAttribute("mess", new Message("backupMess", "备份成功"));
            } else {
                session.setAttribute("mess", new Message("backupMess", "备份失败"));
            }
            SmartUpload su = new SmartUpload();
            su.initialize(this.getServletConfig(), request, response);
            su.setContentDisposition(null);
            su.downloadFile("/sadmin/backup/" + time + ".sql");
            response.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void restore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();
        Runtime runtime = Runtime.getRuntime();
        String relative = "/sadmin/backup/";
        File file1 = new File(servletContext.getRealPath(relative));
        if (!file1.exists()) {
            file1.mkdirs();
        }
        SmartUpload su = new SmartUpload();
        String message = null;
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = format.format(date);
        try {
            su.initialize(getServletConfig(), request, response);
            su.setMaxFileSize(1000000);
            su.setAllowedFilesList("sql");
            su.upload();
            com.jspsmart.upload.File file = su.getFiles().getFile(0);
            if (file.isMissing()) {
                message = "*请先选择要上传的文件";
            } else {
                file.saveAs(relative + time + ".sql", SmartUpload.SAVE_VIRTUAL);
                message = "*上传成功!";
            }
        } catch (SecurityException e) {
            if (e.getMessage().trim().matches("(.*)1010.$")) {
                message = "*上传的文件类型不正确!";
            } else if (e.getMessage().trim().matches("(.*)1105.$")) {
                message = "*文件大小超出了1M!";
            } else {
                message = "*上传错误!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String command = "cmd /c mysql -u" + ConnectionFactory.USER + " -p" + ConnectionFactory.PASSWORD + " -h" + ConnectionFactory.HOST + " eers < \"" + file1.getAbsolutePath() + "\\" + time + ".sql\"";
        Process process = runtime.exec(command);
        try {
            int tag = process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            if (tag == 0) {
                session.setAttribute("mess", new Message("restoreMess", "还原成功"));
            } else {
                session.setAttribute("mess", new Message("restoreMess", message + " 还原失败"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(servletContext.getContextPath() + "/sadmin/db.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("backup".equals(action)) {
            backUp(req, resp);
        } else if ("restore".equals(action)) {
            restore(req, resp);
        }
    }
}
