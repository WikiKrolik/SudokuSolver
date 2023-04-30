package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class SudokuGroupTest {

    @Test
    void checkVerifyInRow() {
        SudokuField[] c = new SudokuField[9];
        for (int i = 0; i < 9; i++){
            c[i] = new SudokuField();
            c[i].setValue(1);
        }

        SudokuRow row = new SudokuRow(c);
        boolean result = row.verify();
        Assert.assertFalse(result);
    }

    @Test
    void checkVerifyInBox(){
        SudokuField[] c = new SudokuField[9];
        for (int i = 0; i < 9; i++){
            c[i] = new SudokuField();
            c[i].setValue(i+1);
        }

        SudokuBox box = new SudokuBox(c);
        boolean result = box.verify();
        Assert.assertTrue(result);
    }

    @Test
    void checkVerifyInColumn() {

        SudokuField[] c = new SudokuField[9];
        for (int i = 0; i < 9; i++){
            c[i] = new SudokuField();
            c[i].setValue(i+1);
        }

        SudokuColumn column = new SudokuColumn(c);
        boolean result = column.verify();
        Assert.assertTrue(result);
    }

}
