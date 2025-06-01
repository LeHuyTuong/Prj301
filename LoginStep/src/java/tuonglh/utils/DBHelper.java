/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DBHelper implements Serializable{
    public static Connection makeConnection()
            throws ClassNotFoundException,SQLException {
        //1. Load Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. Create Connection String
        String url ="jdbc:server:"
                + "//localhost:1433"
                + ";databaseName=PRJSE1809";
        //3.Open Connection
        Connection con = DriverManager.getConnection(url, "sa", "12345");
        return con;
    }
}
