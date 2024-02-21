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

/**
 *
 * @author Naresh
 */
import java.sql.*;
import java.util.Vector;

//import shekhar.pojo.AddNewEmployee;
import shekhar.pojo.AddSuplier;

public class SuplierDao {

    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public SuplierDao() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        //  stmt=sdo.getStatement();
    }

    public boolean isAddSuplier(AddSuplier ans) throws Exception {
        stmt = conn.prepareStatement("insert into addsupplier values(0,?,?,?,?,?)");
        stmt.setString(1, ans.getSupliername());
        stmt.setString(2, ans.getSuplieraddress());
        stmt.setString(3, ans.getSuplieremail());
        stmt.setString(4, ans.getSupliercontact());

        stmt.setString(5, ans.getSupliercompany());

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Vector supplierDetails(String sname) throws Exception {
        Vector v = new Vector();
        stmt = conn.prepareStatement("select * from addsupplier where sname='" + sname + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {

            v.add(rs.getInt("sid"));
            v.add(rs.getString("sname"));
            v.add(rs.getString("address"));
            v.add(rs.getString("email"));
            v.add(rs.getString("contact"));
            v.add(rs.getString("company"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));

        }
        return v;
    }

    public Vector[] listOfAllSupplier() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select * from addsupplier");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from addsupplier");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("sid"));
            v1[cnt].add(rs.getString("sname"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("company"));

            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector Updatesalebill(String Icrno) throws Exception {
        Vector v = new Vector();
        stmt = conn.prepareStatement("select s.oid,c.custid,c.custmername,c.address,c.conatct,s.total,s.paid,s.balance from saleorder as s inner  join customer as c on s.cid=c.cid Where s.oid='" + Icrno + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {

            v.add(rs.getInt("oid"));//0
            v.add(rs.getString("custid"));//1
            v.add(rs.getString("custmername"));//2
            v.add(rs.getString("address"));//3
            v.add(rs.getString("conatct"));//4
            v.add(rs.getString("total"));//5
            v.add(rs.getString("paid"));//6
            v.add(rs.getString("balance"));//7
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));

        }
        return v;
    }

    public boolean UpdateBill(String icr, String paid, String balance) throws Exception {
        stmt = conn.prepareStatement("update saleorder set paid='" + paid + "',balance='" + balance + "' where oid='" + icr + "'");

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean UpdatepurchaseBill(String icr, String paid, String balance) throws Exception {
        stmt = conn.prepareStatement("update purchaseorder set paid='" + paid + "',balance='" + balance + "' where oid='" + icr + "'");

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Vector updatepurchasebill(String icr) throws Exception {
        Vector v = new Vector();
        stmt = conn.prepareStatement("select p.oid, s.sname,s.address,s.contact,s.company,p.total,p.paid,p.balance from purchaseorder as p inner join addsupplier as s on s.sid=p.sid where p.oid='" + icr + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {

            v.add(rs.getInt("oid"));//0
            v.add(rs.getString("sname"));//1
            v.add(rs.getString("address"));//2
            v.add(rs.getString("contact"));//3
            v.add(rs.getString("company"));//4
            v.add(rs.getString("total"));//5
            v.add(rs.getString("paid"));//6
            v.add(rs.getString("balance"));//7

        }
        return v;
    }

    public boolean UpdateSparepurchaseBill(String icr, String paid, String balance) throws Exception {
        stmt = conn.prepareStatement("update spareorder set paid='" + paid + "',balance='" + balance + "' where orderid='" + icr + "'");

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Vector Updatepurchasesparebill(String Icrno) throws Exception {
        Vector v = new Vector();
        stmt = conn.prepareStatement("select s.orderid,c.sname,c.address,c.contact,c.company,s.total,s.paid,s.balance from spareorder as s inner  join addsupplier as c on s.supplierid=c.sid   Where s.orderid='" + Icrno + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {

            v.add(rs.getInt("orderid"));//0
            v.add(rs.getString("sname"));//1
            v.add(rs.getString("address"));//2
            v.add(rs.getString("contact"));//3
            v.add(rs.getString("company"));//4
            v.add(rs.getString("total"));//5
            v.add(rs.getString("paid"));//6
            v.add(rs.getString("balance"));//7
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));

        }
        return v;
    }

    public Vector UpdateComplainbill(String Complainid) throws Exception {
        Vector v = new Vector();
        stmt = conn.prepareStatement(" select  b.complainid,c.custid,c.custmername,c.address,c.conatct, b.totalbill,b.paid,b.balance from complainbill as b inner join complain as cm on cm.complainid=b.complainid inner join customer as c on c.cid=cm.cid  where  b.complainid='" + Complainid + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {

            v.add(rs.getInt("complainid"));//0
            v.add(rs.getString("custid"));//1
            v.add(rs.getString("custmername"));//1
            v.add(rs.getString("address"));//2
            v.add(rs.getString("conatct"));//3
            v.add(rs.getString("totalbill"));//4
            v.add(rs.getString("paid"));//5
            v.add(rs.getString("balance"));//6

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
        }
        return v;
    }
        public boolean UpdateComplainBill(String id, String paid, String balance) throws Exception {
        stmt = conn.prepareStatement("update complainbill set paid='" + paid + "',balance='" + balance + "' where complainid='" + id + "'");

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }


}
