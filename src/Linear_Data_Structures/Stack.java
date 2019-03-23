package Linear_Data_Structures;

import java.io.*;

/*
# Stack Functions.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/

/**
 * This class represents the behavior of Stacks
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class Stack {
	
	public Node top = null; //Top
	
	public Stack() {}
	
	/**
	 * Consult if the list Empty
	 * @return true if the first node (start) does not point to other node.
	 */
	public boolean isEmpty()
	{
		return top == null ? true : false;
	}
	
	
	/**
	 * Insert a new node at top
	 * @param newNode
	 */
	public void push(Node newNode)
	{
		newNode.setNext(top); //Point the new node a the head of the list
		top = newNode; // New node becomes the head
	}
	
	
	/**
	 * Delete a node of the top
	 * @return
	 */
	public Node pop()
	{
		Node temp = top; //It create a temporary of node
		top = temp.getNext(); //Second node becomes in the head
		temp = null;
		System.gc(); //Cleans the node of the memory
		
		return null;
	}
	
	
	/**
	 * Return the value stored at the top (head)
	 * @return
	 */
	public String peek()
	{
		if(!isEmpty()) { //Consult if top is different of null
			return top.toString(); //Return the value at the top
		}
		return null; //else return null
	}
	
	
	/**
	 * print the stack
	 */
	public void printStack()
	{
		BufferedWriter bw = new BufferedWriter(	new OutputStreamWriter( System.out ));
		
		try
		{
			while(!isEmpty()) //while top is different of null
				bw.write(pop().toString()); //print the top, and delete the node of the top
			
			bw.flush();
		}
		catch(Exception ex) { ex.printStackTrace(); }
	}
}
