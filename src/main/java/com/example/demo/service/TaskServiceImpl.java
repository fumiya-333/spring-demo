package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.impl.TaskService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @Transactional
    public void store(String title, String description){
        taskRepository.insert(title, description);
    }
}