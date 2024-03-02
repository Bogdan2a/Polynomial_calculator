package org.example;

import View.Interface;
import controler.Controller;


public class Main {
    public static void main(String[] args) {
        Interface view = new Interface();
        view.setVisible(true);
        Controller controller = new Controller(view);
    }
}