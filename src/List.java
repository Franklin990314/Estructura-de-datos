package Linear_Data_Structures;
import java.io.*;

/*
# Lists based on Pointers.
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
 * This class represents the behavior of Lists based on Pointers
 * @author MSc. Carlos Andres Sierra, PhD. student
 */

public class List {

	//Pointer that indicates the start of the list, know also as head the list
	public Node head = null;
	
	
	public List() {}
	
	/**
	 * Consult if the list Empty
	 * @return true if the first node (start) does not point to other node.
	 */
	public boolean isEmpty()
	{
		return head == null ? true : false;
	}
	
	
	/**
	 * Print a list
	 * 
	 */
	public void printList()
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( System.out ));
		Node temp = head; //It create a temporary of node
		
		try
		{
			while(temp != null) //Consult if the node is empty, while do not this, the print and pass to the next.
			{
				bw.write(temp.toString()); // Print the node save in temporal
				temp = temp.getNext(); // Go to next node
			}
			bw.flush();
		}
		catch(Exception ex) { ex.printStackTrace(); }
	}
	
	
	/**
	 * Insert a node to start of the list
	 * @param newNode
	 */
	public void insertAtBegin(Node newNode)
	{
		newNode.setNext(head); //Point the new node a the head of the list
		head = newNode; // New node becomes the head
	}
	
	
	/**
	 * Insert a new node of end of the list
	 * @param newNode
	 */
	public void insertAtEnd(Node newNode)
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
	 * Insert a new node to the specified position
	 * @param newNode
	 * @param index
	 */
	public void insertAtIndex(Node newNode, int index)
	{
		Node temp = head; //It create a temporary of node
		
		for(int i = 0; i < index; i++) //Search the position the node to insert
			temp = temp.getNext(); // Go to next node
		
		newNode.setNext(temp.getNext()); //Point the new node to the next node of the temporal
		temp.setNext(newNode); //Point the node to insert to the new node
	}
	
	/**
	 * Delete the start node of the list
	 */
	public void deleteAtBegin()
	{
		Node temp = head; //It create a temporary of node
		head = temp.getNext(); //Second node becomes in the head
		temp = null;
		System.gc(); //Cleans the node of the memory
	}
	
	
	/**
	 * Delete the end node of the list
	 */
	public void deleteAtEnd()
	{
		
		Node toDelete = head; //It create a temporary of node to delete
		Node previous = toDelete; // It create a node previous
		
		while(toDelete != null) //while the node do not this empty go to next node
		{
			previous = toDelete; //Save the previous position of the node to consult
			toDelete = toDelete.getNext(); // Go to next node
		}
		previous.setNext(null); //It point to null, the previous save
		toDelete = null;
		System.gc(); //Cleans the node of the memory
	}
	
	
	/**
	 * Delete a node in an specified position
	 * @param index
	 */
	public void deleteAtIndex(int index)
	{
		Node temp = head; //It create a temporary of node
		Node toDelete; //It create a node to delete
		
		for(int i = 0; i < index - 1; i++) //Search the previous position of the node to delete
			temp = temp.getNext(); //Go to next node
		
		toDelete = temp.getNext();  //Is assigned the node to delete
		temp.setNext(toDelete.getNext()); //the previous position of the node to delete, it is pointed to position next node to Delete
		toDelete = null;
		System.gc(); //Cleans the node of the memory
	}
	
	
	/**
	 * 
	 * Update a node of the list
	 * @param oldNode
	 * @param newNode
	 */
	public void updateFirst(Node oldNode, Node newNode)
	{
		Node temp = head; //It create a temporary of node
		Node previous = head; //A node that saves the temporary position is created
		
		while(temp != null) //Go to through the list while of node to consult do not this empty
		{
			if(temp.isEqual(oldNode)) //Consult if the node temporal is equals to the node to update
			{
				newNode.setNext( temp.getNext() ); //Point the new node to the next to update
				previous.setNext(newNode); //The previous node it is pointed to the new node
				temp = null;
				break; //The cycle closes
			}
			
			previous = temp; //else, is assigned the node already validated
			temp = temp.getNext(); //Go to next node
		}
	}
	
	
	/**
	 * 
	 * Update all nodes of the list
	 * @param oldNode
	 * @param newNode
	 */
	public void updateAll(Node oldNode, Node newNode)
	{
		Node temp = head; //It create a temporary of node
		Node previous = head; //A node that saves the temporary position is created
		
		while(temp != null) //Go to through the list while of node to consult do not this empty
		{
			if(temp.isEqual(oldNode)) //Consult if the node temporal is equals to the node to update
			{
				newNode.setNext( temp.getNext() ); //Point the new node to the next to update
				previous.setNext(newNode); //The previous node it is pointed to the new node
				temp = null;
				previous = newNode; //Is Assigned the new node to the previous
				temp = newNode.getNext(); //Go to next node
			}
			else
			{
				previous = temp; //else, is assigned the node already validated
				temp = temp.getNext(); //Go to next node
			}
		}
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public Node linealSearch(Node node)
	{
		Node temp = head;
		Node result = null;
		
		while(temp != null)
			if(temp.isEqual(node))
			{	
				result =  temp;
				break;
			}
			else
				temp = temp.getNext();
			
		return result;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public List searchAll(Node node)
	{
		Node temp = head;
		List results = new List();
		
		while(temp != null)
		{
			if(temp.isEqual(node))
			{	
				results.insertAtEnd(temp.clone());
			}
			
			temp = temp.getNext();
		}
		
		return results;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public Node binarySearch(Node node)
	{
		return null;
	}
	
	
	/**
	 * 
	 */
	public void reverse()
	{
		Stack tempStack = new Stack();
		Node temp = head;
		
		while(temp != null)
		{
			tempStack.push(temp.clone());
			temp = temp.getNext();
		}
		
		head = tempStack.top;
	}
	
	
	/**
	 * 
	 * @param unsorted
	 * @return
	 */
	public List quickSort(List unsorted)
	{
		if(unsorted.length() <= 1)
		{
			return unsorted;	
		}
		else
		{
			Node pivot = unsorted.head;
			Node temp = pivot.getNext();
			
			List less_elements = new List();
			List greater_elements = new List();
			
			while(temp != null)
			{
				if(temp.isLessThan(pivot))
					less_elements.insertAtEnd(temp.clone());
				else
					greater_elements.insertAtEnd(temp.clone());
				
				temp = temp.getNext();
			}
			
			pivot.setNext(null);
			less_elements = quickSort(less_elements);
			less_elements.insertAtEnd(pivot);
			less_elements.insertAtEnd( quickSort(greater_elements).head );
			
			return less_elements;
		}
	}
	
	
	public List sublist(int begin)
	{
		List subList = new List();
		
		if(begin < this.length())
		{
			Node temp = head;
			
			for(int i = 0; i < begin; i++)
				temp = temp.getNext();
			
			while(temp != null)
			{
				subList.insertAtEnd(temp.clone());
				temp = temp.getNext();
			}
		}
		
		return subList;
	}
	
	
	/**
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public List sublist(int begin, int end)
	{
		List subList = new List();
		
		if(begin < end)
		{
			Node temp = head;
			
			for(int i = 0; i < begin; i++)
				temp = temp.getNext();
			
			while(temp != null)
			{
				subList.insertAtEnd(temp.clone());
				temp = temp.getNext();
			}
		}
		
		return subList;
	}
	
	
	/**
	 * 
	 * @return the long of the list (length)
	 */
	public int length()
	{
		Node temp = head; //It create a temporary of node
		int Cont = 0; //It create a counter 
		
		while(temp != null) //Go to through the list while of node to consult do not this empty 
		{ 
			temp = temp.getNext(); //Go to next node
			Cont++; //The counter is increased by one
		}
		
		return Cont; //Return the long of the list (length)
	}
	
	
	/**
	 * 
	 * @return
	 */
	public List cloneList()
	{
		return null;
	}
	
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public boolean isEqual(List list)
	{
		boolean isEqual = true;
		Node tempCurrent = head;
		Node tempList = list.head;
		
		while(tempCurrent != null && tempList != null)
			if(tempCurrent.isEqual(tempList))
			{
				tempCurrent = tempCurrent.getNext();
				tempList = tempList.getNext();
			}
			else
			{
				isEqual = false;
				break;
			}
			
		return isEqual;
	}
	
	
	/**
	 * 
	 * Return a node to get in specific
	 * @param index
	 * @return
	 */
	public Node get(int index)
	{
		Node temp = head; //It create a temporary of node
		
		for(int i = 0; i < index; i++) //Search the position the node to get
			temp = temp.getNext(); // Go to next node
		
		return temp; //Return the node to get
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public int indexOf(Node node)
	{
		int index = -1;
		Node temp = head;
		
		while(temp != null)
		{
			index += 1;
			if(temp.isEqual(node))
				return index;
			
			temp = temp.getNext();
		}
		 
		index = -1;
		return index;
	}
}