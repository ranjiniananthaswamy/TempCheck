package temperature ;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import temperature.tempData;
;

public class Code  {
	
	private static tempData leastSpreadMonth;

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		ArrayList<String> data= getdata();
		ArrayList<tempData> dataWithSpread = calculateSpread(data);
		
		//System.out.println(dataWithSpread);
		getLeastSpread(dataWithSpread);
		System.out.println("The least spread month " + leastSpreadMonth.month);
		System.out.println(" Max " + leastSpreadMonth.max);
		System.out.println(" Min " + leastSpreadMonth.min);
		System.out.println("The least spread  " + leastSpreadMonth.spread);
		 
		
		}
	
	 public static ArrayList<String> getdata() throws IOException {
		 String Path="C:\\Users\\Ranjini.Ananthaswamy\\eclipse-workspace\\Temperature\\src\\main\\java\\Data\\sydney-temperature.csv";
		  String  line=" ";
         try {
			BufferedReader br = new BufferedReader(new FileReader(Path));
		 
			ArrayList <String> value = new ArrayList() ;
			while (( line = br.readLine()) != null) {
				
				//value = line.split(",");
				value.add(line);
				
				//System.out.println(line);
				
				
				}
			return value;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 }
	 
	 
	 public static ArrayList<tempData> calculateSpread(ArrayList<String> data) {
		    
		    ArrayList<tempData> temp = new ArrayList();
		    
		   
		   for (int i= 3; i<data.size() ; i++) {
			    
			    tempData monthlyData = new tempData();
			    String[] ab = data.get(i).split(",");
			    Float max = Float.parseFloat(ab[1].replace("*", ""));
			    Float min = Float.parseFloat(ab[2].replace("*", ""));
			    monthlyData.max = max;
			    monthlyData.min = min;
			    monthlyData.month = ab[0];
			    monthlyData.spread = max - min;
			    temp.add(monthlyData);
		   }
		   return temp;
		   
	      }
	 
	 public static void  getLeastSpread(ArrayList<tempData> data) {
		 
		  leastSpreadMonth = data.get(0);
		   data.forEach( (element) -> {
			   if (element.spread < leastSpreadMonth.spread) {
				   
				    leastSpreadMonth = element;
			   }
			   
		   });
		 
		 
		 
	 }

}

   
	
	   
	
	
	

