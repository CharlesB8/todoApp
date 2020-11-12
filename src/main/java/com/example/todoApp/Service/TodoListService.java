package com.example.todoApp.Service;

import com.example.todoApp.Model.TodoList;
import org.json.simple.JSONObject;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public interface TodoListService {

    Optional<TodoList> getTodoListById(UUID id);

    Optional<TodoList> getTodoListByTitle(String title);

    Iterable<TodoList> getAllTodoLists();

    JSONObject deleteAllTodoLists();

    JSONObject deleteTodoListById(UUID id);

    JSONObject updateTodoListById(UUID id, TodoList newTodoList);

    JSONObject postTodoList(TodoList todoList);
}
