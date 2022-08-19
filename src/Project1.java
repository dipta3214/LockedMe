import java.io.File;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Project1 {
	
	public static void welcomeScreen() {
		System.out.println("Welcome to LockedMe.com!");
		System.out.println("===================================================");
		System.out.println("This is Abidur a Software Engineer! \n");
	}
	
	public static void primaryOperations() {
		System.out.println("Which operation you want to choose? ");
		System.out.println("===================================================");
		System.out.println(" 1. Show files in an ascending order \n 2. Business-level Operations \n 3. Close the application \n ");
		
		try {
			Scanner sc = new Scanner(System.in);
			int operation = sc.nextInt();
			
			if(operation == 1) {
				showFiles();
			}else if(operation == 2) {
				businessOperations();
			}else if(operation == 3) {
				System.out.println("\nClosing application... \nHave a nice day!!!");
				System.exit(0);
			}else {
				System.out.println("Wrong input!!! \nPlease choose from 1-3\n");
				primaryOperations();
			}
		}
		catch(Exception e) {
			System.out.println("Invalid input type \nPlease choose from 1-3\n");
			primaryOperations();
		}
	}
	
	public static void showFiles() {
		File folder = new File("C://lockedMeAbidur");
		if(folder.exists() == false) {
			folder.mkdir();
		}
		
		String[] listOfFiles = folder.list();
		
		ArrayList<String> fileList = new ArrayList<String>(Arrays.asList(listOfFiles));
		if(fileList.size() == 0) {
			System.out.println("Folder is empty");
		}else {
			Collections.sort(fileList);
			
			System.out.println("Showing files in an ascending order \n");
			for(String file: fileList){
				System.out.println(file);
			}
		}
		
		
		System.out.println();
		primaryOperations();
	}
	
	public static void businessOperations() {
		
		System.out.println("Which operation you want to choose? ");
		System.out.println("===================================================");
		System.out.println(" 1. Create a new File \n 2. Delete a file \n 3. Search for a file \n 4. Go back to main menu");
		
		
		try {
			Scanner sc = new Scanner(System.in);
			int operation = sc.nextInt();
			if(operation == 1) {
				addFile();
			}else if(operation == 2) {
				deleteFile();
			}else if(operation == 3) {
				searchFile();
			}else if(operation == 4) {
				primaryOperations();
			}else {
				System.out.println("Wrong input!!! \nPlease choose from 1-4\n");
				businessOperations();
			}
		}
		catch(Exception e) {
			System.out.println("Invalid input type \nChoose from 1-4\n");
			businessOperations();
		}
	}
	
	public static void addFile()  {
		
		File folder = new File("C://lockedMeAbidur");
		folder.mkdir();
		
		System.out.println("Enter file name: ");
		Scanner sc = new Scanner(System.in);
		String fileScanner = sc.next();
		
		File fileName = new File("C://lockedMeAbidur//" + fileScanner);
		
		try {
			if(fileName.createNewFile()) {
				System.out.println("File created successfully \n");
			}else {
				System.out.println("File already exists! \n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Operation not allowed\n");
		}
		businessOperations();
	}
	
	public static void deleteFile() {
		System.out.println("Enter file name: ");
		Scanner sc = new Scanner(System.in);
		String fileScanner = sc.next();
		
		try {
			if(Files.deleteIfExists(Paths.get("C://lockedMeAbidur//" + fileScanner))) {
				System.out.println("File deleted successfully! \n");
			}else {
				System.out.println("File not found! \n");
			}
		} 
        catch(IOException e) 
        { 
            System.out.println("Invalid permissions."); 
        } 
		businessOperations();
	}
	
	public static void searchFile() {
		System.out.println("Enter file name: ");
		Scanner sc = new Scanner(System.in);
		String fileScanner = sc.next();
		
		File file = new File("C://lockedMeAbidur//" + fileScanner);
		
		if(Files.exists(Paths.get("C://lockedMeAbidur//" + fileScanner)) == true) {
			System.out.println("Found " + fileScanner + "\nPath to file: " + file.getAbsolutePath() + "\n");
		}else {
			System.out.println("File not found \n");
		}
		businessOperations();
	}
	
	public static void main(String[] args) {
		welcomeScreen();
		primaryOperations();
	}
}
