
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
		System.out.println(thisFulfilment.getFulfilment(args[0]));
	}
}