package _JDBC;



import org.testng.annotations.Test;

import java.sql.*;

// city tablosundaki tüm satırlardaki şehir isimlerini next ile yazdırınız

public class _02_Soru {

    @Test
    public void Test1() throws SQLException {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        Connection baglanti = DriverManager.getConnection(url, username, password);
        Statement sorguEkrani = baglanti.createStatement();

        ResultSet sonucTablosu = sorguEkrani.executeQuery("select * from city");

        while (sonucTablosu.next())
            System.out.println(sonucTablosu.getString("city"));

        baglanti.close();
    }


}
