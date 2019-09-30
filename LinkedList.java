/*
* File name: LinkedLIst.java
* Author: Aaron Bermingham
* Student Number: C17738539
* Description of class: Class that defines the LinkedList structure and its associated methods
*/
package dataStructures;

public class LinkedList<T> implements LinkedListADT<T> {

	private int count; // the current number of elements in the list
	private LinearNode<T> list; // pointer to the first element
	private LinearNode<T> last; // pointer to the last element
	

	public LinkedList() {
		this.count = 0;
		this.last = null;
		this.list = null;
	}

	// 1 Adds one element to the end of this list
	public void add(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		// LinearNode<T> current = this.list;
		
		if (size() == 0) { // if Linked list is empty
			this.last = node; // This is the last and the
			this.list = node; // first node
			this.count++;
		} // end if
		else if(contains(element) == false)
		{

			last.setNext(node); // add node to the end of the list
			last = node; // now make this the new last node.
			count++;
		}
	}

	/* 
	 * 2 Add a generic object in a correct sorted position
	 * Used info from these links:
	 * https://www.geeksforgeeks.org/insert-a-node-at-a-specific-position-in-a-linked-list/
	 * https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
	 * to help with writing this method
	 * 
	 */
	public void add(T element, int num) { // Two parameters, Polymorphic method
		int counter = 1; // Count variable to iterate through LinkedList, used counters to avoid confusion with count variable
		LinearNode<T> insert = new LinearNode<T>(element); // Node that will be inserted
		LinearNode<T> current = this.list; // Node that will be to the left of the inserted node
		LinearNode<T> after = null; // Node that will be to the right of the inserted node
		

		if (num > size() + 1 || num < 1) { // Check if position is a valid input
			System.out.println("ERROR---Position is either less than one or outside the size of the linkedlist---ERROR");
		}
		if (num == size()) { // If adding a node to the end of the linkedlist
			last.setNext(insert); // add node to the end of the list
			last = insert; // now make this the new last node.
			count++; // Increment count
		}
		else if (num == 1) { // If node is inserted at one
			insert.setNext(list); // Set the head of the LinkedList to the next of the inserted one
			list = insert; // insert is the new head of the LinkedList
			count++; // Increment count
		} 
		else {
			while (counter < num - 1) { // While loop increments until the node prior to where the new node will be inserted
				current = current.getNext(); // Move to next node
				counter++; // Increment count
			}

			after = current.getNext(); // Having found the node that will be to the left of the inserted node, get the node to its right
			insert.setNext(after); // insert set next points to after node
			current.setNext(insert); // Set next of node before to the newly inserted node
			count++; // Increment count
		}

	}

	// Removes and returns the first element from this list
	public T remove() {
		T result = null;
		if (isEmpty()) {
			System.out.println("There are no nodes in the list");
		} // end if
		else {
			result = this.list.getElement();
			this.list = this.list.getNext(); // sets next node to in the list to the first node, first node is now dereferenced
			count--;
		} // end else
		return result;
	}

	// 3 Remove element from the list where the object is passed as a parameter
	public T remove(T element) {
		LinearNode<T> current = this.list;
		LinearNode<T> previous = null;
		boolean found = false;

		if (isEmpty())
			System.out.println("There are no nodes in the list");

		while (current != null && !found)
			if (current.getElement().equals(element))
				found = true;
			else {
				previous = current; // previous has the same value as current
				current = current.getNext(); // current is set to the next element in list
			}

		if (!found) {
			System.out.println("No such element in array"); // if the element is not in the LinkedList
		}

		// If the element is the first node
		if (current == list)
			this.list = current.getNext(); // sets next node to in the list to the first node, first node now
											// dereferenced

		// If the element is the last node
		else if (current == last) {
			previous = this.last; // last node set to previous
			previous.setNext(null); // De-reference the last node

		}
		// If the element is in the middle
		else
			previous.setNext(current.getNext()); // set node to the left of current next node as currents next node

		count--; // decrement count
		System.out.println( current.getElement() + "\n was deleted");
		return current.getElement();

	}
	

	// 4 Returns a string representation of the list

	public String toString() {
		LinearNode<T> current = this.list;
		String fullList = "";
		if(isEmpty()) {
			System.out.println("List is empty");
			return null;	
		}
		else {
			for (current = this.list; current != null; current = current.getNext()) {
				fullList = fullList + "\n" + current.getElement().toString();
				} // end for
			return fullList + "\n";
		}
		
		
	}

	// 5 Return first object in the list
	public T first() {
		if(this.list.getElement() != null)
			return this.list.getElement();
		else
			return null;
	}

	// 6 Return last object in the list
	public T last() {
		if(this.last.getElement() != null)
			return this.last.getElement();
		else 
			return null;
	}

	// 7 Return next generic object in the list
	public T next(T element) {
		LinearNode<T> current = this.list;
		LinearNode<T> next = null;
		boolean found = false;

		if (isEmpty())
			System.out.println("There are no nodes in the list");

		while (current != null && !found) // Iterate through list to find the if the element passed is in the LinkedList
			if (current.getElement().equals(element)) {
				found = true;
			}
				else {
					current = current.getNext(); // Move on to next node
				}
		
		if (found && current == last)
			next = null; // if the node is the last in the LinkedList
		else if(found)
			next = current.getNext();
		if (next != null)
			return next.getElement();
		else
			return null;
	}

	// 8 Check to see if the list is empty
	public boolean isEmpty() {
		if (this.list == null)
			return true; // Returns true if this list contains no element
		else
			return false;
	}

	// 9 Check does the list already contains a generic object that is input as a parameter, returns a boolean
	public boolean contains(T element) {
		boolean found = false; // found initially set to false
		LinearNode<T> current; // current used to search through array

		if (this.list == null) { // is the first node empty?
			found = false;
		} else {
			current = this.list; // make current equal to the first node
			while (current != null) // while current is not null
			{
				if (current.getElement().equals(element)) // if current element is equal to arg element
					found = true; // found is set to true
				current = current.getNext(); // current equal to the next node in the linked list
			}

		}
		return found;
	}
	

	// Returns the number of elements in this list
	public int size() {
		return this.count;
	}
	
	// Extra method - remove all nodes from LinkedList
		public void removeAll() {
			
			if (isEmpty())
				System.out.println("There are no nodes in the list");
			else
				this.list = null; // Set the first node to null, node to its right is dereferenced
				System.out.println("All elements are deleted");
		}
	
	// Extra method - get node at a specified position
		public T nodePostion(int num) {
			LinearNode<T> current = this.list;
			int counter = 1;
			if (num > size() + 1 || num < 1) { // Check if position is a valid input
				System.out.println("ERROR---No such position in the list ---ERROR");
			}
			while(current != null) { // Loop while current is not null
				if (num == counter) { 
					System.out.println(current.getElement()); //if number and counter are equal, print out the element
					return current.getElement();
					
				}
				// else increment counter and move to the next node
				else {
					counter++;
					current = current.getNext();
				}
				
			}
			return null;
		}
		
		/* Extra method - delete node at a specified position
		 * Used info from this link:
		 * https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
		 */
		 public void remove(int num) { // Polymorphic method, different parameter to other remove method
				int counter = 1; // Count variable to iterate through LinkedList, used counters to avoid confusion with count variable
				LinearNode<T> current = this.list; // Node that will be to the left of the deleted node
				LinearNode<T> after = null;
				
				if (num > size() + 1 || num < 1) { // Check if position is a valid input
					System.out.println("ERROR---Position is either less than one or outside the size of the linkedlist---ERROR");
				}
				if (num == 1) { // If node is inserted at one
					this.list = this.list.getNext();
				}
				else {
					while (counter < num - 1) { // While loop increments until the node prior to where the new node will be deleted
						current = current.getNext(); // Move to next node
						counter++; // Increment count
					}
					after = current.getNext().getNext();
					current.setNext(after);
					count--; // decrement count
				}

		}


	 
	  /*
	  Personalised function   
	  Return mid point of list, method to facilitate merge sort of Linked List
	  Unfortunately I could not get this to work
	  Used info/code from these links:
	  http://cslibrary.stanford.edu/105/LinkedListProblems.pdf
	  Lewis,J., Chase,J (2014). Searching and Sorting(pp 262-265) Java Software Structures. Pearson.
	  https://coderbyte.com/algorithm/linked-list-middle-element
	  https://www.geeksforgeeks.org/merge-sort-for-linked-list/
	  
	 
	public LinearNode<T> midPoint() {
		LinearNode<T> node = this.list; // node set to first node in LinkedList
		LinearNode<T> fast = node; // fast pointer set to node
		LinearNode<T> slow = node; // slow pointer set to node
		

		
		  Fast pointer traverse the list 2x speed of slow pointer
		  so by the time it gets to the end of the list
		  slow pointer will be at the mid point
		 
		while(fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext(); // slow moves by one 
			fast = fast.getNext().getNext(); // fast moves by two
		}
		 
		
		return slow; // Return the node where the list is split
	}
	
	
	public LinearNode<T> divideList(LinearNode<T> mid2) {
		LinearNode<T> node = new LinearNode<T>();
		LinearNode<T> mid = new LinearNode<T>();
		LinearNode<T> split = new LinearNode<T>();
		if (node == null || node.getNext()== null )
		{
			return node;
		}
		
		mid = midPoint(); // set mid to middle of list
		split = mid.getNext(); // set split to node after the middle node
		mid.setNext(null); // unlink mid from split
		LinearNode<T> left = divideList(mid); // Call divideList on the first part of list
		LinearNode<T> right = divideList(split); // Call divideList on the second part of list
		LinearNode<T> sortedList = sortedMerge(left,right); // Merge the two lists using sortedMerge method
		return sortedList;
	}
	
	// Method to sort the list 
	private LinearNode<T> sortedMerge(LinearNode<T> a, LinearNode<T> b) {
		LinearNode<T> node = new LinearNode<T>();
		// Base case
		if(a == null)
			return b;
		if(b == null)
			return a;
		// Check if a is greater than b and then recur
		 if (a.getElement().compareTo(b.getElement()) == 1)  
	        { 
	            node = a; 
	            node.setNext(sortedMerge(a.getNext(), b)); // recur
	        }  
	        else 
	        { 
	            node = b; 
	            node.setNext(sortedMerge(a, b.getNext())); // recur
	        } 
	        return node; 
	}*/
	
		
		
		
		
	}
	

