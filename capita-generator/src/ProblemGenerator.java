import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ProblemGenerator {
	public static void main(String [] args) {
		generateRandomGDODOSP(0);
		generateRandomCDODOSP(0);
	}
	
	public static void generateRandomGDODOSP(int fileId) {
		int timespan = 5 + (int)(Math.random() * 25);
		int workDayMin;
		if(timespan < 7) {
			workDayMin = 1 + (int)(Math.random() * timespan/3);
		} else {
			workDayMin = 1 + (int)(Math.random() * 4);
		}
	
		int workDayMax;
		workDayMax = workDayMin + 1 + (int)(Math.random() * 2);
		
		int offDayMin = 1;
		int offDayMax;
		if(timespan < 7) {
			offDayMax = 1 + (int)(Math.random() * timespan/3);
		} else {
			offDayMax = 1 + (int)(Math.random() * 4);
		}
		
		int[] requiredEmployeeArray = new int[timespan];
		int initialAmountOfEmployees = 10 + (int)(Math.random() * 15);
		requiredEmployeeArray[0] = initialAmountOfEmployees;
		
		for(int i = 1; i < timespan; i++) {
			int newAmount = initialAmountOfEmployees + (-2) + (int)(Math.random() * 2);
			requiredEmployeeArray[i] = newAmount;
		}
		
		try {
			String content = timespan + "-" + workDayMin + "-" + workDayMax + "-" + offDayMin + "-" + offDayMax + "-" + Arrays.toString(requiredEmployeeArray);
			
			String filename = "GDODOSPproblem" + fileId + ".txt";
			File file = new File(filename);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void generateRandomCDODOSP(int fileId) {
		int timespan = 5 + (int)(Math.random() * 25);
		
		int[] workDayArray = new int[timespan];
		for(int i = 0; i < timespan; i++) {
			int newNumber = 0 + (int)(Math.random() * 2);
			if((i > 2 && workDayArray[i-1] == newNumber && workDayArray[i-2] == newNumber  && workDayArray[i-3] == newNumber) || newNumber == 2) {
				workDayArray[i] = Math.abs(newNumber - 1);
			} else {
				workDayArray[i] = newNumber;
			}
		}
		
		int[] requiredEmployeeArray = new int[timespan];
		int initialAmountOfEmployees = 10 + (int)(Math.random() * 15);
		requiredEmployeeArray[0] = initialAmountOfEmployees;
		
		for(int i = 1; i < timespan; i++) {
			int newAmount = initialAmountOfEmployees + (-2) + (int)(Math.random() * 2);
			requiredEmployeeArray[i] = newAmount;
		}
		
		try {
			String content = timespan + "-" + Arrays.toString(workDayArray) + "-" + Arrays.toString(requiredEmployeeArray);
			
			String filename = "CDODOSPproblem" + fileId + ".txt";
			File file = new File(filename);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
