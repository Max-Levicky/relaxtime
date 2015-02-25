package relaxtime.lib.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Document(collection = "user")
public class User extends MongoModel implements UserDetails {

    protected int authRole = 1;

    private PersonalInformation personalInformation;
    private Department department;

    public User(int id, PersonalInformation personalInformation, Department department) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> auth = new ArrayList<>();
        auth.add(() -> {
            String authority;
            switch (authRole) {
                case 1:
                    authority = "ROLE_USER";
                    break;
                case 2:
                    authority = "ROLE_EDITOR";
                    break;
                case 3:
                    authority = "ROLE_ADMIN";
                    break;
                default:
                    authority = "ROLE_ANONYMOUS";
            }
            return authority;
        });
        return auth;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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
}
