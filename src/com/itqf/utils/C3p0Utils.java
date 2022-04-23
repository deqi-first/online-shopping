package com.itqf.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3p0Utils {
    private static ComboPooledDataSource dataSource = null;

    static {
        dataSource = new ComboPooledDataSource();
    }

    public static ComboPooledDataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 关闭所有资源连接
     *
     * @param conn
     * @param ps
     * @param rs
     */
    public static void releaseAll(Connection conn, Statement ps, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps = null;
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
    }
}
