
import java.util.*;

public class Odd_Even{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int arr []=new int[10];
		int oddarray[]=new int[5];
		int evenarray[]=new int[5];
		int i;
		for(i=0;i<10;i++)
		{
			System.out.println("Enter element at "+(i+1));
			arr[i]=sc.nextInt();
		}
		int j=0,k=0;
		for(i=0;i<10;i++)
		{	
			if(arr[i]%2!=0)
			{
				oddarray[j]=arr[i]*arr[i];
				j++;
			}
			else
			{
				evenarray[k]=arr[i]*arr[i]*arr[i];
				k++;
			}
		}
		System.out.println("Orginal array");
		for(i=0;i<10;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("Odd array");
		for(i=0;i<oddarray.length;i++)
		{
			System.out.print(oddarray[i]+" ");
		}
		System.out.println();
		System.out.println("Even array");
		for(i=0;i<evenarray.length;i++)
		{
			System.out.print(evenarray[i]+" ");
		}
	}
}

