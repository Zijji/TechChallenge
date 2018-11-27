import java.util.ArrayList;
//import java.io.BufferedReader;
import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


public class Fulfilment
{
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