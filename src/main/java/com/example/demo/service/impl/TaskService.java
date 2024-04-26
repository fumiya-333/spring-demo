 package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;

@Service
public interface TaskService {
    List<Task> findAll();
    Task findById(int taskId);
    void store(String title, String description);
    void update(int id, String title, String description);
    void delete(int id);
}