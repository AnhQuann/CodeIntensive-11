package base.game;

import base.KeyEventPress;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {

    public GameWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(Setting.SCREEN_WIDTH, Setting.SCREEN_HEIGHT);
        this.setTitle("Game Toohoo");
        this.addKeyEvent();
    }

    private void addKeyEvent() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == Setting.UP_BUTTON) {
                    KeyEventPress.isUpPress = true;
                } else if (e.getKeyCode() == Setting.LEFT_BUTTON) {
                    KeyEventPress.isLeftPress = true;
                } else if (e.getKeyCode() == Setting.DOWN_BUTTON) {
                    KeyEventPress.isDownPress = true;
                } else if (e.getKeyCode() == Setting.RIGHT_BUTTON) {
                    KeyEventPress.isRightPress = true;
                } else if (e.getKeyCode() == Setting.FIRE_BUTTON) {
                    KeyEventPress.isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == Setting.UP_BUTTON) {
                    KeyEventPress.isUpPress = false;
                } else if (e.getKeyCode() == Setting.LEFT_BUTTON) {
                    KeyEventPress.isLeftPress = false;
                } else if (e.getKeyCode() == Setting.DOWN_BUTTON) {
                    KeyEventPress.isDownPress = false;
                } else if (e.getKeyCode() == Setting.RIGHT_BUTTON) {
                    KeyEventPress.isRightPress = false;
                } else if (e.getKeyCode() == Setting.FIRE_BUTTON) {
                    KeyEventPress.isFirePress = false;
                }
            }
        });
    }
}
