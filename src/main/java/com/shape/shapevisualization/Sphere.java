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
import java.awt.geom.Ellipse2D;

public class Sphere extends JPanel implements Object {
    private int radius = 100;
    private Color fillColor = Color.GREEN;
    private Color shadowColor = new Color(0, 0, 0, 50);
    private int shadowOffsetX = 5;
    private int shadowOffsetY = 5;

    public Sphere() {
    }

    public Sphere(int radius) {
        this.radius = radius;
    }

    @Override
    public void setSideLength(int radius) {
        this.radius = radius;
        repaint(); // Trigger a repaint when the radius is changed
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

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int diameter = 2 * radius;
        int x = centerX - radius;
        int y = centerY - radius;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(shadowColor);
        g2d.fillOval(x + shadowOffsetX, y + shadowOffsetY, diameter, diameter);

        g2d.setColor(fillColor);
        g2d.fillOval(x, y, diameter, diameter);

        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, diameter, diameter);
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
        JFrame frame = new JFrame("Sphere Drawing Example");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.add(this);
        frame.pack();
        frame.setLocation(1000, 0);
        frame.setVisible(true);
    }
}
