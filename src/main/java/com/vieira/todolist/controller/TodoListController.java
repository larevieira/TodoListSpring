package com.vieira.todolist.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vieira.todolist.daos.TodoListDAO;
import com.vieira.todolist.model.TodoList;
import com.vieira.todolist.service.TodoListService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("todoList")
public class TodoListController {

	@Autowired
	private TodoListService todoListService;
	
	@Autowired
	TodoListDAO listDAO;

	@PostMapping()
	public ResponseEntity<TodoList> save(@RequestBody TodoList todo) {
		System.out.println("cadastrou tarefa " + todo.getDescription());

		TodoList teste = todoListService.save(todo);

		return new ResponseEntity<TodoList>(teste, HttpStatus.CREATED);

	}

	@GetMapping()
	public ResponseEntity<Collection<TodoList>> buscar() {

		Collection<TodoList> listTodo = todoListService.findAll();
		System.out.println("buscar");
		return new ResponseEntity<>(listTodo, HttpStatus.OK);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<TodoList> deleteList(@PathVariable Integer id) {
		System.out.println("deletou tarefa ");
		
		listDAO.deleteById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TodoList> edit(@PathVariable Integer id, @RequestBody TodoList todo) {

		if(todo.getId() != id) {
			return ResponseEntity.badRequest().build();
		}
		if(!listDAO.existsById(id)){
			return ResponseEntity.notFound().build();
		}
		todo.setId(id);
		TodoList todoEdit = todoListService.edit(todo);
		System.out.println("alterado");
		return new ResponseEntity<>(todoEdit, HttpStatus.OK);
	}

}
