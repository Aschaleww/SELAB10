package com.example.assignment10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArrayFlattenerServiceTest {

    @Autowired
    private ArrayFlattenerService arrayFlattenerService;

    @Test
    public void testFlattenArray_valid2DArray() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};

        int[] result = arrayFlattenerService.flattenArray(input);
        assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testFlattenArray_nullInput() {
        int[] result = arrayFlattenerService.flattenArray(null);
        assertNull(result);
    }
}
