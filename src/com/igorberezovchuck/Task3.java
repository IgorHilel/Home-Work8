package com.igorberezovchuck;

import java.util.Random;

public class Task3 {

    private static final int PASSWORD_LENGTH = 8;

    public static void main(String[] args) {

        StringBuilder password = new StringBuilder();

        for (int i = 0; i <= PASSWORD_LENGTH; i++) {
            Random rand = new Random();
            int options = rand.nextInt(4);
            int num = 0;
            int boundNums = 10;
            int boundLetters = 26;
            int minLargeLet = 'A';
            int minSmallLet = 'a';
            int minNums = 48;
            int underscoreSymbol = '_';

            if (i == (PASSWORD_LENGTH - 3)) {
                num = rand.nextInt(boundLetters) + minSmallLet;
                char change = (char) num;
                password.append(change);
                num = rand.nextInt(boundLetters) + minLargeLet;
                change = (char) num;
                password.append(change);
                num = rand.nextInt(boundNums) + minNums;
                change = (char) num;
                password.append(change);
                break;
            }

            if (options == 0) {
                num = rand.nextInt(boundLetters) + minSmallLet;
            } else if (options == 1) {
                num = rand.nextInt(boundLetters) + minLargeLet;
            } else if (options == 2) {
                num = rand.nextInt(boundNums) + minNums;
            } else if (options == 3) {
                num = underscoreSymbol;
            }

            char change = (char) num;
            password.append(change);
        }
        System.out.println("Password: " + password);
    }
}
