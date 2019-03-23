package Linear_Data_Structures;
/*
# Queues based on Lists.
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
 * This class represents the behavior of Queues
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class Queue {
	
	Node head = null; //Pointer that indicates the start of the list
	
	public Queue() {}
	
	/**
	 * Consult if the list Empty
	 * @return true if the first node (start) does not point to other node.
	 */
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	/**
	 * Insert a new node at enqueue (it is insert in the end of list)
	 * @param newNode
	 */
	public void enqueue(Node newNode)
	{
		Node temp = head; //It create a temporary of node
		
		while(temp != null) // Go to through the list while of node to consult do not this empty
		{
			temp = temp.getNext(); // Go to next node
		}
		temp.setNext(newNode); // Point the end node of the list to the new node
		newNode.setNext(null); // Point the new node to the null
		
	}
	
	/**
	 * Delete a node of the enqueue (it is deleted in the start to list)
	 * @return
	 */
	public Node dequeue()
	{
		Node temp = head; //It create a temporary of node
		head = temp.getNext(); //Second node becomes in the head
		temp = null;
		System.gc(); //Cleans the node of the memory
		
		return null;
	}
}