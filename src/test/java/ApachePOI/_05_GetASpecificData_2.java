package ApachePOI;

import org.apache.http.impl.execchain.ServiceUnavailableRetryExec;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class _05_GetASpecificData_2 {

    public static void main(String[] args) throws IOException {

        System.out.println(ExceldenGetir("Address"));

    }


    public static String ExceldenGetir(String aranan) throws IOException {

        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        FileInputStream input = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(input);
        Sheet sheet = workbook.getSheetAt(0);

        String bulunan = "";

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            //bu satırın ilk hücresi aranan a eşit mi
            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(aranan)) {

                //bu satırın tüm hücrelerini bulunan a ekle
                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    bulunan += sheet.getRow(i).getCell(j) + " ";
                }
            }
        }

        return bulunan;
    }

}





