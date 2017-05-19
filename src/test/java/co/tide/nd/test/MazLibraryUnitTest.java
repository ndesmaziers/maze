/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tide.nd.test;

import co.tide.nd.mazelibrary.LabEscape;
import co.tide.nd.mazelibrary.MazeUtils;
import co.tide.nd.mazelibrary.NoEscapeException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author nicolas
 */
public class MazLibraryUnitTest {
    
    public MazLibraryUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1() {
        String[] labyrinth = {
            "OOOOOOOOOO",
            "O    O   O",
            "O OO O O O",
            "O  O O O O",
            "O OO   O  ",
            "O OOOOOOOO",
            "O        O",
            "OOOOOOOOOO"};
        
        String[] solution = {
            "OOOOOOOOOO",
            "O••••O•••O",
            "O•OO•O•O•O",
            "O• O•O•O•O",
            "O OO•••O••",
            "O OOOOOOOO",
            "O        O",
            "OOOOOOOOOO"};

        try {
           char[][] sol = LabEscape.drawPathForEscape(MazeUtils.toCharArray(labyrinth), 3, 1);
           printStringArray(MazeUtils.toStringArray(sol));
           
           assert equals(solution, MazeUtils.toStringArray(sol));
           
        }
        catch (NoEscapeException ex) {
            Logger.getLogger(MazLibraryUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void test2() {
        String[] labyrinth = {
            "OOOOOOOOOO",
            "O    O   O",
            "O OO O O O",
            "O  O O O O",
            "O OO   O O",
            "O OOOOOOOO",
            "O        O",
            "OOOOOOOOOO"};
        
       

        try {
            // Should not find a solution => NoEscapeException
           char[][] sol = LabEscape.drawPathForEscape(MazeUtils.toCharArray(labyrinth), 3, 1);

           assert false;
        }
        catch (NoEscapeException ex) {
            
        }
    }
    
    private boolean equals(String[] a1, String[] a2) {
        if(a1.length == a2.length) {
            for (int i = 0; i < a1.length; i++) {
                if(!a1[i].equals(a2[i]))
                    return false;
            }
        }
        return true;
    }
    
    void printStringArray(String[] array) {
        for (String line : array) {
            System.out.println(line);
        }
    }
    
    
    
}
