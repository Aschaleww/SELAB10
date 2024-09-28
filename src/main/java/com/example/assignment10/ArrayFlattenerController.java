package com.example.assignment10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/array")
public class ArrayFlattenerController {

    @Autowired
    private ArrayFlattenerService arrayFlattenerService;

    @PostMapping("/flatten")
    public int[] flattenArray(@RequestBody int[][] nestedArray) {
        return arrayFlattenerService.flattenArray(nestedArray);
    }
}
