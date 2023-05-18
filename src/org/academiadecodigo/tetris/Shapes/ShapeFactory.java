package org.academiadecodigo.tetris.Shapes;

public class ShapeFactory {

    public static TetrisShapes getNewShape() {

        int random = (int) (Math.random() * ShapeType.values().length);

        ShapeType shapeType = ShapeType.values()[random];

        TetrisShapes shape;

        switch (shapeType) {
            case SQUARE:
                shape = new Square();
                shape.makeShape();
                break;
            case L:
                shape = new L();
                shape.makeShape();
                break;
            case T:
                shape = new T();
                shape.makeShape();
                break;
            case SKEW:
                shape = new Skew();
                shape.makeShape();
                break;
            default:
                shape = new Straight();
                shape.makeShape();
                break;
        }
        return shape;
    }
}
