/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.dao;

import java.sql.*;
import java.util.Vector;
import shekhar.pojo.AddPurchaseOrder;
/**
 *
 * @author Rohit
 */
public class PurchaseOrder {
    

    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public PurchaseOrder() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        
    }
    
    public boolean isAddPurchaseOrder(AddPurchaseOrder apo)
    {
        try{
            stmt=conn.prepareStatement("insert into purchaseorder values(0,?,?,?,'0','0',?)");
            stmt.setInt(1,apo.getSupplierID());
            stmt.setString(2, apo.getOrderDate());
            stmt.setString(3, apo.getTotal());
            stmt.setString(4, apo.getStatus());
            int a=stmt.executeUpdate();
            if (a>0)
            {
                System.out.println("Purchase order added sucessfully");
            }
            else
            {
               System.out.println("Purchase order not added sucessfully"); 
            }
            stmt.close();
            
        }
        catch(Exception ex)
        {
          System.out.println("Exception is in isAddPurchaseOrder function.."+ex.getMessage());  
        }
        return true;
    }
   
    
     public int isGetOrderId(int suppId)throws Exception
    {
        int v=0;
        stmt=conn.prepareStatement("select oid from purchaseorder where sid='"+suppId+"'");
        rs=stmt.executeQuery();
        while(rs.next())
        {
            v=(rs.getInt(1));
        }
        stmt.close();
        return v;
    }
    
    
    public boolean isUpdatePurchaseOrder(AddPurchaseOrder apo)
    {
        try{
            stmt=conn.prepareStatement("update purchaseorder set total=?,paid=?,balance=?,status=? where oid='"+apo.getOrderID()+"'");
             stmt.setString(1, apo.getTotal());
            stmt.setString(4, apo.getStatus());
            stmt.setString(2,apo.getPaid());
            stmt.setString(3,apo.getBalance());
           
            int a=stmt.executeUpdate();
            if(a>0)
            {
                System.out.println("Purchase Order updated Sucessfully...");
            }
            else
            {
              System.out.println("Purchase Order not updated Sucessfully...");   
            }
        }
        catch(Exception ex)
        {
            
        }
        return false;
    }
    
}
