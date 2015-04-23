package marathonRunner;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import javax.print.attribute.standard.Destination;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.xml.transform.Templates;
//find the smallest number of stops through Dynamic programming Bottom Up Table look up 


public class nonRecursMarathonRunner {
	public int intMileCanRun;
	public int intNumWaterLocation;
	public Integer[] arraylist_Distance;
	
	public ArrayList<Integer> waterLocation = new ArrayList<Integer>();//warter location
	
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
		
		
		HashMap<Integer, Integer> stopslookUptable = new HashMap<Integer, Integer>();
		Integer[] lookupTableR;	
		
		lookupTableR = new Integer[intNumWaterLocation+2];     //Look up table 
		for( int i = 0; i<intNumWaterLocation+2; i++){
			lookupTableR[i] = Integer.MAX_VALUE;
		}//initiating look up table
		
		lookupTableR[0] = 0; //base case
				
		for( int j = 1; j<= intNumWaterLocation+1; j++){
			int i = 0;
			
			while((distance(i,j, arraylist_Distance) > intMileCanRun )&&i<j){
				i++;
			}//find the smallest node can run to j
			
			for( int intTemp = i; intTemp < j ; intTemp++ )	{
				
				if( lookupTableR[j] > lookupTableR[intTemp]+1){
				
					lookupTableR[j] = lookupTableR[intTemp]+1;
					//System.out.println(intTemp);
					stopslookUptable.put(j, intTemp);
					
					//Print all key and Value
					/*System.out.printf("key : ");
					System.out.println(j);
					System.out.printf("Value: ");
					System.out.println(stopslookUptable.get(j));
					System.out.println();
					System.out.println();*/   
					
					}
				}
		
		}
			
		
		//for(Integer j : tempArray){System.out.println(j);} //test`	
		Integer key = key=stopslookUptable.get(intNumWaterLocation+1);
		while(key>0)
		{
			this.waterLocation.add(key);
			key=stopslookUptable.get(key);
		}//find the water location stops solution
		
		
		
		return lookupTableR[intNumWaterLocation+1]-1; //cutting the end point
	
	}
	
	
		
	public int distance(int i, int j, Integer[] arraylist_Distance){
		int dValue = 0;
		if(i == j){
			return 0;
		}
			
		for (int n = i; n<j;n++)
		{
			dValue = arraylist_Distance[n]+ dValue;
			//System.out.print("dValue  ");
			//System.out.println(dValue);
			
		}
		return dValue;
	}


}
