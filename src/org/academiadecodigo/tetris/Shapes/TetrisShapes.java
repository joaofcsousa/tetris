package org.academiadecodigo.tetris.Shapes;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class TetrisShapes {

    protected Rectangle[] shapes;
    protected Color color = Color.PINK;
    protected boolean hitBottom;
    protected ShapePosition position;

    public TetrisShapes() {
        shapes = new Rectangle[4];
        position = ShapePosition.POSITION1;
    }

   public void makeShape() {
       shapes[0] = new Rectangle(190, 10, 20, 20);
       shapes[1] = new Rectangle(190, 30, 20, 20);
       shapes[2] = new Rectangle(210, 10, 20, 20);
       shapes[3] = new Rectangle(210, 30, 20, 20);
       for (Rectangle shape : shapes) {
           shape.setColor(Color.YELLOW);
           shape.fill();
       }
   }

    // move shape down by one block
    public void moveDown() {
        if (shapes[0].getY() >= 790 || shapes[1].getY() >= 790 || shapes[2].getY() >= 790 || shapes[3].getY() >= 790) {
            setBottom(true);
        } else {
            shapes[0].translate(0, 20);
            shapes[1].translate(0, 20);
            shapes[2].translate(0, 20);
            shapes[3].translate(0, 20);
        }
    }

    // move shape left by one block
    public void moveLeft() {
            if (shapes[0].getX() <= 10 ||shapes[1].getX() <= 10 || shapes[2].getX() <= 10 || shapes[3].getX() <= 10  ) {
                shapes[0].translate(0, 0);
                shapes[1].translate(0, 0);
                shapes[2].translate(0, 0);
                shapes[3].translate(0, 0);
            } else {
                shapes[0].translate(-20, 0);
                shapes[1].translate(-20, 0);
                shapes[2].translate(-20, 0);
                shapes[3].translate(-20, 0);
            }
        }


    // move shape right by one block
    public void moveRight() {
        if (shapes[0].getX() >= 390 ||shapes[1].getX() >= 390 || shapes[2].getX() >= 390 || shapes[3].getX() >= 390  ) {
            shapes[0].translate(0, 0);
            shapes[1].translate(0, 0);
            shapes[2].translate(0, 0);
            shapes[3].translate(0, 0);
        } else {
            shapes[0].translate(20, 0);
            shapes[1].translate(20, 0);
            shapes[2].translate(20, 0);
            shapes[3].translate(20, 0);
        }
    }

    // rotate shape 90 degrees clockwise

    // get the rectangles that make up the shape
    public Rectangle[] getShapes() {
        return shapes;
    }

    public Color getColor() {
        return color;
    }

    public boolean isAtBottom() {
        return hitBottom;
    }

    public void setBottom(boolean bol) {
        hitBottom = bol;
    }
    public void changePosition(){
        switch (position) {
            case POSITION1:
                shapes[0].translate(0, 0);
                shapes[1].translate(0, 0);
                shapes[2].translate(0, 0);
                shapes[3].translate(0, 0);
                position = ShapePosition.POSITION2;
                break;
            case POSITION2:
                shapes[0].translate(0,0);
                shapes[1].translate(0,0);
                shapes[2].translate(0,0);
                shapes[3].translate(0,0);
                position = ShapePosition.POSITION3;
                break;
            case POSITION3:
                shapes[0].translate(0,0);
                shapes[1].translate(0,0);
                shapes[2].translate(0,0);
                shapes[3].translate(0,0);
                position = ShapePosition.POSITION4;
                break;
            case POSITION4:
                shapes[0].translate(0,0);
                shapes[1].translate(0,0);
                shapes[2].translate(0,0);
                shapes[3].translate(0,0);
                position = ShapePosition.POSITION1;
                break;


        }
    }

}
