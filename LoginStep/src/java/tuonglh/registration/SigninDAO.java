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
import java.util.ArrayList;
import java.util.List;
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
                        + "FROM Signin " 
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
    
    public List<SigninDTO> accounts;
    
    public List<SigninDTO> getAccounts(){
        return accounts;
    }
    
    public void searchLastName (String searchValue) 
    throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{ 
            //1.Connect DB
            con = DBHelper.makeConnection();
            if(con != null){
                //2.Model queries from DB 
                //2.1 Create SQL String
                String sql = "Select phoneNumber, password, role, name  "
                        + "FROM Signin " 
                        + "WHERE name LIKE ? ";
                //2.2 Create  Statement Object
                
                stm = con.prepareStatement(sql);
                stm.setString(1,"%" + searchValue +"%");
                
                //4.Execute Query
                rs = stm.executeQuery();
                //5.Process Result
                if(rs.next()){
                    // lay nhieu dong tu db 
                    String phoneNumber = rs.getString("phoneNumber");
                    String password = rs.getString("password");
                    boolean role = rs.getBoolean("role");
                    String name = rs.getString("name");
                   
                    //tao DTO roi moi set duoc 
                    SigninDTO dto = new SigninDTO(phoneNumber, password, role, name);
                    
                    //set data
                    if(this.accounts == null){
                        this.accounts = new ArrayList<>();
                    }
                    
                    this.accounts.add(dto);
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
    }
}
