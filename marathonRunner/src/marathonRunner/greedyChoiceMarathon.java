package marathonRunner;

import java.util.ArrayList;
import java.util.HashMap;

import org.omg.CORBA.PUBLIC_MEMBER;

//This problem can be easily solved by greedy choice
public class greedyChoiceMarathon {
	public int intMileCanRun;
	public int intNumWaterLocation;
	public Integer[] arraylist_Distance;
	
	public ArrayList<Integer> waterLocation = new ArrayList<Integer>();//warter location
	
	public greedyChoiceMarathon(getInput gi){
		this.intMileCanRun = gi.intMileCanRun;
		this.intNumWaterLocation = gi.intNumWaterLocation;
		this.arraylist_Distance = gi.arraylist_Distance.toArray(new Integer[gi.arraylist_Distance.size()]);
		checkInput();

	}
	
	public int Greedy_Marathon(int CurrentNode){
		
		int nextNode;
		while(CurrentNode< this.intNumWaterLocation)
		{
			nextNode = CurrentNode+1;
			while(distance(CurrentNode, nextNode, arraylist_Distance)<=intMileCanRun)
			{
				nextNode++;	
			}
			nextNode--;
			waterLocation.add(nextNode);
			CurrentNode = nextNode;
		}
		
		
		//return lookupTableR[intNumWaterLocation+1]-1; //cutting the end point
		return waterLocation.size();
	}
	
	
		
	private void greedyChoice() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean checkInput() {
		for(int i = 0; i < this.intNumWaterLocation; i++){
					
					if(this.arraylist_Distance[i]>this.intMileCanRun)
					{
						System.out.println("Distance too long, cannot acheive!!");
						return false;
					}
			return true;
		}//Check the scenario, input data
	
		return false;
	
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

