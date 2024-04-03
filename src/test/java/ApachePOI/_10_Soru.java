package ApachePOI;

/*
   Main den bir metod çağırmak suretiyle, path i ve sheetName i verilen excelden
   istenilen sütun kadar veriyi okuyup bir List e atınız.
   Bu soruda kaynak Excel için : ApacheExcel2.xlsx  in 2.sheet ini kullanabilirsiniz.
 */

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class _10_Soru {

    public static void main(String[] args) {
       //buradan fonksiyona: path, sheetName, sutunSayısı nı göndereceğim bana List olarak verecek
       String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
       String sheetName="testCitizen";
       int sutunSayisi=4;

       ArrayList< ArrayList<String> >  sonuc=   getData(path, sheetName, sutunSayisi);
        System.out.println("sonuc = " + sonuc);
    }


    public static ArrayList< ArrayList<String> > getData(String path, String sheetName, int sutunSayisi) {
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


}
