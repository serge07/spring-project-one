package com.example.todo.controller;


import com.example.todo.model.Status;
import com.example.todo.model.Task;
import com.example.todo.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.data.domain.Sort.Order.by;

@Controller
//RequestMapping("/tasks")
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private static final int PAGE_SIZE = 20;

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/tasks")
    public String getAllTasks(@RequestParam(defaultValue = "0") int page, Model model) {
        logger.info("Getting all tasks for page: {}", page);

        Pageable pageable = PageRequest.of(page, PAGE_SIZE, Sort.by("id"));
        Page<Task> tasks = taskService.getAllTasks(pageable);
        model.addAttribute("tasks", tasks.getContent());
        model.addAttribute("totalPages", tasks.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("hasNext", tasks.hasNext());
        model.addAttribute("hasPrevious", tasks.hasPrevious());

        return "task-list";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        logger.info("Test endpoint called");
        return "Test endpoint is working";
    }

    // For showing edit form
    @GetMapping("/tasks/edit/{id}")
    public String ShowEditForm(@PathVariable Long id, Model model) {
        logger.info("Editing task with id: {}", id);
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "edit-task";
    }



    //For handling the update request submission
    @PostMapping("/tasks/update/{id}")
    public String updateTaskStatus(@PathVariable Long id, Status status) {
        logger.info("Updating task status. ID: {}, New Status: {}", id, status);
        taskService.updateTaskStatus(id, status);
        return "redirect:/tasks";
    }

    //For handling the delete request
    @PostMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        logger.info("Deleting task with id: {}", id);
        try {
            taskService.deleteTask(id);
        } catch (EmptyResultDataAccessException e) {
            // Task already deleted - ignore
        }
        return "redirect:/tasks";
    }


//For showing the add new form
@GetMapping("/tasks/new")
public String ShowAddForm(Model model) {
    logger.info("Showing the add new form");
    model.addAttribute("task", new Task());
    return "add-task";
}


// Handle create submission
@PostMapping("/tasks/save")
public String createTask(@Valid Task task, BindingResult result) {
    logger.info("Creating a new task");
    if (result.hasErrors()) {
        return "add-task";
    }
    taskService.saveTask(task);
    return "redirect:/tasks";

   }


}





