package com.furcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaRepositories
public class FurcareApplication {
    private static final Logger logger = LoggerFactory.getLogger(FurcareApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FurcareApplication.class, args);
        
        // Log database connection info
        DataSource dataSource = context.getBean(DataSource.class);
        try {
            logger.info("Database connection successful!");
            logger.info("Database URL: {}", dataSource.getConnection().getMetaData().getURL());
            logger.info("Database Username: {}", dataSource.getConnection().getMetaData().getUserName());
        } catch (Exception e) {
            logger.error("Database connection failed: {}", e.getMessage());
        }
    }
} 