// this class represents the parent node
public class nodesParent {
	private int parentID;
	private int key;
	
	nodesParent(int parentID, int key)
	{
		this.parentID = parentID;
		this.key = key;
	}
	public void setParentId(int id)
	{
		parentID=id;
	}
	public void setKey(int key)
	{
		this.key=key;
	}

	public int getParentId()
	{
		return parentID;
	}
	public int getWeight()
	{
		return key;
	}
	
}
