package com.aditya.ds.heap.patterns.node;
public class NullNode<T> extends NodeFactory<T> {
	public NullNode() {
		this._anObject = null;
		this._leftSubTree = null;
		this._rightSubTree = null;
	}
	@Override
	public boolean isNil() {
		return true;
	}
	@Override
	public int height(NodeFactory<T> aNode) {
		return 0;
	}
}
