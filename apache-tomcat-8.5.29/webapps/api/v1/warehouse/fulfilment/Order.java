//Represents an order
public class Order
{
	private int orderId;
	private String status;
	private String dateCreated;
	private Item[] items;
	public Order(int orderId, String status,String dateCreated, Item[] items)
	{
		this.orderId = orderId;
		this.status = status;
		this.dateCreated = dateCreated;
		this.items = items;
	}
	public int getOrderId()
	{
		return orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getDateCreated()
	{
		return dateCreated;
	}
	public void setDateCreated(String dateCreated)
	{
		this.dateCreated = dateCreated;
	}
	public Item[] getItems()
	{
		return items;
	}
	public void setItems(Item[] items)
	{
		this.items = items;
	}
}