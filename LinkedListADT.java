/*
* File name: LinkedListADT.java
* Author: Aaron Bermingham
* Student Number: C17738539
* Description of class: Abstract Data Type definition for a Linked List
*/

//

//Note that this is not a full definition as we are only implementing some
//of the standard functions associated with a list.

package dataStructures;

public interface LinkedListADT <T>
	{
	   //  Adds one element to the start or end of this list
	   public void add (T element);
	   
	   // Add an element at a specified position
	   public void add(T element, int num);

	   //  Removes and returns the first element from this list
	   public T remove();
	   
	   // Removes and returns an element that is passed as a parameter
	   public T remove(T element);
	   
	   // Returns a string representation of this list
	   public String toString();
	   
	   // Returns first generic object in the LinkedList
	   public T first();
	   
	   // Returns last generic object in the LinkedList
	   public T last();
	   
	   // Returns the next generic object in the LinkedList
	   public T next(T element);
	   
	   //  Returns true if this list contains no elements
	   public boolean isEmpty();
	   
	   // Check does the list already contains a generic object that is input as a parameter, returns a boolean
	   public boolean contains(T element);

	   // Returns the number of elements in this list
	   public int size();
	   
	   // Removes all elements in the list
	   public void removeAll();
	   
	   // Returns element at specified position
	   public T nodePostion(int num);
	   
	   // Removes element at specified position
	   public void remove(int num);
	   
	   
	   
	   
	  
	   

}