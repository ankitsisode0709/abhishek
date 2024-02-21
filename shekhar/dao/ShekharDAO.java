/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shekhar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import shekhar.pojo.*;
import shekhar.pojo.AddNewEmployee;
import shekhar.pojo.AddProduct;
import shekhar.pojo.AddSpare;
import shekhar.pojo.UpdateProduct;

/**
 *
 * @author Rohit
 */
public class ShekharDAO {

    private static ShekharDAO skd;
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    Vector[] v;
    public Vector v1[];

    private ShekharDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shekar1", "root", "root");
        } catch (Exception e) {
            System.out.println("There is proble to establish connection" + e.toString());
        }
    }

    public static ShekharDAO getInstance() throws Exception {
        if (skd == null) {
            skd = new ShekharDAO();
        }
        return skd;
    }

    public Connection getConn() throws Exception {
        return conn;
    }

    public PreparedStatement getStatement() {
        return stmt;
    }
}
    /*
    

   //Table employee
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

    public boolean isUpdateEmployee(int id, UpdateEmployee uet) throws Exception {
        stmt = conn.prepareStatement("update employee set name=?,email=?,address=?,contact=?,date=?,designation=? where eid='" + id + "'");
        stmt.setString(1, uet.getEmployeeName());
        stmt.setString(2, uet.getEmployeeEmail());
        stmt.setString(3, uet.getEmployeeAddress());
        stmt.setString(4, uet.getEmployeeContact());
        stmt.setString(1, uet.getEmployeeJoiningDate());
        stmt.setString(1, uet.getEmployeeDesignation());
        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDeleteEmployee(String EmployeeName) throws SQLException {
        stmt = conn.prepareStatement("delete from employee where product name='" + EmployeeName + "'");

        int c = stmt.executeUpdate();
        if (c > 0) {
            return true;
        } else {
            return false;
        }
    }

     //Table customer
    public boolean isAddCustomer(AddNewCustomer anc) throws Exception {
        stmt = conn.prepareStatement("insert into customer values(0,?,?,?,?,?)");
        stmt.setString(1, anc.getCustomerName());
        stmt.setString(2, anc.getCustomerAddress());
        stmt.setString(3, anc.getCustomerContact());
        stmt.setString(4, anc.getCustomerEmailid());
        stmt.setString(5, anc.getCustomerProductId());

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isUpdateCustomer(int customerId, UpdateCustomer uct) throws Exception {
        stmt = conn.prepareStatement("update customer set custname=?,address=?,contact=?,email=?,pid=? where cid='" + customerId + "'");
        stmt.setString(1, uct.getCustomerEmailid());
        stmt.setString(2, uct.getCustomerAddress());
        stmt.setString(3, uct.getCustomerContact());
        stmt.setString(4, uct.getCustomerEmailid());
        stmt.setInt(5, uct.getCustomerProductId());

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDeleteCustomer(String CustomerName) throws SQLException {
        stmt = conn.prepareStatement("delete from customer where product name='" + CustomerName + "'");

        int c = stmt.executeUpdate();
        if (c > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Vector[] isSearchCustomer(int id) throws Exception {
        ResultSet rs;
        int cnt = 0;
        stmt = conn.prepareStatement("select * from customer where pid='" + id + "'");
        rs = stmt.executeQuery();
        while (rs.next()) {
            cnt++;
        }
        rs.close();
        v = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from customer where pid='" + id + "'");
        rs = stmt.executeQuery();
        while (rs.next()) {
            v[cnt] = new Vector();
            v[cnt].addElement(rs.getInt("cid"));
            v[cnt].addElement(rs.getString("custmernane"));
            v[cnt].addElement(rs.getString("address"));
            v[cnt].addElement(rs.getString("contact"));
            v[cnt].addElement(rs.getString("email"));
            v[cnt].addElement(rs.getInt("pid"));
            cnt++;
        }
        return v;
    }

         //Table "spare"
    public boolean isAddSpare(AddSpare ast) throws Exception {
        stmt = conn.prepareStatement("insert into spare values(0,?,?,?,?,?)");
        stmt.setString(1, ast.getSname());
        stmt.setString(2, ast.getsDesc());
        stmt.setString(3, ast.getScost());
        stmt.setString(4, ast.getsComp());
        stmt.setString(5, ast.getType());
        stmt.setString(5, ast.getWDate());

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isUpdateSpare(int spareid, UpdateSpare ust) throws Exception {
        stmt = conn.prepareStatement("update spare set sparename=?,sparedescription=?,sparecost=?,companyname=?,type=?,warrentydate=? where spareid='" + spareid + "'");
        stmt.setString(1, ust.getSpareName());
        stmt.setString(2, ust.getSpareDescription());
        stmt.setString(3, ust.getSpareCost());
        stmt.setString(4, ust.getSpareCompony());
        stmt.setString(5, ust.getSpareType());
        stmt.setString(5, ust.getSpareWarrontyDate());

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDeleteSpare(String SpareName) throws SQLException {
        stmt = conn.prepareStatement("delete from spare where product sparename='" + SpareName + "'");

        int c = stmt.executeUpdate();
        if (c > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Vector[] isSearchSpare(int spareid) throws Exception {
        ResultSet rs;
        int cnt = 0;
        stmt = conn.prepareStatement("select * from customer where pid='" + spareid + "'");
        rs = stmt.executeQuery();
        while (rs.next()) {
            cnt++;
        }
        rs.close();
        v = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select * from customer where pid='" + spareid + "'");
        rs = stmt.executeQuery();
        while (rs.next()) {
            v[cnt] = new Vector();
            v[cnt].addElement(rs.getInt("spareid"));
            v[cnt].addElement(rs.getString("sparenane"));
            v[cnt].addElement(rs.getString("sapredescription"));
            v[cnt].addElement(rs.getString("sparecost"));
            v[cnt].addElement(rs.getString("companyname"));
            v[cnt].addElement(rs.getString("type"));
            v[cnt].addElement(rs.getString("warrentydate"));
            cnt++;
        }
        return v;
    }

    //Table complain
    public boolean isAddComplain(AddComplain act) throws Exception {
        stmt = conn.prepareStatement("insert into complain values(0,?,?,?,?,?)");
        stmt.setString(1, act.getComplainDescription());
        stmt.setString(2, act.getComplainDate());
        stmt.setString(3, act.getComplainTime());
        stmt.setString(4, act.getComplainStatus());
        stmt.setInt(5, act.getCustomerId());

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean iaUpdateComplain(int complainid, UpdateComplain act) throws Exception {
        stmt = conn.prepareStatement("update copmlain set decription=?,date=?,time=?,satus=?,cid=? where complainid='" + complainid + "' ");
        stmt.setString(1, act.getComplainDescription());
        stmt.setString(2, act.getComplainDate());
        stmt.setString(3, act.getComplainTime());
        stmt.setString(4, act.getComplainStatus());
        stmt.setInt(5, act.getCustomerId());

        int b = stmt.executeUpdate();
        if (b > 0) {
            return true;
        } else {
            return false;
        }
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
            v1[cnt].add(rs.getInt("type"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
*/

