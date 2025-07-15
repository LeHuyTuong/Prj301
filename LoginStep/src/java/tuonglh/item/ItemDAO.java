/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuonglh.item;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import tuonglh.utils.DBHelper;

/**
 *
 * @author USER
 */
public class ItemDAO implements Serializable{
    private List<ItemDTO> items;
    public List<ItemDTO> getItems(){
        return this.items;
    }
    
    public void searchItems(String searchName)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1.Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Model queries from DB 
                //2.1 Create SQL String
                String sql = "Select itemID, name, price , time "
                        + "FROM Item "
                        + "Where name like ? ";
                //2.2 Create  Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, "%"+  searchName +"%");
                //4.Execute Query
                rs = stm.executeQuery();
                //5.Process Result
                while (rs.next()) {
                    // lay nhieu dong tu db 
                    String itemID = rs.getString("itemID");
                    double price = rs.getDouble("price");
                    String nameItem = rs.getString("name");
                    Timestamp time = rs.getTimestamp("time");
                    //tao DTO roi moi set duoc 
                    ItemDTO dto = new ItemDTO(itemID, price, nameItem, time);
                    //set data
                    if (this.items == null) {
                        this.items = new ArrayList<>();
                    }
                    this.items.add(dto);
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
    
    public String getNameByID(String searchName)
            throws SQLException, NamingException {
        String result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1.Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Model queries from DB 
                //2.1 Create SQL String
                String sql = "Select name "
                        + "FROM Item "
                        + "Where itemID like ? ";
                //2.2 Create  Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, "%"+  searchName +"%");
                //4.Execute Query
                rs = stm.executeQuery();
                //5.Process Result
                while(rs.next()){
                    String name = rs.getString("name");
                    result = name;
                }
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
    
    
    public boolean addItems(ItemDTO items)
            throws SQLException, NamingException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1.Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2.Model queries from DB 
                //2.1 Create SQL String
                String sql = "Insert into Item ("
                        + "itemID, price, name, time "
                        + ") Values("
                        + "?, ?, ?, ?)";
                //2.2 Create  Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, items.getItemID());
                stm.setDouble(2, items.getPrice());
                stm.setString(3, items.getName());
                stm.setTimestamp(4, items.getDateTime());
                //4.Execute Query
                int effectRows = stm.executeUpdate();
                if(effectRows > 0){
                    result = true;
                }
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
} 
