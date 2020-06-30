package com.company;
import com.company.exception.FunctionHasNoLimitException;

public class IntegralSolver {

    public double[] solve(Function function) throws FunctionHasNoLimitException {
        double precision = function.getPrecision();
        double integralDifference = function.getPrecision();
        int division = 100;

        double integral = 0;

            integral = integrate(function, division);
            while (integralDifference>=precision){
                division *=2;
                double doubleIntegral = integrate(function, division);
                integralDifference = Math.abs(doubleIntegral - integral)/15;
                integral = doubleIntegral;
            }

        return  new double[]{integral, division, precision};
    }

    public double integrate(Function function, int division) throws FunctionHasNoLimitException{
        double [] bounds = new double[2];

        if (function.getRightBound()>function.getLeftBound()){
            bounds[0] = function.getLeftBound();
            bounds[1] = function.getRightBound();
        }else{
            bounds[0] = function.getRightBound();
            bounds[1] = function.getLeftBound();
        }
        double step = (bounds[1]-bounds[0])/division;
        double sum = 0;
        for (int i = 1; i < division-1; i++){
            if (i%2==0){
                sum += 2*function.getValue(bounds[0]+i*step);
            }else {
                sum += 4*function.getValue(bounds[0]+i*step);
            }
            if (function.getValue(bounds[0]+i*step)>1e10d)
                throw new FunctionHasNoLimitException();
        }
        sum = (function.getValue(bounds[0]) + sum + function.getValue(bounds[1]))*step/3;
        return sum;
    }
}