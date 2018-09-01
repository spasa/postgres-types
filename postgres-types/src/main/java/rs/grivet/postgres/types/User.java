package rs.grivet.jdbi.test;

import java.sql.SQLException;
import org.postgresql.util.PGobject;
import org.postgresql.util.PGtokenizer;

/**
 *
 * @author spasa
 */
public class User extends PGobject {

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    private Long id;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public String getValue() {
        return "(" + id + "," + firstName + "," + lastName + ")";
    }

    @Override
    public void setValue(String value) throws SQLException {
        PGtokenizer t = new PGtokenizer(PGtokenizer.removePara(value), ',');
        
        id = Long.valueOf(t.getToken(0));
        firstName = t.getToken(1);
        lastName = t.getToken(2);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + '}';
    }
    
}
