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
public class EntryGenXlsx {
    String realPath;
    String photo;
    String username;
    public static String path = "WEB-INF/resources/baom.xlsx";
    public static String pdfPath = "/upload/baom/";

    public EntryGenXlsx(String realPath, String photo, String username) {
        this.realPath = realPath;
        this.photo = photo;
        this.username = username;
    }

    public XSSFWorkbook getSheet() {
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(realPath + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public void inputTextToXlsx(XSSFWorkbook wb, Reginfo reginfo, School school) {
        XSSFSheet sheet = wb.getSheetAt(0);

        String title = school.getShyear() + "年 " + school.getShname() + " " + school.getShtest() + " 考试";
        sheet.getRow(0).getCell(0).setCellValue(title);

        sheet.getRow(2).getCell(1).setCellValue(reginfo.getUserid());
        sheet.getRow(3).getCell(1).setCellValue(reginfo.getMname());

        sheet.getRow(5).getCell(1).setCellValue(reginfo.getSname());
        sheet.getRow(6).getCell(1).setCellValue(reginfo.getSsex());
        sheet.getRow(7).getCell(1).setCellValue(reginfo.getNation());
        sheet.getRow(8).getCell(1).setCellValue(reginfo.getPolitical());
        sheet.getRow(9).getCell(1).setCellValue(reginfo.getIdcode());
        sheet.getRow(10).getCell(1).setCellValue(reginfo.getSource());
        sheet.getRow(11).getCell(1).setCellValue(reginfo.getHomeaddr());
        sheet.getRow(12).getCell(1).setCellValue(reginfo.getSchool());
        sheet.getRow(13).getCell(1).setCellValue(reginfo.getIsnew() ? "是" : "否");
        sheet.getRow(14).getCell(1).setCellValue(reginfo.getGradutetime().toString());
        sheet.getRow(15).getCell(1).setCellValue(reginfo.getAos());
        sheet.getRow(16).getCell(1).setCellValue(reginfo.getMajor());
        sheet.getRow(17).getCell(1).setCellValue(reginfo.getCet());

        sheet.getRow(19).getCell(1).setCellValue(reginfo.getReceiver());
        sheet.getRow(20).getCell(1).setCellValue(reginfo.getConaddr());
        sheet.getRow(21).getCell(1).setCellValue(reginfo.getZipcode());
        sheet.getRow(22).getCell(1).setCellValue(reginfo.getMobile());
        sheet.getRow(23).getCell(1).setCellValue(reginfo.getTelphone());
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
        XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 255, 255, 2, 1, 4, 6);
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
        ServletContext context = req.getServletContext();
        School school = (School) context.getAttribute("school");
        XSSFWorkbook wb = getSheet();
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
}
