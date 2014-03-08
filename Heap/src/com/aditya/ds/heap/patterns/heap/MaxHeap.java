package com.aditya.ds.heap.patterns.heap;
import com.aditya.ds.heap.patterns.node.Node;
import com.aditya.ds.heap.patterns.node.NodeFactory;
import com.aditya.ds.heap.patterns.node.NullNode;

public class MaxHeap<T> extends HeapFactory<T> implements HeapStrategy<T> {
	public MaxHeap() {
		rootNode = new NullNode<T>();
	}
	@Override
	public boolean add(T anObject) {
		return add(anObject, rootNode);
	}
	public boolean add(T anObject, NodeFactory<T> aNode) {
		if (aNode.isNil()) {
			rootNode = new Node<T>(anObject);
			return true;
		} else {
			if (aNode.getData().toString().compareTo(anObject.toString()) <= 0) {
				// new string lexicographically smaller than node
				T temporaryObject = aNode.getData();
				aNode.setData(anObject);
				anObject = temporaryObject;
			}
			if (aNode.height(aNode.getLeft()) <= aNode.height(aNode.getRight())) {
				if (aNode.getLeft().isNil()) {
					aNode.setLeft(new Node<T>(anObject));
				} else {
					aNode = aNode.getLeft();
					add(anObject, aNode);
				}
			} else {
				if (aNode.getRight().isNil()) {
					aNode.setRight(new Node<T>(anObject));
				} else {
					aNode = aNode.getRight();
					add(anObject, aNode);
				}
			}
			return true;
		}
	}
}
