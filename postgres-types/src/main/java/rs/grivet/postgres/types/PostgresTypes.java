package rs.grivet.postgres.types;

import java.util.concurrent.ConcurrentHashMap;
import org.postgresql.util.PGobject;

/**
 *
 * @author spasa
 */
public class PostgresTypes {
    
    private static final ConcurrentHashMap<Class, String> types = new ConcurrentHashMap<Class, String>();
    
    public static void registerCustomType(String typeName, Class clazz) {
        if (!PGobject.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException(String.format("PGobject is not assignable from %s", clazz));
        }
        
        types.put(clazz, typeName);
    }
    
    public static String getTypeName(Class clazz) {
        return types.get(clazz);
    }
    
}
