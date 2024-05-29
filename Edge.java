// This class defines an edge node for use in the graph.
public class Edge {
	private int vertex1;
	private int vertex2;
	private int weight;
	
	public Edge (int vertex1, int vertex2, int weight)
	{
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
		
	}
	public int getVertex2()
	{
		return vertex2;
	}

	public int getVertex1() {
		return vertex1;
	}

	public int getWeight()
	{
		return weight;
	}

}
