package com.company.interfaces.impl;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

import com.company.interfaces.IFileSorter;

public class SortFilesByExtensions implements IFileSorter {

	private static final String DELIMETER = File.separator + ".";
	
	@Override
	public List<String> sortFiles(String[] listOfFileNames) {
		List<String> orginalList = new CopyOnWriteArrayList<>(Arrays.asList(listOfFileNames));
		Set<String> setOfuniqueExtension = new TreeSet<>();

		for (String item : listOfFileNames) {
			if (item.contains(".")) {
				String[] split = item.split(DELIMETER);
				String temp = "." + split[split.length - 1];
				setOfuniqueExtension.add(temp);
			}
		}

		List<String> finalListOfAllFiles = new LinkedList<>();
		setOfuniqueExtension.stream().forEach((s1) -> {
			for (int i = 0; i < orginalList.size(); i++) {
				if (orginalList.get(i).contains(s1)) {
					finalListOfAllFiles.add(orginalList.get(i));
					orginalList.remove(orginalList.get(i));
					i--;
				}
			}
		});

		orginalList.stream().filter((s1) -> (!finalListOfAllFiles.contains(s1))).forEach((s1) -> {
			finalListOfAllFiles.add(s1);
		});

		return finalListOfAllFiles;
	}

}
