package com.cristian.Calculator.app;

public class LogicCalculator {
    private double number1 = 0;
    private double number2 = 0;

    private char operator;

    @Override
    public String toString() {
        return "LogicCalculator{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                ", operator=" + operator +
                '}';
    }

    public void setNumber (double number){
        if(operator == 0){
            number1 = number;
        } else{
            number2 = number;
        }
    }

    public char operator(char operator){
        return this.operator = operator;
    }

    public double operation(){
        double result = 0;
        switch (operator){
            case '+' -> result =  number1 + number2;
            case '-' -> result = number1 - number2;
            case 'x' -> result = number1 * number2;
            case '/' -> {
                if(number2 == 0) throw new ArithmeticException("Cannot divide by zero");
                result = number1 / number2;
            }
            default -> result = 0;
        }
        operator = 0;
        return result ;
    }


}
