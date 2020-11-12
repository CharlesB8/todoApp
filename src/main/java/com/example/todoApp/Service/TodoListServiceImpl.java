package com.example.todoApp.Service;


import com.example.todoApp.Model.TodoList;
import com.example.todoApp.Repo.TodoListRepo;
import org.json.simple.JSONObject;

import java.util.Optional;
import java.util.UUID;

public class TodoListServiceImpl implements TodoListService {

    TodoListRepo todoListRepo;

    public TodoListServiceImpl(TodoListRepo todoListRepo){
        this.todoListRepo = todoListRepo;
    }

    @Override
    public Optional<TodoList> getTodoListById(UUID id) {
        return todoListRepo.findById(id);
    }

    @Override
    public Optional<TodoList> getTodoListByTitle(String title) {
        return todoListRepo.findTodoListByTitle(title);
    }

    @Override
    public Iterable<TodoList> getAllTodoLists() {
        return todoListRepo.findAll();
    }

    @Override
    public JSONObject deleteAllTodoLists() {
        JSONObject response = new JSONObject();
        response.put("message", "deleted all todo lists");
        return response;
    }

    @Override
    public JSONObject deleteTodoListById(UUID id) {
        todoListRepo.deleteById(id);
        JSONObject response = new JSONObject();
        response.put("message", "deleted todo lists");
        return response;
    }

    @Override
    public JSONObject updateTodoListById(UUID id, TodoList newTodoList) {
        Optional<TodoList> optionalTodoList = todoListRepo.findById(id);
        optionalTodoList.map(todoList-> {
            todoList.setTitle(newTodoList.getTitle());
            todoList.setTasks(newTodoList.getTasks());
            return todoList;
        });

        JSONObject response = new JSONObject();
        response.put("message", "deleted todo lists");
        return response;
    }

    @Override
    public JSONObject postTodoList(TodoList todoList) {
        return null;
    }
}
