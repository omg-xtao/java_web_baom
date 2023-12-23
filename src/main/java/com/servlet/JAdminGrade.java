package com.servlet;

import com.dao.GradeDao;
import com.dao.impl.GradeImpl;
import com.entity.Grade;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.util.Message;
import com.util.PageModel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author xtaod
 */
@WebServlet("/jadmin/gradeinput.do")
public class JAdminGrade extends HttpServlet {
    ArrayList<Grade> grades;

    private XSSFWorkbook getSheet(File file) {
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return wb;
    }

    private Grade getOrCreate(GradeDao gradeDao, String testCardNum, String cName) {
        Grade grade = gradeDao.findByTestcardnumAndCname(testCardNum, cName);
        if (grade == null) {
            grade = new Grade();
            grade.setTestcardnum(testCardNum);
            grade.setCname(cName);
        }
        return grade;
    }

    private PageModel createPageModel(HttpServletRequest request) {
        int pageSize = request.getParameter("pageSize") == null ? 5 : Integer.parseInt(request.getParameter("pageSize"));
        int pageNo = request.getParameter("pageNo") == null ? 1 : Integer.parseInt(request.getParameter("pageNo"));
        if (grades == null) {
            GradeDao gradeDao = new GradeImpl();
            grades = gradeDao.queryAll();
        }
        PageModel pm = new PageModel(pageSize, pageNo, null, null, grades);
        pm.setPageNav(request.getRequestURI());
        return pm;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SmartUpload upload = new SmartUpload();
        upload.initialize(this.getServletConfig(), request, response);
        upload.setAllowedFilesList("xlsx");
        File temp = File.createTempFile("grade", ".xlsx");
        try {
            upload.upload();
            Files files = upload.getFiles();
            files.getFile(0).saveAs(temp.getAbsolutePath(), SmartUpload.SAVE_PHYSICAL);
        } catch (SmartUploadException e1) {
            e1.printStackTrace();
        }
        GradeDao gradeDao = new GradeImpl();
        XSSFWorkbook wb = getSheet(temp);
        temp.delete();
        XSSFSheet sheet = wb.getSheetAt(0);
        for (int row = 1; row <= sheet.getLastRowNum(); row++) {
            String testCardNum = sheet.getRow(row).getCell(1).getStringCellValue();
            String cName = sheet.getRow(row).getCell(3).getStringCellValue();
            Grade grade = getOrCreate(gradeDao, testCardNum, cName);
            grade.setSname(sheet.getRow(row).getCell(2).getStringCellValue());
            grade.setScore((float) sheet.getRow(row).getCell(4).getNumericCellValue());
            grade.setNote(sheet.getRow(row).getCell(5).getStringCellValue());
            if (grade.getGradeid() != null) {
                gradeDao.update(grade);
            } else {
                gradeDao.add(grade);
            }
        }
        grades = gradeDao.queryAll();
        PageModel pm = createPageModel(request);
        request.setAttribute("pm", pm);
        request.getSession().setAttribute("mess", new Message("gradeMess", "成绩录入成功"));
        request.getRequestDispatcher("/jadmin/grade.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageModel pm = createPageModel(req);
        req.setAttribute("pm", pm);
        req.getRequestDispatcher("/jadmin/grade.jsp").forward(req, resp);
    }
}
