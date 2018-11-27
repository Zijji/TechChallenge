public class ReorderStub
{
	//Generates a new purchase order.
	private long productId;
	private long reorderAmount;
	
	public ReorderStub(long productId, long reorderAmount){
		this.productId = productId;
		this.reorderAmount = reorderAmount;
	}
}