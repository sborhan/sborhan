
/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package sborhan_lab9;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * class StackTest
 * Junit testing all methods of Stack class
 */
public class StackTest {

	
	@Test
	public void testEmpty() {
		//fail("Not yet implemented");
		Stack<String> test1 = new Stack<>();
		Stack<Double> test2 = new Stack<>();

		assertTrue("after construction",test1.empty());
		assertTrue("after construction",test2.empty());

		
		test1.push("SAM");
		test2.push(1.23);
		assertFalse("after a String push",test1.empty());
		assertFalse("after a double push",test2.empty());
		
		

        test1.pop();
        test2.pop();
		assertTrue("after push/pop",test1.empty());
		assertTrue("after push/pop",test2.empty());


	}

	@Test
	public void testPush() {
		
		//fail("Not yet implemented");
		Stack<String> test1 = new Stack<>();
		Stack<Double> test2 = new Stack<>();

		test1.push("SAM");
		test1.push("Nancy");

		test2.push(1.23);
		test2.push(4.56);
		
		assertFalse("after push",test1.empty());
		assertFalse("after push",test2.empty());


		
		assertEquals("Nancy",test1.peek());
		assertEquals(new Double(4.56) ,test2.peek());
		
			
	}

	@Test
	public void testPop() {
		//fail("Not yet implemented");
		Stack<String> test1 = new Stack<>();
		Stack<Double> test2 = new Stack<>();
		
		try {
			test1.pop();
            fail("should catch the exception on empty stack");
		}catch(IllegalArgumentException e) {
			//catch the exception
		}
		
		try {
			test2.pop();
            fail("should catch the exception on empty stack");
		}catch(IllegalArgumentException e) {
			//catch the exception
		}
	
	
		test1.push("SAM");
		test1.push("Nancy");
		test2.push(1.23);
		test2.push(4.56);
		assertEquals("Nancy" ,test1.peek());
		assertEquals(new Double(4.56),test2.peek());
		
		test1.pop();
		test2.pop();
		assertEquals("SAM" ,test1.peek());
		assertEquals(new Double(1.23),test2.peek());

		test1.pop();
		test2.pop();
		assertTrue("after push/push/pop/pop",test1.empty());
		assertTrue("after push/push/pop/pop",test2.empty());

		
	}

	@Test
	public void testPeek() {
		//fail("Not yet implemented");
		Stack<String> test1 = new Stack<>();
		Stack<Double> test2 = new Stack<>();
		
		try {
			test1.peek();
			fail("should catch the exception");
		}catch(IllegalArgumentException e) {
			//catch the exception
		}
		
		try {
			test2.peek();
			fail("should catch the exception");
		}catch(IllegalArgumentException e) {
			//catch the exception
		}
		
		test1.push("SAM");
		test1.push("Nancy");
		assertEquals("Nancy",test1.peek());

		test2.push(1.23);
		test2.push(4.56);
		assertEquals(new Double(4.56),test2.peek());

		
		test1.pop();
		assertEquals("SAM",test1.peek());
		

		test2.pop();
		assertEquals(new Double(1.23),test2.peek());
		
		test1.pop();
		assertTrue("after push/push/pop/pop",test1.empty());
		
		test2.pop();
		assertTrue("after push/push/pop/pop",test2.empty());

		
		
	}

	@Test
	public void testEqualsStackOfT() {
		//fail("Not yet implemented");
		
		
		Stack<String> test1 = new Stack<>();
		test1.push("Sam");
		test1.push("Nancy");
		
		Stack<String> test11 = new Stack<>();
		test11.push("Sam");
		test11.push("Nancy");
		
		Stack<String> test111 = new Stack<>();
		test111.push("Sam111");
		test111.push("Nancy111");	
		assertFalse("check to see both Stacks are equals",test1.equals(test111));

		assertTrue("check to see both Stacks are equals",test1.equals(test11));
       
		test1.pop();
        assertFalse("pop from test1 and expect not equal",test1.equals(test11));

        
        Stack<String> test1_ = new Stack<>();
		Stack<String> test11_ = new Stack<>();
		assertFalse("check to see both empty Stacks are equals",test1_.equals(test11_));

        
        
        Stack<Double> test2 = new Stack<Double>();
		test2.push(1.0);
		test2.push(3.0);
		
		Stack<Double> test22 = new Stack<Double>();
		test22.push(1.0);
		test22.push(3.0);
		
		Stack<Double> test222 = new Stack<Double>();
		test222.push(1.0);
		test222.push(2.0);	
		
		assertTrue("check to see both Stacks are equals",test22.equals(test2));
		assertFalse("check to see both Stacks are equals",test2.equals(test222));
		assertTrue("check to see both Stacks are equals",test2.equals(test2));
       
		test2.pop();
        assertFalse("pop from test1 and expect not equal",test2.equals(test22));

	 
        Stack<Double> test2_ = new Stack<>();
		Stack<Double> test22_ = new Stack<>();
		assertFalse("check to see both empty Stacks are equals",test2_.equals(test22_));

        
  
	}

	@Test
	public void testCopy() {
		//fail("Not yet implemented");

		Stack<String> test1 = new Stack<>();
		test1.push("SAM");
		test1.push("Nancy");
		Stack<String> test1Copy = test1.copy();
		assertEquals(test1.peek(),test1Copy.peek());

		
		Stack<Double> test2 = new Stack<>();
		test2.push(1.23);
		test2.push(4.56);
		Stack<Double> test2Copy = test2.copy();
		assertEquals(test2.peek(),test2Copy.peek());
   
   
		test1.pop();
		test1.pop();
		Stack<String> test1Copy1 = test1.copy();
		assertTrue("emptying out stack",test1.empty());
		assertTrue("emptying out stack",test1Copy1.empty());


		test2.pop();
		test2.pop();
		Stack<Double> test2Copy2 = test2.copy();
		assertTrue("emptying out stack",test2.empty());
		assertTrue("emptying out stack",test2Copy2.empty());

		
		
	}

	@Test
	public void testToString() {
		//fail("Not yet implemented");
		Stack<String> test1 = new Stack<>();
		Stack<Double> test2 = new Stack<>();
		
		assertEquals("No element","",test1.toString());
		assertEquals("NO element","",test2.toString());
		
		
		test1.push("SAM");
		test2.push(1.23);

		assertEquals("one element","SAM,",test1.toString());
		assertEquals("one element","1.23,",test2.toString());

		test1.push("Nancy");
		test2.push(4.56);

		assertEquals("Two element","Nancy,SAM,",test1.toString());
		assertEquals("Two element","4.56,1.23,",test2.toString());
		
		
		
	}

}
