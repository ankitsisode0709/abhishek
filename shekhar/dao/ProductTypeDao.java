/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.dao;

/**
 *
 * @author Rohit
 */

import java.sql.*;
import java.util.Vector;

import shekhar.pojo.ProductType;


public class ProductTypeDao {

    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public ProductTypeDao() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        
    }

public boolean isAddType(ProductType type) throws Exception {
        stmt = conn.prepareStatement("insert into producttype values(0,?)");
        stmt.setString(1, type.getType());
        int value = stmt.executeUpdate();
        //javax.swing.JOptionPane.showMessageDialog(null,value);
        if (value > 0) {
            return true;
        } else {
            return false;
        }
    }

 public Vector[] listOfProduct()throws Exception
    {
        v1=null;
        stmt=conn.prepareStatement("select * from producttype");
        rs=stmt.executeQuery();
        int cnt=0; 
        while(rs.next())
        {
            cnt++;
        }
         v1=new Vector[cnt];
         cnt=0;
         stmt=conn.prepareStatement("select * from producttype");
        rs=stmt.executeQuery();
         
       while(rs.next())
        {
            v1[cnt]=new Vector();
            v1[cnt].add(rs.getInt("typeid"));
            v1[cnt].add(rs.getString("typename"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
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
   
    
}
