package fc.anpopo.springcustomframework.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {

    private static Logger log = LoggerFactory.getLogger(UserDao.class);

    private static final JdbcTemplate jdbcTemplate;

    static {
        jdbcTemplate = new JdbcTemplate();
    }

    public void create(User user) throws SQLException {
        final String sql = "INSERT INTO users VALUES(?, ?, ?)";
        jdbcTemplate.executeUpdate(
            sql,
            ps -> {
                ps.setString(1, user.getUserId());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getUserName());
            }
        );
    }

    public User findByUserId(String userId) throws SQLException {
        final String sql = "select userId, password, userName from users where userId = ?";

        return jdbcTemplate.executeQuery(
            sql,
            ps -> {
                ps.setString(1, userId);
            },
            rs -> new User(
                rs.getString("userId"),
                rs.getString("password"),
                rs.getString("userName")
            )
        );
    }
}
