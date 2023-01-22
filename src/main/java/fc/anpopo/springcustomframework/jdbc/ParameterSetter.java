package fc.anpopo.springcustomframework.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface ParameterSetter {

    void set(PreparedStatement ps) throws SQLException;
}
