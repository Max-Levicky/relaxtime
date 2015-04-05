package relaxtime.lib.model;

import java.util.Date;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
//@Document(collection = "personalInformation")
public class PersonalInformation {
    private int id;
    private String firstName;
    private String secondName;
    private Date birthday;

    public PersonalInformation() {
    }

    public PersonalInformation(int id, String firstName, String secondName, Date birthday) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
