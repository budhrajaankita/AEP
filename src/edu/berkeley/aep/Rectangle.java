package edu.berkeley.aep;

public class Rectangle {
    private int length;
    private int width;
    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;

    }

    public void setLength(int length){
        this.length = length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getArea(){
        return this.length * this.width;
}

}