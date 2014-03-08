package com.aditya.ds.heap.patterns.node;


public class Node<T> extends NodeFactory<T> {

	public Node() {
		this._anObject = null;
		this._leftSubTree = new NullNode<T>();
		this._rightSubTree = new NullNode<T>();
	}

	public Node(T anObject) {
		this._anObject = anObject;
		this._leftSubTree = new NullNode<T>();
		this._rightSubTree = new NullNode<T>();
	}

	@Override
	public boolean isNil() {		
		return false;
	}

	@Override
	public int height(NodeFactory<T> aNode) {
		return 1 + Math.max(aNode.height(aNode.getLeft()),
				aNode.height(aNode.getRight()));
	}
	
}

