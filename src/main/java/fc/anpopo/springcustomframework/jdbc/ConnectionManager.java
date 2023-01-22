package fc.anpopo.springcustomframework.jdbc;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;


public class ConnectionManager {

    private static final String H2_DRIVER = "org.h2.Driver";
    private static final String H2_JDBC_URL = "jdbc:h2:mem:ditto;MODE=MySQL;DB_CLOSE_DELAY=-1";
    private static final int MAX_POOL_SIZE = 40;
    private static final DataSource dataSource;

    static {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(H2_DRIVER);
        hikariDataSource.setJdbcUrl(H2_JDBC_URL);
        hikariDataSource.setUsername("sa");
        hikariDataSource.setMaximumPoolSize(MAX_POOL_SIZE);
        dataSource = hikariDataSource;
    }

    public static Connection getConnection()  {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    // datasource 가 적용되지 않은 커넥션 가져오기
//    public static Connection getConnection() {
//        String url = "jdbc:h2:mem:ditto;MODE=MySQL;DB_CLOSE_DELAY=-1";
//        String id = "sa";
//        String password = "";
//
//        try {
//            return DriverManager.getConnection(url, id, password);
//        } catch (SQLException e) {
//            log.error(e.getMessage(), e);
//        }
//        return null;
//    }
}
