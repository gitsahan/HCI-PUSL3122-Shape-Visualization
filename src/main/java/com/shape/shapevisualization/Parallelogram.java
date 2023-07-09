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

public class Parallelogram extends JPanel implements Object {
    private int baseLength = 200;
    private int height = 100;
    private Color fillColor = Color.GREEN;
    private Color shadowColor = new Color(0, 0, 0, 50);
    private int shadowOffsetX = 5;
    private int shadowOffsetY = 5;

    public Parallelogram() {
    }
    
    public Parallelogram(int baseLength, int height) {
        this.baseLength = baseLength;
        this.height = height;
    }
    
    @Override
    public void setSideLength(int baseLength) {
        this.baseLength = baseLength;
        repaint(); // Trigger a repaint when the base length is changed
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
        repaint(); // Trigger a repaint when the fill color is changed
    }

    @Override
    public void setShadowColor(Color color) {
        this.shadowColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), 50);
        repaint(); // Trigger a repaint when the shadow color is changed
    }

    @Override
    public void setShadowOffset(int offset) {
        this.shadowOffsetX = offset;
        this.shadowOffsetY = offset;
        repaint(); // Trigger a repaint when the shadow offset is changed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = (getWidth() - baseLength) / 2;
        int y = (getHeight() - height) / 2;

        g.setColor(shadowColor);
        int[] xShadowPoints = {x + shadowOffsetX, x + baseLength + shadowOffsetX, x + baseLength - height + shadowOffsetX, x - height + shadowOffsetX};
        int[] yShadowPoints = {y + shadowOffsetY, y + shadowOffsetY, y + height + shadowOffsetY, y + height + shadowOffsetY};
        g.fillPolygon(xShadowPoints, yShadowPoints, 4);

        g.setColor(fillColor);
        int[] xPoints = {x, x + baseLength, x + baseLength - height, x - height};
        int[] yPoints = {y, y, y + height, y + height};
        g.fillPolygon(xPoints, yPoints, 4);

        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 4);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 900);
    }

    @Override
    public void clear(Color color) {
        fillColor = color;
        shadowColor = new Color(0, 0, 0, 50);
        shadowOffsetX = 10;
        shadowOffsetY = 10;
        repaint();
    }

    @Override
    public void draw() {
        JFrame frame = new JFrame("Parallelogram Drawing Example");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.add(this);
        frame.pack();
        frame.setLocation(1000, 0);
        frame.setVisible(true);
    }
}

