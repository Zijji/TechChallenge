//Represents a product
public class Product
{
	private long productId;
	private String description;
	private long quantityOnHand;
	private long reorderThreshold;
	private long reorderAmount;
	private long deliveryLeadTime;
	public Product(long productId, String description, long quantityOnHand, long reorderThreshold, long reorderAmount, long deliveryLeadTime)
	{
		this.productId = productId;
		this.description = description;
		this.quantityOnHand = quantityOnHand;
		this.reorderThreshold = reorderThreshold;
		this.reorderAmount = reorderAmount;
		this.deliveryLeadTime = deliveryLeadTime;
	}
	public long getProductId()
	{
		return productId;
	}
	public void setProductId(long productId)
	{
		this.productId = productId;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public long getQuantityOnHand()
	{
		return quantityOnHand;
	}
	public void setQuantityOnHand(long quantityOnHand)
	{
		this.quantityOnHand = quantityOnHand;
	}
	public long getReorderThreshold()
	{
		return reorderThreshold;
	}
	public void setReorderThreshold(long reorderThreshold)
	{
		this.reorderThreshold = reorderThreshold;
	}
	public long getReorderAmount()
	{
		return reorderAmount;
	}
	public void setReorderAmount(long reorderAmount)
	{
		this.reorderAmount = reorderAmount;
	}
	public long getDeliveryLeadTime()
	{
		return deliveryLeadTime;
	}
	public void setDeliveryLeadTime(long deliveryLeadTime)
	{
		this.deliveryLeadTime = deliveryLeadTime;
	}
}