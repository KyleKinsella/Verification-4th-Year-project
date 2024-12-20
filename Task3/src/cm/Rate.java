package cm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Rate {
    // refactored kind, hourlyNormalRate and hourlyReducedRate to be final
    private final CarParkKind kind;
    private final BigDecimal hourlyNormalRate;
    private final BigDecimal hourlyReducedRate;
    private ArrayList<Period> reduced = new ArrayList<>();
    private ArrayList<Period> normal = new ArrayList<>();

    public Rate(CarParkKind kind, ArrayList<Period> reducedPeriods, ArrayList<Period> normalPeriods, BigDecimal normalRate, BigDecimal reducedRate) {
        if (reducedPeriods == null || normalPeriods == null) {
            throw new IllegalArgumentException("periods cannot be null");
        }
        if (normalRate == null || reducedRate == null) {
            throw new IllegalArgumentException("The rates cannot be null");
        }
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A rate cannot be negative");
        }
        if (normalRate.compareTo(reducedRate) <= 0) {
            throw new IllegalArgumentException("The normal rate cannot be less or equal to the reduced rate");
        }
        // this is the bug that task 2 did not respect this requirement:
        if (normalRate.compareTo(BigDecimal.TEN) > 0 || reducedRate.compareTo(BigDecimal.TEN) > 0) {
            System.out.println("Rates must be less than or equal to 10");
        }
        if (!isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)) {
            throw new IllegalArgumentException("The periods are not valid individually");
        }
        if (!isValidPeriods(reducedPeriods, normalPeriods)) {
            throw new IllegalArgumentException("The periods overlaps");
        }
        this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;
    }

    /**
     * Checks if two collections of periods are valid together
     // refactored / removed period1 and period2 because there was tag description is missing
     * @return true if the two collections of periods are valid together
     */
    //refactored Boolean to be boolean
    private boolean isValidPeriods(ArrayList<Period> periods1, ArrayList<Period> periods2) {
        //refactored Boolean to be boolean
        boolean isValid = true;
        int i = 0;
        while (i < periods1.size() && isValid) {
            isValid = isValidPeriod(periods1.get(i), periods2);
            i++;
        }
        return isValid;
    }

    /**
     * checks if a collection of periods is valid
     * @param list the collection of periods to check
     * @return true if the periods do not overlap
     */
    //refactored Boolean to be boolean
    private boolean isValidPeriods(ArrayList<Period> list) {
        //refactored Boolean to be boolean
        boolean isValid = true;
        if (list.size() >= 2) {
            Period secondPeriod;
            int i = 0;
            int lastIndex = list.size()-1;
            while (i < lastIndex && isValid) {
                isValid = isValidPeriod(list.get(i), ((List<Period>)list).subList(i + 1, lastIndex+1));
                i++;
            }
        }
        return isValid;
    }

    /**
     * checks if a period is a valid addition to a collection of periods
     * @param period the Period addition
     * @param list the collection of periods to check
     * @return true if the period does not overlap in the collecton of periods
     */
    //refactored Boolean to be boolean
    private boolean isValidPeriod(Period period, List<Period> list) {
        //refactored Boolean to be boolean
        boolean isValid = true;
        int i = 0;
        while (i < list.size() && isValid) {
            isValid = !period.overlaps(list.get(i));
            i++;
        }
        return isValid;
    }
    public BigDecimal calculate(Period periodStay) {
        int normalRateHours = periodStay.occurences(normal);
        int reducedRateHours = periodStay.occurences(reduced);
        if (this.kind==CarParkKind.VISITOR) return BigDecimal.valueOf(0);

        BigDecimal totalCost = (this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours)))
                .add(this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));

        switch (this.kind) {
            case VISITOR:
                BigDecimal visitor = BigDecimal.valueOf(10.00);
                if (totalCost.compareTo(visitor) <= 0) {
                    // this part is free if the cost is <= 10.00
                    return BigDecimal.ZERO;
                }
                return totalCost.subtract(visitor).multiply(BigDecimal.valueOf(0.50));
            case STAFF:
                BigDecimal maxCost = BigDecimal.valueOf(16.00);
                return totalCost.min(maxCost); // max cost is 16.00
            case STUDENT:
                BigDecimal student = BigDecimal.valueOf(5.50);
                if (totalCost.compareTo(student) <= 0) {
                    return totalCost; // no discount if the totalcost is <= 5.50
                }
                return student.add(totalCost.subtract(student).multiply(BigDecimal.valueOf(0.75)));
            case MANAGEMENT:
                BigDecimal management = BigDecimal.valueOf(4.00);
                return totalCost.max(management); // cannot be more than 4.00
            default:
                throw new IllegalArgumentException("Invalid car park kind" + this.kind); // someone other than student, staff,
                                                                                        // visitor and management trying to get access
        }
    }
}