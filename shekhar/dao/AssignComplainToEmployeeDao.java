/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shekhar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import shekhar.pojo.AssignComplaintoEmployee;

/**
 *
 * @author Sunny
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Naresh
 */
import java.sql.*;
import java.util.Vector;

//import shekhar.pojo.AddNewEmployee;
import shekhar.pojo.AssignComplaintoEmployee;

public class AssignComplainToEmployeeDao {

    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public AssignComplainToEmployeeDao() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        //  stmt=sdo.getStatement();
    }

   public boolean isAssignEmployeetoWork(AssignComplaintoEmployee ans)
   {    
       try{
       stmt=conn.prepareStatement("insert into assignemployeetocomplain values(?,?,?,?,?)");
       stmt.setInt(1, ans.getComplainid());
       stmt.setInt(2, ans.getCustid());
       stmt.setInt(3, ans.getEmpid());
       stmt.setString(4, ans.getDatetosend());
       stmt.setString(5, ans.getReason());
       //stmt.setString(5, ans.getComplaintype());
      // stmt.setString(6, ans.getComplaintime());
       //stmt.setString(7, ans.getComplaindate());
       
      // stmt.setInt(9, ans.getTotleCharge());
      // stmt.setInt(10, ans.getPaindingAmount());
      // stmt.setInt(11, ans.getRmaining());
       
       int b=stmt.executeUpdate();
       if(b>0)
       {
           return true;
       }
       else
       {
        
           return false;
       }
       }catch(Exception e)
       {
              System.out.println("Error is"+e.toString());
       }
       return false;
   }
    

   /*public Vector[] listOfProduct()throws Exception
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
            System.out.println(rs.getInt("typeid"));
            System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }*/
}


