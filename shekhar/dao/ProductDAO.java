/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.dao;

/**
 *
 * @author Naresh
 */
import java.sql.*;
import java.util.Vector;
import shekhar.pojo.AddProduct;

import shekhar.pojo.ProductType;
import shekhar.pojo.UpdateProduct;


public class ProductDAO {

    ShekharDAO sdo;
    Vector vect;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private Vector[] v;

    public ProductDAO() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        //  stmt=sdo.getStatement();
    }

   
    

  public boolean isAddProducts(AddProduct aps) throws SQLException {
        stmt = conn.prepareStatement("insert into producttable values(0,?,?,?)");
        stmt.setString(1, aps.getProductName());
        stmt.setString(2, aps.getCompanyName());
        stmt.setInt(3, aps.getProductType());
        //stmt.setString(4.aps.getProductCost());
        int a = stmt.executeUpdate();
        if (a > 0) {
            return true;
        } else {
            System.out.println("Error");
            return false;

        }

    }

    public boolean isUpdateProducts(UpdateProduct ups) throws SQLException {
        stmt = conn.prepareStatement("update producttable set pname=?,compname=?,type=? where pid='" + ups.getPid() + "'");
        stmt.setString(1, ups.getProductName());
        stmt.setString(2, ups.getCompanyName());
        stmt.setString(3, ups.getProductType());
        int a = stmt.executeUpdate();
        if (a > 0) {
            return true;
        } else {
            return false;
        }
    }

    
    //get id of product
   public int getProductID(String pname)
   {
       int a=0;
       try{
           PreparedStatement stmt=conn.prepareStatement("select pid from producttable where pname='"+pname+"'");
          ResultSet rs=stmt.executeQuery();
          if(rs.next())
          {
              a=rs.getInt("pid");
          }
       }
       catch(Exception ex)
       {
           System.out.println(""+ex.toString());
           
           
       }
       return a;
   }
   
    
    
    
    
    
    
    
   public boolean isDeleteProduct(int pid) throws SQLException {
        stmt = conn.prepareStatement("delete from producttable where pid='"+pid+"' ");
        //stmt.setInt(1, pid);
        
        //stmt.setString(4.aps.getProductCost());
        int a = stmt.executeUpdate();
        if (a > 0) {
            return true;
        } else {
            System.out.println("Error");
            return false;

        }
   }
   
    public Vector[] isSearchProduct(int id) throws Exception {
        ResultSet rs;
        int cnt = 0;
        stmt = conn.prepareStatement("select * from producttable where pid='" + id + "'");
        rs = stmt.executeQuery();
        while (rs.next()) {
            cnt++;
        }
        rs.close();
        v = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from producttable where pid='" + id + "'");
        rs = stmt.executeQuery();
        while (rs.next()) {
            v[cnt] = new Vector();
            v[cnt].addElement(rs.getInt("pid"));
            v[cnt].addElement(rs.getString("pname"));
            v[cnt].addElement(rs.getString("compname"));
            v[cnt].addElement(rs.getString("type"));
            cnt++;
        }
        return v;
    }

    public Vector[] listOfProductName() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select * from producttable");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from producttable");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("pid"));
            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("compname"));
            v1[cnt].add(rs.getString("type"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
   
   public Vector[] productDetails(int productid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select * from producttable where pid='"+productid+"' ");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from producttable where pid='"+productid+"' ");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("pid"));
            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("compname"));
            v1[cnt].add(rs.getString("type"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
   
   public Vector isGetProductName(int pid)throws Exception
   {
       vect=new Vector();
       stmt=conn.prepareStatement("select DISTINCT pid,pname from producttable where pid='"+pid+"'");
       rs=stmt.executeQuery();
       while(rs.next())
       {
           vect.add(rs.getInt("pid"));
           vect.add(rs.getString("pname"));
       }
    return vect;   
   }
}
