//import java.util.ArrayList;
//import java.io.BufferedReader;
import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Fulfilment
{
	public void read() throws Exception
	{
		//Reads all lines from data.json
		try
		{
			JSONParser parser = new JSONParser();
			JSONObject getData = (JSONObject) parser.parse(new FileReader("data.json"));
			//JSONArray getJSONArray = (JSONArray) parser.parse(new FileReader("data.json"));
			JSONArray products = (JSONArray) getData.get("products");
			
			for(Object getObject : products)
			{
				JSONObject getJSONObject = (JSONObject) getObject;
				
				String description = (String) getJSONObject.get("description");
				System.out.print(description);
			}
			//System.out.print(getJSONArray.get(1));
			/*
			for(Object o : getJSONArray.get(1);)
			{
				
			}
			*/
			/*
			JSONArray getProducts = getJSONArray.get("products");
			String description = getProducts.get("description");
			System.out.println(description);
			*/
			/*
			for(Object o : getJSONArray)
			{
				JSONObject thisObject = (JSONObject) o;
			}
			*/
			/*
			BufferedReader dataReader = new BufferedReader(new FileReader("data.json"));
			String getLine = dataReader.readLine();
			ArrayList<String> getList = new ArrayList<String>();
			
			while(getLine != null)
			{
				getList.add(getLine);
			}
			*/
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
		//String[] returnList = 
	}
}