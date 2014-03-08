package com.aditya.ds.heap.patterns.heap;
import java.util.AbstractCollection;
import java.util.Iterator;

import com.aditya.ds.heap.patterns.node.NodeFactory;

public abstract class HeapFactory<T> extends AbstractCollection<T> {
	protected NodeFactory<T> rootNode;
	public abstract boolean add(T anObject);
	public int height() {
		return height(rootNode);
	}
	private int height(NodeFactory<T> root) {
		return rootNode.height(rootNode);
	}
	public String preOrderTraversal() {
		return preOrderTraversal(rootNode);
	}
	private String preOrderTraversal(NodeFactory<T> aNode) {
		if (aNode.isNil())
			return "";
		return aNode.getData() + " " + preOrderTraversal(aNode.getLeft())
				+ preOrderTraversal(aNode.getRight());
	}
	private String toString(NodeFactory<T> aNode) {
		String heapString = "";
		for (Iterator<T> i = iterator(); i.hasNext();) {
			heapString = heapString + i.next() + " ";
		}
		return heapString;
	}
	@Override
	public String toString() {
		return toString(rootNode);
	}
	private Object[] toArray(NodeFactory<T> aNode) {
		Object[] treeArray = new Object[size()];
		int index = 0;
		for (Iterator<T> i = iterator(); i.hasNext();) {
			treeArray[index] = i.next();
			index++;
		}
		return treeArray;
	}
	public Object[] toArray() {
		return toArray(rootNode);
	}
	@Override
	public int size() {
		return size(rootNode);
	}
	private int size(NodeFactory<T> aNode) {
		int count = 0;
		for (Iterator<T> i = iterator(); i.hasNext();) {
			i.next();
			count++;
		}
		return count;
	}
	public Iterator<T> iterator() {
		return (new HeapIterator<T>(rootNode));
	}
}
