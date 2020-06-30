package com.company;


public class Function{

    private final int funcNumber;

    private double rightBound;
    private double leftBound;
    private double precision;
    private boolean isDefined;

    public void setRightBound(double rightBound) {
        this.rightBound = rightBound;
    }
    public void setLeftBound(double leftBound) {
        this.leftBound = leftBound;
    }
    public void setPrecision(double precision) {
        this.precision = precision;
    }


    public boolean isDefined(){ return isDefined;}
    public double getRightBound() {
        return rightBound;
    }
    public double getLeftBound() {
        return leftBound;
    }
    public double getPrecision() {
        return precision;
    }

    public Function(int funcNumber){
        this.funcNumber = funcNumber;
    }

    public double getValue(double x){
        switch (funcNumber){
            case 1:
                if(x<0) {
                    isDefined = false;
                    return 0;
                }
                return Math.pow(x, 0.5);
            case 2:
                return x*Math.sin(x);
            case 3:
                if (x == 0)
                    return (Math.atan(1/(x+precision))+Math.atan(1/(x-precision)))/2;
                return Math.atan(1/x);
            case 4:
                return Math.pow(3, 2/(x*x));
            default:
                return x*x-5*x+7;
        }
    }
}
