package com.igorberezovchuck;

public class Task2 {

    public static void main(String[] args) {

        StringBuilder firstString = new StringBuilder("TeSTsTriNg tEStSTRing tEStstrInG");
        StringBuilder result = getString(firstString);
        System.out.println(result);
    }

    private static StringBuilder getString(StringBuilder firstString) {

        for (int i = 0; i < firstString.length(); i++) {
            char symbol = firstString.charAt(i);
            if (i == 0) {
                firstString.replace(i, (i + 1), String.valueOf(Character.toUpperCase(symbol)));
            } else if (firstString.charAt(i - 1) == ' ') {
                firstString.replace(i, (i + 1), String.valueOf(Character.toUpperCase(symbol)));
            } else {
                firstString.replace(i, (i + 1), String.valueOf(Character.toLowerCase(symbol)));
            }
        }
        return firstString;
    }
}
