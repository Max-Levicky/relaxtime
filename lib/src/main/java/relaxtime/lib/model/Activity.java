package relaxtime.lib.model;

import com.google.common.collect.Range;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
@Document(collection = "activity")
public class Activity extends MongoModel {
    private String name;
    private String place;
    private int neededTime;
    private Range<Integer> personsRange;
    private boolean busy;

    public Activity() {
    }

    public Activity(String name, String place, int neededTime, Range<Integer> personsRange) {
        this.name = name;
        this.place = place;
        this.neededTime = neededTime;
        this.personsRange = personsRange;
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
}
