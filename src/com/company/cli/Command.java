package com.company.cli;

import com.company.Function;
import com.company.FunctionManager;
import com.company.IntegralSolver;
import com.company.exception.FunctionHasNoLimitException;

import java.io.*;

public class Command {
    private PrintStream out = System.out;
    Reader reader = new Reader();

    private String greetingMsg = "Достпуные функии: "+"\n"+
            "1. x^(1/2)" +"\n"+
            "2. x*sin(x)" +"\n"+
            "3. arctg(1/x)" +"\n"+
            "4. 3^(2/x^2)" +"\n"+
            "5. x^2-5x+7" +"\n";

    public Function readFunction(){
        out.println(greetingMsg);

        FunctionManager manager =  new FunctionManager();
        manager.setFunctionNumber(getFunctionFromOut());
        Function function = new Function(manager.getFunctionNumber());
        function.setLeftBound(getLeftBoundFromOut());
        function.setRightBound(getRightBoundFromOut());
        function.setPrecision(getPrecisionFromOut());

        return function;
    }

    public int getFunctionFromOut(){
        out.println("Введите номер функции");
        return reader.readInt();
    }
    public double getLeftBoundFromOut(){
        out.println("Введите нижнюю границу");
        return reader.readDouble();
    }
    public double getRightBoundFromOut(){
        out.println("Введите верхнюю границу");
        return reader.readDouble();
    }
    public double getPrecisionFromOut(){
        out.println("Введите точность");
        return reader.readDouble();
    }

    public String formatIntegral(Function function){
        double[] ans;
        try {
             ans = new IntegralSolver().solve(function);
        }catch (FunctionHasNoLimitException e){
            return "В данном промежутке нет предела или существует разрыв 2 рода";
        }
        if(!function.isDefined() && ans[0] == 0)
            return "В данном промежутке функция не определена";
        return "интеграл: " + ans[0] +"\n"+
                "количество делений: " + ans[1] +"\n"+
                "погрешность: " + ans[2];
    }
    public void printAnswer(Function function){
        out.println(formatIntegral(function));
    }
}
