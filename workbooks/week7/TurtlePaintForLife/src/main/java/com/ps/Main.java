package com.ps;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main implements Runnable {
    private Turtle turtle;

    public Main(Turtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public void run() {
        int accum = 0;
        for (int i = 0; i < 26; i++) {

            turtle.forward(accum);
            turtle.turnRight(90);
            turtle.setColor(Color.black);
            accum += i;

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Turtle Canvas");
            CanvasPanel canvas = new CanvasPanel();
            frame.add(canvas);
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            World world = new World(800, 600, Color.WHITE);
            canvas.setWorld(world);

            multiSpiral(canvas, world);
        });
    }

    public static void multiSpiral(CanvasPanel canvas, World world) {
        int width = 150;
        int[][] coordinates = {{-width, -width}, {width, -width}, {width, width}, {-width, width}};

        for (int[] coordinate : coordinates) {
            Turtle turtle = new Turtle(world, coordinate[0], coordinate[1]);

            turtle.setShellSize(0);
            turtle.setPenWidth(1);
            turtle.setDelay(.01);

            Thread multiThread = new Thread(new Main(turtle));
            multiThread.start();
        }
    }

//    public static void singleSpiral(Turtle turtle){
//        Color[] colors = {Color.red,Color.BLUE, Color.GREEN, Color.PINK};
//
//        int accum = 0;
//        for(int i=1;i<25;i++){
//            int colorIndex = (i-1)%4;
//            turtle.setColor(colors[colorIndex]);
//            turtle.forward(accum);
//            turtle.turnRight(90);
//            accum += i;
//        }
//    }


    static class CanvasPanel extends JPanel {
        private BufferedImage buffer;
        private World world;

        public CanvasPanel() {
            buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        }

        public void setWorld(World world) {
            this.world = world;
        }

        public synchronized void draw(Turtle turtle) {
            Graphics2D g2d = buffer.createGraphics();
            world.paint(g2d);
            g2d.dispose();
            repaint();
        }

        @Override
        protected synchronized void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(buffer, 0, 0, null);
        }
    }
}
