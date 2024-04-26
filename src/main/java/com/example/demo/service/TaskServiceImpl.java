package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

    public Task findById(int taskId){
        return taskRepository.findById(taskId);
    }

    public void store(String title, String description){
        taskRepository.insert(title, description);
    }

    public void update(int id, String title, String description){
        taskRepository.update(id, title, description);
    }

    public void delete(int id){
        taskRepository.delete(id);
    }
}