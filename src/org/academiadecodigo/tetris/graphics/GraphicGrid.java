package org.academiadecodigo.tetris.graphics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tetris.Shapes.TetrisShapes;

public class GraphicGrid {
    private int x = 10;
    private int y = 10;
    private static final int CELL_SIZE = 20;
    private static final int ROWS = 40;
    private static final int COLS = 20;
    private final Rectangle[][] cells;

    public boolean[][] getFilledCells() {
        return filledCells;
    }

    private boolean[][] filledCells = new boolean[41][20];

    /*public GraphicGrid (int row, int col){
        cells = new Rectangle[row][col];
    }*/
    public GraphicGrid() {
        cells = new Rectangle[ROWS][COLS];

        // create grid of rectangles
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                cells[row][col] = new Rectangle(x, y, CELL_SIZE, CELL_SIZE);
                cells[row][col].setColor(Color.BLACK);
                cells[row][col].fill();
                x += CELL_SIZE;
            }
            x = 10;
            y += CELL_SIZE;
        }
    }

    public void add(TetrisShapes tetrisShapes){
        filledCells[((tetrisShapes.getShapes()[0].getY()-10)/20)][(tetrisShapes.getShapes()[0].getX()-10)/20] = true;
        filledCells[((tetrisShapes.getShapes()[1].getY()-10)/20)][(tetrisShapes.getShapes()[1].getX()-10)/20] = true;
        filledCells[((tetrisShapes.getShapes()[2].getY()-10)/20)][(tetrisShapes.getShapes()[2].getX()-10)/20] = true;
        filledCells[((tetrisShapes.getShapes()[3].getY()-10)/20)][(tetrisShapes.getShapes()[3].getX()-10)/20] = true;
    }
    public void setFilledCells(int x,int y, boolean bol) {
        filledCells[x][y] = bol;
    }
    }

