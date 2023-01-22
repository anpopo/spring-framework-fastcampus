package fc.anpopo.springcustomframework.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ValueMapper<T> {

    T map(ResultSet rs) throws SQLException;
}
