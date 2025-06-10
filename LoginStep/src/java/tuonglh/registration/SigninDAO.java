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
public class SigninDAO implements Serializable{
    public boolean checkLogin(int phoneNumber, String password)
            throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{ 
            //1.Connect DB
            con = DBHelper.makeConnection();
            if(con != null){
                //2.Model queries from DB 
                //2.1 Create SQL String
                String sql = "Select phoneNumber "
                        + "FROM Registration " 
                        + "WHERE phoneNumber = ? "
                        + "AND password = ?";
                //2.2 Create  Statement Object
                
                stm = con.prepareStatement(sql);
                stm.setInt(1, phoneNumber);
                stm.setString(2, password);
                //4.Execute Query
                rs = stm.executeQuery();
                //5.Process Result
                if(rs.next()){
                    return true;
                }//user is existed
            }//connection available buoc 12 trong so do 
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
