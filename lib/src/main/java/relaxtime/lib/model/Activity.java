package relaxtime.lib.model;

import com.google.common.collect.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Entity
public class Activity extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String place;
    private int neededTime;
    private Range<Integer> personsRange;
    private boolean busy;
    private ActivityType type;

    public Activity() {
    }

    public Activity(String name, String place, int neededTime, Range<Integer> personsRange) {
        this.name = name;
        this.place = place;
        this.neededTime = neededTime;
        this.personsRange = personsRange;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(int neededTime) {
        this.neededTime = neededTime;
    }

    public Range<Integer> getPersonsRange() {
        return personsRange;
    }

    public void setPersonsRange(Range<Integer> personsRange) {
        this.personsRange = personsRange;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }
}
