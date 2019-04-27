package com.supero.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supero.todo.entities.TodoItem;
import com.supero.todo.repositories.TodoItemRepository;

@Service
public class TodoItemServiceImpl implements TodoItemService {
	
	@Autowired
	TodoItemRepository repository;
	
	@Override
	public TodoItem save(TodoItem item) {
		return repository.save(item);
	}

	@Override
	public List<TodoItem> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);;
	}

	@Override
	public Optional<TodoItem> findById(Long id) {
		return repository.findById(id);
	}

}
