package ApachePOI;


/*
   Main den bir metod çağırmak suretiyle, henüz oluşturulmamış
   path i verilen excel için, program her çalıştıkça içine "test passed"
   yazısını ekleyen metodu yazınız.
   Yani dosya yoksa oluştur ilk satıra yaz, sonra dosya oluşacağı için
   dosya varsa en son satırın altına yaz.

   File dosya= new File(path); //dosya kontrolü

if (!file.exists()) //dosya yok ise
{
  oluşturup
  merhaba düznya yazsın
}
else
{
   var olan dosyaya eklesin
  }

 */

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class _11_Soru {

    public static void main(String[] args) {
        String path="src/test/java/ApachePOI/resource/TestSonuclari.xlsx";
        String testSonuc="Test Passed";

        writeToExcel(path, testSonuc); //excel create
        writeToExcel(path, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, testSonuc); //dosya artık var ekleyecek
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
        }



    }

}








