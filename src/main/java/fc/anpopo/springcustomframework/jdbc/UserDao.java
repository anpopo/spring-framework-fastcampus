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

    public void create(User user) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            final String sql = "INSERT INTO users VALUES(?, ?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getUserName());

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (con != null) {
                con.close();
            }
        }

    }

    private Connection getConnection() {
        String url = "jdbc:h2:mem:ditto;MODE=MySQL;DB_CLOSE_DELAY=-1";
        String id = "sa";
        String password = "";

        try {
            return DriverManager.getConnection(url, id, password);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public User findByUserId(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            final String sql = "select userId, password, userName from users where userId = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            User user = null;
            if (rs.next()) {
                user = new User(
                    rs.getString("userId"),
                    rs.getString("password"),
                    rs.getString("userName")
                );
            }

            return user;
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }
}
