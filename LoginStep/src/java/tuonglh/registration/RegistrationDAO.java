/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tuonglh.utils.DBHelper;

/**
 *
 * @author USER
 */
public class RegistrationDAO implements Serializable{
    public boolean checkLogin(String username, String password)
            throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{ 
            //1.Connect DB
            con = DBHelper.makeConnection();
            if(con != null){
                //2.Create String SQL
                String sql = "Select username"
                        + "FROM Registration"
                        + "WHERE username = ? "
                        + "AND password = ?";
                //3.Create SQL Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4.Execute Query
                rs = stm.executeQuery();
                //5.Process Result
                if(rs.next()){
                    return true;
                }
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return false;
    } 
}
