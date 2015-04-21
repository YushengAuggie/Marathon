package marathonRunner;

import java.util.ArrayList;

import javax.xml.transform.Templates;
//find the smallest number of stops through Dynamic programming Bottom Up Table look up 


public class nonRecursMarathonRunner {
	public int intMileCanRun;
	public int intNumWaterLocation;
	public Integer[] arraylist_Distance;
	
	
	public nonRecursMarathonRunner(getInput gi){
		this.intMileCanRun = gi.intMileCanRun;
		this.intNumWaterLocation = gi.intNumWaterLocation;
		this.arraylist_Distance = gi.arraylist_Distance.toArray(new Integer[gi.arraylist_Distance.size()]);
		 
	}
	
	public int Bottom_Up_Marathon(int intMileCanRun, int intNumWaterLocation, Integer[] arraylist_Distance){
		
		for(int i = 0; i < intNumWaterLocation; i++){
			
			if(arraylist_Distance[i]>intMileCanRun)
			{
				System.out.println("Distance too long, cannot acheive!!");
				return -1;
			}
			
		}
		
		Integer[] lookupTableR;
		lookupTableR = new Integer[intNumWaterLocation];     //Look up table 
		for( int i = 0; i<intNumWaterLocation; i++){
			lookupTableR[i] = Integer.MAX_VALUE;
		}//initiating look up table
		
		lookupTableR[0] = 0; //base case
		
		for( int j = 1; j< intNumWaterLocation; j++){
			int i = 0;
			while((distance(i,j, arraylist_Distance) > intMileCanRun )&&i<j){
				i++;
			}//find the smallest node can run to j
		
			for( int intTemp = i; intTemp < j ; intTemp++ )	{
				if( lookupTableR[j] >lookupTableR[intTemp]+1){
	
					lookupTableR[j] = lookupTableR[intTemp]+1;
				
					}
				}
		
		}
			
		//for(Integer i : lookupTableR){System.out.println(i);} //test
		
		return lookupTableR[intNumWaterLocation-1]+1;
	
	}
		
	public int distance(int i, int j, Integer[] arraylist_Distance){
		int dValue = 0;
		if(i == j){
			return 0;
		}
			
		for (int n = i+1; n<j;n++)
		{
			dValue = arraylist_Distance[n]+ dValue;
			
		}
		return dValue;
	}
	
}
