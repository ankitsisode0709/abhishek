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

import shekhar.pojo.AddNewEmployee;

public class EmployeeDao {

    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public EmployeeDao() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        //  stmt=sdo.getStatement();
    }

    public boolean isAddEmployee(AddNewEmployee ane) throws Exception {
        stmt = conn.prepareStatement("insert into employee values(0,?,?,?,?,?,?)");
        stmt.setString(1, ane.getName());
        stmt.setString(2, ane.getEmail());
        stmt.setString(3, ane.getAddress());
        stmt.setString(4, ane.getContact());
        stmt.setString(5, ane.getDate().toString());
        stmt.setString(6, ane.getDesignation());
        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDeleteEmployee(int eid) throws SQLException {
        stmt = conn.prepareStatement("delete from employee where eid='" + eid + "' ");
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

    public Vector[] listOfEmployee() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select * from employee");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from employee");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("eid"));
            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("jdate"));
            v1[cnt].add(rs.getString("Designation"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] searchEmployee(String emp) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select * from employee like %'" + emp + "'%");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from employee like %'" + emp + "'%");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("eid"));
            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("jdate"));
            v1[cnt].add(rs.getString("designation"));

            cnt++;
        }
        return v1;
    }

    public int isLogin(AddNewEmployee ane) throws SQLException {
        stmt = conn.prepareStatement("select eid from employee where name=? and email=?");
        stmt.setString(1, ane.getName());
        stmt.setString(2, ane.getEmail());
        rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("eid");
        } else {
            return 0;
        }
    }
    public Vector[] EmployeeDetails(int eid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select * from employee where eid='" + eid + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from employee where eid='" + eid + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();
            v1[cnt].add(rs.getInt("eid"));
            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("jdate"));
            v1[cnt].add(rs.getString("Designation"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
    public int CountEmpOnProcessComplain(int eid) {
        int cnt = 0;
        try {

            stmt = conn.prepareStatement("select count(complainstatus) from complain as c inner join assignemployeetocomplain as asw on c.complainid=asw.complainid inner join employee as e on asw.eid=e.eid where e.eid='" + eid + "' and complainstatus='On Process' ");
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
     public int CountEmpSolvedComplain(int eid) {
        int cnt = 0;
        try {

            stmt = conn.prepareStatement("select count(complainstatus) from complain as c inner join assignemployeetocomplain as asw on c.complainid=asw.complainid inner join employee as e on asw.eid=e.eid where e.eid='" + eid + "' and complainstatus='Solved' ");
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
     public int CountEmpPendingComplain(int eid) {
        int cnt = 0;
        try {

            stmt = conn.prepareStatement("select count(complainstatus) from complain as c inner join assignemployeetocomplain as asw on c.complainid=asw.complainid inner join employee as e on asw.eid=e.eid where e.eid='" + eid + "' and complainstatus='Pending' ");
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
     public Vector[] EmployeeOnProcessDetails(int eid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select e.name,asw.complainid,e.email,cu.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,p.pname,spc.spareid,sp.sparename,sp.company,spc.cost from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as p on p.pid=c.pid inner join sparechangetocomplain as spc on asw.complainid=spc.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='On Process' and e.eid='"+eid+"' ");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select e.name,asw.complainid,e.email,cu.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,p.pname,spc.spareid,sp.sparename,sp.company,spc.cost from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as p on p.pid=c.pid inner join sparechangetocomplain as spc on asw.complainid=spc.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='On Process' and e.eid='"+eid+"'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name")); //0
            v1[cnt].add(rs.getInt("complainid")); //1
            v1[cnt].add(rs.getString("email")); //1
            v1[cnt].add(rs.getString("address"));//2
            v1[cnt].add(rs.getString("contact"));//3
            v1[cnt].add(rs.getString("description"));//4
            v1[cnt].add(rs.getString("complaindate"));//5

            v1[cnt].add(rs.getString("complaintime"));//6
            v1[cnt].add(rs.getString("complainstatus"));//7
            v1[cnt].add(rs.getString("custmername"));//8
            v1[cnt].add(rs.getString("pname"));//9
            v1[cnt].add(rs.getString("spareid"));//10
            v1[cnt].add(rs.getString("sparename"));//11
            v1[cnt].add(rs.getString("company"));//12
            v1[cnt].add(rs.getString("cost"));//13
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
     public Vector[] EmployeeSolvedDetails(int eid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select e.name,asw.complainid,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,p.pname,spc.spareid,sp.sparename,sp.company,spc.cost,cb.totalbill from employee as e  inner join assignemployeetocomplain as asw on e.eid=asw.eid  inner join complain as c on asw.cid=c.cid  inner join customer as cu on cu.cid=c.cid inner join producttable as p on p.pid=c.pid inner join sparechangetocomplain as spc on asw.complainid=spc.complainid inner join spare as sp on sp.spareid=spc.spareid inner join complainbill as cb on cb.complainid=asw.complainid WHERE c.complainstatus='Solved'and e.eid='"+eid+"'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select e.name,asw.complainid,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,p.pname,spc.spareid,sp.sparename,sp.company,spc.cost,cb.totalbill from employee as e  inner join assignemployeetocomplain as asw on e.eid=asw.eid  inner join complain as c on asw.cid=c.cid  inner join customer as cu on cu.cid=c.cid inner join producttable as p on p.pid=c.pid inner join sparechangetocomplain as spc on asw.complainid=spc.complainid inner join spare as sp on sp.spareid=spc.spareid inner join complainbill as cb on cb.complainid=asw.complainid WHERE c.complainstatus='Solved'  and e.eid='"+eid+"'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name")); //0
            v1[cnt].add(rs.getInt("complainid")); //0
            v1[cnt].add(rs.getString("email")); //1
            v1[cnt].add(rs.getString("address"));//2
            v1[cnt].add(rs.getString("contact"));//3
            v1[cnt].add(rs.getString("description"));//4
            v1[cnt].add(rs.getString("complaindate"));//5

            v1[cnt].add(rs.getString("complaintime"));//6
            v1[cnt].add(rs.getString("complainstatus"));//7
            v1[cnt].add(rs.getString("custmername"));//8
            v1[cnt].add(rs.getString("pname"));//9
            v1[cnt].add(rs.getString("spareid"));//10
            v1[cnt].add(rs.getString("sparename"));//11
            v1[cnt].add(rs.getString("company"));//12
            v1[cnt].add(rs.getString("cost"));//13
            v1[cnt].add(rs.getString("totalbill"));//14
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
}
