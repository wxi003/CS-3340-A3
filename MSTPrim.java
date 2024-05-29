// minimum spanning tree implements Prim's Algorithm
import java.util.LinkedList;

public class MSTPrim {
	private int numVertices;
	LinkedList<Edge>[] edges;

	@SuppressWarnings("unchecked")
	MSTPrim(int v)
	{
		this.numVertices=v;
		edges = (LinkedList<Edge>[]) new LinkedList[numVertices];

		for (int i=0; i<numVertices; i++)
		{
			edges[i] = new LinkedList<>();
		}
	}

	public void addEdge (int v1, int v2, int weight)
	{
		Edge edge1 = new  Edge (v1-1,v2-1,weight);
		edges[v1-1].addFirst(edge1);
		
		Edge edge2 = new Edge (v2-1,v1-1,weight);
		edges[v2-1].addFirst(edge2);
	}

	public void MST()
	{
		nodesParent[] resSet = new nodesParent[numVertices];
		int[] key = new int[numVertices];
		nodeHeap[] heap = new nodeHeap[numVertices];

		for (int i =0; i<numVertices; i++)
		{
			heap[i]= new nodeHeap(i,Integer.MAX_VALUE);
			resSet[i]= new nodesParent(-1,Integer.MAX_VALUE);
			key[i] = Integer.MAX_VALUE;
		}

		heap[0].setKey(0);

		Heap minHeap = new Heap(heap, numVertices);

		while (!minHeap.isEmpty())
		{
			nodeHeap min = minHeap.delete_min();

			int minId = min.getId();
			minHeap.setInHeap(minId,false);

			//iterate 
			LinkedList<Edge> list = edges[minId];
            for (Edge edge : list) {
                // check if edge v2 is in the heap
                if (minHeap.in_heap(edge.getVertex2())) {
                    int dest = edge.getVertex2();
                    int newKey = edge.getWeight();

                    if (key[dest] > newKey) {
                        minHeap.decrease_key(dest, newKey);
                        // update parent
                        resSet[dest].setParentId(minId);
                        resSet[dest].setKey(newKey);
                        key[dest] = newKey;
                    }
                }
            }
			
		
		}
		printMST(resSet);
	}




	private void printMST(nodesParent[] resSet)
	{
		int totalWeight =0;
		System.out.println("Minimum Spanning Tree: ");
		for (int i=1; i< numVertices; i++)
		{
			System.out.println("Edge: " + (i+1) + "-" + (resSet[i].getParentId()+1) + " weight: "+ resSet[i].getWeight());
			totalWeight +=resSet[i].getWeight();
		}

		System.out.println("Total minimum key: " + totalWeight);
	}




}




