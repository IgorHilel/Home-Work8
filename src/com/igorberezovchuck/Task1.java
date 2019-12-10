package com.igorberezovchuck;

public class Task1 {

    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= 99; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.append("Hello World ");
                continue;
            } else if (i % 3 == 0) {
                result.append("Hello ");
                continue;
            } else if (i % 5 == 0) {
                result.append("World ");
                continue;
            } else {
                result.append(i + " ");
            }
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }
}
