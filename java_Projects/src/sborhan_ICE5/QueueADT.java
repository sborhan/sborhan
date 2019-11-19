package sborhan_ICE5;

import java.util.EmptyStackException;

public interface QueueADT<T> {
	public boolean empty();
	public void enqueue(T element);
	public T peek() throws EmptyStackException;
	public T dequeue() throws EmptyStackException;
}
