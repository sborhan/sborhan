

/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


package sborhan_lab8;



/*
 * 
 *class Queue
 * Making a generic class <T> Type
 * @author Sam Borhan
 * @version 1.0
 */
public class Queue<T>  {
	
	   
	
	
     //====== Inner class Node =======
    private class Node {

    	//======= Inner class Fields ======
    	// render data type is <T> generic
    	public T render;
        public Node next ;

        /*
         * Inner class constructor
         * 
         * @param render : <T> -> generic
         * @param next : Node
         * 
         */
        public Node(T render, Node next) {
            this.render = render;
            this.next = next;
        }
    }

    // RenderQueue class private fields 
    private Node head;
    private Node tail;

    /*
     * method append
     * Enqueue all the elements from another queue into this queue.
     * @param other : <T> generic data type
     */
    public void append(Queue<T> other) {
        System.out.println("Original values are appending as Follow: ");
  	
        for (Node p = other.head; p != null; p = p.next)
            enqueue(p.render);
    }
    
    
    /*
     * method equals
     * check if 2 Queues are equals
     * @param qu :Queue<T>
     * @return boolean
     */
    public boolean equals(Queue<T> qu){
    	Queue<T> copyofOrig=this.copy();
 
    	 boolean bool = false;
     	 if(copyofOrig.empty()) {
    		 return false;
    	 }
    	 
     	for(Node p =qu.head;p != null;p=p.next) {
     		if(!copyofOrig.empty()) {
    		  if(p.render == copyofOrig.dequeue()) {
    			    bool=true;
    		   }else {
    			  return false;
    		   }
			   System.out.println("\n copy is empting out\n");
     		}
     		else {
     			return false;
     		}
    	 }
     	
     	if(copyofOrig.empty())    	
    	 return bool;
     	
     	else
     		return false;
     }
    
    
    

    /*
     * method copy
     * using append method
     *
     * @return : Queue -> <T> type
     */
    public Queue<T> copy() {
        System.out.println("\nMaking a copy....");

    	Queue<T> theCopy = new Queue<>();
        theCopy.append(this);
        
      return theCopy;
    }


    /**
     * method dequeue
     * Remove an element from the front of the queue (oldest element in the
     * queue).
     *
     * @throws IllegalArgumentException Queue is empty
     * @return  generic <T> type value
     */
    public T dequeue() {


        if (empty()) {
            throw new IllegalArgumentException("cannot dequeue from "
                    + "empty queue");
        }else{

            T render = head.render;
            System.out.println("\n"+head.render+":removed");

            head = head.next;

          return render;
        }
    }


    /**
     * method enqueue
     * Add an element to the end of the queue.
     *
     * @param render new  generic <T> type element's payload
     * @return : void
     */
    public void enqueue(T render) {

        T copyRender = render;
        if (tail != null) {
            tail.next = new Node(copyRender, null);
            tail = tail.next;
            System.out.println(tail.render+":added");
        } else {
            tail = new Node(copyRender, null);
            head = tail;
            System.out.println(tail.render+":added");

        }
    }

   
    /*
     * method toString
     * 
     * String representation of the queue with generic <T> type contents.
     *
     * @return: string representation
     */
    public String toString() {
    	
    	StringBuilder builder = new StringBuilder();
    	builder.append("\nList :");
       Node p = head;
       while(p != null) {
    	    builder.append(p.render+" |");
           p=p.next;
           if(p == null) {
       	    builder.append(".....!");

           }    	    
       }
       builder.append("\n\nFirst value is:"+ head.render);
       builder.append("\nLast value is:"+ tail.render);


  
       return builder.toString();
    }

    /**
     * method empty
     * Reports if the queue has any elements.
     *
     * @return true if the queue has zero elements, false otherwise
     */
    public boolean empty() {
        
        return head == null;

    }

}
