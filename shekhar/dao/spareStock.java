/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.dao;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Rohit
 */
public class spareStock {
    ShekharDAO sdo;
    Vector vect;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private Vector[] v;
    
    
    public spareStock() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
       
    }
    
    
    public boolean isAddSpare(int spid,int qnty)
    {
        try
        {
          PreparedStatement stmt=conn.prepareStatement("insert into sparestock values(?,?)");
          stmt.setInt(1, spid);
           stmt.setInt(2,qnty);
          int a=stmt.executeUpdate();
          if(a>0)
          {
              System.out.println("stock added...");
          }
          else
          {
             System.out.println("stock added..."); 
          }
        }
        catch(Exception ex)
        {
           System.out.println("Exception is in isAddSpare...."+ex.toString()); 
        }
        return true;
    }
    
    public boolean isUpdateSpare(int spid,int qtnty)
    {
        try
        {
          PreparedStatement stmt=conn.prepareStatement("update sparestock set totalstock='"+qtnty+"' where spareid='"+spid+"'");
          
          int a=stmt.executeUpdate();
          if(a>0)
          {
              System.out.println("stock updated...");
          }
          else
          {
             System.out.println("stock updated..."); 
          }
        }
        catch(Exception ex)
        {
           System.out.println("Exception is in isUpdateSpare...."+ex.toString()); 
        }
        return true;
    }
    
    public int getsPareTotalStock(int spid)
  {
      int stock=0;
      try{
          
          PreparedStatement stmt=conn.prepareStatement("select sum(totalstock) from sparestock where spareid=?");
          stmt.setInt(1, spid);
          ResultSet rs=stmt.executeQuery();
          if(rs.next())
          {
              stock=rs.getInt(1);
          }
      }
      catch (Exception ex){
          System.out.println("Exception is in getsPareTotalStock function...."+ex.toString());          
      }
      return stock;
  }
    
    
  
    
    
    
    
    
    
}
