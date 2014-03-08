package com.aditya.ds.heap.patterns.heap;
import java.util.Iterator;
public class Heap<T> {
	private HeapStrategy<T> _aHeapStrategy;
	public Heap() {
		this._aHeapStrategy = new MinHeap<T>();
	}
	public Heap(HeapStrategy<T> aHeapStrategy) {
		this._aHeapStrategy = aHeapStrategy;
	}
	public boolean add(T anObject) {
		return _aHeapStrategy.add(anObject);
	}
	public String preOrderTraversal() {
		return _aHeapStrategy.preOrderTraversal();
	}
	public Iterator<T> iterator() {
		return (_aHeapStrategy.iterator());
	}
	public String toString() {
		return (_aHeapStrategy.toString());
	}
	public Object[] toArray() {
		return (_aHeapStrategy.toArray());
	}
	public int size() {
		return (_aHeapStrategy.size());
	}
}
