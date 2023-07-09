/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.shape.shapevisualization;

/**
 *
 * @author dhananjayawmt
 */
import javax.swing.*;
import java.awt.*;

public class Line extends JPanel implements Object {
    private int startX = 100;
    private int startY = 100;
    private int endX = 300;
    private int endY = 300;
    private Color lineColor = Color.BLACK;

    public Line() {
    }

    public Line(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public void setStartPoint(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;
        repaint(); // Trigger a repaint when the start point is changed
    }

    public void setEndPoint(int endX, int endY) {
        this.endX = endX;
        this.endY = endY;
        repaint(); // Trigger a repaint when the end point is changed
    }

    public void setLineColor(Color color) {
        this.lineColor = color;
        repaint(); // Trigger a repaint when the line color is changed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(lineColor);
        g.drawLine(startX, startY, endX, endY);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    @Override
    public void clear(Color color) {
        lineColor = color;
        repaint();
    }

    @Override
    public void draw() {
        JFrame frame = new JFrame("Line Drawing Example");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.add(this);
        frame.pack();
        frame.setLocation(1000, 0);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Line Drawing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Line line = new Line();
        line.setLineColor(Color.RED);

        frame.add(line);
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
