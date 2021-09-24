package com.vieira.todolist.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vieira.todolist.model.TodoList;

@Repository
public interface TodoListDAO extends JpaRepository<TodoList, Integer>{
	
	
}
