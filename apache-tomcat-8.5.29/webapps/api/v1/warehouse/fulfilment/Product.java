//Represents a product
public class Product
{
	private int productId;
	private String description;
	private int quantityOnHand;
	private int reorderThreshold;
	private int reorderAmount;
	private int deliveryLeadTime;
	public Product(int productId, String description, int quantityOnHand, int reorderThreshold, int reorderAmount, int deliveryLeadTime)
	{
		this.productId = productId;
		this.description = description;
		this.quantityOnHand = quantityOnHand;
		this.reorderThreshold = reorderThreshold;
		this.reorderAmount = reorderAmount;
		this.deliveryLeadTime = deliveryLeadTime;
	}
	public int getProductId()
	{
		return productId;
	}
	public void setProductId(int productId)
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
	public int getQuantityOnHand()
	{
		return quantityOnHand;
	}
	public void setQuantityOnHand(int quantityOnHand)
	{
		this.quantityOnHand = quantityOnHand;
	}
	public int getReorderThreshold()
	{
		return reorderThreshold;
	}
	public void setReorderThreshold(int reorderThreshold)
	{
		this.reorderThreshold = reorderThreshold;
	}
	public int getReorderAmount()
	{
		return reorderAmount;
	}
	public void setReorderAmount(int reorderAmount)
	{
		this.reorderAmount = reorderAmount;
	}
	public int getDeliveryLeadTime()
	{
		return deliveryLeadTime;
	}
	public void setDeliveryLeadTime(int deliveryLeadTime)
	{
		this.deliveryLeadTime = deliveryLeadTime;
	}
}