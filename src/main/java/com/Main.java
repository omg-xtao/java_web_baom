package com;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xtaod
 */
public class Main {
    static String photo = "D:\\git\\java_web_baom\\src\\main\\java\\com\\mrwangzhe.jpg";
    static String old = "D:\\git\\java_web_baom\\src\\main\\java\\com\\baom.xlsx";
    static String newFile = "D:\\git\\java_web_baom\\src\\main\\java\\com\\baom_mrwangzhe.xlsx";

    public static XSSFWorkbook getSheet() {
        // 读取 baom.xlsx
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(old);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static void inputTextToXlsx(XSSFWorkbook wb) {
        // 输入文本数据到 baom_mrwangzhe.xlsx
        XSSFSheet sheet = wb.getSheetAt(0);
        sheet.getRow(10).getCell(1).setCellValue("2022222");
    }

    public static void inputPhotoToXlsx(XSSFWorkbook wb) {
        // 读取图片
        BufferedImage bufferImg;
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        File f = new File(photo);
        System.out.println(f);
        try {
            bufferImg = ImageIO.read(f);
            ImageIO.write(bufferImg, "jpg", byteArrayOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 输入图片到 baom_mrwangzhe.xlsx
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFDrawing patriarch = sheet.createDrawingPatriarch();
        //anchor主要用于设置图片的属性
        XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 255, 255, 2, 1, 4, 6);
        anchor.setAnchorType(ClientAnchor.AnchorType.byId(3));
        //插入图片
        patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));
    }

    public static void saveFile(XSSFWorkbook wb) {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(newFile);
            // 写入excel文件
            wb.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XSSFWorkbook wb = getSheet();
        inputTextToXlsx(wb);
        inputPhotoToXlsx(wb);
        saveFile(wb);
    }
}
