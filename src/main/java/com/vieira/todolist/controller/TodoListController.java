package com.vieira.todolist.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vieira.todolist.daos.TodoListDAO;
import com.vieira.todolist.model.TodoList;
import com.vieira.todolist.service.TodoListService;

@RestController
public class TodoListController {

	@Autowired
	private TodoListService todoListService;

	@RequestMapping(method = RequestMethod.POST, value = "/todoList", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TodoList> save(@RequestBody TodoList todo) {
		System.out.println("cadastrou tarefa " + todo.getDescription());

		TodoList teste = todoListService.save(todo);

		return new ResponseEntity<TodoList>(teste, HttpStatus.CREATED);

		// todoListDAO.save(todo);
		// return "products/ok";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/busca", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<TodoList>> buscar() {

		Collection<TodoList> listTodo = todoListService.findAll();
		System.out.println("buscar");
		return new ResponseEntity<>(listTodo, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public ResponseEntity<TodoList> deleteList(@PathVariable Integer id) {
		System.out.println("deletou tarefa ");

	
		TodoList testeExcluir = (TodoList) todoListService.findById(id);
		
		 if(testeExcluir == null) { 
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
		

		todoListService.delete(testeExcluir);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TodoList> edit(@RequestBody TodoList todo) {

		TodoList todoEdit = todoListService.edit(todo);
		System.out.println("alterado");
		return new ResponseEntity<>(todoEdit, HttpStatus.OK);
	}

}
