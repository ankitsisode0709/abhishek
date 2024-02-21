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
import java.util.ArrayList;
import java.util.Vector;

import shekhar.pojo.AddSpare;

public class SpareDao {

    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public SpareDao() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        //  stmt=sdo.getStatement();
    }

    public boolean isAddSpare(AddSpare asp) throws Exception {
        stmt = conn.prepareStatement("insert into spare values(0,?,?,?,?)");
        stmt.setString(1, asp.getSname());
        stmt.setString(2, asp.getsComp());
        stmt.setString(3, asp.getsDesc());
        stmt.setInt(4, asp.getPid());
        int value = stmt.executeUpdate();
        //javax.swing.JOptionPane.showMessageDialog(null,value);
        if (value > 0) {
            return true;
        } else {
            return false;
        }
    }

   public Vector[] listOfSpare()throws Exception
    {
        v1=null;
        stmt=conn.prepareStatement("select * from spare");
        rs=stmt.executeQuery();
        int cnt=0; 
        while(rs.next())
        {
            cnt++;
        }
         v1=new Vector[cnt];
         cnt=0;
         stmt=conn.prepareStatement("select * from spare");
        rs=stmt.executeQuery();
         
       while(rs.next())
        {
             v1[cnt]=new Vector();
            v1[cnt].add(rs.getInt("spareid"));
            v1[cnt].add(rs.getString("sparename"));
            v1[cnt].add(rs.getString("Company"));
            v1[cnt].add(rs.getString("Description"));
            cnt++;
        }
        return v1;
    }
    public Vector[] listOfSelectedSpare( int id)throws Exception
    {
        v1=null;
         //stmt=conn.prepareStatement("select * from complain where complainstatus='Pending'");
        stmt=conn.prepareStatement("select s.sparename ,s.company,s.spareid from spare as s inner join producttable as pt on s.pid=pt.pid where pt.pid='"+id+"' ");
        rs=stmt.executeQuery();
        int cnt=0; 
        while(rs.next())
        {
            cnt++;
        }
         v1=new Vector[cnt];
         cnt=0;
        // stmt=conn.prepareStatement("select * from complain where complainstatus='Pending'");
          stmt=conn.prepareStatement("select s.sparename ,s.company,s.spareid from spare as s inner join producttable as pt on s.pid=pt.pid where pt.pid='"+id+"'");
        rs=stmt.executeQuery();
         
       while(rs.next())
        {
            v1[cnt]=new Vector();
            v1[cnt].add(rs.getString("sparename"));
            v1[cnt].add(rs.getString("company"));
            v1[cnt].add(rs.getInt("spareid"));
            
             cnt++;
        }
        
       stmt.close();
       rs.close();
       return v1;
       
    }
    
    
    public Vector listOfCompany(String spare)
    {
        Vector v=new Vector();
        int cnt=0;
        try{
           PreparedStatement stmt=conn.prepareStatement("select company from Spare where sparename='"+spare+"' "); 
           ResultSet rs=stmt.executeQuery();
           while(rs.next())
           {
               v.add(rs.getString(1));
               cnt++;
           }
        }
        catch(Exception ex)
        {
           System.out.println("Exception is in listOfCompany function......."+ex.toString()); 
        }
        return v;
    }
    
    
    
    
     public Vector listOfSpareName()throws Exception
    {
        Vector  v1=new Vector();
        stmt=conn.prepareStatement("select distinct sparename from spare");
        rs=stmt.executeQuery();
        int cnt=0; 
        while(rs.next())
        {
            
               v1.add(rs.getString(1));
               cnt++;
          }
        rs.close();
        stmt.close();
         
        return v1;
    }
     
     
     public int getSpareID(String spname,String cmpny)
     {
         int v=0;
         try{
             PreparedStatement stmt=conn.prepareStatement("select spareid from spare where sparename='"+spname+"' and company='"+cmpny+"'");
             ResultSet rs=stmt.executeQuery();
             if(rs.next())
             {
                 v=rs.getInt(1);
             }
             
         }
         catch(Exception ex)
         {
           System.out.println("Exception is in getSpareID funtion...."+ex.toString());  
         }
         return v;
     }
     
     
      public Vector[] isSearchSpare(int id) throws Exception {
        Vector v[];
        ResultSet rs;
        int cnt = 0;
        stmt = conn.prepareStatement("select * from spare where spareid='" + id + "'");
        rs = stmt.executeQuery();
        while (rs.next()) {
            cnt++;
        }
        rs.close();
        v = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from spare where spareid='" + id + "'");
        rs = stmt.executeQuery();
        while (rs.next()) {
            v[cnt] = new Vector();
            v[cnt].addElement(rs.getInt("spareid"));
            v[cnt].addElement(rs.getString("sparename"));
            v[cnt].addElement(rs.getString("company"));
            v[cnt].addElement(rs.getString("description"));
            v[cnt].addElement(rs.getString("pid"));
            cnt++;
        }
        return v;
    }
      
      public Vector[] Notification()throws Exception
    {
        v1=null;
        stmt=conn.prepareStatement("select cu.custmername, DATEDIFF(CURDATE(),s.SDate) as Date1 from servicecard as s inner join complain as c on c.complainid=s.complainid inner join customer as cu on cu.cid=c.cid  where c.complainstatus='Solved'and DATEDIFF(CURDATE(),s.SDate)>=90");
        rs=stmt.executeQuery();
        int cnt=0; 
        while(rs.next())
        {
            cnt++;
        }
         v1=new Vector[cnt];
         cnt=0;
         stmt=conn.prepareStatement("select cu.custmername, DATEDIFF(CURDATE(),s.SDate) as Date1 from servicecard as s inner join complain as c on c.complainid=s.complainid inner join customer as cu on cu.cid=c.cid  where c.complainstatus='Solved'and DATEDIFF(CURDATE(),s.SDate)>=90");
        rs=stmt.executeQuery();
         
       while(rs.next())
        {
             v1[cnt]=new Vector();
          
            v1[cnt].add(rs.getString("custmername"));
            v1[cnt].add(rs.getString("Date1"));
           
            cnt++;
        }
        return v1;
    }
      public Vector[] CountNotification()throws Exception
    {
        v1=null;
        stmt=conn.prepareStatement("select COUNT(cu.custmername) as con from servicecard as s inner join complain as c on c.complainid=s.complainid  inner join customer as cu on cu.cid=c.cid  where c.complainstatus='Solved' and DATEDIFF(CURDATE(),s.SDate)>=90");
        rs=stmt.executeQuery();
        int cnt=0; 
        while(rs.next())
        {
            cnt++;
        }
         v1=new Vector[cnt];
         cnt=0;
         stmt=conn.prepareStatement("select COUNT(cu.custmername) as con from servicecard as s inner join complain as c on c.complainid=s.complainid  inner join customer as cu on cu.cid=c.cid  where c.complainstatus='Solved' and DATEDIFF(CURDATE(),s.SDate)>=90");
        rs=stmt.executeQuery();
         
       while(rs.next())
        {
             v1[cnt]=new Vector();
          
            v1[cnt].add(rs.getString("con"));
         
           
            cnt++;
        }
        return v1;
    }
      
     
}
