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

import shekhar.pojo.SearchCustomerComplainDetails;

public class SearchEmployeeDetails {

    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    public static String custid;
        public static String modal;
    public SearchEmployeeDetails() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        //  stmt=sdo.getStatement();
    }

    /*public Vector[] StartDateToEndDateComplain(String sdate,String edate)throws Exception
     {
     v1=null;
     stmt=conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid WHERE complaindate BETWEEN '"+sdate+"' AND '"+edate+"'\n" +
     "\n" +
     "\n" +
     "\n" +
     "");
     rs=stmt.executeQuery();
     int cnt=0; 
     while(rs.next())
     {
     cnt++;
     }
     v1=new Vector[cnt];
     cnt=0;
     stmt=conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid WHERE complaindate BETWEEN '"+sdate+"' AND '"+edate+"'\n" +
     "\n" +
     "\n" +
     "\n" +
     "");
     rs=stmt.executeQuery();
         
     while(rs.next())
     {
     v1[cnt]=new Vector();
            
     v1[cnt].add(rs.getString("name"));
     v1[cnt].add(rs.getString("email"));
     v1[cnt].add(rs.getString("address"));
     v1[cnt].add(rs.getString("contact"));
     v1[cnt].add(rs.getString("description"));
     v1[cnt].add(rs.getString("complaindate"));
     v1[cnt].add(rs.getString("complaintime"));
     v1[cnt].add(rs.getString("complainstatus"));
     //System.out.println(rs.getInt("typeid"));
     //System.out.println(rs.getString("typename"));
     cnt++;
     }
     return v1;
     }
     */
    public Vector[] StartDateToEndDateComplain(String sdate, String edate) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill  from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid   inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complaindate BETWEEN '" + sdate + "' AND '" + edate + "'\n"
                + " \n"
                + " \n"
                + " ");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill  from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid   inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complaindate BETWEEN '" + sdate + "' AND '" + edate + "'\n"
                + " \n"
                + " \n"
                + " ");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));

            v1[cnt].add(rs.getString("custmername"));
            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("sparename"));
            v1[cnt].add(rs.getString("company"));
            v1[cnt].add(rs.getString("cost"));
            v1[cnt].add(rs.getString("totalbill"));

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] AllOnProcessRecord() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid WHERE c.complainstatus='On Process'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid WHERE c.complainstatus='On Process'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] AllPaindingRecord() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cust.custmername from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='Pending' and complaindate between NOW()- INTERVAL 1 MONTH and now()");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cust.custmername from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='Pending' and complaindate between NOW()- INTERVAL 1 MONTH and now()");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    /*public Vector[] OnProcessCOmplainBetweenTwoDate(String sdate,String edate)throws Exception
     {
     v1=null;
     stmt=conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid WHERE complaindate BETWEEN '"+sdate+"' AND '"+edate+"' and c.complainstatus='On Process'");
     rs=stmt.executeQuery();
     int cnt=0; 
     while(rs.next())
     {
     cnt++;
     }
     v1=new Vector[cnt];
     cnt=0;
     stmt=conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid WHERE complaindate BETWEEN '"+sdate+"' AND '"+edate+"' and c.complainstatus='On Process'");
     rs=stmt.executeQuery();
         
     while(rs.next())
     {
     v1[cnt]=new Vector();
            
     v1[cnt].add(rs.getString("name"));
     v1[cnt].add(rs.getString("email"));
     v1[cnt].add(rs.getString("address"));
     v1[cnt].add(rs.getString("contact"));
     v1[cnt].add(rs.getString("description"));
     v1[cnt].add(rs.getString("complaindate"));
     v1[cnt].add(rs.getString("complaintime"));
     v1[cnt].add(rs.getString("complainstatus"));
     //System.out.println(rs.getInt("typeid"));
     //System.out.println(rs.getString("typename"));
     cnt++;
     }
     return v1;
     }*/
    public Vector[] SlovedComplainBetweenTwoDate(String sdate, String edate) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill  from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid   inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='Solved' and c.complaindate BETWEEN '" + sdate + "' AND '" + edate + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement(" select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill  from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid   inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='Solved' and c.complaindate BETWEEN '" + sdate + "' AND '" + edate + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));

            v1[cnt].add(rs.getString("custmername"));
            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("sparename"));
            v1[cnt].add(rs.getString("Company"));
            v1[cnt].add(rs.getString("cost"));
            v1[cnt].add(rs.getString("totalbill"));

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] OnProcessCOmplainBetweenTwoDate(String sdate, String edate) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill  from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid   inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='On Process' and c.complaindate BETWEEN '" + sdate + "' AND '" + edate + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill  from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid   inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='On Process' and c.complaindate BETWEEN '" + sdate + "' AND '" + edate + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));

            v1[cnt].add(rs.getString("custmername"));
            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("sparename"));
            v1[cnt].add(rs.getString("Company"));
            v1[cnt].add(rs.getString("cost"));
            v1[cnt].add(rs.getString("totalbill"));

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] SolvedComplainMonth(String month) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='Solved' and complaindate between NOW()- INTERVAL '" + month + "' MONTH and now()");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='Solved' and complaindate between NOW()- INTERVAL '" + month + "' MONTH and now()");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));//0
            v1[cnt].add(rs.getString("email"));//1
            v1[cnt].add(rs.getString("address"));//2
            v1[cnt].add(rs.getString("contact"));//3
            v1[cnt].add(rs.getString("complainid"));//3
            v1[cnt].add(rs.getString("description"));//4
            v1[cnt].add(rs.getString("complaindate"));//5
            v1[cnt].add(rs.getString("complaintime"));//6
            v1[cnt].add(rs.getString("complainstatus"));//7
            v1[cnt].add(rs.getString("custmername"));//8

            v1[cnt].add(rs.getString("pname"));//9
            v1[cnt].add(rs.getString("sparename"));//3
            v1[cnt].add(rs.getString("company"));//3
            v1[cnt].add(rs.getString("cost"));//3
            v1[cnt].add(rs.getString("totalbill"));//10
            //v1[cnt].add(rs.getString("sparename"));
            // v1[cnt].add(rs.getString("Company"));

            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] PendingComplainMonth(String month) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select c.complainid,cu.custmername,c.description,c.complaindate,c.complaintime,c.complainstatus,p.pname from complain as c inner join customer as cu on cu.cid=c.cid inner join producttable as p on p.pid=c.pid WHERE c.complainstatus='Pending' and complaindate between NOW()- INTERVAL '" + month + "' MONTH and now()\n"
                + " \n"
                + " ");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select c.complainid,cu.custmername,c.description,c.complaindate,c.complaintime,c.complainstatus,p.pname from complain as c inner join customer as cu on cu.cid=c.cid inner join producttable as p on p.pid=c.pid WHERE c.complainstatus='Pending' and complaindate between NOW()- INTERVAL '" + month + "' MONTH and now()\n"
                + " \n"
                + " ");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("custmername"));

            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));

            v1[cnt].add(rs.getString("pname"));

            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] PendingComplanByCustomer(String cid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select c.complainid,cu.custmername,c.description,c.complaindate,c.complaintime,c.complainstatus,p.pname from complain as c inner join customer as cu on cu.cid=c.cid inner join producttable as p on p.pid=c.pid WHERE c.complainstatus='Pending' and cu.cid='" + cid + "'\n"
                + " \n"
                + " ");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select c.complainid,cu.custmername,c.description,c.complaindate,c.complaintime,c.complainstatus,p.pname from complain as c inner join customer as cu on cu.cid=c.cid inner join producttable as p on p.pid=c.pid WHERE c.complainstatus='Pending' and cu.cid='" + cid + "'\n"
                + " \n"
                + " ");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("custmername"));

            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));

            v1[cnt].add(rs.getString("pname"));

            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] OnProcessComplainMonth(String month) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc  inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid 	inner join employee as e on asw.eid=e.eid  	inner join complain as c on asw.cid=c.cid 	inner join customer as cu on cu.cid=c.cid	 inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='On Process'and complaindate between NOW()- INTERVAL '" + month + "' MONTH and now()");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc  inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid 	inner join employee as e on asw.eid=e.eid  	inner join complain as c on asw.cid=c.cid 	inner join customer as cu on cu.cid=c.cid	 inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='On Process'and complaindate between NOW()- INTERVAL '" + month + "' MONTH and now()");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));//0
            v1[cnt].add(rs.getString("email"));//1
            v1[cnt].add(rs.getString("address"));//2
            v1[cnt].add(rs.getString("contact"));//3
            v1[cnt].add(rs.getString("complainid"));//3
            v1[cnt].add(rs.getString("description"));//4
            v1[cnt].add(rs.getString("complaindate"));//5
            v1[cnt].add(rs.getString("complaintime"));//6
            v1[cnt].add(rs.getString("complainstatus"));//7
            v1[cnt].add(rs.getString("custmername"));//8

            v1[cnt].add(rs.getString("pname"));//9
            // v1[cnt].add(rs.getString("totalbill"));
            v1[cnt].add(rs.getString("sparename"));//10
            v1[cnt].add(rs.getString("Company"));//11
            v1[cnt].add(rs.getString("cost"));//12
            v1[cnt].add(rs.getString("totalbill"));//3
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] AllComplain1Month(String month) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE complaindate between NOW()- INTERVAL '" + month + "' MONTH and now()");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE complaindate between NOW()- INTERVAL '" + month + "' MONTH and now()");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));

            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("sparename"));
            v1[cnt].add(rs.getString("Company"));
            v1[cnt].add(rs.getString("cost"));
            v1[cnt].add(rs.getString("totalbill"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    /*public Vector[] PaindingComplainRecordBetweenTwoDateJsp(String sdate,String edate)throws Exception
     {
     v1=null;
     stmt=conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid WHERE complaindate BETWEEN '"+sdate+"' AND '"+edate+"' and c.complainstatus='Pending'");
     rs=stmt.executeQuery();
     int cnt=0; 
     while(rs.next())
     {
     cnt++;
     }
     v1=new Vector[cnt];
     cnt=0;
     stmt=conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid WHERE complaindate BETWEEN '"+sdate+"' AND '"+edate+"' and c.complainstatus='Pending'");
     rs=stmt.executeQuery();
         
     while(rs.next())
     {
     v1[cnt]=new Vector();
            
     v1[cnt].add(rs.getString("name"));
     v1[cnt].add(rs.getString("email"));
     v1[cnt].add(rs.getString("address"));
     v1[cnt].add(rs.getString("contact"));
     v1[cnt].add(rs.getString("description"));
     v1[cnt].add(rs.getString("complaindate"));
     v1[cnt].add(rs.getString("complaintime"));
     v1[cnt].add(rs.getString("complainstatus"));
     //System.out.println(rs.getInt("typeid"));
     //System.out.println(rs.getString("typename"));
     cnt++;
     }
     return v1;
     }*/
    public Vector[] PaindingComplainRecordBetweenTwoDateJsp(String sdate, String edate) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement(" select c.complainid,cu.custmername,c.description,c.complaindate,c.complaintime,c.complainstatus,p.pname from complain as c inner join customer as cu on cu.cid=c.cid inner join producttable as p on p.pid=c.pid WHERE complainstatus='Pending' and complaindate BETWEEN '" + sdate + "' AND '" + edate + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement(" select c.complainid,cu.custmername,c.description,c.complaindate,c.complaintime,c.complainstatus,p.pname from complain as c inner join customer as cu on cu.cid=c.cid inner join producttable as p on p.pid=c.pid WHERE complainstatus='Pending' and complaindate BETWEEN '" + sdate + "' AND '" + edate + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("complainid"));

            v1[cnt].add(rs.getString("custmername"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));

            v1[cnt].add(rs.getString("pname"));
            // v1[cnt].add(rs.getString("sparename"));
            // v1[cnt].add(rs.getString("Company"));
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] AllOnprocess1mntRecord() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime, c.complainstatus,cust.custmername from employee as e  inner join assignemployeetocomplain as asw on e.eid=asw.eid  inner join complain as c on asw.cid=c.cid  inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='On Process' and complaindate between NOW()- INTERVAL 1 MONTH and now()");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime, c.complainstatus,cust.custmername from employee as e  inner join assignemployeetocomplain as asw on e.eid=asw.eid  inner join complain as c on asw.cid=c.cid  inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='On Process' and complaindate between NOW()- INTERVAL 1 MONTH and now()");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] AllOnprocessRecordIn3Month() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime, c.complainstatus,cust.custmername from employee as e  inner join assignemployeetocomplain as asw on e.eid=asw.eid  inner join complain as c on asw.cid=c.cid  inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='On Process' and complaindate between NOW()- INTERVAL 3 MONTH and now()");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime, c.complainstatus,cust.custmername from employee as e  inner join assignemployeetocomplain as asw on e.eid=asw.eid  inner join complain as c on asw.cid=c.cid  inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='On Process' and complaindate between NOW()- INTERVAL 3 MONTH and now()");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] AllOnprocessRecordIn6Month() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cust.custmername from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='On Process' and complaindate between NOW()- INTERVAL 6 MONTH and now()");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cust.custmername from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='On Process' and complaindate between NOW()- INTERVAL 6 MONTH and now()");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] AllPaindingRecordIn3Month() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cust.custmername from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='Pending' and complaindate between NOW()- INTERVAL 3 MONTH and now()");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cust.custmername from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='Pending' and complaindate between NOW()- INTERVAL 3 MONTH and now()");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] AllPaindingRecordIn6Month() throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cust.custmername from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='Pending' and complaindate between NOW()- INTERVAL 6 MONTH and now()");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select e.name,e.email,e.address,e.contact,asw.description,c.complaindate,c.complaintime,c.complainstatus,cust.custmername from employee as e inner join assignemployeetocomplain as asw on e.eid=asw.eid inner join complain as c on asw.cid=c.cid inner join customer as cust on cust.cid=c.cid WHERE c.complainstatus='Pending' and complaindate between NOW()- INTERVAL 6 MONTH and now()");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] listOfSupplier() throws Exception {
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
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
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
            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] PurchaseBetweenTwoDate(String sdate, String edate) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select sup.sname,poe.oid,po.odate,p.pname,poe.quantity,poe.rate,poe.total,po.total as grandtotal,po.paid,po.balance from purchaseorderentry as poe inner join purchaseorder as po on poe.oid=po.oid  inner join producttable as p on poe.pid=p.pid  inner join addsupplier as sup on po.sid=sup.sid  where po.status='Yes' and odate between  '" + sdate + "' And '" + edate + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select sup.sname,poe.oid,po.odate,p.pname,poe.quantity,poe.rate,poe.total,po.total as grandtotal,po.paid,po.balance from purchaseorderentry as poe inner join purchaseorder as po on poe.oid=po.oid  inner join producttable as p on poe.pid=p.pid  inner join addsupplier as sup on po.sid=sup.sid  where po.status='Yes' and odate between  '" + sdate + "' And '" + edate + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("sname"));//0
            v1[cnt].add(rs.getInt("oid"));//1
            v1[cnt].add(rs.getString("odate"));//2
            v1[cnt].add(rs.getString("pname"));//3
            v1[cnt].add(rs.getString("quantity"));//4
            v1[cnt].add(rs.getString("rate"));//5
            v1[cnt].add(rs.getString("total"));//6
            v1[cnt].add(rs.getString("grandtotal"));//7
            v1[cnt].add(rs.getString("paid"));//8
            v1[cnt].add(rs.getString("balance"));//9

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] Purchasebysupplier(String sdate, String edate, String sname) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select sup.sname,poe.oid,po.odate,p.pname,poe.quantity,poe.rate,poe.total,po.total as grandtotal,po.paid,po.balance from purchaseorderentry as poe inner join purchaseorder as po on poe.oid=po.oid  inner join producttable as p on poe.pid=p.pid  inner join addsupplier as sup on po.sid=sup.sid  where po.status='Yes' and odate between  '" + sdate + "' And '" + edate + "' and sup.sid='" + sname + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select sup.sname,poe.oid,po.odate,p.pname,poe.quantity,poe.rate,poe.total,po.total as grandtotal,po.paid,po.balance from purchaseorderentry as poe inner join purchaseorder as po on poe.oid=po.oid  inner join producttable as p on poe.pid=p.pid  inner join addsupplier as sup on po.sid=sup.sid  where po.status='Yes' and odate between  '" + sdate + "' And '" + edate + "' and sup.sid='" + sname + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("sname"));//0
            v1[cnt].add(rs.getInt("oid"));//1
            v1[cnt].add(rs.getString("odate"));//2
            v1[cnt].add(rs.getString("pname"));//3
            v1[cnt].add(rs.getString("quantity"));//4
            v1[cnt].add(rs.getString("rate"));//5
            v1[cnt].add(rs.getString("total"));//6
            v1[cnt].add(rs.getString("grandtotal"));//7
            v1[cnt].add(rs.getString("paid"));//8
            v1[cnt].add(rs.getString("balance"));//9

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] PurchaseSupplierbyTwoDate(String sname) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select sup.sname,poe.oid,po.odate,p.pname,poe.quantity,poe.rate,poe.total,po.total as grandtotal,po.paid,po.balance from purchaseorderentry as poe inner join purchaseorder as po on poe.oid=po.oid  inner join producttable as p on poe.pid=p.pid  inner join addsupplier as sup on po.sid=sup.sid  where po.status='Yes' and sup.sid='" + sname + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select sup.sname,poe.oid,po.odate,p.pname,poe.quantity,poe.rate,poe.total,po.total as grandtotal,po.paid,po.balance from purchaseorderentry as poe inner join purchaseorder as po on poe.oid=po.oid  inner join producttable as p on poe.pid=p.pid  inner join addsupplier as sup on po.sid=sup.sid  where po.status='Yes' and sup.sid='" + sname + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("sname"));//0
            v1[cnt].add(rs.getInt("oid"));//1
            v1[cnt].add(rs.getString("odate"));//2
            v1[cnt].add(rs.getString("pname"));//3
            v1[cnt].add(rs.getString("quantity"));//4
            v1[cnt].add(rs.getString("rate"));//5
            v1[cnt].add(rs.getString("total"));//6
            v1[cnt].add(rs.getString("grandtotal"));//6
            v1[cnt].add(rs.getString("paid"));//7
            v1[cnt].add(rs.getString("balance"));//8

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] SaleProductBetweenTwoDate(String sdate, String edate) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select c.custmername,soe1.oid,so.odate,p.pname,soe1.Warrenty_Upto,soe1.quantity ,soe1.rate,soe1.rate,soe1.total,so.total as saletotal,so.paid,so.balance from saleorderentry1 as soe1 inner join saleorder as so on so.oid=soe1.oid inner join producttable as p on p.pid=soe1.pid inner join customer as c on so.cid=c.cid where so.odate between '" + sdate + "' and '" + edate + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select c.custmername,soe1.oid,so.odate,p.pname,soe1.Warrenty_Upto,soe1.quantity ,soe1.rate,soe1.total,so.total as saletotal,so.paid,so.balance from saleorderentry1 as soe1 inner join saleorder as so on so.oid=soe1.oid inner join producttable as p on p.pid=soe1.pid inner join customer as c on so.cid=c.cid where so.odate between '" + sdate + "' and '" + edate + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("custmername"));//0
            v1[cnt].add(rs.getInt("oid"));//1
            v1[cnt].add(rs.getString("odate"));//2
            v1[cnt].add(rs.getString("pname"));//3
            v1[cnt].add(rs.getString("Warrenty_Upto"));//4
            v1[cnt].add(rs.getString("quantity"));//5
            v1[cnt].add(rs.getString("rate"));//6
            v1[cnt].add(rs.getString("total"));//7
            v1[cnt].add(rs.getString("saletotal"));//8
            v1[cnt].add(rs.getString("paid"));//9
            v1[cnt].add(rs.getString("balance"));//10

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] SaleProductByCustomer(String cname) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select c.custmername,soe1.oid,so.odate,p.pname,soe1.Warrenty_Upto,soe1.quantity ,soe1.rate,so.total,so.paid,so.balance from saleorderentry1 as soe1 inner join saleorder as so on so.oid=soe1.oid inner join producttable as p on p.pid=soe1.pid inner join customer as c on so.cid=c.cid where c.cid='" + cname + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select c.custmername,soe1.oid,so.odate,p.pname,soe1.Warrenty_Upto,soe1.quantity ,soe1.rate,so.total,so.paid,so.balance from saleorderentry1 as soe1 inner join saleorder as so on so.oid=soe1.oid inner join producttable as p on p.pid=soe1.pid inner join customer as c on so.cid=c.cid where c.cid='" + cname + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("custmername"));//0
            v1[cnt].add(rs.getInt("oid"));//1
            v1[cnt].add(rs.getString("odate"));//2
            v1[cnt].add(rs.getString("pname"));//3
            v1[cnt].add(rs.getString("Warrenty_Upto"));//4
            v1[cnt].add(rs.getString("quantity"));//5
            v1[cnt].add(rs.getString("rate"));//6
            //v1[cnt].add(rs.getString("total"));//7
            v1[cnt].add(rs.getString("total"));//8
            v1[cnt].add(rs.getString("paid"));//9
            v1[cnt].add(rs.getString("balance"));//10

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] SaleProductByProductName(String pid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select P.pname,p.compname,poe.rate as purchaserate,soe1.rate as salerate,po.odate as purchasedate, so.odate as saledate from purchaseorderentry as poe inner join saleorderentry1 as soe1 on soe1.pid=poe.pid inner join producttable as p on soe1.pid=p.pid inner join purchaseorder as po on po.oid=poe.oid inner join saleorder as so on soe1.oid=so.oid Where p.pid='" + pid + "' ");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select P.pname,p.compname,poe.rate as purchaserate,soe1.rate as salerate,po.odate as purchasedate, so.odate as saledate from purchaseorderentry as poe inner join saleorderentry1 as soe1 on soe1.pid=poe.pid inner join producttable as p on soe1.pid=p.pid inner join purchaseorder as po on po.oid=poe.oid inner join saleorder as so on soe1.oid=so.oid Where p.pid='" + pid + "' ");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("pname"));//0
            v1[cnt].add(rs.getString("compname"));//0
            v1[cnt].add(rs.getInt("purchaserate"));//1
            v1[cnt].add(rs.getString("salerate"));//2
            v1[cnt].add(rs.getString("purchasedate"));//3
            v1[cnt].add(rs.getString("saledate"));//4
            //v1[cnt].add(rs.getString("quantity"));//5
            //v1[cnt].add(rs.getString("rate"));//6
            //v1[cnt].add(rs.getString("total"));//7

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] SparePurchaseBetweenTwoDate(String sdate, String edate) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select sup.sname,so.orderid,so.orderdate, sp.sparename,sp.company,spoe.quantity,spoe.rate,spoe.total as sparetotal,so.total as grandtotal,so.paid,so. balance from spareorderentry as spoe  inner join spareorder as so on spoe.orderid=so.orderid inner join spare as sp on spoe.spareid=sp.spareid inner join addsupplier as sup on so.supplierid=sup.sid  where so.status='Yes' and so.orderdate between '" + sdate + "' and '" + edate + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select sup.sname,so.orderid,so.orderdate, sp.sparename,sp.company,spoe.quantity,spoe.rate,spoe.total as sparetotal,so.total as grandtotal,so.paid,so. balance from spareorderentry as spoe  inner join spareorder as so on spoe.orderid=so.orderid inner join spare as sp on spoe.spareid=sp.spareid inner join addsupplier as sup on so.supplierid=sup.sid  where so.status='Yes' and so.orderdate between '" + sdate + "' and '" + edate + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("sname"));//0
            v1[cnt].add(rs.getInt("orderid"));//1
            v1[cnt].add(rs.getString("orderdate"));//2
            v1[cnt].add(rs.getString("sparename"));//3
            v1[cnt].add(rs.getString("company"));//4
            v1[cnt].add(rs.getString("quantity"));//5
            v1[cnt].add(rs.getString("rate"));//6
            v1[cnt].add(rs.getString("sparetotal"));//7
            v1[cnt].add(rs.getString("grandtotal"));//8
            v1[cnt].add(rs.getString("paid"));//9
            v1[cnt].add(rs.getString("balance"));//10

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] SparePurchaseSupplier(String sname) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select sup.sname,so.orderid,so.orderdate, sp.sparename,sp.company,spoe.quantity,spoe.rate,spoe.total as sparetotal,so.total as grandtotal,so.paid,so. balance from spareorderentry as spoe  inner join spareorder as so on spoe.orderid=so.orderid inner join spare as sp on spoe.spareid=sp.spareid inner join addsupplier as sup on so.supplierid=sup.sid  where so.status='Yes' and sup.sid='" + sname + "' ");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select sup.sname,so.orderid,so.orderdate, sp.sparename,sp.company,spoe.quantity,spoe.rate,spoe.total as sparetotal,so.total as grandtotal,so.paid,so. balance from spareorderentry as spoe  inner join spareorder as so on spoe.orderid=so.orderid inner join spare as sp on spoe.spareid=sp.spareid inner join addsupplier as sup on so.supplierid=sup.sid  where so.status='Yes' and sup.sid='" + sname + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("sname"));//0
            v1[cnt].add(rs.getInt("orderid"));//1
            v1[cnt].add(rs.getString("orderdate"));//2
            v1[cnt].add(rs.getString("sparename"));//3
            v1[cnt].add(rs.getString("company"));//4
            v1[cnt].add(rs.getString("quantity"));//5
            v1[cnt].add(rs.getString("rate"));//6
            v1[cnt].add(rs.getString("sparetotal"));//7
            v1[cnt].add(rs.getString("grandtotal"));//8
            v1[cnt].add(rs.getString("paid"));//9
            v1[cnt].add(rs.getString("balance"));//10

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] SparePurchasebysupplierByDate(String sdate, String edate, String sname) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select sup.sname,so.orderid,so.orderdate, sp.sparename,sp.company,spoe.quantity,spoe.rate,spoe.total as sparetotal,so.total as grandtotal,so.paid,so. balance from spareorderentry as spoe  inner join spareorder as so on spoe.orderid=so.orderid inner join spare as sp on spoe.spareid=sp.spareid inner join addsupplier as sup on so.supplierid=sup.sid  where so.status='Yes' and sup.sid='" + sname + "' and so.orderdate between '" + sdate + "' and '" + edate + "' ");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select sup.sname,so.orderid,so.orderdate, sp.sparename,sp.company,spoe.quantity,spoe.rate,spoe.total as sparetotal,so.total as grandtotal,so.paid,so. balance from spareorderentry as spoe  inner join spareorder as so on spoe.orderid=so.orderid inner join spare as sp on spoe.spareid=sp.spareid inner join addsupplier as sup on so.supplierid=sup.sid  where so.status='Yes' and sup.sid='" + sname + "' and so.orderdate between '" + sdate + "' and '" + edate + "' ");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("sname"));//0
            v1[cnt].add(rs.getInt("orderid"));//1
            v1[cnt].add(rs.getString("orderdate"));//2
            v1[cnt].add(rs.getString("sparename"));//3
            v1[cnt].add(rs.getString("company"));//4
            v1[cnt].add(rs.getString("quantity"));//5
            v1[cnt].add(rs.getString("rate"));//6
            v1[cnt].add(rs.getString("sparetotal"));//7
            v1[cnt].add(rs.getString("grandtotal"));//8
            v1[cnt].add(rs.getString("paid"));//9
            v1[cnt].add(rs.getString("balance"));//10

            //System.out.println(rs.getInt("typeid"));
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] ComplianBillByCustomer(String cname) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select  c.custmername,p.pname,asw.datetosend,e.name,cb.totalbill,cb.paid,cb.balance, cb.complainid from complainbill as cb inner join assignemployeetocomplain as asw on cb.complainid=asw.complainid inner join complain as cp on asw.complainid=cp.complainid inner join customer as c on cp.cid=c.cid inner join producttable as p on p.pid=cp.pid inner join employee as e on asw.eid=e.eid where c.cid='" + cname + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select  c.custmername,p.pname,asw.datetosend,e.name,cb.totalbill,cb.paid,cb.balance, cb.complainid from complainbill as cb inner join assignemployeetocomplain as asw on cb.complainid=asw.complainid inner join complain as cp on asw.complainid=cp.complainid inner join customer as c on cp.cid=c.cid inner join producttable as p on p.pid=cp.pid inner join employee as e on asw.eid=e.eid where c.cid='" + cname + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("custmername"));//0
            v1[cnt].add(rs.getString("pname"));//1
            v1[cnt].add(rs.getString("datetosend"));//2
            v1[cnt].add(rs.getString("name"));//3
            v1[cnt].add(rs.getString("totalbill"));//4
            v1[cnt].add(rs.getString("paid"));//5
            v1[cnt].add(rs.getString("balance"));//6
              v1[cnt].add(rs.getInt("complainid"));//7

            cnt++;
        }
        return v1;
    }

    public Vector[] ComplianBillByEmployee(String ename) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select  c.custmername,p.pname,asw.datetosend,e.name,cb.totalbill,cb.paid,cb.balance, cb.complainid from complainbill as cb inner join assignemployeetocomplain as asw on cb.complainid=asw.complainid inner join complain as cp on asw.complainid=cp.complainid inner join customer as c on cp.cid=c.cid inner join producttable as p on p.pid=cp.pid inner join employee as e on asw.eid=e.eid where e.eid='" + ename + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select  c.custmername,p.pname,asw.datetosend,e.name,cb.totalbill,cb.paid,cb.balance, cb.complainid from complainbill as cb inner join assignemployeetocomplain as asw on cb.complainid=asw.complainid inner join complain as cp on asw.complainid=cp.complainid inner join customer as c on cp.cid=c.cid inner join producttable as p on p.pid=cp.pid inner join employee as e on asw.eid=e.eid where e.eid='" + ename + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("custmername"));//0
            v1[cnt].add(rs.getString("pname"));//1
            v1[cnt].add(rs.getString("datetosend"));//2
            v1[cnt].add(rs.getString("name"));//3
            v1[cnt].add(rs.getString("totalbill"));//4
            v1[cnt].add(rs.getString("paid"));//5
            v1[cnt].add(rs.getString("balance"));//6
             v1[cnt].add(rs.getInt("complainid"));//7

            cnt++;
        }
        return v1;
    }

    public Vector[] AllComplainByCustomer(String cid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE cu.cid='" + cid + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE cu.cid='" + cid + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));

            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("sparename"));
            v1[cnt].add(rs.getString("Company"));
            v1[cnt].add(rs.getString("cost"));
            v1[cnt].add(rs.getString("totalbill"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] SolvedComplainByCustomer(String cid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='Solved' and cu.cid='" + cid + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='Solved' and cu.cid='" + cid + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));

            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("sparename"));
            v1[cnt].add(rs.getString("Company"));
            v1[cnt].add(rs.getString("cost"));
            v1[cnt].add(rs.getString("totalbill"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] OnProcessComplainByCustomer(String cid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='On Process' and cu.cid='" + cid + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE c.complainstatus='On Process' and cu.cid='" + cid + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));

            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("sparename"));
            v1[cnt].add(rs.getString("Company"));
            v1[cnt].add(rs.getString("cost"));
            v1[cnt].add(rs.getString("totalbill"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] ServiceCard(int cid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct s.ICRNO,cu.custmername,cu.address, cu.conatct,s.ContractNO , s.CFDate,s.CTDate,s.SDate,s.visittype, s.WorkDetails,sp.sparename, sp.Company,spc.cost ,cb.totalbill,a.complainid,name,cu.cid,emp.eid,cu.custid,c.modal from servicecard as s inner join assignemployeetocomplain as a on a.complainid=s.complainid inner join customer as cu on a.cid=cu.cid inner join employee as emp on a.eid=emp.eid inner join complainbill as cb on cb.complainid=s.complainid inner join sparechangetocomplain as spc on s.complainid=spc.complainid  inner join contract as c on c.cid=cu.cid inner join spare as sp on spc.spareid=sp.spareid where  cu.cid='"+cid+"'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct s.ICRNO,cu.custmername,cu.address, cu.conatct,s.ContractNO , s.CFDate,s.CTDate,s.SDate,s.visittype, s.WorkDetails,sp.sparename, sp.Company,spc.cost ,cb.totalbill,name,a.complainid,cu.cid,emp.eid,cu.custid,c.modal from servicecard as s inner join assignemployeetocomplain as a on a.complainid=s.complainid inner join customer as cu on a.cid=cu.cid inner join employee as emp on a.eid=emp.eid inner join complainbill as cb on cb.complainid=s.complainid inner join sparechangetocomplain as spc on s.complainid=spc.complainid  inner join contract as c on c.cid=cu.cid inner join spare as sp on spc.spareid=sp.spareid where  cu.cid='"+cid+"'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("ICRNO"));
            CustConstant.CUSTNAME=rs.getString("custmername");
            CustConstant.ADDRESS=rs.getString("address");
            CustConstant.CONTACT=rs.getString("conatct");
            v1[cnt].add(CustConstant.CUSTNAME);
            v1[cnt].add(CustConstant.ADDRESS);
            v1[cnt].add(CustConstant.CONTACT);
            v1[cnt].add(rs.getString("ContractNO"));
            v1[cnt].add(rs.getString("CFDate"));
            v1[cnt].add(rs.getString("CTDate"));
            v1[cnt].add(rs.getString("SDate"));
            v1[cnt].add(rs.getString("visittype"));
            v1[cnt].add(rs.getString("WorkDetails"));
            v1[cnt].add(rs.getString("sparename"));//r

            v1[cnt].add(rs.getString("Company"));//r

            v1[cnt].add(rs.getString("cost"));//r
            v1[cnt].add(rs.getString("totalbill"));
            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("cid"));
            v1[cnt].add(rs.getString("eid"));
            custid=rs.getString("custid");
         modal=rs.getString("modal");
            v1[cnt].add(custid);
             v1[cnt].add(modal);
            

            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] ServiceCardContractNo(String cid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct s.ContractNO ,s.CFDate,s.CTDate,cu.cid from assignemployeetocomplain as a inner join customer as cu on a.cid=cu.cid inner join complain as cm on cu.cid=cm.cid inner join servicecard as s on s.complainid=a.complainid inner join complainbill as cb on cb.complainid=s.complainid where cm.complainstatus='On Process' and cu.cid='" + cid + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct s.ContractNO ,s.CFDate,s.CTDate,cu.cid from assignemployeetocomplain as a inner join customer as cu on a.cid=cu.cid inner join complain as cm on cu.cid=cm.cid inner join servicecard as s on s.complainid=a.complainid inner join complainbill as cb on cb.complainid=s.complainid where cm.complainstatus='On Process' and cu.cid='" + cid + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("ContractNO"));
            v1[cnt].add(rs.getString("CFDate"));
            v1[cnt].add(rs.getString("CTDate"));
            v1[cnt].add(rs.getInt("cid"));

            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] Customerpopup(String cid, String type) throws Exception {
        v1 = null;
        String column = "cu." + type;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill,cu.custid from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE " + column + "='" + cid + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill,cu.custid from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE " + column + "='" + cid + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));

            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("sparename"));
            v1[cnt].add(rs.getString("Company"));
            v1[cnt].add(rs.getString("cost"));
            v1[cnt].add(rs.getString("totalbill"));
            v1[cnt].add(rs.getString("custid"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }

    public Vector[] Customecontrpopup(String cid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE cu.conatct='" + cid + "'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.cost,cb.totalbill from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE cu.conatct='" + cid + "'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));
            v1[cnt].add(rs.getString("email"));
            v1[cnt].add(rs.getString("address"));
            v1[cnt].add(rs.getString("contact"));
            v1[cnt].add(rs.getString("complainid"));
            v1[cnt].add(rs.getString("description"));
            v1[cnt].add(rs.getString("complaindate"));
            v1[cnt].add(rs.getString("complaintime"));
            v1[cnt].add(rs.getString("complainstatus"));
            v1[cnt].add(rs.getString("custmername"));

            v1[cnt].add(rs.getString("pname"));
            v1[cnt].add(rs.getString("sparename"));
            v1[cnt].add(rs.getString("Company"));
            v1[cnt].add(rs.getString("cost"));
            v1[cnt].add(rs.getString("totalbill"));
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
    public Vector[] ContractReport(int cid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select con.cid,con.contractno, c.custmername,c.address,c.conatct,c.custid,con.fdate,con.tdate,con.modal,con.amount from contract as con inner join customer as c on c.cid=con.cid Where con.cid='"+cid+"'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select con.cid,con.contractno, c.custmername,c.address,c.conatct,c.custid,con.fdate,con.tdate,con.modal,con.amount from contract as con inner join customer as c on c.cid=con.cid Where con.cid='"+cid+"'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getInt("cid"));//0
            v1[cnt].add(rs.getString("contractno"));//1
            v1[cnt].add(rs.getString("custmername"));//2
            v1[cnt].add(rs.getString("address"));//3
            v1[cnt].add(rs.getString("conatct"));//4
            v1[cnt].add(rs.getString("custid"));//5
            v1[cnt].add(rs.getString("fdate"));//6
            v1[cnt].add(rs.getString("tdate"));//7
            v1[cnt].add(rs.getString("modal"));//8
            v1[cnt].add(rs.getString("amount"));//9
            

            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }
    public Vector[] AllComplainByEmployee(String eid) throws Exception {
        v1 = null;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.qty,spc.rate,spc.cost,cb.totalbill,cb.paid,cb.balance from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE e.eid='"+eid+"'");
        rs = stmt.executeQuery();
        int cnt = 0;
        while (rs.next()) {
            cnt++;
        }
        v1 = new Vector[cnt];
        cnt = 0;
        stmt = conn.prepareStatement("select distinct e.name,e.email,e.address,e.contact,asw.complainid,asw.description,c.complaindate,c.complaintime,c.complainstatus,cu.custmername,pt.pname,sp.sparename,sp.company,spc.qty,spc.rate,spc.cost,cb.totalbill,cb.paid,cb.balance from sparechangetocomplain as spc inner join assignemployeetocomplain as asw on asw.complainid=spc.complainid inner join employee as e on asw.eid=e.eid  inner join complain as c on asw.cid=c.cid inner join customer as cu on cu.cid=c.cid inner join producttable as pt on c.pid=pt.pid inner join complainbill as cb on c.complainid=cb.complainid inner join spare as sp on sp.spareid=spc.spareid WHERE e.eid='"+eid+"'");
        rs = stmt.executeQuery();

        while (rs.next()) {
            v1[cnt] = new Vector();

            v1[cnt].add(rs.getString("name"));//0
            v1[cnt].add(rs.getString("email"));//1
            v1[cnt].add(rs.getString("address"));//2
            v1[cnt].add(rs.getString("contact"));//3
            v1[cnt].add(rs.getString("complainid"));//4
            v1[cnt].add(rs.getString("description"));//5
            v1[cnt].add(rs.getString("complaindate"));//6
            v1[cnt].add(rs.getString("complaintime"));//7
            v1[cnt].add(rs.getString("complainstatus"));//8
            v1[cnt].add(rs.getString("custmername"));//9

            v1[cnt].add(rs.getString("pname"));//10
            v1[cnt].add(rs.getString("sparename"));//11
            v1[cnt].add(rs.getString("Company"));//12
             v1[cnt].add(rs.getString("qty"));//13
              v1[cnt].add(rs.getString("rate"));//14
            v1[cnt].add(rs.getString("cost"));//15
            v1[cnt].add(rs.getString("totalbill"));//16
             v1[cnt].add(rs.getString("paid"));//17
              v1[cnt].add(rs.getString("balance"));//18
            //System.out.println(rs.getInt("typeid"));//custmername
            //System.out.println(rs.getString("typename"));
            cnt++;
        }
        return v1;
    }



}
