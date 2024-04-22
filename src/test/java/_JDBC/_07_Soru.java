package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _07_Soru extends JDBCParent{
    // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
    // aynı mysql sonuç ekranında olduğu gibi

    @Test
    public void Test1() throws SQLException {
        DBConnectionOpen();
        ResultSet rs=sorguEkrani.executeQuery("select * from language");

        ResultSetMetaData rsmd=rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++)
            System.out.print(rsmd.getColumnName(i)+"\t");

        System.out.println();
        while (rs.next()){ // sonraki satır var ise oraya geç

            //bulunduğun satırdaki bütün kolonları yazdır
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
              System.out.print(rs.getString(i)+"\t");

            System.out.println();
        }


        DBConnectionClose();
        // TODO : daha düzenli şekilde printf le isteyen yapsın
    }

}
