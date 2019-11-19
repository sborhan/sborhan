


/*
 * Sam Borhan 
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package sborhan_lab0;

public class Hello {
	final static private int[] listArray = new int[] {12,10,10,8,3,2,1,0,0,3,4,4,10,11};

	private class Node{
		public int data;
		public Node next;
		
		public Node(int data,Node next) {
			this.data = data;
			this.next = next;
		}
		
		
	}

	
	Node  head;
	
	
	public Hello(){
		head    = null;
			
	}
	
	private void sortInAscendingOrder(int n) {
		
		
		if(head == null || head.data > n) {
			 head= new Node(n,head);
		}else {
			
			Node p = head;			
			while(p.next != null && p.next.data < n) {
				p = p.next;
			}
			
		    p.next =new Node(n,p.next);
			
		}
		
	}
	
	private void getData() {
		
		for(int i=0;i<listArray.length;i++) {
	    	  sortInAscendingOrder(listArray[i]);
	      }

	}
	
	private void printList() {
		
		      
		     Node p = head;
               while(p != null) {
				System.out.println(p.data);
				//System.out.println(head.next.data);
                 p = p.next;
               }		
	}
	

	
	
	
	
	
/*
	public static class Enum{
		
	  enum Day {MONDAY,TUESDAY}
	  
	}
	
*/	
//	enum Day {MONDAY,TUESDAY}
	
	public static void main(String[] args) {
		
		
		String str ="sam borhan";
		int hStr = str.hashCode();
		System.out.println("hash of sam : "+ hStr +"\n");
		Hello list = new Hello();
		

		list.getData();
		//list.deleteData(12);
		//list.AddData(2222222);
		//list.AddData(2);
		//list.AddData(22);
		list.sortInAscendingOrder(12);
		list.sortInAscendingOrder(2);
		list.sortInAscendingOrder(222);

		
		
		list.printList();
		System.out.println("============");
		
		String message =String.valueOf(2);
		StringBuilder strBuilder = new StringBuilder();
		System.out.println(strBuilder.append("!@!3")+"oooooooooooooooo");

	}
	public void add(int index ,String e)
	{
		String message =String.valueOf(index);
		throw new IndexOutOfBoundsException(message);

	}


}
