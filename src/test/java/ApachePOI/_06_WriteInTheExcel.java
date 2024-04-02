package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInTheExcel {

    // Var olan bir excele yazma işlemi
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream=new FileInputStream(path); //okuma modunda açıldı
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheetAt(0);

        int enSonSatirMiktari=sheet.getPhysicalNumberOfRows();
        Row yeniSatir=sheet.createRow(enSonSatirMiktari); //yeni satır oluşturdum
        Cell yeniHucre=yeniSatir.createCell(0); // yenisatırda yeni hücre oluşturdum

        yeniHucre.setCellValue("Merhaba Dünya"); // yeni hücreye değer verdim
        //yazma işlemim bitti
        inputStream.close();// aynı anda okuma ve kaydetme yapılamıyor, okuma modu kapatıldı

        // dosyayı KAYDETME modunda aç
        FileOutputStream outputStream=new FileOutputStream(path); // kaydetme modunda açıldı
        workbook.write(outputStream); // workbook kaydedildi
        workbook.close(); // hafıza boşaltıldı
        outputStream.close(); // yazma modu kapatıldı.

        System.out.println("Kayıt yapıldı");
    }
}
