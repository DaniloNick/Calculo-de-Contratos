package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.println("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.print("Enter Worker data:");
		System.out.println();
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.println("Level: ");
		String workLevel = sc.nextLine();
		System.out.println("Base Salary: ");
		Double baseSalary = sc.nextDouble();		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workLevel), baseSalary, new Department(departmentName));
				
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i=1; i<n; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("value per Hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.println("Duration (Hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
			
			

			
			
		}	
		sc.close();
	}	
}
