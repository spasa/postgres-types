package rs.grivet.postgres.types.argument.factory;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import org.jdbi.v3.core.argument.AbstractArgumentFactory;
import org.jdbi.v3.core.argument.Argument;
import org.jdbi.v3.core.config.ConfigRegistry;
import org.jdbi.v3.core.statement.StatementContext;
import org.postgresql.util.PGobject;
import rs.grivet.jdbi.test.User;

/**
 *
 * @author spasa
 */
public class PGObjectArgumentFactory extends AbstractArgumentFactory<PGobject> {

    public PGObjectArgumentFactory() {
        super(Types.OTHER);
    }

    @Override
    protected Argument build(PGobject value, ConfigRegistry config) {
        return new Argument() {
            @Override
            public void apply(int position, PreparedStatement statement, StatementContext ctx) throws SQLException {
                ((org.postgresql.PGConnection) statement.getConnection()).addDataType("player_type", User.class);
                
                statement.setObject(position, value);
            }
        };
        
    }
    
    
    
}
