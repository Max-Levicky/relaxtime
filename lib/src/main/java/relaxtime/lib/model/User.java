package relaxtime.lib.model;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Entity
@Table(name = "users")
public class User extends BaseModel implements UserDetails {
    @Id
    private Long id;
    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    private List<Role> roles = Lists.newArrayList(Role.ANONYMOUS);

    private String username;
    private String password;
    private String email;

    private Date lastRelaxTime;
    private RelaxStatus relaxStatus;

    @ManyToOne
    private PersonalInformation personalInformation;
    @ManyToOne
    private Department department;

    public static enum Role {
        ANONYMOUS(0), USER(1), EDITOR(2), ADMIN(3);
        private int roleId;
        Role(int roleId) {
            this.roleId = roleId;
        }
        public int getRoleId() {
            return roleId;
        }
    }

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
        roles.forEach((role) -> auth.add(new SimpleGrantedAuthority("ROLE_" + role)));
        return auth;
    }

    @Override
    public String getPassword() {
        return password;
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
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
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

    public RelaxStatus getRelaxStatus() {
        return relaxStatus;
    }

    public void setRelaxStatus(RelaxStatus relaxStatus) {
        this.relaxStatus = relaxStatus;
    }
}
