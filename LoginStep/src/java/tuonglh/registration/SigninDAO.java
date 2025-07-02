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
public class SigninDAO implements Serializable {

    public SigninDTO checkLogin(String phoneNumber, String password)
            throws SQLException, ClassNotFoundException {
        SigninDTO result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1.Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Model queries from DB 
                //2.1 Create SQL String
                String sql = "Select role, name  "
                        + "FROM Signin "
                        + "WHERE phoneNumber = ? "
                        + "AND password = ?";
                //2.2 Create  Statement Object

                stm = con.prepareStatement(sql);
                stm.setString(1, phoneNumber);
                stm.setString(2, password);
                //4.Execute Query
                rs = stm.executeQuery();
                //5.Process Result
                if (rs.next()) {
                    String fullName = rs.getString("name");
                    boolean isAdmin = rs.getBoolean("role");
                    result = new SigninDTO(phoneNumber, password, isAdmin, fullName);
                }//user is existed
            }//connection available buoc 12 trong so do 
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public List<SigninDTO> accounts;

    public List<SigninDTO> getAccounts() {
        return accounts;
    }

    public void searchLastName(String searchValue)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1.Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Model queries from DB 
                //2.1 Create SQL String
                String sql = "Select phoneNumber, password, role, name  "
                        + "FROM Signin "
                        + "WHERE name LIKE ?";
                //2.2 Create  Statement Object

                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");

                //4.Execute Query
                rs = stm.executeQuery();
                //5.Process Result
                while (rs.next()) {
                    // lay nhieu dong tu db 
                    String phoneNumber = rs.getString("phoneNumber");
                    String password = rs.getString("password");
                    boolean role = rs.getBoolean("role");
                    String name = rs.getString("name");

                    //tao DTO roi moi set duoc 
                    SigninDTO dto = new SigninDTO(phoneNumber, password, role, name);

                    //set data
                    if (this.accounts == null) {
                        this.accounts = new ArrayList<>();
                    }

                    this.accounts.add(dto);
                }//user is existed
            }//connection available buoc 12 trong so do 
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean deleteValue(String phoneNumber)
            throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //1.Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Model queries from DB 
                //2.1 Create SQL String
                String sql = "Delete "
                        + "From Signin "
                        + "Where phoneNumber = ?";
                //2.2 Create  Statement Object

                stm = con.prepareStatement(sql);
                stm.setString(1, phoneNumber);   // chi co 1 tham chieu
                //4.Execute Query
                int effectRows = stm.executeUpdate();  // nhung cau lenh ve insert delete hay update thi se tra ve so dong 

                //3. check so dong co hieu luc
                if (effectRows > 0) {
                    result = true;
                }
            }//connection available buoc 12 trong so do 
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean updateAccount(String phone, String password, String role)
            throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //B1 ket noi DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2 Query voi DB
                //2.1 Tao query 
                String query = "Update Signin "
                        + "Set password = ? ,"
                        + "role = ? "
                        + "Where phoneNumber = ?";

                //2.2 Set statement vao query
                stm = con.prepareStatement(query);
                stm.setString(1, password);
                if (role != null) {
                    stm.setBoolean(2, true);
                } else {
                    stm.setBoolean(2, false);
                }
                
                
                stm.setString(3, phone);
                //2.3 excute

                int effectRows = stm.executeUpdate();

                if (effectRows > 0) {
                    result = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
    public boolean createAccount(SigninDTO accounts) throws SQLException, ClassNotFoundException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            //B1 ket noi DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //B2 Query voi DB
                //2.1 Tao query 
                String query = "Insert into Signin("
                        + "phoneNumber, password, role, name"
                        + ") Values ("
                        + "?, ?, ?, ?)";

                //2.2 Set statement vao query
                stm = con.prepareStatement(query);
                stm.setString(1, accounts.getPhoneNumber());
                stm.setString(2, accounts.getPassword());
                stm.setBoolean(3, accounts.isRole());
                stm.setString(4, accounts.getName());
                //2.3 excute
                
                int effectRows = stm.executeUpdate();

                if (effectRows > 0) {
                    result = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
