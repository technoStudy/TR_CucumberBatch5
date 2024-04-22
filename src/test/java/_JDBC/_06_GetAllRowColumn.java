package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
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


}
