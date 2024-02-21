/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.dao;
import java.sql.*;
import java.util.Vector;
import shekhar.pojo.AddSellProduct;
import shekhar.pojo.UpdateSaleProduct;
/**
 *
 * @author Rohit
 */
public class SellProduct {
    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    public Vector v;

    public SellProduct() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
   
    }
    
    public boolean isAddSellProduct(AddSellProduct asp)throws Exception 
    {
        stmt=conn.prepareStatement("insert into saleorder values(0,?,?,?,'0','0',?,'0')");
        stmt.setString(1, asp.getOrderDate());
        stmt.setInt(2,asp.getCustId());
        stmt.setInt(3,asp.getTotal());
        stmt.setString(4,asp.getStatus());
        
       
        int a=stmt.executeUpdate();
        if(a>0)
        {
            System.out.println("Sell Product Added Sucessfully....");
        }
        else
        {
             System.out.println("Sell Product Not Added Sucessfully....");
        }
        return false;
    }
    public int isGetOrderId(int custID)throws Exception
    {
        int v=0;
        stmt=conn.prepareStatement("select oid from saleorder where cid='"+custID+"'");
        rs=stmt.executeQuery();
        while(rs.next())
        {
            v=(rs.getInt(1));
        }
        stmt.close();
        return v;
    }
    
    
    public boolean isUpdateSaleRecord(UpdateSaleProduct usp)throws Exception
    {
        stmt=conn.prepareStatement("update saleorder set total=?,paid=?,balance=?,status=? ,vatAmt=? where oid='"+usp.getOrderID()+"' ");
        stmt.setString(1,usp.getTotal());
        stmt.setString(2,usp.getPaid());
        stmt.setString(3,usp.getBalance());
        stmt.setString(4,usp.getStatus());
        stmt.setString(5,usp.getVat());
        int a=stmt.executeUpdate();
        if(a>0)
        {
         System.out.println("Sale Product Updated Sucessfully....");   
        }
        else
        {
           System.out.println("Sale Product Not Updated Sucessfully....");  
        }
         stmt.close();
        return false;
    }
    
          public int SaleTotal(String sdate,String edate) {
        int total = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement("select sum(total) from saleorder where odate BETWEEN  '"+sdate+"' And '"+edate+"'  ");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Exception is in getBillTotal..." + ex.toString());
        }
        return total;
    }
           public int purchaseTotal( String sdate,String edate) {
        int total = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement("select sum(total) from purchaseorder where odate BETWEEN  '"+sdate+"' And '"+edate+"' ");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Exception is in getBillTotal..." + ex.toString());
        }
        return total;
    }
            public Vector[] ProfitByEmployee( int eid,String sdate, String edate) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select sum(cmp.totalbill),sum(cmp.paid),sum(cmp.balance) from complainbill as cmp inner join assignemployeetocomplain as ase on ase.complainid=cmp.complainid inner join employee as e on e.eid=ase.eid where ase.eid='"+eid+"' and ase.datetosend BETWEEN '"+sdate+"' and '"+edate+"' ");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select sum(cmp.totalbill),sum(cmp.paid),sum(cmp.balance) from complainbill as cmp inner join assignemployeetocomplain as ase on ase.complainid=cmp.complainid inner join employee as e on e.eid=ase.eid where ase.eid='"+eid+"' and ase.datetosend BETWEEN '"+sdate+"' and '"+edate+"'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("sum(cmp.totalbill)"));
            v1[cnt].add(rs.getString("sum(cmp.paid)"));
            v1[cnt].add(rs.getString("sum(cmp.balance)"));
            
      

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
            
}
