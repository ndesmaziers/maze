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
public class MazeUtils {

    public static char[][] toCharArray(String[] labyrinth) {
        char[][] array = new char[labyrinth.length][];
        for (int i = 0; i < labyrinth.length; i++) {
            array[i] = new char[labyrinth[i].length()];

            for (int j = 0; j < labyrinth[i].length(); j++) {
                array[i][j] = labyrinth[i].charAt(j);
            }
        }
        return array;
    }

    public static String[] toStringArray(char[][] labyrinth) {
        String[] array = new String[labyrinth.length];
        for (int i = 0; i < labyrinth.length; i++) {
            StringBuilder buff = new StringBuilder();

            for (int j = 0; j < labyrinth[i].length; j++) {
                buff.append(labyrinth[i][j]);
            }

            array[i] = buff.toString();
        }
        return array;
    }
}
