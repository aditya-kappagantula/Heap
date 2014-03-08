package com.aditya.ds.heap.patterns.heap;

import java.util.Iterator;

public abstract class HeapDecorator<T> extends HeapFactory<T> implements
		HeapStrategy<T> {
	protected final HeapFactory<T> aHeapFactory;

	public HeapDecorator(HeapFactory<T> aHeapFactory) {
		this.aHeapFactory = aHeapFactory;
	}

	public boolean add(T anObject) {
		return aHeapFactory.add(anObject);
	}

	public String preOrderTraversal() {
		return aHeapFactory.preOrderTraversal();
	}

	public abstract Iterator<T> iterator();

	public abstract String toString();

	public abstract Object[] toArray();

	public int size() {
		return aHeapFactory.size();
	}
}
