package net.toregard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;


@Configuration

public class DbConfig {

    //@Profile("H2")
    @Bean(name = "dataSource",destroyMethod = "shutdown")
    public DataSource createEmbeddedDataSource() {

        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("toregardDB")
                //.addScript("classpath:/database/H2_SCHEMA.database")
                .build();
    }
}
