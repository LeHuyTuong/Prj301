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
import javax.naming.NamingException;
import tuonglh.utils.DBHelper;

/**
 *
 * @author USER
 */
public class ItemDAO implements Serializable{
    private List<ItemDTO> items;
    public List<ItemDTO> getItems(){
        return items;
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
                String sql = "Select itemID, price "
                        + "FROM Item "
                        + "Where name like ? ";
                //2.2 Create  Statement Object
                stm = con.prepareStatement(sql);
                stm.setString(1, searchName);
                //4.Execute Query
                rs = stm.executeQuery();
                //5.Process Result
                while (rs.next()) {
                    // lay nhieu dong tu db 
                    String itemID = rs.getString("itemID");
                    double price = rs.getDouble("price");
                    String nameItem = rs.getString("name");
                    //tao DTO roi moi set duoc 
                    ItemDTO dto = new ItemDTO(itemID, price, nameItem);
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
} 
