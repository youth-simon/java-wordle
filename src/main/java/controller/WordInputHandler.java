package controller;

import java.util.Scanner;

public class WordInputHandler {

    public String inputWord() {
        while (true) {
            String input = new Scanner(System.in).nextLine().toLowerCase();
            try {
                validateInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Empty input");
        }
        if (input.length() != 5) {
            throw new IllegalArgumentException("Not five characters long");
        }
    }
}
