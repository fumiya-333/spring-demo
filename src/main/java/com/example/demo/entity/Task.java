package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Task {
    /** ID */
    private int id;
    /** タイトル */
    private String title;
    /** 詳細 */
    private String description;
}