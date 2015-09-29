import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement:
 * Application that should be returned in change if someone gives too much money to pay for an item.
 * 
 * @author Bijaya Rai
 */
public class ChangeCoins {
	
	//array containing types of coins
	private static int coins[]= {25,50,1,3,15,75};
	
	static double paidAmount= 10.80;
	static double priceOfItem= 1.19;
	
	
	public static void main(String[] args) {
		
	paidAmount= paidAmount-priceOfItem;
	
	paidAmount=Double.parseDouble(new DecimalFormat("##.##").format(priceOfItem));
	System.out.println("Change to be given: " + paidAmount);
	
	
	changeFinder(priceOfItem);
	
	}
	
	private static  void changeFinder(double x)
	{
		int sortedCoins[]=coinsInStockSort();//store the sorted coins list
	
		int inputinP=numDivider(x); // store the value of user input in penny measurement 
	
		//HasMap to store change and no of coins in a hashtable
		HashMap<String, Integer> changeValueHolder= new HashMap<>();
	
	//	System.out.println(inputinP);
		
		for(int i=sortedCoins.length-1;i!=-1;i--)
		{
			int valueToCompare= sortedCoins[i];
			
			if(inputinP>=valueToCompare&& inputinP!=0)
			{
				String key=Integer.toString(valueToCompare);
		
				
				
					if(!changeValueHolder.containsKey(key))
					{	//create new value key pair if key is absent in the table
						changeValueHolder.put(key, 1);
					}else
					{
						//update the value if the change to be given is repeated
						changeValueHolder.put(key, changeValueHolder.get(key) + 1);
					}
					inputinP=inputinP-valueToCompare;
					i=sortedCoins.length;
			}
			
			
			}
	
		System.out.println("Penny Change , No of penny");
		for (Map.Entry keyValuePair: changeValueHolder.entrySet())
		{
			System.out.println(keyValuePair.getKey()+"p  * "+ keyValuePair.getValue());
		}
	}

	private static int[] coinsInStockSort()
	{
		
	//	System.out.println(coins.length);
		for(int i=1; i<coins.length;i++)
		{
			int compareValue= coins[i];//store the value to be compared
			int j=i-1;
			
			/*	while the j > -1
				and
				value of variable in jth place > array value in ith place
				place the value 1 step forward in the array		  
			*/
			while((j>-1) && (coins[j]>compareValue))
			{
				coins[j+1]=coins[j];
				j--;
			}
			//insert the initial value "compareValue" on to the sorted list
			coins[j+1]=compareValue;
		}
		
		/*for(int a: sortedCoins)
		{
			System.out.println(a+" ");
		}
		*/
		
		return coins;
	}
	
	private static int numDivider(double numToDivide)
	{
		//System.out.println(numToDivide);
		
		int beforeDec = (int)numToDivide;
		
		double a=numToDivide-beforeDec;
		a=Double.parseDouble(new DecimalFormat("##.##").format(a));
		
		
		int suminP= (int) ((beforeDec*100)+(a*100));
		
		return suminP;
	}

}
