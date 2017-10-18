package com.company.interfaces.impl.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.company.interfaces.IFilePrinter;
import com.company.interfaces.IFileSorter;
import com.company.interfaces.impl.ConsoleFilePrinter;
import com.company.interfaces.impl.DirectoryReader;
import com.company.interfaces.impl.SortFilesByExtensions;

public class TestDirectoryReader {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void testlistFilesConsolePrints() {
		File rootDirectory = new File("./testdirectory/Main Project");
		int directoryFileLength = rootDirectory.getAbsolutePath().length() - rootDirectory.getName().length();
		IFilePrinter filePrinter = new ConsoleFilePrinter();
		IFileSorter fileSorter = new SortFilesByExtensions();
		DirectoryReader directoryReader = new DirectoryReader(directoryFileLength,fileSorter,filePrinter);
		directoryReader.listFiles(rootDirectory, 0);
		
		assertTrue(outContent.toString().contains("URL: Main Project\\Project 1\\WordFile1.docx"));
	}
	
	@Test
	public void testlistFilesWrongDirectory() {
		File rootDirectory = new File("./testdirectory/Main Project1");
		int directoryFileLength = rootDirectory.getAbsolutePath().length() - rootDirectory.getName().length();
		IFilePrinter filePrinter = new ConsoleFilePrinter();
		IFileSorter fileSorter = new SortFilesByExtensions();
		DirectoryReader directoryReader = new DirectoryReader(directoryFileLength,fileSorter,filePrinter);
		directoryReader.listFiles(rootDirectory, 0);
		
		assertTrue(outContent.toString().contains("Please provide a path to root directory"));
	}

}
