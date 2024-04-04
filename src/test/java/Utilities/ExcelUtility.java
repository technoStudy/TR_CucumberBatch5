package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExcelUtility {

    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int sutunSayisi) {
        Sheet sheet=null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        ArrayList< ArrayList<String> > tablo=new ArrayList<>();
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  //tüm satırlar

            ArrayList<String> satir=new ArrayList<>();
            for (int j = 0; j < sutunSayisi; j++) {
                satir.add(sheet.getRow(i).getCell(j).toString());  // o andaki satırın tüm hücreleri okundu
            }

            tablo.add(satir);  // satır  tabloya (2D)  eklendi
        }

        return tablo;
    }

    public static void writeToExcel(String path, String testSonuc){
        File dosya=new File(path);

        if (!dosya.exists()) // dosya yoksa
        {
            XSSFWorkbook workbook=new XSSFWorkbook();
            XSSFSheet sheet=workbook.createSheet("Senaryolar");

            Row yeniSatir=sheet.createRow(0);
            Cell yeniHucre=yeniSatir.createCell(0);
            yeniHucre.setCellValue(testSonuc);

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            System.out.println("Dosya yok ise bölümü çalıştı");
        }
        else // dosya var ise
        {
            FileInputStream inputStream=null;
            Workbook workbook=null;
            Sheet sheet =null;

            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }

            int satirMiktar=sheet.getPhysicalNumberOfRows();
            Row yeniSatir=sheet.createRow(satirMiktar);
            Cell yeniHucre=yeniSatir.createCell(0);
            yeniHucre.setCellValue(testSonuc);

            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }

            System.out.println("Dosya VAR ise bölümü çalıştı");
        }
    }

}
