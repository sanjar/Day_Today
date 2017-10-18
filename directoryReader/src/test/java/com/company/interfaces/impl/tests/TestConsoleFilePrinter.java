package com.company.interfaces.impl.tests;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.company.interfaces.IFilePrinter;
import com.company.interfaces.impl.ConsoleFilePrinter;

public class TestConsoleFilePrinter {
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
	public void testPrintCorrectly() {
		IFilePrinter filePrinter = new  ConsoleFilePrinter();
		filePrinter.print(new File(".\\testdirectory\\Main Project\\Project 1\\WordFile1.docx"), 2, 57);

		assertTrue(outContent.toString().contains("URL: Main Project\\Project 1\\WordFile1.docx"));
	}
	
	@Test
	public void testPrintIncorrectly() {
		IFilePrinter filePrinter = new  ConsoleFilePrinter();
		filePrinter.print(new File(".\\testdirectory\\Main Project\\Project 1\\WordFile1.docx"), 2, 45);

		assertFalse(outContent.toString().contains("URL: Main Project\\Project 1\\WordFile1.docx"));
	}

}
