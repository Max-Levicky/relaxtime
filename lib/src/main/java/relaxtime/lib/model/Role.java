package relaxtime.lib.model;

import javax.persistence.Id;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public enum Role {
    ANONYMOUS(0), USER(1), EDITOR(2), ADMIN(3);
    private int roleId;
    Role(int roleId) {
        this.roleId = roleId;
    }
    public int getRoleId() {
        return roleId;
    }
}
