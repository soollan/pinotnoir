package com.wine.pinotnoir.config;

import org.h2.tools.Server;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class H2ServerConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource h2TcpServer() throws SQLException {
        Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "8082").start();
        return new com.zaxxer.hikari.HikariDataSource();
    }
}
