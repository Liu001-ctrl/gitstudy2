package com.example.lfj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class teacher {

    private int id;
    private String name;
    private  String teaching_expertise;
    private List<course> courses;

}

