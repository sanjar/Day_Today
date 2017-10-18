package com.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author MSANIAR
 *
 *
 *Text le Description
The text les boynames.txt and girlnames.txt, which are included in the source code
for this book text, contain a list of the 1,000 most popular boy and girl names in the United
States for the year 2003 as compiled by the Social Security Administration.
These are blank-delimited les, where the most popular name is listed rst, the second
most popular name is listed second, and so on, to the 1,000th most popular name, which
is listed last.
Each line consists of the rst name followed by a blank space and then the number of
registered births using that name in the year. For example, the girlnames.txt le begins
with :
 Emily 25494
 Emma 22532
 Madison 19986
This indicates that Emily was the most popular name with 25,494 registered namings,
Emma was the second most popular with 22,532, and Madison was the third most popular
with 19,986.
2 Project Requirements.
 Write a program that reads both the girl and boy les into memory using arrays.
 Then, allow the user to input a name.
 The program should search through both arrays.
1
 If there is a match, then it should output the popularity ranking and the number of
namings.
 The program should also indicate if there is no match.
 For example, if the user enters the name \Justice", then the program should output:
Justice is ranked 456 in popularity among girls with 655 namings.
Justice is ranked 401 in popularity among boys with 653 namings.
 If the user enters the name \Walter", then the program should output:
Walter is not ranked among the top 1000 girl names.
Walter is ranked 356 in popularity among boys with 775 namings.

 */
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
