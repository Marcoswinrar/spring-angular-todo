package com.supero.todo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.supero.todo.services.TodoItemService;

@RestController
@RequestMapping(value = "api/v1/todo-item")
public class TodoItemController {

	@Autowired
	TodoItemService service;
	
	@CrossOrigin
	@PostMapping
	public TodoItem create(@RequestBody TodoItem item) {
		return service.save(item);
	}
	
	@CrossOrigin
	@GetMapping
	public List<TodoItem> findAll() {
		return service.findAll();
	}
	
	@CrossOrigin
	@GetMapping(path = { "/{id}" })
	public Optional<TodoItem> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@CrossOrigin
	@PutMapping(path = { "/{id}" })
	  public TodoItem update(@PathVariable("id") Long id, @RequestBody TodoItem item){
	    TodoItem itemToUpdate = service.findById(id).get();
	    
	    itemToUpdate.setTitle(item.getTitle());
	    itemToUpdate.setDescription(item.getDescription());
	    itemToUpdate.setFinished(item.isFinished());
	    itemToUpdate.setModifiedDate(item.getModifiedDate());
	    
	    return service.save(itemToUpdate);
	 }
	
	@CrossOrigin
	@DeleteMapping(path = { "/{id}" })
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
}
