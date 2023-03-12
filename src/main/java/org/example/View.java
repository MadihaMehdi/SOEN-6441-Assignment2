package org.example;

import org.example.controllers.ViewController;

import java.text.ParseException;

public class View {
    public static void main(String[] args) throws ParseException {

        ViewController viewController = new ViewController();

        viewController.startProgram();
    }
}