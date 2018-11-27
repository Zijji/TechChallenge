public class Testfulfilment
{
	public static void main(String[] args)
	{
		Fulfilment thisFulfilment = new Fulfilment();
		try
		{
			Product[] getProducts = thisFulfilment.returnProducts();
			for(int i = 0; i < getProducts.length; i++)
			{
				System.out.println(getProducts[i].getProductId());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println();
	}
}