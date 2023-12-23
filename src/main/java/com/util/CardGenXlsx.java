package com.util;

import com.entity.Reginfo;
import com.entity.School;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author xtaod
 */
public class CardGenXlsx {
    String realPath;
    String photo;
    String username;
    public static String path = "WEB-INF/resources/zkz.xlsx";
    public static String pdfPath = "/upload/zkz/";

    public CardGenXlsx(String realPath, String photo, String username) {
        this.realPath = realPath;
        this.photo = photo;
        this.username = username;
    }

    public void inputTextToXlsx(XSSFWorkbook wb, Reginfo reginfo, School school) {
        XSSFSheet sheet = wb.getSheetAt(0);

        String title = school.getShyear() + "年 " + school.getShname() + " " + school.getShtest() + " 考试";
        sheet.getRow(0).getCell(0).setCellValue(title);

        sheet.getRow(2).getCell(2).setCellValue(reginfo.getUserid());
        sheet.getRow(3).getCell(2).setCellValue(reginfo.getSname());
        sheet.getRow(4).getCell(2).setCellValue(reginfo.getSsex());
        sheet.getRow(5).getCell(2).setCellValue(reginfo.getIdcode());
        sheet.getRow(6).getCell(2).setCellValue(reginfo.getMname());
        sheet.getRow(7).getCell(2).setCellValue(reginfo.getTestcardnum());
        sheet.getRow(8).getCell(2).setCellValue(school.getShname());
        sheet.getRow(9).getCell(2).setCellValue(school.getShaddr());
        sheet.getRow(10).getCell(2).setCellValue(school.getShyear());
        sheet.getRow(11).getCell(2).setCellValue(school.getShname());
        sheet.getRow(12).getCell(2).setCellValue(reginfo.getExamroom());
        sheet.getRow(13).getCell(2).setCellValue(reginfo.getSeatnum());
    }

    public void inputPhotoToXlsx(XSSFWorkbook wb) {
        // 读取图片
        BufferedImage bufferImg;
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        File f = new File(realPath + "/upload/" + photo);

        try {
            bufferImg = ImageIO.read(f);
            ImageIO.write(bufferImg, "jpg", byteArrayOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFDrawing patriarch = sheet.createDrawingPatriarch();
        //anchor主要用于设置图片的属性
        XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 255, 255, 7, 2, 9, 6);
        anchor.setAnchorType(ClientAnchor.AnchorType.byId(3));
        //插入图片
        patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));
    }

    public void convertToPdf(XSSFWorkbook wb) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            wb.write(byteArrayOutputStream);
            byteArrayOutputStream.close();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            Workbook wb2 = new Workbook();
            wb2.loadFromStream(inputStream);
            File file = new File(realPath + pdfPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            wb2.saveToFile(realPath + pdfPath + username + ".pdf", FileFormat.PDF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gen(Reginfo reginfo, HttpServletRequest req) {
        File path = new File(realPath + pdfPath + username + ".pdf");
        if (path.exists()) {
            return;
        }
        ServletContext context = req.getServletContext();
        School school = (School) context.getAttribute("school");
        XSSFWorkbook wb = EntryGenXlsx.getSheet(realPath + CardGenXlsx.path);
        inputTextToXlsx(wb, reginfo, school);
        inputPhotoToXlsx(wb);
        convertToPdf(wb);
    }

    public void get(ServletOutputStream outputStream) {
        File file = new File(realPath + pdfPath + username + ".pdf");
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                int len;
                while ((len = fileInputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, len);
                }
                fileInputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteAll() {
        File path = new File(realPath + pdfPath);
        if (path.exists()) {
            File[] files = path.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
    }
}
