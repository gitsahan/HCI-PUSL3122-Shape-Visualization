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


public class Cube extends JPanel {
    private int sideLength = 100;
    private Color fillColor = Color.GREEN;

    public Cube() {
    }

    public Cube(int sideLength) {
        this.sideLength = sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
        repaint(); // Trigger a repaint when the side length is changed
    }

    public void setFillColor(Color color) {
        this.fillColor = color;
        repaint(); // Trigger a repaint when the fill color is changed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = (getWidth() - sideLength) / 2;
        int y = (getHeight() - sideLength) / 2;

        // Draw the front face of the cube
        g.setColor(fillColor);
        g.fillRect(x, y, sideLength, sideLength);

        // Draw the top face of the cube
        g.setColor(fillColor.brighter());
        g.fillRect(x, y - sideLength / 2, sideLength, sideLength / 2);

        // Draw the side face of the cube
        g.setColor(fillColor.darker());
        int[] sideX = {x + sideLength, x + sideLength, x + sideLength / 2, x + sideLength / 2};
        int[] sideY = {y, y - sideLength / 2, y - sideLength, y};
        g.fillPolygon(sideX, sideY, 4);

        // Draw the outline of the cube
        g.setColor(Color.BLACK);
        g.drawRect(x, y - sideLength / 2, sideLength, sideLength);
        g.drawLine(x, y, x + sideLength, y - sideLength / 2);
        g.drawLine(x, y, x + sideLength / 2, y - sideLength);
        g.drawLine(x + sideLength, y - sideLength / 2, x + sideLength / 2, y - sideLength);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cube Drawing Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Cube cube = new Cube();
        cube.setFillColor(Color.CYAN);

        frame.add(cube);
        frame.pack();
        frame.setVisible(true);
    }
}
