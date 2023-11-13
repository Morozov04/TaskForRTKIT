package org.example.dataBase;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder{
    DataSource dataSource;

    public PoolConnectionBuilder() {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/taskPool");
        }catch (NamingException e){
            e.printStackTrace();
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}