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

import shekhar.pojo.ServiceCard;

public class servicecard {

    ShekharDAO sdo;
    public Vector v1[];
    ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;

    public servicecard() throws Exception {
        sdo = ShekharDAO.getInstance();
        conn = sdo.getConn();
        //  stmt=sdo.getStatement();
    }

    public boolean isAddServicecard(ServiceCard ser) throws Exception {
        stmt = conn.prepareStatement("insert into servicecard values(?,?,?,?,?,?,?,?)");
        stmt.setString(1, ser.getComplainid());
        stmt.setString(2, ser.getVtype());
        stmt.setString(3, ser.getSdate());
        stmt.setString(4, ser.getwDetails());
        stmt.setString(5, ser.getIcrNO());
        stmt.setString(6, ser.getFdate());
        stmt.setString(7, ser.getTdate());
        stmt.setString(8,ser.getContractNo());
        int value = stmt.executeUpdate();
        //javax.swing.JOptionPane.showMessageDialog(null,value);
        if (value > 0) {
            return true;
        } else {
            return false;
        }
    }

}
