package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {

    public static void main(String[] args) throws IOException {
        //hafızada worbook oluştur
        //bundan hazfızada sheet oluştur
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("Sayfa1");

        // kalan kısım aynı.
        Row yeniSatir=sheet.createRow(0);
        Cell yeniHucre=yeniSatir.createCell(0);
        yeniHucre.setCellValue("Merhaba yeni Excel");

        // ctrl+s
        String path="src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(path); // kaydetme modu
        workbook.write(outputStream);
        workbook.close();
        outputStream.close(); //kaydetme bağlantısını kapat
    }
}
