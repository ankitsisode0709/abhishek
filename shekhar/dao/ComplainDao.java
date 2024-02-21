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
import shekhar.pojo.AddComplain;

public class ComplainDao {

    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public ComplainDao() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        //  stmt=sdo.getStatement();
    }

    public boolean isAddComplain(AddComplain anc, String cid, String pid) throws Exception {
        stmt = conn.prepareStatement("insert into complain values(0,?,?,?,?,?,?)");
        stmt.setString(1, anc.getComplainDescription());
        stmt.setString(2, anc.getComplainDate());
        stmt.setString(3, anc.getComplainTime());
        stmt.setString(4, anc.getComplainStatus());
        stmt.setString(5, cid);
        stmt.setString(6, pid);

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAddSparechangetocomplain(AddComplain adc, String id) throws Exception {
        stmt = conn.prepareStatement("insert into sparechangetocomplain values(?,?,?,?,?,?,?,?)");
        stmt.setString(1, id);
        stmt.setString(2, adc.getEmpid());
        stmt.setInt(3, adc.getSpareid());
        stmt.setString(4, adc.getStatus());
        stmt.setInt(5, adc.getSpaercost());
        stmt.setString(6, adc.getDate());
        stmt.setString(7, adc.getQty());
        stmt.setString(8, adc.getRate());

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAddServiceCard(AddComplain adc) throws Exception {
        stmt = conn.prepareStatement("insert into servicecard values(?,?,?,?,?,?,?,?)");
        stmt.setString(1, adc.getComplainId());
        stmt.setString(2, adc.getVtype());
        stmt.setString(3, adc.getSdate());
        stmt.setString(4, adc.getwDetails());
        stmt.setString(5, adc.getIcrNO());
        stmt.setString(6, adc.getFdate());
        stmt.setString(7, adc.getTdate());
        stmt.setString(8, adc.getContractNo());
        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAddComplainBill(int complainid, String sum, String paid, String bal) throws Exception {
        stmt = conn.prepareStatement("insert into complainbill values(?,?,?,?)");
        stmt.setInt(1, complainid);
        stmt.setString(2, sum);
        stmt.setString(3, paid);
        stmt.setString(4, bal);

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Vector[] listOfAllComplain() throws Exception {
        v1 = null;
        //stmt=conn.prepareStatement("select * from complain where complainstatus='Pending'");
        stmt = conn.prepareStatement("select cmp.complainid, custmername ,cmp.complainid,cmp.description,cmp.complaindate,cmp.complaintime,cmp.complainstatus,c.address,c.conatct,cmp.cid from complain as cmp inner join customer as c on cmp.cid=c.cid");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        // stmt=conn.prepareStatement("select * from complain where complainstatus='Pending'");
        stmt = conn.prepareStatement("select cmp.complainid, custmername ,cmp.complainid,cmp.description,cmp.complaindate,cmp.complaintime,cmp.complainstatus,c.address,c.conatct,cmp.cid from complain as cmp inner join customer as c on cmp.cid=c.cid");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("complainid"));
            v1[cnt].add(rs.getString("custmername"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("conatct"));
            v1[cnt].add(rs.getInt("cid"));
            // System.out.println("HIIII");
            cnt++;
        }
        return v1;
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
            System.out.println(rs.getInt("cid"));
            System.out.println(rs.getString("custmername"));
            cnt++;
        }
        return v1;
    }

    /*public Vector[] listOfComplain()throws Exception
     {
     v1=null;
     stmt=conn.prepareStatement("select * from complain where complainstatus='Pending'");
     rs=stmt.executeQuery();
     int cnt=0; 
     while(rs.next())
     {
     cnt++;
     }
     v1=new Vector[cnt];
     cnt=0;
     stmt=conn.prepareStatement("select * from complain where complainstatus='Pending'");
     rs=stmt.executeQuery();
         
     while(rs.next())
     {
     v1[cnt]=new Vector();
     v1[cnt].add(rs.getInt("complainid"));
     v1[cnt].add(rs.getString("description"));
     v1[cnt].add(rs.getString("complainstatus"));
            
     cnt++;
     }
     return v1;
     }
     */
    public boolean isComplainUpdateStatus(String id) throws Exception {
        stmt = conn.prepareStatement("update complain set complainstatus='On Process' where complainid='" + id + "'");

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Vector[] listOfComplain() throws Exception {
        v1 = null;
        //stmt=conn.prepareStatement("select * from complain where complainstatus='Pending'");
        stmt = conn.prepareStatement("select cmp.complainid, custmername ,cmp.complainid,cmp.description,cmp.complaindate,cmp.complaintime,cmp.complainstatus,c.address,c.conatct,cmp.cid from complain as cmp inner join customer as c on cmp.cid=c.cid where complainstatus='Pending'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        // stmt=conn.prepareStatement("select * from complain where complainstatus='Pending'");
        stmt = conn.prepareStatement("select cmp.complainid, custmername ,cmp.complainid,cmp.description,cmp.complaindate,cmp.complaintime,cmp.complainstatus,c.address,c.conatct,cmp.cid from complain as cmp inner join customer as c on cmp.cid=c.cid where complainstatus='Pending';");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("complainid"));
            v1[cnt].add(rs.getString("custmername"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("conatct"));
            v1[cnt].add(rs.getInt("cid"));
            // System.out.println("HIIII");
            cnt++;
        }
        return v1;
    }

    public Vector[] listOfAssignWork(int id1) throws Exception {

        v1 = null;
        //stmt=conn.prepareStatement("select * from complain where complainid='"+id1+"' ");
        stmt = conn.prepareStatement("select cm.complainid,c.cid,c.custmername,cm.description,cm.complaindate,cm.complaintime,cm.complainstatus from customer c inner join complain cm on c.cid=cm.cid where cm.complainid='" + id1 + "' ");
        //select cm.complainid,c.custmername,cm.description,cm.complaindate,cm.complaintime,cm.complainstatus from customer c inner join complain cm on c.cid=cm.cid where cm.complainid=
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select cm.complainid,c.cid,c.custmername,cm.description,cm.complaindate,cm.complaintime,cm.complainstatus from customer c inner join complain cm on c.cid=cm.cid where cm.complainid='" + id1 + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("complainid"));
            v1[cnt].add(rs.getInt("cid")); //customer id
            v1[cnt].add(rs.getString("custmername"));
            v1[cnt].add(rs.getString("description"));

            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));

            //v1[cnt].add(rs.getInt("cid"));
            cnt++;
        }
        return v1;
    }

    public boolean changeComplainStatus(int complainId, String status) {
        try {
            stmt = conn.prepareStatement("");

        } catch (Exception ex) {
            System.out.println("Exception in changeComplainStatus function.." + ex.toString());
        }
        return false;
    }

    public Vector[] listOfAssignwork() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct cm.complainid,cu.custmername,cm.complaintime,cm.complaindate, cm.complainstatus,cu.address, cu.conatct,name,cu.cid,p.pid,p.pname,emp.eid from assignemployeetocomplain as a  inner join customer as cu on a.cid=cu.cid inner join complain as cm on cu.cid=cm.cid inner join employee as emp on a.eid=emp.eid  inner join producttable as p on p.pid=cm.pid  where cm.complainstatus='On Process'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct cm.complainid,cu.custmername,cm.complaintime,cm.complaindate, cm.complainstatus,cu.address, cu.conatct,name,cu.cid,p.pid,p.pname,emp.eid from assignemployeetocomplain as a  inner join customer as cu on a.cid=cu.cid inner join complain as cm on cu.cid=cm.cid inner join employee as emp on a.eid=emp.eid  inner join producttable as p on p.pid=cm.pid  where cm.complainstatus='On Process'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("complainid"));     //0
            v1[cnt].add(rs.getString("custmername")); //1
            v1[cnt].add(rs.getString("complaintime")); //2
            v1[cnt].add(rs.getString("complaindate")); //3
            v1[cnt].add(rs.getString("complainstatus")); //4
            v1[cnt].add(rs.getString("address")); //5
            v1[cnt].add(rs.getString("conatct")); //6
            v1[cnt].add(rs.getString("name")); //7
            v1[cnt].add(rs.getInt("cid")); //8
            v1[cnt].add(rs.getInt("pid")); //9
            v1[cnt].add(rs.getString("pname")); //10
            v1[cnt].add(rs.getInt("eid")); //11
            cnt++;
        }
        return v1;
    }

    public Vector[] customerSellDetails(int oid) throws Exception {
        v1 = null;
        //stmt=conn.prepareStatement("select * from complain where complainstatus='Pending'");
        stmt = conn.prepareStatement("select distinct sl.pid,pt.pname,od.cid,c.custmername,c.address,c.conatct,c.email from saleorderentry1 as sl inner join producttable as pt on sl.pid=pt.pid inner join saleorder as od on sl.oid=od.oid inner join customer as c on c.cid=od.cid where sl.oid='" + oid + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        // stmt=conn.prepareStatement("select * from complain where complainstatus='Pending'");
        stmt = conn.prepareStatement("select distinct sl.pid,pt.pname,od.cid,c.custmername,c.address,c.conatct,c.email from saleorderentry1 as sl inner join producttable as pt on sl.pid=pt.pid inner join saleorder as od on sl.oid=od.oid inner join customer as c on c.cid=od.cid where sl.oid='" + oid + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("pid"));
            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("cid"));
            v1[cnt].add(rs.getString("custmername"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("conatct"));
            v1[cnt].add(rs.getString("email"));

            cnt++;
        }
        return v1;
    }

    public int countPendingComplain() {
        int cnt = 0;
        try {

            stmt = conn.prepareStatement("select count(complainstatus) from complain where complainstatus='Pending' ");
            rs = stmt.executeQuery();
            if (rs.next()) {
                cnt = rs.getInt(1);
            }
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Exception is in countPendingComplian function.." + ex.toString());
        }
        return cnt;
    }

    public boolean isSparechangetocomplain(int id) throws Exception {
        stmt = conn.prepareStatement("update sparechangetocomplain set status='Solved' where complainid='" + id + "'");

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isComplainsolved(int id) throws Exception {
        stmt = conn.prepareStatement("update complain set complainstatus='Solved' where complainid='" + id + "'");

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int countOnProcessComplain() {
        int cnt = 0;
        try {

            stmt = conn.prepareStatement("select count(complainstatus) from complain where complainstatus='On Process' ");
            rs = stmt.executeQuery();
            if (rs.next()) {
                cnt = rs.getInt(1);
            }
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Exception is in countPendingComplian function.." + ex.toString());
        }
        return cnt;
    }

    public int countSovlvedComplian() {
        int cnt = 0;
        try {

            stmt = conn.prepareStatement("select count(complainstatus) from complain where complainstatus='Solved' ");
            rs = stmt.executeQuery();
            if (rs.next()) {
                cnt = rs.getInt(1);
            }
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Exception is in countPendingComplian function.." + ex.toString());
        }
        return cnt;
    }

    public int getBillTotal(int cmpid) {
        int total = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement("select totalbill from complainbill where complainid='" + cmpid + "'");
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

    public boolean isUpdateBill(int cmpid, int bill, int paid, int Bal) {
        try {
            PreparedStatement stmt = conn.prepareStatement("update complainbill set totalbill='" + bill + "',paid='" + paid + "',balance='" + Bal + "' where complainid='" + cmpid + "'");
            int a = stmt.executeUpdate();
            if (a > 0) {
                System.out.println("Complain bill updated.....");
            } else {
                System.out.println("Compalin bill not added....");
            }

        } catch (Exception ex) {
            System.out.println("Exception is in isUpdateBill.." + ex.toString());
        }
        return true;
    }

    public int getPaidTotal(int cmpid) {
        int Ptotal = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement("select paid from complainbill where complainid='" + cmpid + "'");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Ptotal = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Exception is in getBillTotal..." + ex.toString());
        }
        return Ptotal;
    }

    public int getBalanceTotal(int cmpid) {
        int Btotal = 0;
        try {
            PreparedStatement stmt = conn.prepareStatement("select balance from complainbill where complainid='" + cmpid + "'");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Btotal = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Exception is in getBillTotal..." + ex.toString());
        }
        return Btotal;
    }

}
