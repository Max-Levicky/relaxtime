package relaxtime.lib.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Entity
@Table(name = "users")
public class User extends BaseModel implements UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role = Role.ANONYMOUS;

    private String username;
    private String password;
    private String email;

    private boolean enabled = true;
    private boolean accountNonLocked = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;

    private Date lastRelaxTime = new Date();

    @Enumerated(EnumType.STRING)
    private RelaxStatus status = RelaxStatus.PAUSED;

    @ManyToOne
    private PersonalInformation personalInformation;
    @ManyToOne
    private Department department;

    public User(Long id, PersonalInformation personalInformation, Department department) {
        setId(id);
        this.personalInformation = personalInformation;
        this.department = department;
    }

    public User() {
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getLastRelaxTime() {
        return lastRelaxTime;
    }

    public void setLastRelaxTime(Date lastRelaxTime) {
        this.lastRelaxTime = lastRelaxTime;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> auth = new ArrayList<>();
//        role.forEach((role) -> auth.add(new SimpleGrantedAuthority("ROLE_" + role)));
        auth.add(new SimpleGrantedAuthority("ROLE_" + role));
        return auth;
    }

//    @Column(name = "roles", nullable = false)
//    @ElementCollection(targetClass = Role.class)
//    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "roleId"))
//    @JoinTable(name = "roles", joinColumns = @JoinColumn(name = "roleId"))
//    @Enumerated(EnumType.STRING)
//    public Set<Role> getRole() {
//        return role;
//    }
//
//    public void setRole(Set<Role> roles) {
//        this.role = roles;
//    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RelaxStatus getStatus() {
        return status;
    }

    public void setStatus(RelaxStatus status) {
        this.status = status;
    }
}
