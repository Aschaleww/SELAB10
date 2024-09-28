package com.example.assignment10;

import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class ArrayFlattenerService {

    public int[] flattenArray(int[][] nestedArray) {
        if (nestedArray == null) {
            return null;
        }

        return Arrays.stream(nestedArray)
                .flatMapToInt(Arrays::stream)
                .toArray();
    }
}

