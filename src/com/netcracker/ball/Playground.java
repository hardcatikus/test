package com.netcracker.ball;

import java.awt.*;
import javax.swing.*;

public class Playground extends JPanel {

    private Container container;
    private Ball ball;

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Playground(Container container,Ball ball){
        this.container=container;
        this.ball=ball;
        this.setPreferredSize(new Dimension(container.getWidth(),container.getHeight()));
        Thread gameThread = new Thread() {
            public void run() {
                while(true){
                    ball.move();
                    //проверка на выход мяча за рамки и отскок мяча от стен
                    if(container.collides(ball)){
                        if (ball.getX() - ball.getRadius() < 0) {
                            ball.reflectHorizontal();
                            ball.setX(ball.getRadius());
                        }
                        else if (ball.getX() + ball.getRadius() > container.getWidth()) {
                            ball.reflectHorizontal();
                            ball.setX(container.getWidth()-ball.getRadius());
                        }
                        if (ball.getY() - ball.getRadius() < 0) {
                            ball.reflectVertical();
                            ball.setY(ball.getRadius());
                        }
                        else if (ball.getY() + ball.getRadius() > container.getHeight()) {
                            ball.reflectVertical();
                            ball.setY(container.getHeight()-ball.getRadius());
                        }
                    }
                    repaint();
                    try {
                        Thread.sleep(1000 / 30);
                    } catch (InterruptedException ex) { }
                }
            }
        };
        gameThread.start();
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        //прямоугольное поле
        graphics.setColor(Color.black);
        graphics.fillRect(container.getX(),container.getY(),container.getWidth(),container.getHeight());
        //границы поля
        graphics.setColor(Color.red);
        graphics.drawRect(container.getX(),container.getY(),container.getWidth(),container.getHeight());
        //мяч
        graphics.setColor(Color.green);
        graphics.fillOval((int) ball.getX()-ball.getRadius(),
                (int)ball.getY()-ball.getRadius(),(int)(2*ball.getRadius()),
                (int)(2*ball.getRadius()));
    }

}