Heap
====

An Object Oriented Heap Tree implementation with Null, Iterator, Strategy and Decorator Patterns.
Created for an assignment in the course Object Oriented Programming and Design [CS635, Spring 2014] handled by Prof. Roger Whitney at the San Diego State University, San Diego. 

#Heap Addition Logic:
* To add a new value to the heap add it to the top of the heap.
* If the heap is empty the new value becomes the root. 
* If heap is not empty then the smaller of the two values (current value in heap and the new value) is kept in the root.
* The larger of the two values is added the sub-heap with the smallest height. 
* If both sub-heaps have the same height then the larger of the two values is added to the left heap. 
* The process is repeated until a value is added to a new node at the bottom of the heap.
