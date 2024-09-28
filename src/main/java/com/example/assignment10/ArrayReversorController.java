package com.example.assignment10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/array")
public class ArrayReversorController {

    @Autowired
    private ArrayReversorService arrayReversorService;

    @PostMapping("/reverse")
    public int[] reverseArray(@RequestBody int[][] nestedArray) {
        return arrayReversorService.reverseArray(nestedArray);
    }
}

