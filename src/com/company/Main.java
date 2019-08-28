package com.company;

import common.ReadFile;
import nesting.NestingCheck;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ReadFile readFile = new ReadFile();
        BufferedReader br = readFile.getFile();
        NestingCheck nestingCheck = new NestingCheck();
        String st;
        while ((st = br.readLine()) != null) {
            nestingCheck.checkBracket(st);
           // System.out.println(st);
        }
    }
}
