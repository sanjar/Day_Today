package com.company.interfaces.impl;

import java.io.File;
import java.util.List;

import com.company.interfaces.IDirectoryReader;
import com.company.interfaces.IFilePrinter;
import com.company.interfaces.IFileSorter;

public class DirectoryReader implements IDirectoryReader {
	
	private final int lenghtOfDirectory;
	
	private IFileSorter fileSorter;
	private IFilePrinter filePrinter;
	
	
	
	public DirectoryReader(int lenghtOfDirectory,IFileSorter fileSorter,IFilePrinter filePrinter) {
		this.lenghtOfDirectory = lenghtOfDirectory;
		this.filePrinter = filePrinter;
		this.fileSorter = fileSorter;
	}

	@Override
	public void listFiles(File dir, int tabs) {
		if (dir != null) {
			if (dir.isDirectory()) {
				for (int i = 0; i < tabs; i++) {
					System.out.print("  ");
				}
				System.out.println("- Project: " + dir.getName() + " - URL: "
						+ dir.getAbsolutePath().substring(lenghtOfDirectory));
				String listOfFileNames[] = dir.list();
				// sortedList = sort(s);
				List<String> sortedListOfFiles = fileSorter.sortFiles(listOfFileNames);
				iterateFiles(sortedListOfFiles, tabs, dir);
			} else {
				System.out.println("Please provide a path to root directory");
			}
		} else {
			System.out.println(dir + " is not a directory");
		}

	}

	public static void main(String[] args) {
		File rootDirectory = new File("./testdirectory/Main Project");
		int directoryFileLength = rootDirectory.getAbsolutePath().length() - rootDirectory.getName().length();
		IFilePrinter filePrinter = new ConsoleFilePrinter();
		IFileSorter fileSorter = new SortFilesByExtensions();
		DirectoryReader directoryReader = new DirectoryReader(directoryFileLength,fileSorter,filePrinter);
		directoryReader.listFiles(rootDirectory, 0);

	}

	@Override
	public void iterateFiles(List<String> listOfFiles, int tabs, File dir) {
		for (String item : listOfFiles) {
			tabs++;
			File file = new File(dir + "/" + item);
			if (file.isDirectory()) {
				listFiles(file, tabs);
				tabs--;
			} else {
				filePrinter.print(file, tabs,lenghtOfDirectory);
				tabs--;
			}
		}
		
	}

}
