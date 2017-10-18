package com.company.interfaces.impl.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.company.interfaces.IFileSorter;
import com.company.interfaces.impl.SortFilesByExtensions;

public class TestSortFilesByExtensions {

	@Test
	public void testSortFilesCorrectly() {
		IFileSorter fileSorter = new SortFilesByExtensions();
		
		String[] files = {"ExcelFile1.xlsx","WordFile1.docx"};
		List<String> sortedFiles = fileSorter.sortFiles(files);
		assertEquals("WordFile1.docx", sortedFiles.get(0));
	}

}
