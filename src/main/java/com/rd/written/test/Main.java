package com.rd.written.test;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AccountLoader.loadFile(args[0])
                .forEach(System.out::println);
    }
}