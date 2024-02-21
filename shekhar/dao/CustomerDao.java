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
package shekhar.dao;

import java.sql.*;
import java.util.Vector;
import shekhar.pojo.AddNewCustomer;
import shekhar.pojo.Addcontract;

public class CustomerDao {

    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public CustomerDao() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        //  stmt=sdo.getStatement();
    }

    public boolean isAddCustomer(AddNewCustomer anc) throws Exception {
        stmt = conn.prepareStatement("insert into customer values(0,?,?,?,?)");
        stmt.setString(1, anc.getCustomerName());
        stmt.setString(2, anc.getCustomerAddress());
        stmt.setString(3, anc.getCustomerContact());
        stmt.setString(4, anc.getCustomerEmailid());
         // stmt.setString(5, anc.getCustid());
       //stmt.setString(5, anc.getCustomerProductId());

        int b = stmt.executeUpdate();
        if (b > 0) {
            System.out.println("Hi");
            return true;

        } else {
            return false;
        }
    }

    public boolean isDeleteCustomer(int cid) throws Exception {
        stmt = conn.prepareStatement("delete from customer where cid= '" + cid + "'");

        int b = stmt.executeUpdate();
        if (b > 0) {
            //System.out.println("Hi");
            return true;

        } else {
            return false;
        }
    }

    public Vector[] listOfCustomer() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select * from customer");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from customer");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("cid"));
            v1[cnt].add(rs.getString("custmername"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("conatct"));
            v1[cnt].add(rs.getString("email"));
             v1[cnt].add(rs.getString("custid"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
    
    public Vector[] listOfCustomerforcard(int id) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select * from customer where cid='"+id+"'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from customer where cid='"+id+"'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("cid"));
            v1[cnt].add(rs.getString("custmername"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("conatct"));
            v1[cnt].add(rs.getString("email"));
             v1[cnt].add(rs.getString("custid"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
    Vector v2;

    public Vector searchCustomer(String cust) throws Exception {
        System.out.println("....1");
        v2 = null;
        int cnt = 0;

        v2 = new Vector();

        stmt = conn.prepareStatement("select * from customer where custmername='" + cust + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {

            v2.add(rs.getInt("cid"));
            v2.add(rs.getString("custmername"));
            v2.add(rs.getString("address"));
            v2.add(rs.getString("conatct"));
            v2.add(rs.getString("email"));
            // v2.add(rs.getString("pid"));
            System.out.println("id is ;;;" + rs.getInt("cid"));

        }
        return v2;
    }

    public Vector[] listOfCustomerName(String contact) throws Exception {
        Vector v5[];
        v5 = null;
        stmt = conn.prepareStatement("select distinct soe1.oid,soe1.pid,so.cid,ct.custmername, ct.address,ct.conatct,ct.email,p.pname   from saleorderentry1 as soe1  inner join saleorder as so on soe1.oid=so.oid   inner join customer as ct on ct.cid=so.cid  inner join producttable as p on soe1.pid=p.pid   where ct.conatct='" + contact + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v5 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct soe1.oid,soe1.pid,so.cid,ct.custmername, ct.address,ct.conatct,ct.email,p.pname   from saleorderentry1 as soe1  inner join saleorder as so on soe1.oid=so.oid   inner join customer as ct on ct.cid=so.cid  inner join producttable as p on soe1.pid=p.pid   where ct.conatct='" + contact + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v5[cnt] = new Vector();
            v5[cnt].add(rs.getInt("oid"));//0
            v5[cnt].add(rs.getInt("pid"));//1
            v5[cnt].add(rs.getInt("cid"));//2
            v5[cnt].add(rs.getString("custmername"));//3
            v5[cnt].add(rs.getString("address"));//4
            v5[cnt].add(rs.getString("conatct"));//5
            v5[cnt].add(rs.getString("email"));//6

            v5[cnt].add(rs.getString("pname"));//7
            // v5[cnt].add(rs.getString("conatct"));
            // v5[cnt].add(rs.getString("email"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v5;
    }

    public Vector[] BillDetails(int oid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("SELECT c.custmername,c.address,so.oid,p.pid,p.pname,soe1.quantity,soe1.rate,soe1.total,so.total as GrandTotal from saleorder as so inner join saleorderentry1 as soe1 on so.oid=soe1.oid inner join customer as c on c.cid=so.cid inner join producttable as p on p.pid=soe1.pid where so.oid='" + oid + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("SELECT c.custmername,c.address,so.oid,p.pid,p.pname,soe1.quantity,soe1.rate,soe1.total,so.total as GrandTotal from saleorder as so inner join saleorderentry1 as soe1 on so.oid=soe1.oid inner join customer as c on c.cid=so.cid inner join producttable as p on p.pid=soe1.pid where so.oid='" + oid + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getString("custmername"));//0
            v1[cnt].add(rs.getString("address"));//1
            v1[cnt].add(rs.getInt("oid"));//2
            v1[cnt].add(rs.getInt("pid"));//2
            v1[cnt].add(rs.getString("pname"));//3
            v1[cnt].add(rs.getString("quantity"));//4
            v1[cnt].add(rs.getString("rate"));//5
            v1[cnt].add(rs.getString("total"));//6
            v1[cnt].add(rs.getString("GrandTotal"));//7
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
    public boolean isAddcontract(Addcontract anc) throws Exception {
        stmt = conn.prepareStatement("insert into contract values(0,?,?,?,?,?)");
        stmt.setString(1, anc.getFdate());
        stmt.setString(2, anc.getTdate());
        stmt.setString(3, anc.getModal());
        stmt.setString(4, anc.getAmount());
          stmt.setInt(5, anc.getCid());
       //stmt.setString(5, anc.getCustomerProductId());

        int b = stmt.executeUpdate();
        if (b > 0) {
            System.out.println("Hi");
            return true;

        } else {
            return false;
        }
    }


   

}
