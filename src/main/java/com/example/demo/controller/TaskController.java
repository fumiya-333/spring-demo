package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Task;
import com.example.demo.form.TaskForm;
import com.example.demo.service.impl.TaskService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @GetMapping
    public String index(Model model) {
        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks/index";
    }

    @GetMapping("/tasks/create")
    public String create(@ModelAttribute TaskForm form) {
        return "tasks/create";
    }
    
    @Transactional
    @PostMapping("/tasks/store")
    public String store(@Validated TaskForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return create(form);
        }
        taskService.store(form.getTitle(), form.getDescription());
        return "redirect:/";
    }
    
    @GetMapping("/tasks/{taskId}")
    public String detail(@PathVariable("taskId") int taskId, Model model) {
        Task task = taskService.findById(taskId);
        model.addAttribute("task", task);
        return "tasks/detail";
    }

    @GetMapping("/tasks/{taskId}/edit")
    public String edit(@PathVariable("taskId") int taskId, Model model) {
        Task task = taskService.findById(taskId);
        TaskForm form = new TaskForm(taskId, task.getTitle(), task.getDescription());
        
        model.addAttribute("taskForm", form);
        return "tasks/edit";
    }

    @PostMapping("/tasks/update")
    public String update(Model model, @Validated TaskForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "tasks/edit";
        }
        
        taskService.update(form.getId(), form.getTitle(), form.getDescription());
        return "redirect:/";
    }
}
