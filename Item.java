//Represents an item in an order
public class Item
{
	private long orderId;
	private long productId;
	private long quantity;
	private double costPerItem;
	public Item(long orderId, long productId, long quantity, double costPerItem)
	{
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.costPerItem = costPerItem;
	}
	public long getOrderId()
	{
		return orderId;
	}
	public void setOrderId(long orderId)
	{
		this.orderId = orderId;
	}
	public long getProductId()
	{
		return productId;
	}
	public void setProductId(long productId)
	{
		this.productId = productId;
	}
	public long getQuantity()
	{
		return quantity;
	}
	public void setQuantity(long quantity)
	{
		this.quantity = quantity;
	}
	public double getCostPerItem()
	{
		return costPerItem;
	}
	public void setCostPerItem(long costPerItem)
	{
		this.costPerItem = costPerItem;
	}
}