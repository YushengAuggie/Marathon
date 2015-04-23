/**
 * Marathon 
 * Yusheng Ding & Qi Zhu. Algorithm Project
 */
package marathonRunner;

import java.util.ArrayList;

import javax.management.openmbean.OpenDataException;
import javax.print.attribute.standard.OutputDeviceAssigned;

public class main {

	
	public static void main(String[] args) {
	
		String inputfilepath = "..\\marathonRunner\\IOFile\\input.txt";
		String outputfilepath = "..\\marathonRunner\\IOFile\\output.txt";

		getInput ob =new getInput();		
		ob = ob.getInputFuc(inputfilepath);
		ob.printInfo();
		//check dimension Node and m
		nonRecursMarathonRunner marathon = new nonRecursMarathonRunner(ob);
		Integer numStops = marathon.Bottom_Up_Marathon(marathon.intMileCanRun, marathon.intNumWaterLocation, marathon.arraylist_Distance);
		
		ArrayList<Integer> stopWaterLocation = new ArrayList<Integer>();
		if(ob.intNumWaterLocation+1 != ob.arraylist_Distance.size()){
			System.out.println("Water location number is not equal to distance array dimentsion-1");
		}// check input data is valid for this problem
		
		
		stopWaterLocation = marathon.waterLocation;
		
		
		System.out.println("The runner has to stop: ");
		System.out.print(numStops);
		System.out.println("  times.");
		
		System.out.println("Stop At WaterLocation:");
		for(Integer i : stopWaterLocation)
			{
				System.out.println(i);
			} //test`
		
		outputFile output = new outputFile(outputfilepath,numStops,stopWaterLocation);
		
		
		//----------------Greedy_Sulotion-------------------------------------------
		
		String GreedyOutPut = "..\\marathonRunner\\IOFile\\Greedyoutput.txt";
		greedyChoiceMarathon GreedyObject =new greedyChoiceMarathon(ob);
		int numGreedyStops = GreedyObject.Greedy_Marathon(0);
		System.out.println(numGreedyStops);
		System.out.println(GreedyObject.waterLocation);
		outputFile GreedyOutput = new outputFile(GreedyOutPut, numGreedyStops, GreedyObject.waterLocation);
		//-----------------Greedy_Sulotion-------------------------------------------
			
	}

}
