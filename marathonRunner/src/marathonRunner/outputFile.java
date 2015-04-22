package marathonRunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
//generate output file 
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class outputFile {
	public String outputFile = "..//output.txt";
	public outputFile(String outputFilepath, Integer numStops,ArrayList<Integer> stopPoints) {
		 BufferedWriter writer = null;
	        try {
	            
	            writer = new BufferedWriter(new FileWriter(outputFilepath));
	            writer.write(numStops.toString());
	            String newline = System.getProperty("line.separator");
	            writer.write(newline);
	            writer.write(stopPoints.toString());
	            System.out.println("File Write Successful!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close the writer regardless of what happens...
	                writer.close();
	            } catch (Exception e) {
	            }
	        }
	    }
		
}

