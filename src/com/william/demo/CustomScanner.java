package com.william.demo;

import java.util.Scanner;

public class CustomScanner {

    private Scanner scanner;

    public CustomScanner() {
        scanner = new Scanner(System.in);
    }

    public int nextInt() {
        return scanner.nextInt();
    }
    public String next() {
        return scanner.next();
    }

}