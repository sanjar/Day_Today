package com.sanjar.hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EasyStrongPermutation {

    public static List<List<Integer>> permute(Integer[] myInts){

        if(myInts.length==1){
            List<Integer> arrayList = new ArrayList<Integer>();
            arrayList.add(myInts[0]);
            List<List<Integer> > listOfList = new ArrayList<List<Integer>>();
            listOfList.add(arrayList);
            return listOfList;
        }

        Set<Integer> setOf = new HashSet<Integer>(Arrays.asList(myInts));   

        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();

        for(Integer i: myInts){
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            arrayList.add(i);

            Set<Integer> setOfCopied = new HashSet<Integer>();
            setOfCopied.addAll(setOf);
            setOfCopied.remove(i);

            Integer[] isttt = new Integer[setOfCopied.size()];
            setOfCopied.toArray(isttt);

            List<List<Integer>> permute = permute(isttt);
            Iterator<List<Integer>> iterator = permute.iterator();
            while (iterator.hasNext()) {
                List<java.lang.Integer> list = iterator.next();
                list.add(i);
                listOfLists.add(list);
            }
        }   

        return listOfLists;
    }

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       String noOfInteger = br.readLine();
	       String[] numberStrs = br.readLine().split(" ");
	       
	       Integer[] numbers = new Integer[numberStrs.length];
	       for(int i = 0;i < numberStrs.length;i++)
	       {
	          // Note that this is assuming valid input
	          // If you want to check then add a try/catch 
	          // and another index for the numbers if to continue adding the others
	          numbers[i] = Integer.parseInt(numberStrs[i]);
	       }
	       
        List<List<Integer>> permute = permute(numbers );
        int strongValue = 0;
        for(List<Integer> list : permute){
        	
        	
        	int value = calStrongPermuattion(list);
        	if(value>strongValue){
        		strongValue=value;
        	}
        	//System.out.println(list);
        }
        System.out.println(strongValue);
       // System.out.println(permute);
    }

	private static int calStrongPermuattion(List<Integer> list) {
		int sum =0;
		//System.out.println(list);
		//System.out.println("-");
		for(int i =0;i<list.size()-1;i++){
			sum = sum + Math.abs(list.get(i)-list.get(i+1));
		}
		sum = sum +Math.abs(list.get(0)-list.get(list.size()-1));
		return sum;
	}

}
