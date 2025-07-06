package com.todoapp.springboot.myfirstwebapp.login;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static int idCount = 1;

	private static List <Todo> todos = new ArrayList<>();
	
	static
	{
	
		todos.add(new Todo(idCount++,"UdayKumar","Learn Spring and SpringBoot",LocalDate.now().plusMonths(2),true));
		todos.add(new Todo(idCount++,"UdayKumar","Learn UI and UX",LocalDate.now().plusMonths(3),false));
		todos.add(new Todo(idCount++,"UdayKumar","Learn DataStructures and Algorithms",LocalDate.now().plusMonths(3),false));
	
	}
	public List<Todo> findByUsername(String username)
	{
		Predicate <? super Todo > predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();	
	}
	
	public void addTodo(String username,String description,LocalDate Target,boolean done)
	{
		Todo obj = new Todo(idCount++,username,description,Target,done);
		todos.add(obj);
		}
	
	public void deleteTodo(int id)
	{
		todos.removeIf(tudu -> tudu.getId() == id);
	}
	
	public Todo findbyId(int id) {
	    for (Todo todo : todos) {
	        if (todo.getId() == id) {
	            return todo;
	        }
	    }
		return null;
					}

	public void updateTodo(@Valid Todo todoDesc) {
		// TODO Auto-generated method stub
		deleteTodo(todoDesc.getId());
		
		//addTodo(todoDesc.getUsername(),todoDesc.getUsername(),todoDesc.getTargetDate(),todoDesc.isDone());
		todos.add(todoDesc);
	}
	
	
		
	}

