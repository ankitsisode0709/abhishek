/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.dao;
import java.util.*;
import java.sql.*;
import shekhar.pojo.SpareOredrPojo;
/**
 *
 * @author Rohit
 */
public class SpareOrder {
    
    
    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public SpareOrder() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        
    }
    
    
    public boolean isAddSpareOrder(SpareOredrPojo spo)
    {
        try{
            PreparedStatement stmt=conn.prepareStatement("insert into spareorder values(0,?,?,?,?,?,?)");
            stmt.setInt(1,spo.getSupplierID());
            stmt.setString(2, spo.getOrderDate());
            stmt.setString(3, spo.getTotal());
            stmt.setString(4, spo.getPaid());
            stmt.setString(5, spo.getBalance());
            stmt.setString(6, spo.getStatus());
            int a=stmt.executeUpdate();
            if(a>0)
            {
                System.out.println("Spare order is added...");
            }
            else
            {
                System.out.println("spare order is not added...");
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception is in isAddSpareOrder function...."+e.toString());
        }
        return true;
    }
    
    
    public boolean isUpdateSpareOrder(SpareOredrPojo spo)
    {
        try{
            PreparedStatement stmt=conn.prepareStatement("update spareorder set total='"+spo.getTotal()+"',paid='"+spo.getPaid()+"',balance='"+spo.getBalance()+"',status='"+spo.getStatus()+"' where orderid='"+spo.getSpareOrderID()+"'");
            int a=stmt.executeUpdate();
            if(a>0)
            {
                System.out.println("Spare order is updated...");
            }
            else
            {
                System.out.println("spare order is not updated...");
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception is in isUpdateSpareOrder function...."+e.toString());
        }
        return true;
    }
    
    
    
     public int isGetSpareOrderId(int suppId)throws Exception
    {
        int v=0;
        stmt=conn.prepareStatement("select orderid from spareorder where supplierid='"+suppId+"'");
        rs=stmt.executeQuery();
        while(rs.next())
        {
            v=(rs.getInt(1));
        }
        stmt.close();
        return v;
    }
    
    
    
    
}
