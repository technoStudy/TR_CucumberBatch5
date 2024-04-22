package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_FirstLastGetRowgetType extends JDBCParent{

    @Test
    public void Test1() throws SQLException {
        DBConnectionOpen();

        ResultSet rs= sorguEkrani.executeQuery("select city from city");

        rs.last();  // son satıra gider
        System.out.println("Son satır : "+ rs.getString(1));

        rs.first();  // ilk satıra gider
        System.out.println("İlk satır : "+ rs.getString(1));
        
        rs.last(); // son satıra gittim
        int kacinciSatirdayim= rs.getRow(); // şu anda kaçıncı satırda olduğunun bilgisini verir
        System.out.println("kacinciSatirdayim = " + kacinciSatirdayim); 

        DBConnectionClose();
    }

}
