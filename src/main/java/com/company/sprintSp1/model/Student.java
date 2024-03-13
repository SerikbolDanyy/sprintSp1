package com.company.sprintSp1.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    Long id;
    String name;
    String surname;
    int exam;
    String mark;
}
