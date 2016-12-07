package com.wl.dao;

import com.wl.db.DbConn;
import com.wl.db.Dbclose;
import com.wl.entity.Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by shizhouyong on 2016/12/7.
 */
public class RegistrationDao {

    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public int addRegistration(Registration registration) {
        int row = 0;
        int amount = 0;
        conn = DbConn.getconn();
        String sql = "INSERT INTO t_registration(name, organization, phoneNumber, createTime) VALUES (?, ?, ?, NOW())";
        try {
            pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            for(String param:registration.getParamList()){
                amount++;
                pst.setString(amount, param);
            }
            if(1==pst.executeUpdate()){
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    Long id = rs.getLong(1);
                    row = id.intValue();
                }
            }
        } catch (Exception e) {
            row = -1;
        } finally {
            Dbclose.addClose(pst, conn);
        }
        return row;

    }
}
