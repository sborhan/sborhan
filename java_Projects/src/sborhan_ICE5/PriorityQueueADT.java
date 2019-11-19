/*
 * Sam Borhan
 * CPSC 5003, Seattle University
 * Summer 2018
 * This is free and unencumbered software released into the public domain.
 */
package sborhan_ICE5;
/**
 * The priority queue enqueues items in any order, but the dequeue order
 * is determined by the natural ordering of the elements. The item dequeued
 * is always the minimum value of all the items currently in the priority
 * queue.
 * 
 * A priority queue does not permit null elements.
 * 
 * Note that some priority queue authors would call our 'enqueue' method 'offer'
 * and our 'dequeue' method 'poll'.
 * 
 * A priority queue has the same methods as a queue but the semantics of dequeue
 * (and correspondingly, peek) are different.
 * 
 * We encourage implementations to provide a default constructor and a constructor
 * that takes an iterable collection of T, especially if a faster all-at-once
 * construction algorithm exists (as it does with the Heap implementation of
 * priority queue).
 * 
 * @author sam borhan
 * @version 1.0
 * @param <T>  data type of each element in the priority queue
 */
public interface PriorityQueueADT<T> extends QueueADT<T> {

}
