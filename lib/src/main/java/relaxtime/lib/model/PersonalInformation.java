package relaxtime.lib.model;

import java.util.Date;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class PersonalInformation {
    private String firstName;
    private String secondName;
    private Date birthday;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
