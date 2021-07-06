package com.xinlei.log4j2demo2.config;


import org.apache.logging.log4j.core.appender.db.jdbc.AbstractConnectionSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory extends AbstractConnectionSource {
    private final DataSource dataSource;

    public ConnectionFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
