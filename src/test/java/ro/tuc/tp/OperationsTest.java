package ro.tuc.tp;

import java.util.HashMap;

import model.Polynomial;
import model.DivisionResult;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    Polynomial polynom = new Polynomial();

    @Test
    public void SumTest1() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> polynom2 = new HashMap<>();
        HashMap<Integer, Double> result = new HashMap<>();
        //polynom1 x^4+2x^3-1x^2+3x+2
        //polynom2      x^3+2x^2-6x-3
        //result   x^4+3x^3+ x^2-3x-1
//                 x^4+3.0x^3+x^2-3.0x-1
        polynom1.put(4, 1.0d);
        polynom1.put(3, 2.0d);
        polynom1.put(2, -1.0d);
        polynom1.put(1, 3.0d);
        polynom1.put(0, 2.0d);

        polynom2.put(3, 1.0d);
        polynom2.put(2, 2.0d);
        polynom2.put(1, -6.0d);
        polynom2.put(0, -3.0d);

        result.put(4, 1.0d);
        result.put(3, 3.0d);
        result.put(2, 1.0d);
        result.put(1, -3.0d);
        result.put(0, -1.0d);

        assertEquals(polynom.Sum(polynom1, polynom2), result);
    }

    @Test
    public void SumTest2() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> polynom2 = new HashMap<>();
        HashMap<Integer, Double> result = new HashMap<>();
        //polynom1 x^7-x^5+1.5x^2+x
        //polynom2      2x^3+x^2-3
        //result   x^7-x^5+2x^3+2.5x^2+x-3
        polynom1.put(7, 1.0d);
        polynom1.put(5, -1.0d);
        polynom1.put(2, 1.5d);
        polynom1.put(1, 1.0d);

        polynom2.put(3, 2.0d);
        polynom2.put(2, 1.0d);
        polynom2.put(0, -3.0d);

        result.put(7, 1.0d);
        result.put(6, 0.0d);
        result.put(5, -1.0d);
        result.put(4, 0.0d);
        result.put(3, 2.0d);
        result.put(2, 2.5d);
        result.put(1, 1.0d);
        result.put(0, -3.0d);

        assertEquals(polynom.Sum(polynom1, polynom2), result);
    }

    @Test
    public void DiffTest1() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> polynom2 = new HashMap<>();
        HashMap<Integer, Double> result = new HashMap<>();
        //polynom1 x^4+2x^3-1x^2+3x+2
        //polynom2      x^3+2x^2-6x-3
        //result   x^4+x^3−3x^2+9x+5
        polynom1.put(4, 1.0d);
        polynom1.put(3, 2.0d);
        polynom1.put(2, -1.0d);
        polynom1.put(1, 3.0d);
        polynom1.put(0, 2.0d);

        polynom2.put(3, 1.0d);
        polynom2.put(2, 2.0d);
        polynom2.put(1, -6.0d);
        polynom2.put(0, -3.0d);

        result.put(4, 1.0d);
        result.put(3, 1.0d);
        result.put(2, -3.0d);
        result.put(1, 9.0d);
        result.put(0, 5.0d);

        assertEquals(polynom.Subtract(polynom1, polynom2), result);
    }

    @Test
    public void DiffTest2() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> polynom2 = new HashMap<>();
        HashMap<Integer, Double> result = new HashMap<>();
        //polynom1 x^7-x^5+1.5x^2+x
        //polynom2      2x^3+x^2-3
        //result   x^7-x^5-2x^3+0.5x^2+x+3
        polynom1.put(7, 1.0d);
        polynom1.put(5, -1.0d);
        polynom1.put(2, 1.5d);
        polynom1.put(1, 1.0d);

        polynom2.put(3, 2.0d);
        polynom2.put(2, 1.0d);
        polynom2.put(0, -3.0d);

        result.put(7, 1.0d);
        result.put(5, -1.0d);
        result.put(3, -2.0d);
        result.put(2, 0.5d);
        result.put(1, 1.0d);
        result.put(0, 3.0d);

        assertEquals(polynom.Subtract(polynom1, polynom2), result);
    }

    @Test
    public void MultiplyTest1() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> polynom2 = new HashMap<>();
        HashMap<Integer, Double> result = new HashMap<>();
        //polynom1 x^7-x^5+1.5x^2+x
        //polynom2      2x^3+x^2-3
        //result   2x^10+x^9-2x^8-4x^7+6x^5+3.5x^4+x^3-4.5x^2-3x
        polynom1.put(7, 1.0d);
        polynom1.put(6, 0.0d);
        polynom1.put(5, -1.0d);
        polynom1.put(4, 0.0d);
        polynom1.put(3, 0.0d);
        polynom1.put(2, 1.5d);
        polynom1.put(1, 1.0d);
        polynom1.put(0, 0.0d);

        polynom2.put(3, 2.0d);
        polynom2.put(2, 1.0d);
        polynom2.put(1, 0.0d);
        polynom2.put(0, -3.0d);

        result.put(10, 2.0d);
        result.put(9, 1.0d);
        result.put(8, -2.0d);
        result.put(7, -4.0d);
        result.put(6, 0.0d);
        result.put(5, 6.0d);
        result.put(4, 3.5d);
        result.put(3, 1.0d);
        result.put(2, -4.5d);
        result.put(1, -3.0d);
        result.put(0, 0.0d);

        assertEquals(polynom.Multiply(polynom1, polynom2), result);
    }

    @Test
    public void MultiplyTest2() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> polynom2 = new HashMap<>();
        HashMap<Integer, Double> result = new HashMap<>();
        //polynom1 x^4+2x^3-1x^2+3x+2
        //polynom2      x^3+2x^2-6x-3
        //result   x^7+4x^6−3x^5−14x^4+8x^3−11x^2−21^x−6
        polynom1.put(4, 1.0d);
        polynom1.put(3, 2.0d);
        polynom1.put(2, -1.0d);
        polynom1.put(1, 3.0d);
        polynom1.put(0, 2.0d);

        polynom2.put(3, 1.0d);
        polynom2.put(2, 2.0d);
        polynom2.put(1, -6.0d);
        polynom2.put(0, -3.0d);

        result.put(7, 1.0d);
        result.put(6, 4.0d);
        result.put(5, -3.0d);
        result.put(4, -14.0d);
        result.put(3, 8.0d);
        result.put(2, -11.0d);
        result.put(1, -21.0d);
        result.put(0, -6.0d);

        assertEquals(polynom.Multiply(polynom1, polynom2), result);
    }

    @Test
    public void DivisionTest1() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> polynom2 = new HashMap<>();
        HashMap<Integer, Double> quotient = new HashMap<>();
        HashMap<Integer, Double> remainder = new HashMap<>();
        //polynom1 x^3-2x^2+6x-5
        //polynom2     x^2-1
        //quotient   x-2
        //remainder  7x-7
        polynom1.put(3, 1.0d);
        polynom1.put(2, -2.0d);
        polynom1.put(1, 6.0d);
        polynom1.put(0, -5.0d);

        polynom2.put(2, 1.0d);
        polynom2.put(1, 0.0d);
        polynom2.put(0, -1.0d);

        quotient.put(2, 0.0d);
        quotient.put(1, 1.0d);
        quotient.put(0, -2.0d);

        remainder.put(3, 0.0d);
        remainder.put(2, 0.0d);
        remainder.put(1, 7.0d);
        remainder.put(0, -7.0d);

        DivisionResult divisionResult = polynom.Division(polynom1, polynom2);
        assertEquals(divisionResult.getQuotient(), quotient);
        assertEquals(divisionResult.getRemainder(), remainder);
        assertEquals(divisionResult.getDivisionbyzero(), 0);

    }

    @Test
    public void DivisionTest2() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> polynom2 = new HashMap<>();
        HashMap<Integer, Double> quotient = new HashMap<>();
        HashMap<Integer, Double> remainder = new HashMap<>();
        //polynom1 x^2-4
        //polynom2 x-2
        //quotient x+2
        //remainder 0
        polynom1.put(2, 1.0d);
        polynom1.put(0, -4.0d);

        polynom2.put(1, 1.0d);
        polynom2.put(0, -2.0d);

        quotient.put(1, 1.0d);
        quotient.put(0, 2.0d);

        remainder.put(2, 0.0d);
        remainder.put(1, 0.0d);
        remainder.put(0, 0.0d);

        DivisionResult divisionResult = polynom.Division(polynom1, polynom2);
        assertEquals(divisionResult.getQuotient(), quotient);
        assertEquals(divisionResult.getRemainder(), remainder);
        assertEquals(divisionResult.getDivisionbyzero(), 0);
    }

    @Test
    public void DerivationTest1() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> result = new HashMap<>();
        //polynom1 x^4+2x^3-1x^2+3x+2
        //result   4x^3+6x^2-2x+3
        polynom1.put(4, 1.0d);
        polynom1.put(3, 2.0d);
        polynom1.put(2, -1.0d);
        polynom1.put(1, 3.0d);
        polynom1.put(0, 2.0d);

        result.put(3, 4.0d);
        result.put(2, 6.0d);
        result.put(1, -2.0d);
        result.put(0, 3.0d);

        assertEquals(polynom.Derivation(polynom1), result);
    }

    @Test
    public void DerivationTest2() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> result = new HashMap<>();
        //polynom1 x^7-x^5+1.5x^2+x
        //result   7x^6-5x^4+3x+1
        polynom1.put(7, 1.0d);
        polynom1.put(5, -1.0d);
        polynom1.put(2, 1.5d);
        polynom1.put(1, 1.0d);

        result.put(6, 7.0d);
        result.put(4, -5.0d);
        result.put(1, 3.0d);
        result.put(0, 1.0d);

        assertEquals(polynom.Derivation(polynom1), result);
    }

    @Test
    public void IntegrationTest1() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> result = new HashMap<>();
        //polynom1   4x^3+6x^2-2x+3
        //result x^4+2x^3-x^2+3x
        result.put(4, 1.0d);
        result.put(3, 2.0d);
        result.put(2, -1.0d);
        result.put(1, 3.0d);

        polynom1.put(3, 4.0d);
        polynom1.put(2, 6.0d);
        polynom1.put(1, -2.0d);
        polynom1.put(0, 3.0d);

        assertEquals(polynom.Integration(polynom1), result);
    }

    @Test
    public void IntegrationTest2() {
        HashMap<Integer, Double> polynom1 = new HashMap<>();
        HashMap<Integer, Double> result = new HashMap<>();
        //result x^7-x^5+1.5x^2+x
        //polynom1   7x^6-5x^4+3x+1
        result.put(7, 1.0d);
        result.put(5, -1.0d);
        result.put(2, 1.5d);
        result.put(1, 1.0d);

        polynom1.put(6, 7.0d);
        polynom1.put(4, -5.0d);
        polynom1.put(1, 3.0d);
        polynom1.put(0, 1.0d);

        assertEquals(polynom.Integration(polynom1), result);
    }
}

