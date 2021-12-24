package web.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="roleName")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(){}

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Set<User> getUsers() {return users;}

    public void setPersons(Set<User> users) {this.users = users;}

    public String getAuthority() {return getName();}
}
