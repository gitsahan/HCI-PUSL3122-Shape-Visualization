/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shape.shapevisualization;

/**
 *
 * @author dhananjayawmt
 */
import javax.swing.*;
import java.awt.*;

public class HalfCircle extends JPanel implements Object {
    private int x = 100;
    private int y = 100;
    private int width = 200;
    private int height = 200;
    private int startAngle = 0;
    private int arcAngle = 180;
    private Color arcColor = Color.RED;

    public HalfCircle() {
    }

    public HalfCircle(int x, int y, int width, int height, int startAngle, int arcAngle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.arcAngle = arcAngle;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        repaint(); // Trigger a repaint when the position is changed
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
        repaint(); // Trigger a repaint when the dimensions are changed
    }

    public void setAngles(int startAngle, int arcAngle) {
        this.startAngle = startAngle;
        this.arcAngle = arcAngle;
        repaint(); // Trigger a repaint when the angles are changed
    }

    public void setArcColor(Color color) {
        this.arcColor = color;
        repaint(); // Trigger a repaint when the arc color is changed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(arcColor);
        g.fillArc(x, y, width, height, startAngle, arcAngle);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    @Override
    public void clear(Color color) {
        arcColor = color;
        repaint();
    }

    @Override
    public void draw() {
        JFrame frame = new JFrame("Arc Drawing Example");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.add(this);
        frame.pack();
        frame.setLocation(1000, 0);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Arc Drawing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Arc arc = new Arc();
        arc.setArcColor(Color.ORANGE);

        frame.add(arc);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void setFillColor(Color RED) {
       
    }

    @Override
    public void setShadowOffset(int i) {

    }

    @Override
    public void setShadowColor(Color GRAY) {
        
    }

    @Override
    public void setSideLength(int i) {
        
    }
}