/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tide.nd.test;

import co.tide.nd.mazelibrary.LabEscape;
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
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
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
            "O    O   O",
            "O OO O O O",
            "O  O O O O",
            "O OO   O  ",
            "O OOOOOOOO",
            "O        O",
            "OOOOOOOOOO"};
        
        try {
            LabEscape.drawPathForEscape(toCharArray(labyrinth), 3, 1);
        }
        catch (NoEscapeException ex) {
            Logger.getLogger(NewEmptyJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    char[][] toCharArray(String[] labyrinth) {
        char[][] array = new char[labyrinth.length][];
        for(int i = 0; i < labyrinth.length-1; i++) {
            array[i] = new char[labyrinth[i].length()];
            
            for(int j = 0; j < labyrinth[i].length(); j++) {
                array[i][j] = labyrinth[i].charAt(j);
            }
        }
        
        
        
        return array;
    }
}
