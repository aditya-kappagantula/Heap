package com.aditya.ds.heap.patterns.heap;

import java.util.Iterator;

public class IngHeapDecorator<T> extends HeapDecorator<T> {

	public IngHeapDecorator(HeapFactory<T> aHeapFactory) {
		super(aHeapFactory);
	}

	public Iterator<T> iterator() {
		return (new IngFilter<T>(aHeapFactory.rootNode));
	}
	
	public String toString() {
		String heapString = "";
		for (Iterator<T> i = iterator(); i.hasNext();) {
			heapString = heapString + " " + i.next();
		}
		return heapString;
	}

	public Object[] toArray() {
		int index = 0;
		
		for (Iterator<T> i = iterator(); i.hasNext();) {
			i.next();
			index++;
		}
		Object[] treeArray = new Object[index];
		index = 0;
		for (Iterator<T> i = iterator(); i.hasNext();) {
			treeArray[index] = i.next();
			index++;
		}
		return treeArray;
	}
}
