package com.netcracker.mypolynomial;

import java.util.Arrays;

public class MyPolynomial {

    private double[] coeffs;

    public MyPolynomial(double coeffs[]) {
        this.coeffs = coeffs;
    }

    public int getDegree(){
        //степенью полинома является наивысшая степень одночлена полинома, коэффициент которого не равен нулю
        int degree = coeffs.length-1;
        for (int i=degree; i>0; i--){
            if(coeffs[i] == 0){
                continue;
            }
            else{
                degree=i;
                break;
            }
        }
        return degree;
    }

    @Override
    public String toString(){
        StringBuilder polynomial = new StringBuilder();
        if (coeffs.length>0){
            if (coeffs.length>1){
                for(int i=coeffs.length-1; i > 1; i--){
                    polynomial.append(coeffs[i] + "x^" + i + "+");
                }
                polynomial.append(coeffs[1] + "x+");
            }
            polynomial.append(coeffs[0]);
        }
        return polynomial.toString();
    }

    public double evaluate(double x){
        double result = 0.0;
        for(int i=1; i<coeffs.length;i++){
            result += coeffs[i] * Math.pow(x,i);
        }
        result += (coeffs.length>0 ? coeffs[0] : 0); //добавление свободного члена полинома
        return result;
    }

    public MyPolynomial add(MyPolynomial right){
        //количество коэффициентов нового полинома
        int newPolynomialLength = (coeffs.length >= right.coeffs.length ? coeffs.length : right.coeffs.length);
        //количество коэффициентов самого короткого полинома из слагаемых суммы полиномов
        int shortestLength = (coeffs.length >= right.coeffs.length ? right.coeffs.length : coeffs.length);
        double[] coeffsAdd = new double[newPolynomialLength];
        for(int i=0; i < newPolynomialLength; i++){
            if(i<shortestLength){
                coeffsAdd[i]=coeffs[i]+right.coeffs[i]; //приведение подобных слагаемых
            }
            else{
                coeffsAdd[i]=(coeffs.length > right.coeffs.length ? coeffs[i] : right.coeffs[i]);
            }
        }
        return new MyPolynomial(coeffsAdd);
    }

   public MyPolynomial multiply(MyPolynomial right){
        double [] coeffsMultiply = new double[coeffs.length + right.coeffs.length - 1];
        for(int i=0;i < coeffs.length;++i){
            for(int j=0;j < right.coeffs.length;++j){
                coeffsMultiply[i+j] += coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(coeffsMultiply);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof MyPolynomial)){
            return false;
        }
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + Arrays.hashCode(coeffs);
        return result;
    }
}
