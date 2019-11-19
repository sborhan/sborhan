

/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

/*
 * This assignment is going to build an L-system rewrite and
 * rendering system that can animate the drawing of
 *  any of the simple L-system graphics.
 * The doubly-linked list implementation should have
 *  a head reference for the front end of the queue.
 * taking elements off from the head with the dequeue method.
 * It should also have a tail reference. 
 * adding elements on at the tail with the enqueue method.
 */


package sborhan_lab7;

/*
 *class RenderQueue
 *
 * @author Sam Borhan
 * @version 1.0
 */
public class RenderQueue {
	
     //====== Inner class Node =======
    private static class Node {

    	//======= Inner class Fields ======
    	public RenderCommand render;
        public Node next ;
        public Node prev ;

        /*
         * Inner class constructor
         * 
         * @param render : RenderCommand
         * @param next : Node
         * @param tail : Node
         * 
         */
        public Node(RenderCommand render, Node prev, Node next) {
            this.render = render;
            this.prev = prev;
            this.next = next;
        }
    }

    // RenderQueue class private fields 
    private Node head;
    private Node tail;

    /**
     * method append
     * 
     * Enqueue all the elements from another queue onto this queue.
     *
     * @param other the queue with the elements to enqueue
     */

    public void append(RenderQueue other) {

        for (Node p = other.head; p != null; p = p.next)
            enqueue(p.render);
    }

    /**
     * method copy
     * using append method
     * 
     * Make a deep copy of the queue. This means
     * that you will create a new RendorQueue, and copy the contents of the current queue to
     * the new queue. This means you have to remove from the current queue and add to the new queue.
     * This likely will mean starting from the head and getting each value from the node
     * and calling enqueue on the new queue that you will return.
     *
     * @return : RenderQueue -> theCopy
     */
    public RenderQueue copy() {
        
    	RenderQueue theCopy = new RenderQueue();
        theCopy.append(this);
        
      return theCopy;
    }


    /**
     * method dequeue
     * Remove an element from the front of the queue (oldest element in the
     * queue).
     *
     * @throws IllegalArgumentException Queue is empty
     * @return RenderCommand: -> render 
     */
    public RenderCommand dequeue() {


        if (empty()) {
            throw new IllegalArgumentException("cannot dequeue from "
                    + "empty queue");
        }else{

            RenderCommand render = head.render;
            head = head.next;

          return render;
        }
    }


    /**
     * method enqueue
     * Add an element to the end of the queue.
     *
     * @param render new element's payload
     */
    public void enqueue(RenderCommand render) {

        RenderCommand copyRender = render;
        if (tail != null) {
            tail.next = new Node(copyRender, tail, null);
            tail = tail.next;
        } else {
            tail = new Node(copyRender, null, null);
            head = tail;
        }
    }

    /**
     * method fromString
     * 
     * examine each character of queueString, and you will
     * figure out which RendorCommand it is:
     * For instance if it is a 'F' it will be RenderCommand.FORWARD, if it is 'R' it is RendorCommand.FORWARD2. Remember there are seven RendorCommands.
     * enqueue each RendorCommand that you derive from the string into a new queue that you will return.
     *
     * @param queueString : Contains the RendorCommands in string form.
     * @return the corresponding queue
     */

    public static RenderQueue fromString(String queueString) {
        RenderQueue q = new RenderQueue();
        for (char c : queueString.toCharArray()) {
            
            switch (c) {
                case 'F':
                    q.enqueue(RenderCommand.FORWARD);
                    break;
                case 'R':
                    q.enqueue(RenderCommand.FORWARD2);
                    break;
                case 'X':
                    q.enqueue(RenderCommand.IGNORE);
                    break;
                case '-':
                    q.enqueue(RenderCommand.RIGHT);
                    break;
                case '+':
                    q.enqueue(RenderCommand.LEFT);
                    break;
                case '[':
                    q.enqueue(RenderCommand.PUSH);
                    break;
                case ']':
                    q.enqueue(RenderCommand.POP);
                    break;

            }
        }
        return q;

    }


    /**
     * method toString
     * 
     * String representation of the queue contents.
     * Uses traditional notation for the render commands.
     *
     * @return the string representation
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node p = head; p != null; p = p.next)
            switch (p.render) {
                case FORWARD:
                    s.append('F');
                    break;
                case FORWARD2:
                    s.append('R');
                    break;
                case IGNORE:
                    s.append('X');
                    break;
                case RIGHT:
                    s.append('-');
                    break;
                case LEFT:
                    s.append('+');
                    break;
                case PUSH:
                    s.append('[');
                    break;
                case POP:
                    s.append(']');
                    break;
                default:
                    s.append('?');
                    break;
            }
        return s.toString();
    }


    /**
     * method empty
     * Reports if the queue has any elements.
     *
     * @return true if the queue has zero elements, false otherwise
     */
    public boolean empty() {
        // TODO Auto-generated method stub
        return head == null;

    }

}
