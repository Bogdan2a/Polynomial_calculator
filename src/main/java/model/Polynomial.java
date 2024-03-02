package model;

import java.util.*;

public class Polynomial {
    private HashMap<Integer, Double> polynom;

    public Polynomial() {
        this.polynom = new HashMap<Integer, Double>();
    }

    public HashMap<Integer, Double> Sum(HashMap<Integer, Double> polynom1, HashMap<Integer, Double> polynom2) {

        int aux = 0;
        HashMap<Integer, Double> polynom_null = new HashMap<>();
        HashMap<Integer, Double> aux1 = new HashMap<>();
        HashMap<Integer, Double> aux2 = new HashMap<>();
        aux1.putAll(polynom1);
        aux2.putAll(polynom2);
        if (degree(polynom1) < degree(polynom2)) {
            polynom1 = aux2;
            polynom2 = aux1;
        }
        for (Integer iterator : polynom1.keySet()) {
            if (iterator > aux) {
                aux = iterator;
            }
        }

        while (aux >= 0) {
            polynom_null.put(aux, 0.0d);
            aux--;
        }
        HashMap<Integer, Double> result = new HashMap<>();
        result.putAll(polynom_null);
        for (Integer entry : polynom2.keySet()) {
            if (polynom1.containsKey(entry) == false) {
                polynom1.put(entry, 0.0d);
            }
        }
        for (Integer entry : polynom1.keySet()) {
            if (polynom2.containsKey(entry)) {
                result.put(entry, polynom1.get(entry) + polynom2.get(entry));
            } else {
                result.put(entry, polynom1.get(entry));

            }
        }
        return result;
    }

    public HashMap<Integer, Double> Subtract(HashMap<Integer, Double> polynom1, HashMap<Integer, Double> polynom2) {

        int aux;
        HashMap<Integer, Double> polynom_null = new HashMap<>();
        HashMap<Integer, Double> aux1 = new HashMap<>();
        HashMap<Integer, Double> aux2 = new HashMap<>();
        aux1.putAll(polynom1);
        aux2.putAll(polynom2);
        aux = polynom1.size() - 1;
        while (aux >= 0) {
            polynom_null.put(aux, 0.0d);
            aux--;
        }
        HashMap<Integer, Double> result = new HashMap<>();
        result.putAll(polynom_null);
        for (Integer entry : polynom2.keySet()) {
            if (polynom1.containsKey(entry) == false) {
                polynom1.put(entry, 0.0d);
            }
        }
        for (Integer entry : polynom1.keySet()) {
            if (polynom2.containsKey(entry)) {
                result.put(entry, polynom1.get(entry) - polynom2.get(entry));
            } else {
                result.put(entry, polynom1.get(entry));
            }
        }
        return result;
    }

    public HashMap<Integer, Double> Integration(HashMap<Integer, Double> polynom1) {

        HashMap<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : polynom1.entrySet()) {
            result.put(entry.getKey() + 1, entry.getValue() / (entry.getKey() + 1));
        }
        return result;
    }

    public HashMap<Integer, Double> Derivation(HashMap<Integer, Double> polynom1) {

        HashMap<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : polynom1.entrySet()) {
            if (entry.getKey() > 0)
                result.put(entry.getKey() - 1, entry.getValue() * entry.getKey());
            if (entry.getKey() == 0) {
                result.put(0, 0.0d);
            }
        }
        return result;
    }

    public HashMap<Integer, Double> Multiply(HashMap<Integer, Double> polynom1, HashMap<Integer, Double> polynom2) {

        HashMap<Integer, Double> result = new HashMap<>();
        HashMap<Integer, Double> polynom_null = new HashMap<>();
        int aux = polynom1.size() + polynom2.size() - 2;
        while (aux >= 0) {
            polynom_null.put(aux, 0.0d);
            aux--;
        }
        result.putAll(polynom_null);
        HashMap<Integer, Double> intermediate = new HashMap<>();
        intermediate.putAll(polynom_null);
        for (Map.Entry<Integer, Double> entry1 : polynom1.entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : polynom2.entrySet()) {
                intermediate.put(entry1.getKey() + entry2.getKey(), entry1.getValue() * entry2.getValue());
            }
            result = Sum(result, intermediate);
            intermediate.putAll(polynom_null);
        }
        return result;
    }

    public int degree(HashMap<Integer, Double> polynom) {
        int degree = -1;
        for (Integer aux : polynom.keySet()) {
            if (aux > degree && polynom.get(aux) != 0) {
                degree = aux;
            }
        }
        return degree;
    }

    public DivisionResult Division(HashMap<Integer, Double> polynom1, HashMap<Integer, Double> polynom2) {

        int aux;
        DivisionResult result1 = new DivisionResult();
        aux = polynom1.size() - polynom2.size() + 1;
        HashMap<Integer, Double> polynom_null = new HashMap<>();
        while (aux >= 0) {
            polynom_null.put(aux, 0.0d);
            aux--;
        }
        if (polynom2.isEmpty() || polynom1.isEmpty()) {
            result1.setQuotient(polynom1);
            result1.setRemainder(polynom2);
            result1.setDivisionbyzero(1);
            return result1;
        }
        int ok = 1;
        for (Double aux1 : polynom2.values()) {
            if (aux1 != 0) {
                ok = 0;
            }
        }
        if (ok == 1) {
            result1.setQuotient(polynom1);
            result1.setRemainder(polynom2);
            result1.setDivisionbyzero(1);
            return result1;
        }
        HashMap<Integer, Double> quotient = new HashMap<>();
        HashMap<Integer, Double> remainder = new HashMap<>();
        HashMap<Integer, Double> t = new HashMap<>();
        HashMap<Integer, Double> n = new HashMap<>();
        n = polynom1;
        HashMap<Integer, Double> d = new HashMap<>();
        d = polynom2;
        quotient.putAll(polynom_null);
        remainder = n;
        while (remainder.isEmpty() == false && degree(remainder) >= degree(d)) {
            t.put(degree(remainder) - degree(d), remainder.get(degree(remainder)) / d.get(degree(d)));
            quotient = Sum(quotient, t);
            remainder = Subtract(remainder, Multiply(t, d));


            t = Subtract(t, t);

        }


        result1.setQuotient(quotient);
        result1.setRemainder(remainder);
        result1.setDivisionbyzero(0);
        return result1;
    }
}
