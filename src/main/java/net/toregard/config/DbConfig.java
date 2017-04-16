package net.toregard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;


@Configuration
public class DbConfig {
    private @Value("${URL}") String dbURL;
    private @Value("${USER}") String user;
    private @Value("${PASSWORD}") String password;

    @Profile("h2")
    @Bean(name = "dataSource",destroyMethod = "shutdown")
    public DataSource createEmbeddedDataSource() {

        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("toregardDB")
                //.addScript("classpath:/db/mysql-schema.sql")
                .build();
    }

    @Profile("mysql")
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(dbURL);
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

}
