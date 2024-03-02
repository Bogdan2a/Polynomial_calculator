package model;

import java.util.*;

public class DivisionResult {
    private HashMap<Integer, Double> quotient;
    private HashMap<Integer, Double> remainder;
    private Integer divisionbyzero;

    public HashMap<Integer, Double> getQuotient() {
        return quotient;
    }

    public void setQuotient(HashMap<Integer, Double> quotient) {
        this.quotient = quotient;
    }

    public HashMap<Integer, Double> getRemainder() {
        return remainder;
    }

    public void setRemainder(HashMap<Integer, Double> remainder) {
        this.remainder = remainder;
    }

    public Integer getDivisionbyzero() {
        return divisionbyzero;
    }

    public void setDivisionbyzero(Integer divisionbyzero) {
        this.divisionbyzero = divisionbyzero;
    }
}
