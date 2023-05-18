package org.academiadecodigo.tetris.Shapes;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Skew extends TetrisShapes {
    public Skew() {
        super();
    }

    @Override
    public void makeShape() {
        shapes[0] = new Rectangle(210, 10, 20, 20);
        shapes[1] = new Rectangle(190, 10, 20, 20);
        shapes[2] = new Rectangle(190, 30, 20, 20);
        shapes[3] = new Rectangle(170, 30, 20, 20);
        for (Rectangle shape : shapes) {
            shape.setColor(Color.GREEN);
            shape.fill();
        }
    }

    @Override
    public void changePosition() {
        switch (position) {
            case POSITION1:
                shapes[0].translate(0, 40);
                shapes[1].translate(20, 20);
                shapes[2].translate(0, 0);
                shapes[3].translate(20, -20);
                position = ShapePosition.POSITION2;
                break;
            case POSITION2:
                shapes[0].translate(-40, 0);
                shapes[1].translate(-20, 20);
                shapes[2].translate(0, 0);
                shapes[3].translate(20, 20);
                position = ShapePosition.POSITION3;
                break;
           case POSITION3:
                shapes[0].translate(0, -40);
                shapes[1].translate(-20, -20);
                shapes[2].translate(0, 0);
                shapes[3].translate(-20, 20);
                position = ShapePosition.POSITION4;
                break;
            case POSITION4:
                shapes[0].translate(40, 0);
                shapes[1].translate(20, -20);
                shapes[2].translate(0, 0);
                shapes[3].translate(-20, -20);
                position = ShapePosition.POSITION1;
                break;



    }
    }
}
