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
	
		String filepath = "C:\\Users\\DavidThinkle\\Dropbox\\Share\\Algorithm Project\\Input.txt";
		getInput ob =new getInput();		
		ob = ob.getInputFuc(filepath);
		ob.printInfo();
		
		nonRecursMarathonRunner marathon = new nonRecursMarathonRunner(ob);
		Integer numStops = marathon.Bottom_Up_Marathon(marathon.intMileCanRun, marathon.intNumWaterLocation, marathon.arraylist_Distance);
		
		System.out.println("The runner has to stop: ");
		System.out.print(numStops);
		System.out.println("  times.");
		
		
		
		
		
		
		
		
	}

}
