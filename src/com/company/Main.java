package com.company;

import com.company.cli.Command;

public class Main {
    public static void main(String[] args){
        Command cmd = new Command();
        Function function = cmd.readFunction();
        cmd.printAnswer(function);
    }


}

