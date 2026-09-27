/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.hospitaloperationsapp.Operations;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rhula
 */

public class OperationsTest {

    int[][] data = {
            {120, 150, 160, 140},
            {180, 200, 170, 190}
    };

    Operations op = new Operations();

    @Test
    void testTotalOperations() {
        assertEquals(1310, op.getTotal(data));
    }

    @Test
    void testAverageOperations() {
        assertEquals(163.75, op.getAverage(data), 0.001);
    }

    @Test
    void testMaxOperations() {
        assertEquals(200, op.getMax(data));
    }

    @Test
    void testMinOperations() {
        assertEquals(120, op.getMin(data));
    }

}
