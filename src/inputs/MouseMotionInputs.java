package inputs;

import main.Game;
import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionInputs implements MouseMotionListener {

    private GamePanel gamePanel;
    public MouseMotionInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;

    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //gamePanel.setBoxPos(e.getX(),e.getY());
    }
}
