
/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


package sborhan_lab8;

/*
 *class Lab8
 *Testing Generic Queue and Stack classes
 *
 * @author Sam Borhan
 * @version 1.0
 */
public class Lab8 {

	
	public enum RenderCommand {FORWARD,FORWARD2,IGNORE,RIGHT,LEFT,PUSH,POP}
	public enum Command { FF1,IG1,RT1,LFT1,PSH1,P5}

   
	/*
	 * main Method 
	 * Testing purposes
	 * @param String[] : args
	 * @return void
	 */
	public static void main(String[] args) {
		
	// Testing generic Queue class with enum values
		 System.out.println("======== QUEUE Enum Type ===========");
         Queue<RenderCommand> qu  = new Queue<>();
    
         qu.enqueue(RenderCommand.FORWARD);
         qu.enqueue(RenderCommand.LEFT);
         qu.enqueue(RenderCommand.RIGHT);
         qu.enqueue(RenderCommand.IGNORE);

         System.out.println(qu);
         qu.dequeue();
         System.out.println("\nList after removing:"+qu);

         
         Queue<RenderCommand> quCopy  = new Queue<>();
         quCopy = qu.copy();
         System.out.println(quCopy);


      
	
 	// Testing generic Queue class with String values
          System.out.println("\n======== QUEUE String Type ===========");
          Queue<String> quString  = new Queue<>();
          
          quString.enqueue("Nancy");
          quString.enqueue("Sam");
          quString.enqueue("Ash");
          quString.enqueue("Jaz");

          System.out.println(quString);
          quString.dequeue();
          System.out.println("\nList after removing:"+quString);
          
          Queue<String> quStringCopy  = new Queue<>();
          quStringCopy = quString.copy();
          System.out.println(quStringCopy);
          

          
   	// Testing generic Queue class with Integer values
          System.out.println("\n========QUEUE Integer Type ===========");
            Queue<Integer> quInteger  = new Queue<>();
          
            quInteger.enqueue(11);
            quInteger.enqueue(55);
            quInteger.enqueue(77);
            quInteger.enqueue(99);

          System.out.println(quInteger);
          quInteger.dequeue();
          System.out.println("\nList after removing:"+quInteger);

          
          Queue<Integer> quIntegerCopy  = new Queue<>();
          quIntegerCopy = quInteger.copy();
          System.out.println(quIntegerCopy);
          

   	// Testing generic Stack class with Integer values
          System.out.println("\n========Stack Integer Type ===========");
          Stack<Integer> StackInt = new Stack<>();
          
          StackInt.push(44);
          StackInt.push(55);
          StackInt.push(66);
          System.out.println("\n"+StackInt);
          StackInt.pop();
          System.out.println(StackInt);
          
          System.out.println("\nmaking a copy of List:.....\n");
          Stack<Integer> stackIntegerCopy  = new Stack<>();
          stackIntegerCopy = StackInt.copy();
          System.out.println(stackIntegerCopy);
     
          
     // Testing generic Stack class with enum values
          System.out.println("\n========Stack Enum Type ===========");
          Stack<Command> stackEnum = new Stack<>();
          
          stackEnum.push(Command.FF1);
          stackEnum.push(Command.IG1);
          stackEnum.push(Command.P5);
          System.out.println("\n"+stackEnum);
          
          stackEnum.pop();
          System.out.println(stackEnum);
          
          System.out.println("\nmaking a copy of List:.....\n");
          Stack<Command> stackEnumCopy  = new Stack<>();
          stackEnumCopy = stackEnum.copy();
          System.out.println(stackEnumCopy);
          

           
     // Testing generic Stack class with String values
          System.out.println("\n========Stack String Type ===========");
          Stack<String> stackString = new Stack<>();
          
          stackString.push("Sam");
          stackString.push("Nancy");
          stackString.push("Ash");
         
         // System.out.println("\n"+stackString.copy());

          System.out.println("\n"+stackString);
          stackString.pop();
          System.out.println(stackString);
          
          System.out.println("\nmaking a copy of List:.....\n");
          Stack<String> stackStringCopy  = new Stack<>();
          stackStringCopy = stackString.copy();
          System.out.println(stackStringCopy);
           

	}	
	
}
