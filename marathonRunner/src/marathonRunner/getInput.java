package marathonRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;

//read data from a file

public class getInput {

	
	public Integer intMileCanRun;//m,the number of miles he or she can run before having to stop
	public Integer intNumWaterLocation;//n, predetermined locations along the route
	public ArrayList<Integer> arraylist_Distance = new ArrayList<Integer>();//distance, between start point to the..
	//1st water location and 1st water location to the 2nd location...last water location to the finish line.
	
	public getInput() {
	}
	
	public getInput getInputFuc(String filename) {
	
			try{
				BufferedReader br = new BufferedReader(new FileReader(filename));
				this.intMileCanRun = Integer.parseInt( br.readLine() );
				this.intNumWaterLocation = Integer.parseInt( br.readLine() );
				

				String line = br.readLine(); // 3rd line is a arraylist<Integer>
				
				for(String stLine : line.split("\\s+"))
				{
					this.arraylist_Distance.add(Integer.parseInt(stLine) );
				}
				
				br.close();
				System.out.println("Reading File Successful\n");
			} 
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Reading File Failed\n");
			}
			
			return this;
		}
	
	public void printInfo() {
		System.out.println("m[the number of miles he or she can run before having to stop]: " + this.intMileCanRun);
		System.out.println("n[predetermined locations along the route]: " + this.intNumWaterLocation);
		System.out.println("Distance between each node: \n" + this.arraylist_Distance+ "\n");
	}
	
}
