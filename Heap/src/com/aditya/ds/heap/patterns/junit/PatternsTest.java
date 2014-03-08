package com.aditya.ds.heap.patterns.junit;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

import com.aditya.ds.heap.patterns.heap.Heap;
import com.aditya.ds.heap.patterns.heap.HeapFactory;
import com.aditya.ds.heap.patterns.heap.IngHeapDecorator;
import com.aditya.ds.heap.patterns.heap.MaxHeap;
import com.aditya.ds.heap.patterns.heap.MinHeap;

public class PatternsTest {
	@Test
	public void testStrategyPatternForMinHeap() {
		Heap<String> aHeap = new Heap<String>(new MinHeap<String>());
		aHeap.add("aing");
		aHeap.add("b");
		aHeap.add("cing");
		aHeap.add("d");
		aHeap.add("e");
		assertEquals("Heap toString", "d b aing e cing ", aHeap.toString());
	}
	@Test
	public void testStrategyPatternForMaxHeap() {
		Heap<String> aHeap = new Heap<String>(new MaxHeap<String>());
		aHeap.add("aing");
		aHeap.add("b");
		aHeap.add("cing");
		aHeap.add("d");
		aHeap.add("e");
		assertEquals("Heap toString", "aing cing e b d ", aHeap.toString());
	}
	@Test
	public void testDecoratorPattern() {
		// This tests the ING Filter also.
		HeapFactory<String> aHeapFactory = new MinHeap<String>();
		aHeapFactory = new IngHeapDecorator<String>(aHeapFactory);
		aHeapFactory.add("aing");
		aHeapFactory.add("bing");
		aHeapFactory.add("c");
		aHeapFactory.add("d");
		aHeapFactory.add("e");
		aHeapFactory.add("fing");
		aHeapFactory.add("g");
		aHeapFactory.add("hing");
		assertEquals("Heap Preorder Traversal", "aing bing d g fing c e hing ",
		aHeapFactory.preOrderTraversal());
		assertEquals("Heap Inorder traversal and only ING ending strings",
		" bing fing aing hing", aHeapFactory.toString());
		Iterator<String> i = aHeapFactory.iterator();
		assertEquals("Decorator Iterator Filter Test", "bing", i.next());
		assertEquals("Decorator Iterator Filter Test", "fing", i.next());
	}

	@Test
	public void testHeapIterator() {
		Heap<String> aHeap = new Heap<String>();
		aHeap.add("a");
		aHeap.add("b");
		aHeap.add("c");
		aHeap.add("d");
		aHeap.add("e");
		Iterator<String> i = aHeap.iterator();
		String inOrderTraversal = "";
		while (i.hasNext()) {
			inOrderTraversal = inOrderTraversal + i.next() + " ";
		}
		assertEquals("Heap Iterator", "d b a e c ", inOrderTraversal);
	}
}
