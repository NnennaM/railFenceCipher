import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
	
	private String fileName;
	private static Scanner input;
	private String plainText = "";
	private String lineNumber;
	
	
	public FileManager() {
		input = new Scanner(System.in);
	}
	
	public String selectFile() {
        System.out.println("Enter file path or URL: ");
        fileName = input.nextLine(); //takes in users input for file
        System.out.println("File path: " + fileName + "\r\n");
        return fileName;
    }

   public String readFile(String filePath) {
        try {
            Scanner input = new Scanner(new File(filePath));
            while (input.hasNextLine()) { // returns true if there are lines
                plainText += input.nextLine();
            }
            input.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Message: " + plainText);
        return plainText;
    }
	
	


    public void writeToFile(String cipherText){
    
    	//Change this on your System
        Path file = Paths.get("C:\\Workspace\\railFenceCipher\\Encrypted.txt"); // save to file

        byte[] data = cipherText.getBytes();
        OutputStream output = null;
        try
        {
            output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            output.write(data);
            output.flush();
            output.close();
            System.out.println("Message encrypted and successfully written to file" + "\r\n");
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e);
        }
    }
}
