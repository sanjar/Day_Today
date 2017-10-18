package com.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseAndSearchName {
	private static int NUMNAME = 1000;
	private static String[] boyNames = new String[NUMNAME];
	private static String[] girlNames = new String[NUMNAME];
	private int boyRank = 0;
	private int girlRank = 0;
	private boolean boyNameFound=false;
	private boolean girlNameFound=false;
	
	public static void main(String[] args) {
		initializeNames();
		ParseAndSearchName intstance = new ParseAndSearchName();
		intstance.readInputAndfindName();
		
		

	}

	private void readInputAndfindName() {
		System.out.println("Enter the name: ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("you entered" + name);
		
		Stream<String> stream1 = Arrays.stream(girlNames);
        stream1.forEach((row) -> {
        	girlRank++;
        	String[] nameAndtotal= row.split(" ");
        	if(nameAndtotal[0].equalsIgnoreCase(name)) {
        		System.out.println(name + " is ranked "+girlRank+" in popularity among girls with " + nameAndtotal[1] +" namings.");
        		girlNameFound =true;
        		return;
        	}
        	
        });
        if(!girlNameFound) {
        	System.out.println(name + " is not ranked among the top " + NUMNAME +" girl namings.");
        }
        Stream<String> stream2 = Arrays.stream(boyNames);
        stream2.forEach((row) -> {
        	boyRank++;
        	String[] nameAndtotal= row.split(" ");
        	if(nameAndtotal[0].equalsIgnoreCase(name)) {
        		System.out.println(name + "  is ranked "+boyRank+" in popularity among boys with " + nameAndtotal[1] +" namings.");
        		boyNameFound =true;
        		return;
        	}
        	
        });
        if(!boyNameFound) {
        	System.out.println(name + " is not ranked among the top " + NUMNAME +" boy namings.");
        }
	}

	private static void initializeNames() {
		try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/boynames.txt"))) {

			List<String> boyList = stream.collect(Collectors.toList());
			boyNames = boyList.toArray(new String[0]);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/girlnames.txt"))) {

			List<String> boyList = stream.collect(Collectors.toList());
			girlNames = boyList.toArray(new String[0]);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
