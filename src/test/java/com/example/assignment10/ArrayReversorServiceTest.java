package com.example.assignment10;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ArrayReversorServiceTest {

    @Mock
    private ArrayFlattenerService arrayFlattenerService;

    @InjectMocks
    private ArrayReversorService arrayReversorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReverseArray_valid2DArray() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] flattenedArray = {1, 3, 0, 4, 5, 9};
        int[] expectedOutput = {9, 5, 4, 0, 3, 1};

        when(arrayFlattenerService.flattenArray(input)).thenReturn(flattenedArray);

        int[] result = arrayReversorService.reverseArray(input);

        assertArrayEquals(expectedOutput, result);
        verify(arrayFlattenerService).flattenArray(input);
    }

    @Test
    public void testReverseArray_nullInput() {
        when(arrayFlattenerService.flattenArray(null)).thenReturn(null);

        int[] result = arrayReversorService.reverseArray(null);

        assertNull(result);
        verify(arrayFlattenerService).flattenArray(null);
    }
}

