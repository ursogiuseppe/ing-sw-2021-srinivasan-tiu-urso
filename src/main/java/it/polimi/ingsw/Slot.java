package it.polimi.ingsw;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Slot {

    private Rectangle rectangle;

    private double x;
    private double y;

    private double width;
    private double height;

    private boolean empty;

    public Slot(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.empty = true;
        rectangle = new Rectangle(this.x, this.y, this.width, this.height);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLUE);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean isPointInSlot(double x, double y) {
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height;
    }

    public void filLSlot() {
        empty = false;
    }

    public void freeSlot() {
        empty = true;
    }

    public boolean isEmpty() {
        return empty;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
