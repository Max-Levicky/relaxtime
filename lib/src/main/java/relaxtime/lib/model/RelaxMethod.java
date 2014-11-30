package relaxtime.lib.model;

import com.google.common.collect.Range;

/**
 * @author Maxim
 * @date $ {DATE}.
 */
public class RelaxMethod {
    private String name;
    private String place;
    private int neededTime;
    private Range<Integer> placesRange;

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

    public Range<Integer> getPlacesRange() {
        return placesRange;
    }

    public void setPlacesRange(Range<Integer> placesRange) {
        this.placesRange = placesRange;
    }
}
