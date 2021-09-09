
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.*;

/*
*   Rail Fence 
*/
public class RailFence {

    // Fields or Properties tells the object State
    private String fileName;
	private int offSet;
    private int row; //Rail or key required to create a cipher from plain text message
    private int col; //Sum of the character count of the plain text message
    private int rowPos; //keeps track of the current index position of row
    private  boolean dirFlag;  // checks whether it is moving downward or upward 
    private char[][] message; // Matrix of Rail Fence in dimension row x col
    private String plainText = ""; //Text message
    private String cipherText = ""; //Cipher message
    private String decipherText = ""; //decipher message
    private static Scanner input;
    private FileManager fileManager;

    // Constructor instantiate instance of RailFence object
    public RailFence() {
        input = new Scanner(System.in);
    	fileManager = new FileManager();
    }

    // Operations or Methods defines the behavior or function of the object
    public int enterRailKey() {
        System.out.println("Enter Rail Fence Key: "); 
        return row = Integer.parseInt(input.next()); //Takes in users input for key
    }
	public int enterOffset() {
        System.out.println("Enter offset: ");
        offSet = Integer.parseInt(input.next()); //Takes in users input for starting position/ offset
        System.out.println("Offset entered: " + offSet + "\r\n");
        return offSet;
    }

    public String encryptMessage(String plainText, int key, int offSet, int menuOption) throws Exception {
        String cipherText = "";
        row = key; 
        col = plainText.length();
        message = new char[row][col]; 
        dirFlag = false;
        rowPos = offSet; // Will be between 0 - 4 = 5 rows

        // matrix visiting in rails order and putting the character of plaintext
        for (int i = 0; i < col; i++) { 
            if (rowPos == 0 || rowPos == row - 1)
            dirFlag = !dirFlag;
            message[rowPos][i] = plainText.charAt(i); //Add offSet
            if (dirFlag) {
                rowPos++;
            } else
                rowPos--;
        }

        System.out.println();
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (message[i][k] != 0)
                    cipherText += message[i][k];
            }
        }

        //Hide Matrix
        if(menuOption == 5){
            displayRailFence();
        }

        //Write encrypted data to file
        fileManager.writeToFile(cipherText); 

        return cipherText;
    }

    public void displayRailFence() {
         for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                System.out.print(message[i][k] + "  ");
            }
            System.out.println();
        }
    }
	
	
	
       public void decryptMessage(String fileName, int key, int offSet, int menuOption) throws Exception {

        File file = new File(fileName);
        if (file.exists()) {
            cipherText = fileManager.readFile(file.getAbsolutePath());
        } else {
            cipherText = fileName;
            //Print out cipherText before writing into matrix
            System.out.println("Cipher Text is " + cipherText);
        }

        dirFlag = false;
        rowPos = offSet; // Will be between 0 - 4 = 5 rows
        row = key;
        col = cipherText.length();
        message = new char[row][col];
        

        // first of all mark the rails position by * in the matrix
        for (int i = 0; i < col; i++) {
            if (rowPos == 0 || rowPos == row - 1)
                dirFlag = !dirFlag;
            message[rowPos][i] = '*';
            if (dirFlag)
                rowPos++;
            else
                rowPos--;
        }
        
        // now enter the character of cipher text in the matrix position that have *symbol
        int index = 0; //local variable
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (message[i][k] == '*' && index < col) {
                    message[i][k] = cipherText.charAt(index++);
                }
            }
        }

        //Hide matrix
        if(menuOption == 5){
            displayRailFence();
        }
        //reset
        dirFlag = false;


        for (int i = 0; i < col; i++) {
            if (rowPos == 0 || rowPos == row - 1)
                dirFlag = !dirFlag;
            System.out.println("Print out each character  " + message[rowPos][i]);
            decipherText += message[rowPos][i];
            if (dirFlag)
                rowPos++;
            else
                rowPos--;
        }
        System.out.println("Decrypted Text:  " + decipherText);

        fileManager.writeToFile(decipherText);
    }

}
 
 /*
  public void decryptMessage(String fileName, int key, int offSet, int menuOption) throws Exception {

        File file = new File(fileName);
        if (file.exists()) {
            cipherText = fileManager.readFile(file.getAbsolutePath());
        } else {
            cipherText = fileName;
        }

        dirFlag = false;
        rowPos = offSet; // Will be between 0 - 4 = 5 rows
        row = key;
        col = cipherText.length();
        message = new char[row][col];

        // first of all mark the rails position by * in the matrix
        for (int i = 0; i < col; i++) {
            if (rowPos == 0 || rowPos == row - 1)
                dirFlag = !dirFlag;
            message[rowPos][i] = '*';
            if (dirFlag)
                rowPos++;
            else
                rowPos--;
        }

        // now enter the character of cipher text in the matrix position that have *symbol
        int index = 0; //local variable
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (message[i][k] == '*' && index < col) {
                    message[i][k] = cipherText.charAt(index++);
                }
            }
        }

        //Hide matrix
        if(menuOption == 5){
            displayRailFence();
        }
        //reset
        dirFlag = false;
        //rowPos = 0;

        for (int i = 0; i < col; i++) {
            if (rowPos == 0 || rowPos == row - 1)
                dirFlag = !dirFlag;
            decipherText += message[rowPos][i];
            if (dirFlag)
                rowPos++;
            else
                rowPos--;
        }
        System.out.println("Decrypted Text:  " + decipherText);

        fileManager.writeToFile(decipherText);
    }
}
*/
