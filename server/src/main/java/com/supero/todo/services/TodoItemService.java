package com.supero.todo.services;

import java.util.List;
import java.util.Optional;

import com.supero.todo.entities.TodoItem;

public interface TodoItemService {

	public TodoItem save(TodoItem item);
	
	public List<TodoItem> findAll();
	
	public Optional<TodoItem> findById(Long id); 
	
	public void deleteById(Long id);
}
