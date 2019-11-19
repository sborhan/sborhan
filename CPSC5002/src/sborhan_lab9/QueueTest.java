/*
 * Sam Borhan
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */


package sborhan_lab9;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

/*
 * class QueueTest
 * Junit testing all methods of Queue class
 */
public class QueueTest {

	@Test
	public void testAppend() {
		//fail("Not yet implemented");
		Queue<String> test1 = new Queue<>();
		test1.enqueue("Sam,");
		Queue<String> test11 = new Queue<>();
		test11.enqueue("Nancy");
		test1.append(test11);
		String str="";
		while(!test1.empty()) {
			str += test1.dequeue();
		}
        assertEquals("Sam,Nancy",str);
        
        
        
        str="";
        Queue<String> test111 = new Queue<>();
        test111.enqueue("Sam,");
		Queue<String> test1111 = new Queue<>();
		test1111.append(test111);
		while(!test1111.empty()) {
			str += test1111.dequeue();
		}
        assertEquals("Sam,",str);
        
    
        
        str="";
        Queue<String> test_111 = new Queue<>();
        test_111.enqueue("Sam,");
		Queue<String> test_1111 = new Queue<>();
		test_111.append(test_1111);
		while(!test_111.empty()) {
			str += test_111.dequeue();
		}
        assertEquals("Sam,",str);
        
        
        
        str="";
        Queue<String> test_1 = new Queue<>();
		Queue<String> test_11 = new Queue<>();
		test_1.append(test_11);
	
  
        
        Queue<Double> test2 = new Queue<>();
		test2.enqueue(1.23);
		Queue<Double> test22 = new Queue<>();
		test22.enqueue(4.56);
		test2.append(test22);
		String str2 ="";
		while(!test2.empty()) {
			str2 += test2.dequeue()+",";
		}
        assertEquals("1.23,4.56,",str2);
        
		
		
        
        Queue<Double> test222 = new Queue<>();
        test222.enqueue(1.23);
		Queue<Double> test2222 = new Queue<>();
		test222.append(test2222);
		 str2 ="";
		while(!test222.empty()) {
			str2 += test222.dequeue()+",";
		}
        assertEquals("1.23,",str2);
        
        
        
        
        Queue<Double> test_222 = new Queue<>();
		Queue<Double> test_2222 = new Queue<>();
        test_2222.enqueue(1.23);

		test_222.append(test_2222);
		 str2 ="";
		while(!test_222.empty()) {
			str2 += test_222.dequeue()+",";
		}
        assertEquals("1.23,",str2);
        
        
        
        Queue<Double> test_222_ = new Queue<>();
		Queue<Double> test_2222_ = new Queue<>();
        test_2222_.enqueue(1.23);

		test_2222_.append(test_222_);
		 str2 ="";
		while(!test_2222_.empty()) {
			str2 += test_2222_.dequeue()+",";
		}
        assertEquals("1.23,",str2);
        
        
        str="";
        Queue<Double> test_1_ = new Queue<>();
		Queue<Double> test_11_ = new Queue<>();
		test_1_.append(test_11_);
		while(!test_1_.empty()) {
			str += test_1_.dequeue();
		}
        assertEquals("",str);

        
	}

	@Test
	public void testEqualsQueueOfT() {
		//fail("Not yet implemented");
               Queue<String> test0 = new Queue<>();
               Queue<String> test0_ = new Queue<>();
               assertFalse("",test0.equals(test0_));

               Queue<Double> test10_ = new Queue<>();
               Queue<Double> test110_ = new Queue<>();
               assertFalse("",test10_.equals(test110_));

	
		
		        Queue<String> test1 = new Queue<>();
				test1.enqueue("Sam");
				test1.enqueue("Nancy");
				
				Queue<String> test11 = new Queue<>();
				test11.enqueue("Sam");
				test11.enqueue("Nancy");
				
				Queue<String> test111 = new Queue<>();
				test111.enqueue("Sam111");
				test111.enqueue("Nancy111");	
				
				assertFalse("check to see both Queue are equals",test1.equals(test111));
				assertTrue("check to see both Queue are equals",test1.equals(test11));
		        
				test1.dequeue();
		        assertFalse("dequeue from test1 and expect not equal",test1.equals(test11));

		        Queue<String> test1_ = new Queue<>();
		        Queue<String> test11_ = new Queue<>();
				assertFalse("check to see both empty Queue are equals",test1_.equals(test11_));

		        
		        Queue<Double> test2 = new Queue<Double>();
				test2.enqueue(1.0);
				test2.enqueue(3.0);
				
				Queue<Double> test22 = new Queue<Double>();
				test22.enqueue(1.0);
				test22.enqueue(3.0);
				
				Queue<Double> test222 = new Queue<Double>();
				test222.enqueue(1.0);
				test222.enqueue(2.0);	
				assertTrue("check to see both Queue are equals",test22.equals(test2));
				assertFalse("check to see both Queue are equals",test2.equals(test222));

				assertTrue("check to see both Queue are equals",test2.equals(test2));
		        test2.dequeue();
		        assertFalse("pop from test1 and Queue not equal",test2.equals(test22));

		        Queue<Double> test1_1 = new Queue<>();
		        Queue<Double> test11_1 = new Queue<>();
				assertFalse("check to see both empty Queue are equals",test1_1.equals(test11_1));

		        
	}

	@Test
	public void testCopy() {
		//fail("Not yet implemented");

		Queue<String> test1 = new Queue<>();
		test1.enqueue("SAM");
		test1.enqueue("Nancy");
		Queue<String> test1Copy = test1.copy();
		assertEquals(test1.peek(),test1Copy.peek());

		
		Queue<Double> test2 = new Queue<>();
		test2.enqueue(1.23);
		test2.enqueue(4.56);
		Queue<Double> test2Copy = test2.copy();
		assertEquals(test2.peek(),test2Copy.peek());


		test1.dequeue();
		test1.dequeue();
		Queue<String> test1Copy1 = test1.copy();
		assertTrue("emptying out Queue",test1.empty());
		assertTrue("emptying out Queue",test1Copy1.empty());


		test2.dequeue();
		test2.dequeue();
		Queue<Double> test2Copy2 = test2.copy();
		assertTrue("emptying out Queue",test2.empty());
		assertTrue("emptying out Queue",test2Copy2.empty());



	}

	@Test
	public void testPeek() {
		//fail("Not yet implemented");
		
		Queue<String> test1 = new Queue<>();
		Queue<Double> test2 = new Queue<>();
		try {
			test1.peek();
			fail("Should catch the Exception");
		}catch( EmptyStackException e){
			//catch exception
		}
		
		try {
			test2.peek();
			fail("Should catch the Exception");
		}catch( EmptyStackException e){
			//catch exception
		}
		
		
		test1.enqueue("SAM");
		test1.enqueue("Nancy");
		assertEquals("SAM",test1.peek());

		test2.enqueue(1.23);
		test2.enqueue(4.56);
		assertEquals(new Double(1.23),test2.peek());

		
		test1.dequeue();
		assertEquals("Nancy",test1.peek());
		

		test2.dequeue();
		assertEquals(new Double(4.56),test2.peek());
		
		test1.dequeue();
		assertTrue("after push/push/pop/pop",test1.empty());
		
		test2.dequeue();
		assertTrue("after push/push/pop/pop",test2.empty());

		
		
		
		
	}

	@Test
	public void testDequeue() {
		//fail("Not yet implemented");
				Queue<String> test1 = new Queue<>();
				Queue<Double> test2 = new Queue<>();
				
         try {
        	 test1.dequeue() ;
        	 fail("should catch the ecception on empty Queue");
            }catch(IllegalArgumentException e) {
            	//catch the exception
            }
         
         try {
        	 test2.dequeue() ;
        	 fail("should catch the ecception on empty Queue");
            }catch(IllegalArgumentException e) {
            	//catch the exception
            }
         
			
				test1.enqueue("SAM");
				test1.enqueue("Nancy");
				test2.enqueue(1.23);
				test2.enqueue(4.56);
				
				test1.dequeue();
				test2.dequeue();
				assertEquals("Nancy" ,test1.peek());
				assertEquals(new Double(4.56),test2.peek());
         
				test1.dequeue();
				test2.dequeue();
				assertTrue("after enqueue/enqueue/dequeue/dequeue",test1.empty());
				assertTrue("after enqueue/enqueue/dequeue/dequeue",test2.empty());
            
	}

	@Test
	public void testEnqueue() {
		//fail("Not yet implemented");
		Queue<String> test1 = new Queue<>();
		Queue<Double> test2 = new Queue<>();

		test1.enqueue("SAM");
		test1.enqueue("Nancy");

		test2.enqueue(1.23);
		
		assertEquals("SAM",test1.peek());
		assertEquals(new Double(1.23),test2.peek());
		
		
	}

	@Test
	public void testToString() {
		//fail("Not yet implemented");
				Queue<String> test1 = new Queue<>();
				Queue<Double> test2 = new Queue<>();
				
				assertEquals("no element","",test1.toString());
				assertEquals("no element","",test2.toString());
				

				test1.enqueue("SAM");
				test2.enqueue(1.23);

				assertEquals("one element","SAM,",test1.toString());
				assertEquals("one element","1.23,",test2.toString());

				test1.enqueue("Nancy");
				test2.enqueue(4.56);

				assertEquals("Two element","SAM,Nancy,",test1.toString());
				assertEquals("Two element","1.23,4.56,",test2.toString());
				
				
	}

	@Test
	public void testEmpty() {
		//fail("Not yet implemented");
		Queue<String> test1 = new Queue<>();
		Queue<Double> test2 = new Queue<>();

		
		
		assertTrue("after construction",test1.empty());
		assertTrue("after construction",test2.empty());

		
		
		test1.enqueue("SAM");
		test2.enqueue(1.23);
		assertFalse("after a String push",test1.empty());
		assertFalse("after a double push",test2.empty());

		
        test1.dequeue();
        test2.dequeue();
		assertTrue("after push/pop",test1.empty());
		assertTrue("after push/peek",test2.empty());



	}

}
