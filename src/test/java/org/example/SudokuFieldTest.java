package org.example;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class SudokuFieldTest {

    @Test
    void checkFieldEquals(){
        SudokuField field = new SudokuField();
        field.setValue(1);
        SudokuField secondField = new SudokuField();
        secondField.setValue(1);
        Assert.assertTrue(field.equals(secondField));
    }
}
