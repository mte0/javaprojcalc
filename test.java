package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static ArrayList<File> javaFiles = new ArrayList<>();
	public static ArrayList<Integer> lineValues = new ArrayList<>();
	public static int lines = 0;
	public static String biggestFile;
	public static String smallestFile;

	public static void main(String[] args) {
		String dir = "C:\\Users\\";
		
		try {
			Files.walk(Paths.get(dir)).forEach(path -> {
				if(!path.toFile().isDirectory() && path.toFile().toString().endsWith(".java"))
					javaFiles.add(path.toFile());
			});
			
			for(File file : javaFiles) {
				int lines2 = 0;
				BufferedReader br = new BufferedReader(new FileReader(file));
				try {
				    StringBuilder sb = new StringBuilder();
				    String line = br.readLine();

				    while (line != null) {
				        sb.append(line);
				        sb.append(System.lineSeparator());
				        line = br.readLine();
				        
				        if(!(line == null)) {
					        lines++;
					        lines2++;
				        }
				    }				    
				} finally {
				    br.close();
				}
				
				lineValues.add(lines2);
			}
			
			Collections.sort(lineValues);
	        Collections.reverse(lineValues);
			
	        //calculate what the name of the biggest file is
			for(File file : javaFiles) {
				int lines2 = 0;
				BufferedReader br = new BufferedReader(new FileReader(file));
				try {
				    StringBuilder sb = new StringBuilder();
				    String line = br.readLine();

				    while (line != null) {
				        sb.append(line);
				        sb.append(System.lineSeparator());
				        line = br.readLine();
				        
				        if(!(line == null)) {
					        lines2++;
				        }
				    }				    
				} finally {
				    br.close();
				}
				
				if(lines2 == lineValues.get(0)) {
					biggestFile = file.getName();
				}
				
			}
			
	        Collections.reverse(lineValues);
			
			//calculate what the name of the smallest file is
			for(File file : javaFiles) {
				int lines2 = 0;
				BufferedReader br = new BufferedReader(new FileReader(file));
				try {
				    StringBuilder sb = new StringBuilder();
				    String line = br.readLine();

				    while (line != null) {
				        sb.append(line);
				        sb.append(System.lineSeparator());
				        line = br.readLine();
				        
				        if(!(line == null)) {
					        lines2++;
				        }
				    }				    
				} finally {
				    br.close();
				}
				
				if(lines2 == lineValues.get(0)) {
					smallestFile = file.getName();
				}
				
			}
			
			System.out.println("Lines: " + lines);
			System.out.println("Java files: " + javaFiles.size());
			System.out.println("Biggest java file: " + biggestFile);
			System.out.println("Smallest java file: " + smallestFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
