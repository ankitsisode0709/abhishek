/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;
import shekhar.pojo.AddSaleEntryRecord;
/**
 *
 * @author Rohit
 */
public class SellEntryRecordDAO {
    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public SellEntryRecordDAO() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
   
    }
    
    
    public boolean isAddSaleEntryRecord(AddSaleEntryRecord aser)throws Exception 
    {
        stmt=conn.prepareStatement("insert into saleorderentry1 values(?,?,?,?,?,?)");
        stmt.setInt(1,aser.getOrderID());
        stmt.setInt(2,aser.getProductID());
        stmt.setString(3,aser.getQuantity());
        stmt.setString(4,aser.getRate());
        stmt.setString(5,aser.getTotal());
        stmt.setString(6, aser.getWarrentyUpto());
        int a=stmt.executeUpdate();
        if(a>0)
        {
            System.out.println("Sale Entry Added Sucessfully....");
        }
        else
        {
            System.out.println("Sale Entry Not Added Sucessfully....");
        }
        return false;
    }
    
}
