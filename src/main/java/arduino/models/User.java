/**
 * @Author:Serhat CAN
 */
package arduino.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements Serializable {

    /**
     * Default
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(length = 80, nullable = false)
    private String password;

    //	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]", message = "Invalid email address.")
    @Column(unique = true, length = 50)
    private String email;

    private String firstname;

    private String surname;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<Role>();

    public User() {

    }

    public User(String name, String passwordHash) {
        this.username = name;
        this.password = passwordHash;
    }

    public User(String name, String passwordHash, String email, String firstname, String surname, Role role) {
        this.username = name;
        this.password = passwordHash;
        this.email = email;
        this.firstname = firstname;
        this.surname = surname;
        this.addRole(role);
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        // TODO Auto-generated method stub
        return this.username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setPassword(String passwordHash) {
        this.password = passwordHash;
    }

    //@JsonIgnore
    public String getPassword() {
        // TODO Auto-generated method stub
        return this.password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
