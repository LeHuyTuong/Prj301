package dao;

import context.DBContext;
import entity.Digital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DigitalDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Digital getTop1() {
    try {
        String query = "SELECT TOP 1 * FROM digital ORDER BY ID";
        conn = new DBContext().getConnection();
        ps = conn.prepareStatement(query);
        rs = ps.executeQuery();

        if (!rs.next()) {
            System.out.println("⚠️ No data found in getTop1()");
            return null;
        }

        Digital d = new Digital(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getDate(6),
                rs.getString(7)
        );
        System.out.println("✅ getTop1() => " + d);
        return d;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}


    public List<Digital> getTop5Exclude(int excludeId) {
        List<Digital> list = new ArrayList<>();
        try {
            String query = "SELECT TOP 5 * FROM digital WHERE ID != ? ORDER BY timePost DESC";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, excludeId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Digital d = new Digital(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDate(6),
                    rs.getString(7)
                );
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int count(String txt) throws SQLException {
        
        try {
            String query = "select count (*) from digital where title like ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+txt+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}