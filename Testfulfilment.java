public class Testfulfilment
{
	public static void main(String[] args)
	{
		Fulfilment thisFulfilment = new Fulfilment();
		try
		{
			System.out.println("Products");
			Product[] getProducts = thisFulfilment.returnProducts();
			for(int i = 0; i < getProducts.length; i++)
			{
				System.out.println("---");
				System.out.println(getProducts[i].getProductId());
				System.out.println(getProducts[i].getDescription());
				System.out.println(getProducts[i].getQuantityOnHand());
				System.out.println(getProducts[i].getReorderThreshold());
				System.out.println(getProducts[i].getReorderAmount());
				System.out.println(getProducts[i].getDeliveryLeadTime());
			}
			System.out.println("Orders");
			Order[] getOrders = thisFulfilment.returnOrders();
			for(int i = 0; i < getOrders.length; i++)
			{
				System.out.println("---");
				System.out.println(getOrders[i].getOrderId());
				System.out.println(getOrders[i].getStatus());
				System.out.println(getOrders[i].getDateCreated());
				Item[] getItemArray = getOrders[i].getItems();
				for(int i2 = 0; i2 < getItemArray.length; i2++){
					System.out.print(">Item ");
					System.out.println(i2);
					System.out.println(getItemArray[i2].getOrderId());
					System.out.println(getItemArray[i2].getProductId());
					System.out.println(getItemArray[i2].getQuantity());
					System.out.println(getItemArray[i2].getCostPerItem());
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println();
	}
}