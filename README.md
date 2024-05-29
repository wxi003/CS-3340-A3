# CS 3340 - Analysis of Algorithms - Western University
## Assignment 3
Implement the Prim’s minimum spanning tree algorithm for a weighted undirected graph
using a heap data structure. The time complexity of the algorithm is O((|V | +
|E|) log |V |).

### Functions
- heap(keys, n): initializes a heap with the array keys of n elements. Element id is
assumed to be the index of the array.
- in_heap(id): returns true if the element with id is in the heap;
- is_empty(): return true if heap is empty.
- min_key(): returns the minimum key of the heap;
- min_id(): returns the id of the element with minimum key in the heap;
- key(id): returns the key of the element with id in the heap;
- delete_min(): deletes the element with minimum key from the heap;
- decrease_key(id, new key): sets the key of the element with id to new key if its current
key is greater than new key.

### The format of the input file is the following:
The first line of the input file contains an integer, n, indicating the number of vertices
of the input graph.
<br>Each of the remaining lines contains a triple ”i j w”, where 1 ≤ i, j ≤ n, indicating an
edge between vertex i and vertex j with weight w.
