public class Testfulfilment
{
	public static void main(String[] args)
	{
		Fulfilment thisFulfilment = new Fulfilment();
		try
		{
			thisFulfilment.read();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println();
	}
}