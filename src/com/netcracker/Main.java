package com.netcracker;

import com.netcracker.ball.*;
import com.netcracker.book.*;
import com.netcracker.circle.Circle;
import com.netcracker.employee.Employee;
import com.netcracker.mycomplex.MyComplex;
import com.netcracker.mypoint.MyPoint;
import com.netcracker.mypolynomial.MyPolynomial;
import com.netcracker.mytriangle.MyTriangle;
import com.netcracker.rectangle.Rectangle;

import javax.swing.*;

public class Main {
    public static void main(String[] args){

        //Circle class
/*        System.out.println("========Circle class========");
        Circle circle = new Circle(2.0, "yellow");
        System.out.println(circle);
        System.out.println(circle.getArea());*/

        //Rectangle class
/*        System.out.println("========Rectangle class========");
        Rectangle rectangle = new Rectangle(2,2);
        System.out.println(rectangle);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());*/

        //Employee class
/*        System.out.println("========Employee class========");
        Employee employee = new Employee(1,"Михаил","Лепешкин",30000);
        System.out.println(employee);
        System.out.println(employee.getAnnualSalary());
        employee.raiseSalary(5);
        System.out.println(employee.getSalary());*/

        //Book class
/*        System.out.println("========Book class========");
        Author author1 = new Author("Владимир", "vl@mail.ru",'М');
        Author author2 = new Author("Анна", "ann@mail.ru",'Ж');
        Author [] authors = {author1,author2};
        Book book = new Book("Книга",authors,2000,2);
        System.out.println(book);
        System.out.println(book.getAuthorNames());*/

        //MyPoint class
/*        System.out.println("========MyPoint class========");
        MyPoint point1 = new MyPoint(2,5);
        MyPoint point2 = new MyPoint(15,8);
        System.out.println(point1);
        System.out.println(point1.distance(1,4));
        System.out.println(point1.distance(point2));
        System.out.println(point1.distance());*/

        //MyTriangle class
/*        System.out.println("========MyTriangle class========");
        MyPoint pointV1 = new MyPoint(1,1); //v1=(1,1),v2=(1,5),v3=(5,1) - Isosceles
        MyPoint pointV2 = new MyPoint(1,4); //v1=(1,1),v2=(1,4),v3=(5,1) - Scalene
        MyPoint pointV3 = new MyPoint(5,1); //Equilateral - нельзя проверить с целыми значениями координат на плоскости
        MyTriangle triangle = new MyTriangle(pointV1,pointV2,pointV3);
        System.out.println(triangle);
        System.out.println(triangle.getPerimeter());
        System.out.println(triangle.getType());*/

        //MyComplex class
        /*System.out.println("========MyTriangle class========");
        MyComplex complex0 = new MyComplex();
        MyComplex complex1 = new MyComplex(0,12);
        System.out.println(complex1);
        System.out.println(complex1.isReal());
        System.out.println(complex1.isImaginary());
        System.out.println(complex1.equals(3,2));
        System.out.println(complex1.equals(complex0));
        System.out.println(complex1.magnitude());
        System.out.println(complex1.argument());
        MyComplex complex2 = new MyComplex(2,4);
        System.out.println(complex1.add(complex2));
        System.out.println(complex1.addNew(complex2));
        System.out.println(complex1.subtract(complex2));
        System.out.println(complex1.subtractNew(complex2));
        System.out.println(complex1.multiply(complex2));
        System.out.println(complex1.divide(complex2));
        System.out.println(complex1.conjugate());*/

        //MyPolynomial class
        /*System.out.println("========MyPolynomial class========");
        double[] coeffs1 = {0,1,2};
        double[] coeffs2 = {0,1,2,3,4};
        MyPolynomial polynomial1 = new MyPolynomial(coeffs1);
        MyPolynomial polynomial2 = new MyPolynomial(coeffs2);
        System.out.println(polynomial1);
        System.out.println(polynomial2);
        System.out.println(polynomial1.getDegree());
        System.out.println(polynomial2.getDegree());
        System.out.println(polynomial1.evaluate(2));
        System.out.println(polynomial1.add(polynomial2));
        System.out.println(polynomial1.multiply(polynomial2));*/

        //Ball class
        /*System.out.println("========Ball class========");
        Container container = new Container(0,0,10,10);
        Ball ball = new Ball(5,5,3,2,30);
        System.out.println(container);
        System.out.println(ball);
        System.out.println(container.collides(ball));
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));*/

        //A Bouncing Ball on a Playground
        System.out.println("========Ball Bouncing on the Playground========");
        Container container = new Container(0,0,1000,800);
        Ball ball = new Ball(400,400,200,20,30);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("A Bouncing Ball on a Playground");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new Playground(container,ball));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
