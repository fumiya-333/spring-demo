package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TaskForm {

    private int id;

    @NotBlank
    @Size(max=256)
    private String title;
    
    @NotBlank
    @Size(max=256)
    private String description;
}
