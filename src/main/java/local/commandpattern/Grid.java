package local.commandpattern;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grid extends GridPane {
    private final int rows = 8;
    private final int cols = 8;
    private final int squareSize = 80;
    private Rectangle currentSquare;
    private Rectangle[][] gridMatrix = new Rectangle[rows][cols];
    private int[][] toggled = new int[rows][cols];

    public Grid() {
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Rectangle rect = new Rectangle(squareSize, squareSize);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.BLACK);
                gridMatrix[i][j] = rect;
                toggled[i][j] = 0;
                add(rect, j, i);
            }
        }
        currentSquare = gridMatrix[0][0];
        currentSquare.setFill(Color.LIGHTGRAY);
    }

    private int getRowIndex(Rectangle currentSquare) {
        return GridPane.getRowIndex(currentSquare);
    }

    private int getColumnIndex(Rectangle currentSquare) {
        return GridPane.getColumnIndex(currentSquare);
    }

    private void setColor(Rectangle square, Color color) {
        square.setFill(color);
    }

    public void togglePixel() {
        int row = getRowIndex(currentSquare);
        int col = getColumnIndex(currentSquare);
        toggled[row][col] = 1 - toggled[row][col];
        setColor(currentSquare, toggled[row][col] == 1 ? Color.BLACK : Color.WHITE);
    }

    private void moveCursor(int rowOffset, int colOffset) {
        if (currentSquare != null) {
            int currentRow = getRowIndex(currentSquare);
            int currentCol = getColumnIndex(currentSquare);
            int newRow = currentRow + rowOffset;
            int newCol = currentCol + colOffset;
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                setColor(currentSquare, toggled[currentRow][currentCol] == 1 ? Color.BLACK : Color.WHITE);
                currentSquare = gridMatrix[newRow][newCol];
                setColor(currentSquare, Color.LIGHTGRAY);
            }
        }
    }

    public void createCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("int[][] pixelArt = {\n");
        for (int i = 0; i < rows; i++) {
            sb.append("    {");
            for (int j = 0; j < cols; j++) {
                sb.append(toggled[i][j]);
                if (j < cols - 1) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            if (i < rows - 1) {
                sb.append(",\n");
            }
        }
        sb.append("\n};");
        System.out.println(sb.toString());
    }

    public void moveUp() {
        moveCursor(-1, 0);
    }

    public void moveDown() {
        moveCursor(1, 0);
    }

    public void moveLeft() {
        moveCursor(0, -1);
    }

    public void moveRight() {
        moveCursor(0, 1);
    }
}