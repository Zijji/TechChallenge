//
import java.util.ArrayList;
public class FulfilmentClient
{
	//Example Input: java FulfilmentClient 1122,1123,1124,1125
	public static void main(String[] args)
	{
		//Exits program if argument count is invalid.
		if(args.length != 1)
		{
			System.out.println("Format: java Fulfilment (orderId1,orderId2,...)");
			System.out.println("e.g. java Fulfilment 1122,1123,1124,1125");
			System.exit(0);
		}
		//Checks argument count
		Fulfilment thisFulfilment = new Fulfilment();
		try
		{
			//Retrieves Products
			Product[] getProducts = thisFulfilment.returnProducts();
			//Retrieves Orders
			Order[] getOrders = thisFulfilment.returnOrders();
			//Retrieves argument orderId's as string array.
			String[] orderIdInput = args[0].split(",");
			//Assumes input orders are valid.
			
			//For each order id input, processes order and retrieves orders that cannot be fulfilled.
			ArrayList<Order> unfulfillableOrders = new ArrayList<Order>();
			
			for(int i = 0; i < orderIdInput.length; i++)
			{
				//Assumes the input orderId's to be present in orders, and that all orders have unique IDs
				for(int i1 = 0; i1 < getOrders.length; i1++)
				{
					if(getOrders[i1].getOrderId() == Long.parseLong(orderIdInput[i]))
					{
						//Decrements all stored products by order.
						//Retrieves each item in order.
						Item[] orderItems = getOrders[i].getItems();
						for(int i2 = 0; i2 < orderItems.length; i2++){
							//Retrives product ids, decrements products by product ID's.
							//First checks for orders.
							for(int i3 = 0; i3 < getProducts.length; i3++){
								//Retrives product ids, decrements products by product ID's.
								if(orderItems[i2].getProductId() == getProducts[i3].getProductId()){
									if(getProducts[i3].getQuantityOnHand() < orderItems[i2].getQuantity())
									{
										getOrders[i1].setStatus("Error: Unfulfillable");
									}
								}
							}
							if(getOrders[i1].getStatus().equals("Pending")){
								//If order is fulfilled, decrements product quantities.
								for(int i3 = 0; i3 < getProducts.length; i3++){
									//Retrives product ids, decrements products by product ID's.
									if(orderItems[i2].getProductId() == getProducts[i3].getProductId()){
										getProducts[i3].setQuantityOnHand( getProducts[i3].getQuantityOnHand() - orderItems[i2].getQuantity() );
										//TODO: Checks reorder threshold, places reorder if productQuantity is less than order quantity.
										if(getProducts[i3].getQuantityOnHand() < getProducts[i3].getReorderThreshold())
										{
											ReorderStub newReorder = new ReorderStub(getProducts[i3].getProductId(), getProducts[i3].getReorderAmount());
										}
									}
								}
								//
								getOrders[i1].setStatus("Fulfilled");
							}
						}
					}
				}
			}
			
			for(int i = 0; i < getOrders.length; i++){
				System.out.println(getOrders[i].getStatus());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}