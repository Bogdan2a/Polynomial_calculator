package View;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Interface extends JFrame {
    private JTextField Input1;
    private JTextField Input2;
    private JTextField Result1;
    private JTextField Result2;
    private JButton sumButton;
    private JButton differenceButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton derivationButton;
    private JButton integrationButton;
    private JPanel basePanel;

    public Interface() {
        setDimension(900, 500);
    }

    public void setDimension(int w, int h) {
        add(basePanel);
        setBounds(300, 200, w, h);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public String getInput1() {
        return this.Input1.getText();
    }

    public void setResult1(String result1) {
        Result1.setText(result1);
    }

    public String getInput2() {
        return this.Input2.getText();
    }

    public void setResult2(String result2) {
        Result2.setText(result2);
    }

    public void addSumButtonListener(ActionListener listener) {
        this.sumButton.addActionListener(listener);
    }

    public void addDifferenceButtonListener(ActionListener listener) {
        this.differenceButton.addActionListener(listener);
    }

    public void addMultiplyButtonListener(ActionListener listener) {
        this.multiplyButton.addActionListener(listener);
    }

    public void addDivideButtonListener(ActionListener listener) {
        this.divideButton.addActionListener(listener);
    }

    public void addDerivationButtonListener(ActionListener listener) {
        this.derivationButton.addActionListener(listener);
    }

    public void addIntegrationButtonListener(ActionListener listener) {
        this.integrationButton.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(Interface.this, message, "Messsage", JOptionPane.INFORMATION_MESSAGE);
    }
}
