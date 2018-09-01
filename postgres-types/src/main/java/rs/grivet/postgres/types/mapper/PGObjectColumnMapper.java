package rs.grivet.postgres.types.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.jdbi.v3.core.mapper.ColumnMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.postgresql.util.PGobject;

/**
 *
 * @author spasa
 */
public class PGObjectColumnMapper implements ColumnMapper<PGobject> {

    @Override
    public PGobject map(ResultSet rs, int columnNumber, StatementContext ctx) throws SQLException {
        return (PGobject) rs.getObject(columnNumber);
    }
    
}
