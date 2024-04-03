package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Excel Çarpım tablosunu
 * YENİ bir excel dosyasına
 * 1 den 10 kadar çarpımlar için yapınız.
 */

public class _09_Soru {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");

        int yeniSatirIndex=0;
        for (int i = 1; i <= 10; i++) { //

            for (int j = 1; j <= 10 ; j++) {
                Row yeniSatir= sheet.createRow(yeniSatirIndex++);
                //System.out.println(i+"x"+j+"="+(i*j));

                Cell hucre1= yeniSatir.createCell(0); hucre1.setCellValue(i);
                Cell hucre2= yeniSatir.createCell(1); hucre2.setCellValue("x");
                Cell hucre3= yeniSatir.createCell(2); hucre3.setCellValue(j);
                Cell hucre4= yeniSatir.createCell(3); hucre4.setCellValue("=");
                Cell hucre5= yeniSatir.createCell(4); hucre5.setCellValue(i*j);
            }

            Row bosSatir= sheet.createRow(yeniSatirIndex++);
        }


        String path = "src/test/java/ApachePOI/resource/YeniCarpim.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("İşlem tamamlandı");
    }

}
