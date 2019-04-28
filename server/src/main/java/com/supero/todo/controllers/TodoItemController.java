package com.supero.todo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supero.todo.entities.TodoItem;
import com.supero.todo.repositories.TodoItemRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/todo-item")
public class TodoItemController {

	@Autowired
	TodoItemRepository repository;

	@PostMapping
	public TodoItem create(@RequestBody TodoItem item) {
		return repository.save(item);
	}

	@GetMapping
	public List<TodoItem> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public Optional<TodoItem> findById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@PutMapping(path = { "/{id}" })
	public TodoItem update(@PathVariable("id") Long id, @RequestBody TodoItem item) {
		TodoItem itemToUpdate = repository.findById(id).get();

		itemToUpdate.setTitle(item.getTitle());
		itemToUpdate.setDescription(item.getDescription());
		itemToUpdate.setFinished(item.isFinished());
		itemToUpdate.setModifiedDate(item.getModifiedDate());

		return repository.save(itemToUpdate);
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        TodoItem item= repository.findById(id).get();
        repository.delete(item);
        
        return ResponseEntity.ok().build();
    }
}
