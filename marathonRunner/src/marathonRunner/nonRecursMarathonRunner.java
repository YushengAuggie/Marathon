package marathonRunner;

import java.util.ArrayList;

import javax.xml.transform.Templates;



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
		
		for(int i = 0; i > intNumWaterLocation; i++){
			if(arraylist_Distance[i]>intMileCanRun)
			{
				System.out.println("Distance too long, cannot acheive!!");
				return Integer.MAX_VALUE;
			}
		}
		
		Integer[] lookupTableR;
		lookupTableR = new Integer[intNumWaterLocation];     //Look up table 
		for( int i = 0; i<intNumWaterLocation; i++){
			lookupTableR[i] = Integer.MAX_VALUE;
		}//initiating look up table
		
		
		for( int j = 0; j< intNumWaterLocation; j++){
			int i = 0;
			while((distance(i,j, arraylist_Distance) <= intMileCanRun )&&i<j){
				i++;
			}//find the smallest node can run to j
		
			for( int intTemp = i; intTemp < j ; intTemp++ )	{
				if( lookupTableR[j] <lookupTableR[intTemp]+1){
	
					lookupTableR[j] = lookupTableR[i]+1;
				
					}
				}
		System.out.println(lookupTableR[intNumWaterLocation]);
		}
		return lookupTableR[intNumWaterLocation];
	
	}
		
	public int distance(int i, int j, Integer[] arraylist_Distance){
		int dValue = 0;
		for (int n = i+1; n<j;n++)
		{
			dValue = arraylist_Distance[n]+ dValue;
		}
		return dValue;
	}
	
}
