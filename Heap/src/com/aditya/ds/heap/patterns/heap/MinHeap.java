package com.aditya.ds.heap.patterns.heap;
import com.aditya.ds.heap.patterns.node.Node;
import com.aditya.ds.heap.patterns.node.NodeFactory;
import com.aditya.ds.heap.patterns.node.NullNode;

public class MinHeap<T> extends HeapFactory<T> implements HeapStrategy<T> {
	public MinHeap() {
		rootNode = new NullNode<T>();
	}
	@Override
	public boolean add(T anObject) {
		return add(anObject, rootNode);
	}
	public boolean add(T anObject, NodeFactory<T> root) {
		if (root.isNil()) {
			rootNode = new Node<T>(anObject);
			return true;
		} else {
			if (root.getData().toString().compareTo(anObject.toString()) >= 0) {
				T temporaryObject = root.getData();
				root.setData(anObject);
				anObject = temporaryObject;
			}
			if (root.height(root.getLeft()) <= root.height(root.getRight())) {
				if (root.getLeft().isNil()) {
					root.setLeft(new Node<T>(anObject));
				} else {
					root = root.getLeft();
					add(anObject, root);
				}
			} else {
				if (root.getRight().isNil()) {
					root.setRight(new Node<T>(anObject));
				} else {
					root = root.getRight();
					add(anObject, root);
				}
			}
			return true;
		}
	}
}