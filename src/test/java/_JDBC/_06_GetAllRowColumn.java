package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _06_GetAllRowColumn extends JDBCParent{

    @Test
    public void Test1() throws SQLException {
        DBConnectionOpen();

        ResultSet rs=sorguEkrani.executeQuery("select city_id, city, country_id from city");

        rs.next();
        System.out.println("id="+rs.getString(1)); // her tip getString ile alabilirsin
        System.out.println("id="+rs.getString("city_id"));

        int intID= rs.getInt("city_id"); // Kolonun tipine uygun get ile de alabilirsin
        System.out.println("intID = " + intID);

        DBConnectionClose();
    }

    @Test
    public void Test2() throws SQLException {
        DBConnectionOpen();

        ResultSet rs=sorguEkrani.executeQuery("select * from city");

        ResultSetMetaData rsmd=rs.getMetaData(); // sorgu sonucunda DATA dışındaki veriler, kolon sayısı ve kolon isimleri
        // MetaFizik : fizik dışındakiler
        // MetaData  : Data dışı

        int kolonSayisi= rsmd.getColumnCount();
        System.out.println("kolonSayisi = " + kolonSayisi);
        for (int i = 1; i <= kolonSayisi; i++) {
            System.out.println(rsmd.getColumnName(i));
        }

        rs.next(); // 1.Satırdayım
        System.out.println("1.Kolon="+rs.getString(1)); // 1.Kolon
        System.out.println("2.Kolon="+rs.getString(2)); // 2.Kolon
        System.out.println("3.Kolon="+rs.getString(3)); // 3.Kolon

        for (int i = 1; i < kolonSayisi; i++)
            System.out.println(i+".Kolon="+rs.getString(i));

//        rs.next(); // 2.satıra geçildi
        DBConnectionClose();
    }



}
