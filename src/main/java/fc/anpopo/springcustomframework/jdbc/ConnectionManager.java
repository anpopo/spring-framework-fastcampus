package fc.anpopo.springcustomframework.jdbc;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class ConnectionManager {

    public static DataSource getDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("org.h2.Driver");
        hikariDataSource.setJdbcUrl("jdbc:h2:mem:ditto;MODE=MySQL;DB_CLOSE_DELAY=-1");
        hikariDataSource.setUsername("sa");

        return hikariDataSource;
    }
}
