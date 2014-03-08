package com.aditya.ds.heap.patterns.heap;

import java.util.Iterator;

public interface HeapStrategy<T> {
	public boolean add(T anObject);

	public String preOrderTraversal();

	public Iterator<T> iterator();

	public String toString();

	public Object[] toArray();

	public int size();

	public int height();

}
