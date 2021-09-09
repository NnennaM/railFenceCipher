	import java.util.Scanner;


	public class Menu {
			
			private Scanner input;
			private boolean keepRunning= true;
			private RailFence railFence;
			private FileManager fileManager;
			
			private int key; 
			private int offSet;
		
			private String plainText;
			private String cipherText; 
			private String decipherText;
			private String fileName;
			
			
			
			// Display the menu
			public Menu() {
				input= new Scanner (System.in); // initialise scanner to take in user input
				
			}
			
			public void start() throws Exception  {
				while (keepRunning){
				displayOptions(); // callng the method to display menu options
				railFence = new RailFence();
				fileManager= new FileManager();
				
				//Get user's choice
				
				 int choice = input.nextInt();
				
				switch(choice) {
				   case 1:  fileName = fileManager.selectFile(); // user selects file as input
				 break;
				   case 2: 
							key = railFence.enterRailKey(); // accepts users input for key
							offSet= railFence.enterOffset(); // accepts users input for offset
						   break;
				   case 3: 
						   fileName = fileManager.selectFile();
                           key = railFence.enterRailKey();
						   offSet= railFence.enterOffset();
                           plainText = fileManager.readFile(fileName); // reads text file as plainText
                           railFence.encryptMessage(plainText, key, offSet, choice); //encrypts 
						   
						   break;
				   case 4: 
						 
						   fileName = fileManager.selectFile();
                           key = railFence.enterRailKey();
						   offSet= railFence.enterOffset();
                           railFence.decryptMessage(fileName, key, offSet, choice);
						   
						   break;
				   case 5:
							fileName = fileManager.selectFile();
                            key = railFence.enterRailKey();
							offSet= railFence.enterOffset();
                            plainText = fileManager.readFile(fileName);
                            cipherText = railFence.encryptMessage(plainText, key, offSet, choice);
						   break;
				   case 6: System.out.println("Quit.....BYE!!!");
				           keepRunning= false;
						   break;
				   default: System.out.println("Invalid choice");
				
				}
			  }
			
			}		
			
		
				
		private void displayOptions() { // this displays options for the user.
			System.out.println("******************************");
			System.out.println("*   Rail Fence Menu Options  *");
			System.out.println("******************************");
			System.out.println("(1) Select File or URL");
			System.out.println("(2) Enter Rail Fence Key and offset");
			System.out.println("(3) Encrypt");
			System.out.println("(4) Decrypt");
			System.out.println("(5) Display Rail Fence");
			System.out.println("(6) Quit");
			
			System.out.println("Please select an option [1-6]>");
			
		
		}
		
		
		
	}

	