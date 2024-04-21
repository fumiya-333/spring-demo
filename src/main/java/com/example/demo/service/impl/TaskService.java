 package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;

@Service
public interface TaskService {
    List<Task> findAll();
    void store(String title, String description);
}