/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tide.nd.mazelibrary;

/**
 *
 * @author nicolas
 */
public class Point {
    private final int x;
    private final int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
    public Point move(Direction direction) {
        switch(direction) {
            case U: return new Point(x-1, y);
            case R: return new Point(x, y+1);
            case D: return new Point(x+1, y);
            case L: return new Point(x, y-1);
        }
        return null;
    }
    
    @Override
    public boolean equals(Object other) {
        if(other instanceof Point) {
            Point p = (Point) other;
            return x == p.x && y == p.y;
        }
        else {
            return false;
        }
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.x;
        hash = 37 * hash + this.y;
        return hash;
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
