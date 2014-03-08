package com.aditya.ds.heap.patterns.heap;
import java.util.Iterator;
import java.util.Stack;

import com.aditya.ds.heap.patterns.node.NodeFactory;

public class HeapIterator<T> implements Iterator<T> {
	protected NodeFactory<T> rootNode;
	protected Stack<NodeFactory<T>> nodesList = new Stack<NodeFactory<T>>();
	protected Stack<Boolean> rightChildStatusList = new Stack<Boolean>();

	public HeapIterator(NodeFactory<T> aNode) {

		this.rootNode = aNode;
		nodesList = new Stack<NodeFactory<T>>();
		rightChildStatusList = new Stack<Boolean>();
	}
	@Override
	public boolean hasNext() {
		return (rootNode != null);
	}
	@Override
	public T next() {
		if (!hasNext()) {
			throw new java.util.NoSuchElementException("End of Tree!");
		}
		if (nodesList.empty()) {
			// push all nodes till last left node
			traverseLeftEnd(rootNode);
		}
		NodeFactory<T> aNode = nodesList.pop();
		T nextElement = aNode.getData();
		// if the node has a right child, traverse till its left end
		if (!aNode.getRight().isNil()) {
			NodeFactory<T> right = aNode.getRight();
			traverseLeftEnd(right);
		}
		if (nodesList.empty()) {
			rootNode = null;
		}
		return nextElement;
	}
	private void traverseLeftEnd(NodeFactory<T> aNode) {
		// find the leftmost node
		if (aNode.getLeft() != null && aNode.getRight() != null) {
			nodesList.push(aNode); // push this node
			traverseLeftEnd(aNode.getLeft()); // recurse on next left node
		}
	}

	@Override
	public void remove() {

	}

}
