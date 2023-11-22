package com.example.lfj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class course {
    private int id;
    private String name;
    private String description;
    private int student_id;
}
