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
	            //create a temporary file
	            //String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	            //File logFile = new File(inputData.toString());

	            // This will output the full path where the file will be written to...
	           // System.out.println(logFile.getCanonicalPath());

	            writer = new BufferedWriter(new FileWriter(outputFilepath));
	            writer.write(numStops.toString());
	            String newline = System.getProperty("line.separator");
	            writer.write(newline);
	            writer.write(stopPoints.toString());
	            System.out.println("File Write Success!");
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

