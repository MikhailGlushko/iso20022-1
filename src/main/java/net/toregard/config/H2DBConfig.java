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
@Profile("h2")
public class H2DBConfig {
//    private @Value("${URL}") String dbURL;
//    private @Value("${USER}") String user;
//    private @Value("${PASSWORD}") String password;


    @Bean(name = "dataSource",destroyMethod = "shutdown")
    public DataSource createEmbeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("toregardDB")
                //.addScript("classpath:/dev.db/V1__init-orders.sql")
                .build();
    }


}
