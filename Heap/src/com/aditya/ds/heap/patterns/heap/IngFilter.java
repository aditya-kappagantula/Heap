package com.aditya.ds.heap.patterns.heap;
import java.util.Iterator;
import java.util.Stack;

import com.aditya.ds.heap.patterns.node.NodeFactory;

public class IngFilter<T> implements Iterator<T> {
	private static final String FILTER = "ing";
	protected NodeFactory<T> rootNode;
	protected Stack<NodeFactory<T>> nodesList = new Stack<NodeFactory<T>>();

	public IngFilter(NodeFactory<T> aNode) {
		this.rootNode = aNode;
		nodesList = new Stack<NodeFactory<T>>();
	}
	@Override
	public boolean hasNext() {
		return (rootNode != null);
	}
	@Override
	public T next() {
		if (nodesList.empty()) {
			// push all nodes till last left node
			traverseLeftEnd(rootNode);
		}
		T nextElement = null;
		while (nextElement == null) {
			NodeFactory<T> aNode = nodesList.pop();
			if (aNode.getData().toString().endsWith(FILTER)) {
				nextElement = aNode.getData();
			}
			// if the node has a right child, traverse till its left end
			if (!aNode.getRight().isNil()) {
				NodeFactory<T> right = aNode.getRight();
				traverseLeftEnd(right);
				// Traverse right of a right child only if it has more elements
				if (!right.getRight().isNil()) {
					traverseLeftEnd(right.getRight());
				}
			}
			if (nodesList.empty()) {
				rootNode = null;
			}
		}
		return nextElement;
	}

	private void traverseLeftEnd(NodeFactory<T> aNode) {
		if (!aNode.getLeft().isNil()) {
			if (aNode.getData().toString().endsWith(FILTER)) {
				nodesList.push(aNode);
			}
			traverseLeftEnd(aNode.getLeft());
		}
		// boundary condition for last leaf node
		if (aNode.getLeft().isNil() && aNode.getData() != null) {
			if (aNode.getData().toString().endsWith(FILTER)) {
				nodesList.push(aNode);
			}
		}
	}

	@Override
	public void remove() {

	}
}
