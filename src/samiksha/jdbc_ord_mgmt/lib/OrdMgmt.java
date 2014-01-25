package samiksha.jdbc_ord_mgmt.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrdMgmt {
    public int connect() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "samiksha", "samiksha@ande");
            Statement stmt;
            String query = "CREATE SCHEMA order_management";
            stmt = con.createStatement();
            stmt.executeQuery(query);
            System.out.println("created successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 1;
    }

//    public void insert(String elements){
//        String res = elements.split()
//
//    }


}



