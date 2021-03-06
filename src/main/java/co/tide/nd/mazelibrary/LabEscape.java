package co.tide.nd.mazelibrary;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicolas
 */
public class LabEscape {

    private static final char WALL = 'O';
    private static final char FREE = ' ';
    private static final char PATH = '•';
    
    /**
     * @param labyrinth A labyrinth drawn on a matrix of characters. It's at least 4x4, can be a rectangle or a square.
     *                  Walkable areas are represented with a space character, walls are represented with a big O character.
     *                  The escape point is always on the border (see README)
     * @param startX    Starting row number for the escape. 0 based.
     * @param startY    Starting column number for the escape. 0 based.
     * @return          A char matrix with the same labyrinth and a path drawn from the starting point to the escape
     * @throws          NoEscapeException when no path exists to the outside, from the selected starting point
     */
    public static char[][] drawPathForEscape(char[][] labyrinth, int startX, int startY) throws NoEscapeException {
        // buld the initial path.
        ArrayList<Point> path = new ArrayList<>();
        path.add(new Point(startX, startY));
        
        List<Point> solution = solve(labyrinth, path);
        if(solution == null) {
            throw new NoEscapeException();
        }
        else {
            char[][] output = clone(labyrinth);
            
            // Draw the solution in the char[][]
            solution.stream().forEach((p) -> {
                output[p.getX()][p.getY()] = PATH;
            });
            
            return output;
        }
    }
    
    /**
     * 
     * @param labyrinth
     * @param path  The initial path already done in the labyrinth
     * @return      The complete path to an escape or null if there is no path
     *              to an escape.
     */
    private static List<Point> solve(char[][] labyrinth, ArrayList<Point> path) {        
        Point lastPoint = path.get(path.size()-1);
                
        if(escaped(labyrinth, lastPoint)) {
            return path;
        }
        else {
            // Try to go up
            Point up = lastPoint.move(Direction.U);
            char ch = charAt(labyrinth, up);
            if(ch == FREE && !path.contains(up)) {
                ArrayList<Point> newPath = (ArrayList<Point>) path.clone();
                newPath.add(up);
                return solve(labyrinth, newPath);
            }
            
            // Try to go R
            Point right = lastPoint.move(Direction.R);
            char ch2 = charAt(labyrinth, right);
            if(ch2 == FREE && !path.contains(right)) {
                ArrayList<Point> newPath = (ArrayList<Point>) path.clone();
                newPath.add(right);
                return solve(labyrinth, newPath);
            }
            
            // Try to go D
            Point down = lastPoint.move(Direction.D);
            char ch3 = charAt(labyrinth, down);
            if(ch3 == FREE && !path.contains(down)) {
                ArrayList<Point> newPath = (ArrayList<Point>) path.clone();
                newPath.add(down);
                return solve(labyrinth, newPath);
            }
            
            // Try to go L
            Point left = lastPoint.move(Direction.L);
            char ch4 = charAt(labyrinth, left);
            if(ch4 == FREE && !path.contains(left)) {
                ArrayList<Point> newPath = (ArrayList<Point>) path.clone();
                newPath.add(left);
                return solve(labyrinth, newPath);
            }
            
        }
        
        return null;
    }
        
    /**
     * 
     * @param labyrinth
     * @param point
     * @return  The character (WALL or FREE) at this point or 0 if the point is
     *          outside the labyrinth.
     */
    private static char charAt(char[][] labyrinth, Point point) {
        if( point.getX() >= 0 &&
            point.getY() >= 0 &&
            point.getX() < labyrinth.length &&
            point.getY() < labyrinth[0].length)
            
            return labyrinth[point.getX()][point.getY()];
        else {
            return 0;
        }
    }
    
    /**
     * 
     * @param labyrinth
     * @param point
     * @return  True if this point is an escape point inside the labirynth.
     *          FGalse otherwise.
     */
    private static boolean escaped(char[][] labyrinth, Point point) {
        return
            (point.getX() == 0 ||
            point.getY() == 0 ||
            point.getX() == labyrinth.length-1 ||
            point.getY() == labyrinth[0].length-1 ) && charAt(labyrinth, point) == FREE;
    }
    
    /**
     * 
     * @param labyrinth
     * @return A clone of a char[][]
     */
    private static char[][] clone(char[][] labyrinth) {
        char[][] result = new char[labyrinth.length][];
        
        for(int i = 0; i < labyrinth.length; i++) {
            char[] line = labyrinth[i];
            result[i] = new char[line.length];
            System.arraycopy(labyrinth[i], 0, result[i], 0, line.length);
        }
        
        return result;
    } 
   
}
