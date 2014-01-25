package samiksha.jdbc_ord_mgmt.lib;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class OrdMgmtTest {

    String url = "org.mariadb.jdbc.Driver";
    String db_path = "jdbc:mysql://localhost:3306";
    Statement stmt = null;
    Connection con = null;
    ResultSet rs;
    @Before
    public void setUp() throws Exception {
        try{
        Class.forName(url);
        con = DriverManager.getConnection(db_path, "samiksha", "samiksha@ande");
        stmt = con.createStatement();
        String query = "CREATE SCHEMA order_management";
        stmt.execute(query);

        String query2 = "CREATE TABLE order_management.customer(cust_id varchar(20) primary key,cust_name varchar(20),address1 varchar(20))";
        stmt.execute(query2);

        String query3 = "CREATE TABLE order_management.product(p_id int primary key,pname varchar(20)" +
            ",unit_price int,p_category varchar(15))";
        stmt.execute(query3);

        String query4 = "CREATE TABLE order_management.orders(o_id int primary key,pid int" +
                ",o_date date,quantity int,total_price int,o_status char(1))";
        stmt.execute(query4);

            System.out.println("created successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Test
    public void createSchema() throws SQLException {
        stmt.execute("insert into order_management.customer values(101,'abc','nagpur')");
        rs = stmt.executeQuery("select * from order_management.customer");
        int row = 0;
        String name="",city="";
        while(rs.next()){
            row = rs.getInt(1);
            name = rs.getString(2);
            city = rs.getString(3);
        }
        assertEquals(101, row);
        assertEquals("abc", name);
        assertEquals("nagpur",city);
    }

    @After
    public void tearDown() throws Exception {
        try
        {
            String query = "DROP SCHEMA order_management";
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
