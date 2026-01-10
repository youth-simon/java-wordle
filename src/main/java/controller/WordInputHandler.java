package controller;

import java.util.Scanner;

public class WordInputHandler {

    private boolean validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Empty input");
        }
        if (input.length() > 5) {
            throw new IllegalArgumentException("Too Long input");
        }
        return true;
    }
    public String inputWord() {
        boolean inputSuccess = false;
        while (!inputSuccess) {
            String input = new Scanner(System.in).nextLine();
            try {
                inputSuccess = validateInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return "";
    }
}
