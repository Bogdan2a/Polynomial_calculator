package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Polynomial;
import model.DivisionResult;
import View.Interface;

public class Controller {

    private Interface anInterface;
    private Polynomial aPolynom;
    private DivisionResult divres;
    private HashMap<Integer, Double> polynom1;
    private HashMap<Integer, Double> polynom2;
    private HashMap<Integer, Double> result;
    private String input1;
    private String input2;

    public Controller(Interface anInterface) {
        this.anInterface = anInterface;
        this.aPolynom = aPolynom;
        this.divres = divres;
        anInterface.addSumButtonListener(new Sum());
        anInterface.addDifferenceButtonListener(new Difference());
        anInterface.addMultiplyButtonListener(new Multiply());
        anInterface.addDivideButtonListener(new Divide());
        anInterface.addDerivationButtonListener(new Derivate());
        anInterface.addIntegrationButtonListener(new Integrate());

    }

    public static HashMap<Integer, Double> inputToHashMap(String polynomial) {
        HashMap<Integer, Double> polynom = new HashMap<>();
        Polynomial polynomaux = new Polynomial();
        Pattern pat = Pattern.compile("(\\+|-)?(\\d*(\\.\\d+)?)(x(\\^(\\d+))?)?|(-?\\d+(\\.\\d+)?)");
        Matcher match = pat.matcher(polynomial);
        // group 0 matches whole match
        // group 1 matches sign
        // group 2 matches coefficient and . and any digits after it
        // group 3 matches . and any digits after it
        // group 4 matches x^power
        // group 5 matches ^power
        // group 6 matches power
        while (match.find()) {
            Double coeff = 1.0d;
            int power = 0;

            if (match.group(4) == null && match.group(2) != null && !match.group(2).isEmpty()) { // free terms
                coeff = Double.parseDouble(match.group(2));
                if (match.group(1) != null && match.group(1).equals("-")) {
                    coeff = -coeff;
                }
                if (polynom.containsKey(power)) {
                    polynom.put(power, polynom.get(power) + coeff);
                } else {
                    polynom.put(power, coeff);
                }
                continue;
            }
            if (match.group(2) != null && !match.group(2).isEmpty()) {
                coeff = Double.parseDouble(match.group(2));
            }
            if (match.group(6) != null && !match.group(6).isEmpty()) {
                power = Integer.parseInt(match.group(6));
            }
            if (match.group(4) != null) {
                if (match.group(6) != null && !match.group(6).isEmpty()) {
                    power = Integer.parseInt(match.group(6));
                }
            }
            if (match.group(4) != null && match.group(5) == null) {
                power = 1;
            }
            if (match.group(1) != null && match.group(1).equals("-")) {
                coeff = -coeff;
            }
            if (polynom.containsKey(power)) {
                polynom.put(power, polynom.get(power) + coeff);
            } else {
                polynom.put(power, coeff);
            }
            if (polynom.containsKey(0)) {
                polynom.put(0, polynom.get(0) - 1);
            }
        }
        return polynom;
    }

    public static String hashMapToOutput(HashMap<Integer, Double> polynomial) {
        String output = "";
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        for (int power : polynomial.keySet()) {
            String temp = "";
            Double coeff = polynomial.get(power);
            if (coeff == 0) {
                continue;
            }
            if (coeff == -1) {
                if (power == 0) temp = "-1";
                else temp = "-";
            }
            if (coeff == 1) {
                if (power == 0) temp = "+1";
                else temp = "+";
            }
            if (coeff != 1 && coeff != -1) {
                if (coeff > 0)
                    temp = "+" + nf.format(coeff);
                else temp = nf.format(coeff);
            }
            if (power == 0) {
                temp = temp + "";
            }
            if (power != 0) {
                if (power == 1) {
                    temp = temp + "x";
                } else {
                    temp = temp + "x^" + Integer.toString(power);
                }
            }
            output = temp + output;
        }
        if (output == "+0" || output == "-0" || output == "0")
            output = "0";
        if (output.isEmpty()) {
            output = "0";
        } else if (output.charAt(0) == '+') {
            output = output.substring(1);
        }
        return output;
    }

    public static boolean validateInput(String input) {
        boolean valid = false;
        Pattern pat = Pattern.compile("(\\+|-)?(\\d*(\\.\\d+)?)(x(\\^(\\d+))?)?|(-?\\d+(\\.\\d+)?)");
        Matcher match = pat.matcher(input);
        while (match.find()) {
            if (match.group(0) == "") {
                String auxmatch = match.group(0);
                if (match.find() == false)
                    valid = true;
                else {
                    valid = false;
                    return valid;
                }

            } else {
                valid = true;
            }
        }
        return valid;
    }

    class Sum implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial = new Polynomial();
            anInterface.setResult1("");
            anInterface.setResult2("");
            input1 = anInterface.getInput1();
            input2 = anInterface.getInput2();
            polynom1 = inputToHashMap(input1);
            polynom2 = inputToHashMap(input2);
            result = polynomial.Sum(polynom1, polynom2);
            String output = hashMapToOutput(result);
            if (validateInput(input1) == false || validateInput(input2) == false) {
                anInterface.showMessage("Invalid input!");
                anInterface.setResult1("");
                anInterface.setResult2("");
            } else {
                anInterface.setResult1(output);
            }
        }
    }

    class Difference implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial = new Polynomial();
            anInterface.setResult1("");
            anInterface.setResult2("");
            input1 = anInterface.getInput1();
            input2 = anInterface.getInput2();
            polynom1 = inputToHashMap(input1);
            polynom2 = inputToHashMap(input2);
            result = polynomial.Subtract(polynom1, polynom2);
            String output = hashMapToOutput(result);
            if (validateInput(input1) == false || validateInput(input2) == false) {
                anInterface.showMessage("Invalid input!");
                anInterface.setResult1("");
                anInterface.setResult2("");
            } else {
                anInterface.setResult1(output);
            }
        }
    }

    class Multiply implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial = new Polynomial();
            anInterface.setResult1("");
            anInterface.setResult2("");
            input1 = anInterface.getInput1();
            input2 = anInterface.getInput2();
            polynom1 = inputToHashMap(input1);
            polynom2 = inputToHashMap(input2);
            result = polynomial.Multiply(polynom1, polynom2);
            String output = hashMapToOutput(result);
            if (validateInput(input1) == false || validateInput(input2) == false) {
                anInterface.showMessage("Invalid input!");
                anInterface.setResult1("");
                anInterface.setResult2("");
            } else {
                anInterface.setResult1(output);
            }
        }
    }

    class Divide implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial = new Polynomial();
            String output1;
            String output2;
            anInterface.setResult1("");
            anInterface.setResult2("");
            input1 = anInterface.getInput1();
            input2 = anInterface.getInput2();
            polynom1 = inputToHashMap(input1);
            polynom2 = inputToHashMap(input2);

            divres = polynomial.Division(polynom1, polynom2);
            if (divres.getDivisionbyzero() == 1) {
                anInterface.showMessage("Division by zero//Provide 2 inputs");
                output1 = "Division by zero//Provide 2 inputs";
                output2 = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
            } else {
                output1 = hashMapToOutput(divres.getQuotient());
                output2 = hashMapToOutput(divres.getRemainder());
            }


            if (validateInput(input1) == false || validateInput(input2) == false) {
                anInterface.showMessage("Invalid input!");
                anInterface.setResult1("");
                anInterface.setResult2("");
            } else {
                anInterface.setResult1(output1);
                anInterface.setResult2(output2);
            }
        }
    }

    class Derivate implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial = new Polynomial();
            anInterface.setResult1("");
            anInterface.setResult2("");
            input1 = anInterface.getInput1();
            polynom1 = inputToHashMap(input1);
            result = polynomial.Derivation(polynom1);
            String output = hashMapToOutput(result);
            if (validateInput(input1) == false) {
                anInterface.showMessage("Invalid input!");
                anInterface.setResult1("");
                anInterface.setResult2("");
            } else {
                anInterface.setResult1(output);
            }
        }
    }

    class Integrate implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial = new Polynomial();
            anInterface.setResult1("");
            anInterface.setResult2("");
            input1 = anInterface.getInput1();
            polynom1 = inputToHashMap(input1);
            result = polynomial.Integration(polynom1);
            String output = hashMapToOutput(result);
            if (validateInput(input1) == false) {
                anInterface.showMessage("Invalid input!");
                anInterface.setResult1("");
                anInterface.setResult2("");
            } else {
                anInterface.setResult1(output);
            }
        }
    }

}
