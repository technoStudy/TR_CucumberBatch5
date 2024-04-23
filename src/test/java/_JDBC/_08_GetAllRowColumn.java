package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class _08_GetAllRowColumn extends JDBCParent{

    // bir metoda sorguyu("select * from language") gönderiniz,
    // metod size sorgunun datasını bir ArrayList olarak döndürsün


    @Test
    public void Test1()
    {
        String sorgu="select * from language";
        List<List<String>>  donenTablo=getListData(sorgu); //giden var, dönen var
        //System.out.println(donenTablo);
        for(List<String> satir : donenTablo) {
            for (String kolon : satir)
                System.out.print(kolon+"\t");

            System.out.println();
        }
    }

    public List<List<String>> getListData(String sorgu)
    {
        List<List<String>> tablo=new ArrayList<>();

        try {
            DBConnectionOpen();
            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd = rs.getMetaData(); // kolon sayısı

            // kolon isimleri tablonun ilk satırına eklendi
            ArrayList<String> kolonSatiri = new ArrayList<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                kolonSatiri.add(rsmd.getColumnName(i));
            tablo.add(kolonSatiri);

            while (rs.next()) {

                ArrayList<String> satir = new ArrayList<>();
                // bu satırdaki elemanları satır listine ekle
                // rs.getString(1); // 1
                // rs.getString(2); // English
                for (int i = 1; i <= rsmd.getColumnCount(); i++)
                    satir.add(rs.getString(i));

                // satıra ekleme bitince tablo ya ekle
                tablo.add(satir);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            DBConnectionClose();  // hata olsa d aolmasa da çalış
        }

        return tablo;
    }



}
