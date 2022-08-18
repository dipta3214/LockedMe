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
	
	public static void addFile()  {
		
		File folder = new File("C://lockedMe");
		folder.mkdir();
		
		System.out.println("Enter file name: ");
		Scanner sc = new Scanner(System.in);
		String fileScanner = sc.next();
		
		File fileName = new File("C://lockedMe//" + fileScanner);
		
		try {
			if(fileName.createNewFile()) {
				System.out.println("File created successfully");
			}else {
				System.out.println("File already exists!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void deleteFile() {
		System.out.println("Enter file name: ");
		Scanner sc = new Scanner(System.in);
		String fileScanner = sc.next();
		
		try {
			if(Files.deleteIfExists(Paths.get("C://lockedMe//" + fileScanner))) {
				System.out.println("File deleted successfully!");
			}else {
				System.out.println("File not found!");
			}
		} 
        catch(IOException e) 
        { 
            System.out.println("Invalid permissions."); 
        } 

	}
	
	public static void searchFile() {
		System.out.println("Enter file name: ");
		Scanner sc = new Scanner(System.in);
		String fileScanner = sc.next();
		
		if(Files.exists(Paths.get("C://lockedMe//" + fileScanner)) == true) {
			System.out.println("Found " + fileScanner);
		}else {
			System.out.println("File not found");
		}
	}
	
	public static void main(String[] args) {
		addFile();
		deleteFile();
		searchFile();
	}
}
