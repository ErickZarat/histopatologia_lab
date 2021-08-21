package histopatologialab.core;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import javax.sql.DataSource;

public class DB {
    private final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private final String username = "postgres";
    private final String password = "docker";
    
//	private final String jdbcUrl = "jdbc:postgresql://database-lab.ct8k21fpxreo.us-east-2.rds.amazonaws.com:5432/postgres";
//	private final String username = "postgres";
//	private final String password = "Admin123";

    
    private final int minimumIdle = 1;
    private final int maximumPoolSize = 5;
    private final long leakDetectionThreshold = 60000;

    private final HikariConfig hikariConfig;
    private final DataSource dataSource;

    public static DB db;

    DB() {
        hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setAutoCommit(true);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setMinimumIdle(minimumIdle);
        hikariConfig.setMaximumPoolSize(maximumPoolSize);
        hikariConfig.setLeakDetectionThreshold(leakDetectionThreshold);
        hikariConfig.setDriverClassName("org.postgresql.Driver");

        dataSource = new HikariDataSource(hikariConfig);
    }

    private DSLContext DSLContext() {
        Configuration configuration = new DefaultConfiguration().set(dataSource).set(SQLDialect.POSTGRES);
        return DSL.using(configuration);
    }

    public static DSLContext getConexion(){
        if (db == null) {
            db = new DB();
        }
        return db.DSLContext();
    }

}
