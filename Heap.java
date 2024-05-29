
public class Heap {
	private int size; 
	private boolean[] inHeap;
	private nodeHeap[] heap;
	private int[] indexes;

	public Heap(nodeHeap[] keys, int n)
	{
		this.heap = keys;
		size =n;
		indexes = new int [n];
		inHeap = new boolean[n];
		for (int i =0; i<n; i++)
		{
			indexes[i]=i;
			inHeap[i] = true;
		}
	}

	public boolean in_heap(int id)
	{
		return inHeap[id];
	}

	public nodeHeap min_key()
	{
		return heap[0];
	}

	public int min_id()
	{
		return heap[0].getId();
	}

	public int key (int id)
	{
		return (heap[indexes[id]].getKey());
	}
	public nodeHeap delete_min()
	{
		nodeHeap min = heap[0];
		nodeHeap lastNode = heap[size-1];
		indexes[lastNode.getId()]=0;
		heap[0] = lastNode;
		heap[size-1] = null;
		sinkDown(0);
		size--;
		return min;

	}

	public void decrease_key(int id, int new_key)
	{
		nodeHeap node = heap[indexes[id]];
		node.setKey(new_key);
		bubbleUp(indexes[id]);
	}

	private void bubbleUp(int id)
	{
		int parentId = (id)/2;
		int curId = id;

		while(curId>0 && heap[parentId].getKey()>heap[curId].getKey())
		{
			nodeHeap curNode = heap[curId];
			nodeHeap parentNode = heap[parentId];

			//swap
			indexes[curNode.getId()] = parentId;
			indexes[parentNode.getId()] = curId;
			swap(curId,parentId);
			curId = parentId;
			parentId = parentId/2;

		}
	}

	private void sinkDown(int val)
	{
		int min = val+1;
		int leftC = 2*(val+1);
		int rightC = 2*(val+1)+1;
		if (leftC<size && heap[min-1].getKey()>heap[leftC-1].getKey())
		{
			min = leftC;
		}
		if (rightC<size && heap[min-1].getKey()>heap[rightC-1].getKey())
		{
			min = rightC;
		}
		if (min != (val+1))
		{
			nodeHeap minNode = heap[min-1];
			nodeHeap kNode = heap[val];

			//swap
			indexes [minNode.getId()]=val;	
			indexes [kNode.getId()]=min-1;
			swap (val,min-1);
			sinkDown(min-1);
		}
	}

	public void setInHeap (int i, boolean set)
	{
		inHeap[i]=set;
	}
	private void swap (int a, int b)
	{
		nodeHeap temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	public  boolean isEmpty()
	{
		return size ==0;
	}
}


