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

public class Pentagon extends JPanel implements Object{

    private int sideLength = 100;
    private Color fillColor = Color.GREEN;
    private Color shadowColor = new Color(0, 0, 0, 50);
    private int shadowOffsetX = 5;
    private int shadowOffsetY = 5;

    public Pentagon() {
    }

    public Pentagon(int sideLength) {
        this.sideLength = sideLength;
    }
    
    @Override
    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
        repaint(); // Trigger a repaint when the shadow offset is changed
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

    /**
     *
     * @param offset
     */
    @Override
    public void setShadowOffset(int offset) {
        this.shadowOffsetX = offset;
        this.shadowOffsetY = offset;
        repaint(); // Trigger a repaint when the shadow offset is changed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int[] xPoints = new int[5];
        int[] yPoints = new int[5];

        for (int i = 0; i < 5; i++) {
            double angle = 2 * Math.PI * i / 5 + Math.PI / 2;
            xPoints[i] = (int) (centerX + sideLength * Math.cos(angle));
            yPoints[i] = (int) (centerY - sideLength * Math.sin(angle));
        }

        g.setColor(shadowColor);
        int[] xShadowPoints = new int[5];
        int[] yShadowPoints = new int[5];
        for (int i = 0; i < 5; i++) {
            xShadowPoints[i] = xPoints[i] + shadowOffsetX;
            yShadowPoints[i] = yPoints[i] + shadowOffsetY;
        }
        g.fillPolygon(xShadowPoints, yShadowPoints, 5);

        g.setColor(fillColor);
        g.fillPolygon(xPoints, yPoints, 5);

        g.setColor(Color.BLACK);
        g.drawPolygon(xPoints, yPoints, 5);
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
        JFrame frame = new JFrame("Pentagon Drawing Example");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.add(this);
        frame.pack();
        frame.setLocation(1000, 0);
        frame.setVisible(true);
    }

}
