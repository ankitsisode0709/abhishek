/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.dao;
import java.util.*;
import java.sql.*;
import shekhar.pojo.SpareOrderEntryPojo;

/**
 *
 * @author Rohit
 */
public class SpareOrderEntry {
    
    
     ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public SpareOrderEntry() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();

    }

    
     public boolean isAddSparePurchaseOrderEntry(SpareOrderEntryPojo spoe) {
        try
        {
            stmt=conn.prepareStatement("insert into spareorderentry values(?,?,?,?,?)");
            stmt.setInt(1, spoe.getOrderid());
            stmt.setInt(2, spoe.getSpareid());
            stmt.setString(3,spoe.getQuantity());
            stmt.setString(4,spoe.getRate());
            stmt.setString(5,spoe.getTotal());
           int a=stmt.executeUpdate();
           if(a>0)
           {
               System.out.println("Sale Purchase Order Entry added.... ");
           }
           else
           {
                System.out.println("sale Purchase Order Entry not added.... ");
           }
           stmt.close();
        }
        catch (Exception ex) 
        {
            System.out.println("Exception is in isAddSparePurchaseOrderEntry function.."+ex.toString());
        }
        return true;
    }
    
    
    
}
