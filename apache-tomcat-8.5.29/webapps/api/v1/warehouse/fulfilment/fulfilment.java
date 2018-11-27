import java.util.ArrayList;
import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


public class Fulfilment
{
	public Order[] returnOrders() throws Exception
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
	public Product[] returnProducts() throws Exception
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