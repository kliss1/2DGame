package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import inputs.MouseMotionInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private MouseMotionInputs mouseMotionInputs;
    private float xChange = 100, yChange = 100;
    private int frames = 0;
    private long lastCheck = 0;
    private float xDir = 0.1f, yDir = 0.1f;
    private Color color = new Color(150,20,90);
    private Random random;

    public GamePanel(){
        random = new Random();
        mouseInputs = new MouseInputs(this);
        mouseMotionInputs = new MouseMotionInputs(this);
        keyboardInputs = new KeyboardInputs(this);

        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseMotionInputs);

    }

    public void changeXChange(int value){
        this.xChange += value;
    }

    public void changeYChange(int value){
        this.yChange += value;
    }

    public void setBoxPos(int x, int y){
        this.xChange = x;
        this.yChange = y;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateRectangle();

        g.setColor(color);
        g.fillRect((int)xChange, (int)yChange, 50,50);
        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
        repaint();
    }

    private void updateRectangle(){
        xChange += xDir;
        if(xChange > 400 || xChange < 0){
            xDir *= -1;
            color = getRandColor();
        }
        yChange += yDir;
        if(yChange > 400 || yChange < 0){
            yDir *= -1;
            color = getRandColor();
        }
    }

    public Color getRandColor(){
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r,g,b);
    }
}
