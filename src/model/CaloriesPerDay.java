package model;

import java.time.LocalDate;
import java.util.Objects;

public class CaloriesPerDay {

    private LocalDate date;

    private double caloriesSum;

    public CaloriesPerDay(LocalDate date, double caloriesSum) {
        this.date = date;
        this.caloriesSum = caloriesSum;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getCaloriesSum() {
        return caloriesSum;
    }

    public void setCaloriesSum(double caloriesSum) {
        this.caloriesSum = caloriesSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaloriesPerDay that = (CaloriesPerDay) o;
        return Double.compare(that.caloriesSum, caloriesSum) == 0 && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, caloriesSum);
    }

    @Override
    public String toString() {
        return "CaloriesPerDay{" +
                "date=" + date +
                ", caloriesSum=" + caloriesSum +
                '}';
    }
}
