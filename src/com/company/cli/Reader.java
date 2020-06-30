package com.company.cli;

import java.util.Scanner;

public class Reader{
    Scanner in = new Scanner(System.in);
    public int readInt(){
        return Integer.parseInt(in.next());
    }
    public double readDouble(){
        return Double.parseDouble(in.next().replace(",", "."));
    }
}
