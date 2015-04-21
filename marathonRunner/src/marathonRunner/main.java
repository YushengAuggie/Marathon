/**
 * Marathon 
 * Yusheng Ding & Qi Zhu. Algorithm Project
 */
package marathonRunner;

import java.util.ArrayList;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String filepath = "..\\marathonRunner\\inputFile\\input.txt";
		getInput ob =new getInput();		
		ob = ob.getInputFuc(filepath);
		ob.printInfo();
		//check dimension Node and m
		nonRecursMarathonRunner marathon = new nonRecursMarathonRunner(ob);
		Integer numStops = marathon.Bottom_Up_Marathon(marathon.intMileCanRun, marathon.intNumWaterLocation, marathon.arraylist_Distance);
		
		if(ob.intNumWaterLocation != ob.arraylist_Distance.size()){
			System.out.println("Water location number is not equal to distance array dimentsion");
		}// check input data is valid for this problem
		
		System.out.println("The runner has to stop: ");
		System.out.print(numStops);
		System.out.println("  times.");
		
	}

}
