package com.aa.act.interview.org;

import java.util.Optional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
public abstract class Organization {

	private Position root;
	
	public Organization() {
		root = createOrganization();
	}
	
	protected abstract Position createOrganization();
	
	/**
	 * hire the given person as an employee in the position that has that title
	 * 
	 * @param person
	 * @param title
	 * @return the newly filled position or empty if no position has that title
	 */
	public Optional<Position> hire(Name person, String title) {
		//your code here
		//convert the name object into a string 
		String personName = person.toString()
		//set indetifier that is a intger 
		//use hashCode because it return a integer value
		//add identifier and person.toString into map (key and value)
		int indetifier = Math.abs(personName.hashCode());
		hashedNames.put(indetifier, person.toString())

		// create a new employee 
		Employee emp = new Employee(identifier, person);

		//breadth-first search
		//check if position with title matches with Organization
		//if the position does exist we want to assign the employee to the position
		//prolly want to return the position option otherwise return an empty option (dont need an error messsage)
		//use Queue to hold elements being processed using 1st and first out  (ineserts elements at end of list and deletes elements from start of list)
		//.peek() get first element from the top of the stack 
		//create a new LinkedList that takes in positions for the queue
		// the array list holds visited positions 
		// use while loop to iterate through the LinkedList
		Queue <Position> queue = new LinkedList<position>();
		ArrayList<Position> visited = new ArrayList<Position>();
		queue.add(root);
		while(!queue.isEmpty()){
			if (queue.peek().getTitle().equals(title)){
				queue.peek().setEmployeee(optional.of(emp));
				return Optional.of(queue.peek());
			}
			for (Position x : queue.remove().getDirectReports()){
				if (!visited.contains(x)){
					queue.add(x);
				}
			}
		}
		}
		
		return Optional.empty();
	}

	
	
	@Override
	public String toString() {
		return printOrganization(root, "");
	}
	
	private String printOrganization(Position pos, String prefix) {
		StringBuffer sb = new StringBuffer(prefix + "+-" + pos.toString() + "\n");
		for(Position p : pos.getDirectReports()) {
			sb.append(printOrganization(p, prefix + "\t"));
		}
		return sb.toString();
	}

