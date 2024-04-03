package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
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

}
