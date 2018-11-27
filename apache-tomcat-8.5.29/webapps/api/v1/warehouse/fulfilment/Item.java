//Represents an item in an order
public class Item
{
	private int orderId;
	private int productId;
	private int quantity;
	private double costPerItem;
	public Item(int orderId, int productId, int quantity, double costPerItem)
	{
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.costPerItem = costPerItem;
	}
	public int getOrderId()
	{
		return orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}
	public int getProductId()
	{
		return productId;
	}
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public double getCostPerItem()
	{
		return costPerItem;
	}
	public void setCostPerItem(int costPerItem)
	{
		this.costPerItem = costPerItem;
	}
}