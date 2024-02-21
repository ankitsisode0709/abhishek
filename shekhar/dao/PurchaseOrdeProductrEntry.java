/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.dao;

import java.util.*;
import java.sql.*;
import shekhar.pojo.AddPurchaseOrderEnrty;

/**
 *
 * @author Rohit
 */
public class PurchaseOrdeProductrEntry {

    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public PurchaseOrdeProductrEntry() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();

    }

    public boolean isAddPurchaseOrderEntry(AddPurchaseOrderEnrty apoe) {
        try
        {
            stmt=conn.prepareStatement("insert into purchaseorderentry values(?,?,?,?,?)");
            stmt.setInt(1, apoe.getOrderId());
            stmt.setInt(2, apoe.getProductId());
            stmt.setString(3,apoe.getQuantity());
            stmt.setString(4,apoe.getRate());
            stmt.setString(5,apoe.getTotal());
           int a=stmt.executeUpdate();
           if(a>0)
           {
               System.out.println("Purchase Order Entry added ");
           }
           else
           {
                System.out.println("Purchase Order Entry not added ");
           }
        }
        catch (Exception ex) 
        {
            System.out.println("Exception is in isAddPurchaseOrderEntry function.."+ex.toString());
        }
        return false;
    }
}
