package com.wl.db;

import java.sql.*;

/**
 * Created by shizhouyong on 2016/12/7.
 */
public class Dbclose {

    public static void addClose(PreparedStatement pstmt, Connection conn) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void queryClose(PreparedStatement pst, ResultSet rs, Connection conn) {
        try {
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dbClose(Statement st, ResultSet rs, Connection conn) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
