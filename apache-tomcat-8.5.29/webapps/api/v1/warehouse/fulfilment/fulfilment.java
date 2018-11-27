import java.util.ArrayList;
import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


public class Fulfilment
{
	//
	public String getFulfilment(String orderInput)
	{
		//Returns string of all unfulfilled orders.
		try
		{
			//Retrieves Products
			Product[] getProducts = returnProducts();
			//Retrieves Orders
			Order[] getOrders = returnOrders();
			//Retrieves argument orderId's as string array.
			String[] orderIdInput = orderInput.split(",");
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
			String returnString = "";
			
			for(int i = 0; i < getOrders.length; i++){
				if(getOrders[i].getStatus().equals("Error: Unfulfillable")){
					returnString += Long.toString(getOrders[i].getOrderId());
					returnString +=",";
				}
				
			}
			//Deletes last ","
			if(!(returnString.equals("")))
			{
				returnString = returnString.substring(0, returnString.length() - 1);
			}
			return returnString;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}
	private Order[] returnOrders() throws Exception
	{
		//Returns all orders stored in data.json as Order objects
		try
		{
			JSONParser parser = new JSONParser();
			JSONObject getData = (JSONObject) parser.parse(new FileReader("data.json"));
			JSONArray jsonproducts = (JSONArray) getData.get("orders");
			
			ArrayList<Order> orderList = new ArrayList<Order>();
			
			 
			for(Object getObject : jsonproducts)
			{
				//Creates objects and stores them in orderlist
				JSONObject getJSONObject = (JSONObject) getObject;
				
				long orderId = (long) getJSONObject.get("orderId");
				String status = (String) getJSONObject.get("status");
				String dateCreated = (String) getJSONObject.get("dateCreated");
				//Gets items
				JSONArray jsonitems = (JSONArray) getJSONObject.get("items");
				
				ArrayList<Item> itemList = new ArrayList<Item>();
				for(Object getItemObject : jsonitems)
				{	
					JSONObject getJSONItemObject = (JSONObject) getItemObject;
					long itemOrderId = (long) getJSONItemObject.get("orderId");
					long productId = (long) getJSONItemObject.get("productId");
					long quantity = (long) getJSONItemObject.get("quantity");
					double costPerItem = (double) getJSONItemObject.get("costPerItem");
					
					Item getItem = new Item(itemOrderId, productId, quantity, costPerItem);
					itemList.add(getItem);
				}
				Item[] items = itemList.toArray(new Item[itemList.size()]);
				
				Order getOrder = new Order(orderId, status, dateCreated, items);
				orderList.add(getOrder);
			}
			
			//Stores orderList as an array and returns this array.
			return orderList.toArray(new Order[orderList.size()]);
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		//returns null as default
		return null;
	}
	private Product[] returnProducts() throws Exception
	{
		//Returns all products stored in data.json as product objects
		try
		{
			JSONParser parser = new JSONParser();
			JSONObject getData = (JSONObject) parser.parse(new FileReader("data.json"));
			JSONArray jsonproducts = (JSONArray) getData.get("products");
			
			ArrayList<Product> productList = new ArrayList<Product>();
			
			
			for(Object getObject : jsonproducts)
			{
				//Creates objects and stores them in productlist
				JSONObject getJSONObject = (JSONObject) getObject;
				
				long productId = (long) getJSONObject.get("productId");
				String description = (String) getJSONObject.get("description");
				long quantityOnHand = (long) getJSONObject.get("quantityOnHand");
				long reorderThreshold = (long) getJSONObject.get("reorderThreshold");
				long reorderAmount = (long) getJSONObject.get("reorderAmount");
				long deliveryLeadTime = (long) getJSONObject.get("deliveryLeadTime");
				
				
				Product getProduct = new Product(productId, description, quantityOnHand, reorderThreshold, reorderAmount, deliveryLeadTime);
				productList.add(getProduct);
			}
			
			//Stores productList as an array and returns this array.
			return productList.toArray(new Product[productList.size()]);
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		//returns null as default
		return null;
	}
}