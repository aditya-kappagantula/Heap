package com.aditya.ds.heap.patterns.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.aditya.ds.heap.patterns.node.Node;
import com.aditya.ds.heap.patterns.node.NodeFactory;

	public class NodeTest {
		@Test
		public void testNode() {
		assertEquals("Creating a node with value", "3",
				(new Node<String>("3")).getData());
		assertEquals("Testing an empty left subtree", null,
				(new Node<String>("3")).getLeft());
		assertEquals("Testing an empty right subtree", null,
				(new Node<String>("3")).getRight());
		}

		@Test
		public void testHeight() {
		NodeFactory<String> aNode = new Node<String>("3");
		assertEquals("Node Height Test", 2, (aNode.height(aNode)));
		}

}
