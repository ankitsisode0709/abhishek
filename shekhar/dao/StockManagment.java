/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.dao;
import shekhar.pojo.AddProduct;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Rohit
 */
public class StockManagment {
    ShekharDAO sdo;
    Vector vect;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private Vector[] v;
    
    
    public StockManagment() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        //  stmt=sdo.getStatement();
    }
    
    
    
    public boolean isAddStock(int pid)
    {
        try{
            PreparedStatement stmt=conn.prepareStatement("insert into totalstock values(?,'0')");
            stmt.setInt(1, pid);
            int a=stmt.executeUpdate();
            if(a>0)
            {
                System.out.println("Stock is added...");
            }
            else{
                System.out.println("Stock is not added......");
            }
            stmt.close();
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception is in isAddStock function...."+ex.toString());
        }
        return true;
    }
    
    
    
    //get total stock
    
  public int getTotalStock(int pid)
  {
      int stock=0;
      try{
          
          PreparedStatement stmt=conn.prepareStatement("select sum(totalstock) from totalstock where pid=?");
          stmt.setInt(1, pid);
          ResultSet rs=stmt.executeQuery();
          if(rs.next())
          {
              stock=rs.getInt(1);
          }
      }
      catch (Exception ex){
          System.out.println("Exception is in getTotalStock function...."+ex.toString());          
      }
      return stock;
  }
    
    
    
    
    public boolean isUpdateStock(int pid,int qtny)  // use in purchase product
    {
        try{
            PreparedStatement stmt=conn.prepareStatement("update totalstock set totalstock='"+qtny+"' where pid='"+pid+"'");
            //stmt.setString(1, qtny);
            int a=stmt.executeUpdate();
            if(a>0)
            {
                System.out.println("Products are Added and stock is updated...");
            }
            else{
                System.out.println("Products are not Added and stock is not updated...");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception is in isUpdateStock..."+ex.toString());
        }
        return true;
    }
    
    
    
    
    public boolean isDicreasStock(int pid,String qtny)  // use in purchase product
    {
        try{
            PreparedStatement stmt=conn.prepareStatement("update table stock set totalstock=sum(totalstock)-"+qtny+" where pid='"+pid+"'");
            //stmt.setString(1, qtny);
            int a=stmt.executeUpdate();
            if(a>0)
            {
                System.out.println("Stock is updated...");
            }
            else{
                System.out.println("Stock is not updated...");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception is in isDicreasStock..."+ex.toString());
        }
        return true;
    }
    
    
   
    public String chkProduct(int pid)    //check product id is added or not
    {
        String v="";
        try
        {
           int count=0;
           PreparedStatement stmt=conn.prepareStatement("select * from totalstock");
           ResultSet rs=stmt.executeQuery();
           if(rs.next())
           {
               v=rs.getString("totalstock");    
           }
           System.out.println("total Stock is...."+v);
           return v;
           
           
        }
        catch(Exception ex)
        {
            System.out.println("Exception is in chkProduct function..."+ex.toString());
        }
        return v;
    }
    
    
   public int avaliableStock(AddProduct ap)
   {  
       int v=0;
       try{
           stmt=conn.prepareStatement("select sum(p.quantity)-sum(s.quantity) as avlquantity  from purchaseorderentry p,saleorderentry1 s where p.pid=s.pid and s.pid='"+ap.getProdcutID()+"'");
           rs=stmt.executeQuery();
           while(rs.next())
           {
               v=rs.getInt(1);
           }
          stmt.close();
       }
       catch(Exception e)
       {
           System.out.println("Exception is in avaliableStock function.."+e.toString());
       }
       return v;
   }
   
   public int sumOfPurchase(AddProduct ap)
   {  
       int i=0;
       try{
           stmt=conn.prepareStatement("select sum(quantity) from purchaseorderentry where pid='"+ap.getProdcutID()+"'");
           rs=stmt.executeQuery();
           if(rs.next())
                   {
               i=rs.getInt(1);
           }
           
              stmt.close();
       }
       catch(Exception ex)
       {
           System.out.println("Exception is in sumOfPurchase function..."+ex.toString());
       }
       return i;
   }
   
   
    public int sumOfSale(AddProduct ap)
   {  
       int i=0;
       try{
           stmt=conn.prepareStatement("select sum(quantity) from saleorderentry1 where pid='"+ap.getProdcutID()+"'");
            rs=stmt.executeQuery();
           if(rs.next())
                   {
               i=rs.getInt(1);
           } 
           rs.close();
              stmt.close();
       }
              
       catch(Exception ex)
       {
           System.out.println("Exception is in sumOfPurchase function..."+ex.toString());
       }
       return i;
   }
   
    
}
