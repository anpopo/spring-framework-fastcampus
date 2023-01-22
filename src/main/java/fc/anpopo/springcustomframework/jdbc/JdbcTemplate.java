package fc.anpopo.springcustomframework.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {
    public void executeUpdate(final String sql, ParameterSetter ps) throws SQLException {
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql))
        {
            ps.set(pstmt);
            pstmt.executeUpdate();
        }
    }


    public <T> T executeQuery(final String sql, ParameterSetter ps, ValueMapper vm) throws SQLException {
        ResultSet rs = null;
        try (
            Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
            ps.set(pstmt);
            rs = pstmt.executeQuery();

            T ret = null;
            if (rs.next()) {
                ret = (T) vm.map(rs);
            }
            return ret;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }
}
