package org.academiadecodigo.tetris.Game;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tetris.Shapes.TetrisShapes;
import org.academiadecodigo.tetris.graphics.GraphicGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import java.util.LinkedList;

import static org.academiadecodigo.tetris.Shapes.ShapeFactory.getNewShape;


public class Game implements KeyboardHandler {

    LinkedList<TetrisShapes> shapesList = new LinkedList<>();
    private GraphicGrid grid;

    private Text text1;
    private Text text2;
    private Text text3;
    private Text text4;
    private Text text5;
    private Text text6;

    private Rectangle menu;
    private Rectangle gameOver;


    private int counter = 0;

    private final int delay = 101;
    private int scoreBoard = 0;
    private Text score;


    TetrisShapes fallingShape;

    public Game() {
        //grid = new GraphicGrid();
        initKeyboard();


    }

    public void start() throws InterruptedException {
        initMenu();
        initgrid();
        score = new Text(20, 20, "Score: " + scoreBoard);
        score.draw();
        score.setColor(Color.RED);
        fallingShape = getNewShape();
        while (!fallingShape.isAtBottom()) {
            score.delete();
            score = new Text(20,20, "Score: " + scoreBoard);
            score.draw();
            score.setColor(Color.RED);


            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            fallingShape.moveDown();

            for (int i = 0; i < 4; i++) {
                if (grid.getFilledCells()[((fallingShape.getShapes()[i].getY() - 10) / 20) + 1][((fallingShape.getShapes()[i].getX() - 10) / 20)]) {
                    fallingShape.setBottom(true);
                }
                if (grid.getFilledCells()[1][((fallingShape.getShapes()[i].getX() - 10) / 20)]){
                   return;
                }

            }
            if (fallingShape.isAtBottom()) {

                shapesList.add(fallingShape);
                grid.add(fallingShape);
                for (int i = 0; i < grid.getFilledCells().length; i++) {
                    int counter = 0;
                    for (int j = 0; j < grid.getFilledCells()[i].length; j++) {
                        if (grid.getFilledCells()[i][j]) {
                            counter++;
                        }
                        if (counter == 20) {
                            scoreBoard += 100;
                            for (TetrisShapes shape : shapesList) {
                                if ((shape.getShapes()[0].getY() - 10) / 20 <= i) {
                                    grid.setFilledCells((shape.getShapes()[0].getY() - 10) / 20, (shape.getShapes()[0].getX() - 10) / 20, false);
                                    shape.getShapes()[0].delete();
                                }

                                if ((shape.getShapes()[1].getY() - 10) / 20 <= i) {
                                    grid.setFilledCells((shape.getShapes()[1].getY() - 10) / 20, (shape.getShapes()[1].getX() - 10) / 20, false);
                                    shape.getShapes()[1].delete();

                                }
                                if ((shape.getShapes()[2].getY() - 10) / 20 <= i) {
                                    grid.setFilledCells((shape.getShapes()[2].getY() - 10) / 20, (shape.getShapes()[2].getX() - 10) / 20, false);
                                    shape.getShapes()[2].delete();
                                }
                                if ((shape.getShapes()[3].getY() - 10) / 20 <= i) {
                                    grid.setFilledCells((shape.getShapes()[3].getY() - 10) / 20, (shape.getShapes()[3].getX() - 10) / 20, false);
                                    shape.getShapes()[3].delete();
                                }
                            }


                        }

                    }
                }

                fallingShape = getNewShape();
                this.counter = 0;
            }

        }

    }



    public void initKeyboard() {
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent leftArrowPress = new KeyboardEvent();
        leftArrowPress.setKey(KeyboardEvent.KEY_LEFT);
        leftArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftArrowPress);

        KeyboardEvent rightArrowPress = new KeyboardEvent();
        rightArrowPress.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightArrowPress);

        KeyboardEvent upArrowPress = new KeyboardEvent();
        upArrowPress.setKey(KeyboardEvent.KEY_UP);
        upArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upArrowPress);

        KeyboardEvent downArrowPress = new KeyboardEvent();
        downArrowPress.setKey(KeyboardEvent.KEY_DOWN);
        downArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downArrowPress);

        KeyboardEvent rKeyPress = new KeyboardEvent();
        rKeyPress.setKey(KeyboardEvent.KEY_R);
        rKeyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rKeyPress);

        KeyboardEvent qKeyPress = new KeyboardEvent();
        qKeyPress.setKey(KeyboardEvent.KEY_Q);
        qKeyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(qKeyPress);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                for (int i = 0; i < 4; i++) {
                    if (grid.getFilledCells()[((fallingShape.getShapes()[i].getY() - 10) / 20)][((fallingShape.getShapes()[i].getX() - 10) / 20 - 1)]) {
                        fallingShape.getShapes()[0].translate(0, 0);
                        fallingShape.getShapes()[1].translate(0, 0);
                        fallingShape.getShapes()[2].translate(0, 0);
                        fallingShape.getShapes()[3].translate(0, 0);
                        break;
                    }
                    if (i == 3) {
                        fallingShape.moveLeft();
                        break;
                    }
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                for (int i = 0; i < 4; i++) {
                    if (grid.getFilledCells()[((fallingShape.getShapes()[i].getY() - 10) / 20)][((fallingShape.getShapes()[i].getX() - 10) / 20 + 1)]) {
                        fallingShape.getShapes()[0].translate(0, 0);
                        fallingShape.getShapes()[1].translate(0, 0);
                        fallingShape.getShapes()[2].translate(0, 0);
                        fallingShape.getShapes()[3].translate(0, 0);
                        break;
                    }
                    if (i == 3) {
                        fallingShape.moveRight();
                        break;
                    }
                }
                break;
            case KeyboardEvent.KEY_UP:
                if (counter == 1) {
                    break;
                }
                changeShape();
                counter++;
                break;
            case KeyboardEvent.KEY_R:
                fallingShape.changePosition();
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;


        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void changeShape() {
        fallingShape.getShapes()[0].delete();
        fallingShape.getShapes()[1].delete();
        fallingShape.getShapes()[2].delete();
        fallingShape.getShapes()[3].delete();
        fallingShape = getNewShape();
    }

    public void initMenu() throws InterruptedException {

        menu = new Rectangle(10, 10, 400, 800);
        menu.fill();
        menu.setColor(Color.BLACK);
        text1 = new Text(160, 180, "Welcome to the Wizards Tetris!");
        text1.grow(40, 20);
        text1.draw();
        text1.setColor(Color.RED);
        text2 = new Text(70, 340, "Game will start in 5 seconds!");
        text2.grow(20, 10);
        text2.draw();
        text2.setColor(Color.WHITE);
        text3 = new Text(70, 400, "Press Q to quit");
        text3.grow(20, 10);
        text3.draw();
        text3.setColor(Color.WHITE);
        text5 = new Text(70, 460, "Press R to Rotate");
        text5.grow(20, 10);
        text5.draw();
        text5.setColor(Color.WHITE);
        Thread.sleep(5000);
        menu.delete();

    }

    public void gameOver() {
        gameOver = new Rectangle(10,10,400,800);
        gameOver.fill();
        gameOver.setColor(Color.BLACK);
        text4 = new Text(170,180, "Game Over");
        text4.grow(40, 20);
        text4.draw();
        text4.setColor(Color.RED);
        text6 = new Text(160, 240, "Press Q to Quit");
        text6.grow(20, 10);
        text6.draw();
        text6.setColor(Color.WHITE);


    }

    public void initgrid() {
        grid = new GraphicGrid();

    }
}

