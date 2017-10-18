package com.company.interfaces.impl;

import java.io.File;

import com.company.interfaces.IFilePrinter;

public class ConsoleFilePrinter implements IFilePrinter{
	
	private static final String DELIMETER = File.separator + ".";

	@Override
	public void print(File file, int tabs, int lenghtOfDirectory) {
		String fileName = file.getName();
		String[] split = fileName.split(DELIMETER);
		for (int i = 0; i < tabs; i++) {
			System.out.print("  ");
		}
		System.out.println("- Document: " + file.getName() + " - Extension: ." + split[split.length - 1] + " - URL: "
				+ file.getAbsolutePath().substring(lenghtOfDirectory));
		
	}

}
