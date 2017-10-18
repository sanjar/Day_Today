package com.company.interfaces;

import java.io.File;
import java.util.List;

public interface IDirectoryReader {

	public void listFiles(File dir, int tabs);
	public void iterateFiles(List<String> listOfFiles, int tabs, File dir);
}
