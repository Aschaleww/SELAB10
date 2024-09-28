package com.example.assignment10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrayReversorService {

    @Autowired
    private ArrayFlattenerService arrayFlattenerService;

    public int[] reverseArray(int[][] nestedArray) {
        int[] flattenedArray = arrayFlattenerService.flattenArray(nestedArray);
        if (flattenedArray == null) {
            return null;
        }

        for (int i = 0; i < flattenedArray.length / 2; i++) {
            int temp = flattenedArray[i];
            flattenedArray[i] = flattenedArray[flattenedArray.length - i - 1];
            flattenedArray[flattenedArray.length - i - 1] = temp;
        }

        return flattenedArray;
    }
}

