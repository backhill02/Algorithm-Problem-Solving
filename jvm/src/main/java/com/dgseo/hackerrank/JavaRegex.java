package com.dgseo.hackerrank;

import java.util.Scanner;

public class JavaRegex {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }

    public static class MyRegex {
        String num = "(\\d{1,2}|[01]\\d{2}|2[0-4]\\d|25[0-5])";
        String pattern = num + "\\." +  num + "\\." +  num + "\\." + num;
    }
}
