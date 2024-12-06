package cm;

import java.util.List;

public class Period {
    // refactored startHour and endHour to be final
    private final int startHour;
    private final int endHour;

    public Period(int start, int end) {
        // I have refactored the code to not have start < 0, start > 24 || end < 0, end > 24
        if (start < 0 || start > 24) {
            throw new IllegalArgumentException("start of period and end of period must be between 0 and 24");
        }
        if (end < 0 || end > 24) {
            throw new IllegalArgumentException("end of period must be between 0 and 24");
        }
        // the above if statement has been refactored to ensure the "end < 0" requirement being met.
        if (start >= end) {
            throw new IllegalArgumentException("start of period cannot be later or equal to end of period");
        }
        this.startHour = start;
        this.endHour = end;
    }

    /**
     * checks if a given hour is within the period
     * @param hour the start of the hour to check
     * @return true if the hour is within the period
     */
    // refactored Boolean to be boolean
    private boolean isIn(int hour) {
        return hour >= this.startHour && hour < this.endHour;
    }

    // refactored Boolean to be boolean
    private static boolean isIn(int hour, List<Period> list) {
        // refactored Boolean to be boolean
        boolean isIn = false;
        int i = 0;
        while (i < list.size() && !isIn) {
            isIn = list.get(i).isIn(hour);
            i++;
        }
        return isIn;
    }

    /**
     * The duration of a period
     * @return the number of whole hours a this period covers
     */
    public int duration() {
        return this.endHour - this.startHour;
    }

    /**
     * Returns the numbers of hours this period is included in the list
     * @param list the list of periods to check
     * @return the number of full hours covered by this period
     */
    public int occurences(List<Period> list) {
        int occurences = 0;
        for (int hour = this.startHour; hour < this.endHour; hour++) {
            if (isIn(hour, list)) {
                occurences++;
            }
        }
        return occurences;
    }

    public boolean overlaps(Period period) {
        return this.endHour>period.startHour && this.startHour<period.endHour;
    }
}