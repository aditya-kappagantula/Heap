package com.aditya.ds.heap.patterns.node;

public abstract class NodeFactory<T> {
	protected T _anObject;
	protected NodeFactory<T> _leftSubTree;
	protected NodeFactory<T> _rightSubTree;

	public T getData() {
		return _anObject;
	}

	public void setData(T data) {
		this._anObject = data;
	}

	public NodeFactory<T> getLeft() {
		return _leftSubTree;
	}

	public void setLeft(NodeFactory<T> leftSubTree) {
		this._leftSubTree = leftSubTree;
	}

	public NodeFactory<T> getRight() {
		return _rightSubTree;
	}

	public void setRight(NodeFactory<T> rightSubTree) {
		this._rightSubTree = rightSubTree;
	}

	public abstract boolean isNil();
	
	// public abstract void add(Object anObject, NodeFactory aNode);

	public abstract int height(NodeFactory<T> aNode);

}
