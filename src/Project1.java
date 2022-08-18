import java.io.File;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;


public class Project1 {
	
	public static void businessOperations() {
		
		System.out.println("Which operation you want to choose? ");
		System.out.println("======================================================================================");
		System.out.println(" 1. Create a new File \n 2. Delete a file \n 3. Search for a file \n 4. Go back to main menu");
		Scanner sc = new Scanner(System.in);
		int operation = sc.nextInt();
		
		if(operation == 1) {
			addFile();
		}else if(operation == 2) {
			deleteFile();
		}else if(operation == 3) {
			searchFile();
		}
	}
	
	public static void addFile()  {
		
		File folder = new File("C://lockedMe");
		folder.mkdir();
		
		System.out.println("Enter file name: ");
		Scanner sc = new Scanner(System.in);
		String fileScanner = sc.next();
		
		File fileName = new File("C://lockedMe//" + fileScanner);
		
		try {
			if(fileName.createNewFile()) {
				System.out.println("File created successfully \n");
			}else {
				System.out.println("File already exists! \n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		businessOperations();
	}
	
	public static void deleteFile() {
		System.out.println("Enter file name: ");
		Scanner sc = new Scanner(System.in);
		String fileScanner = sc.next();
		
		try {
			if(Files.deleteIfExists(Paths.get("C://lockedMe//" + fileScanner))) {
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
		
		if(Files.exists(Paths.get("C://lockedMe//" + fileScanner)) == true) {
			System.out.println("Found " + fileScanner + "\n");
		}else {
			System.out.println("File not found \n");
		}
		businessOperations();
	}
	
	public static void main(String[] args) {
		businessOperations();
	}
}
