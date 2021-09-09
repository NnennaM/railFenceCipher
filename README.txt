I.  Description
This is a command line menu-driven Java application that is capable of encrypting and decrypting a file using a Rail Fence cypher. 
A Rail Fence is a transposition cypher, where the letters of a plaintext are rearranged using a pattern to encrypt a message. 

II. File list
Runner.java Class contains the main method for running the application.
RailFence.java Class contains both encryption and decryption methods. 
Menu.java Class contains methods for displaying the user menu. 
FilesManager.java Class contains methods required for reading and saving into files and .


III. Design

A. RailFence

Contains four methods:

enterRailKey(): this method takes an input to represent the number of rows in the encryption matrix.

enterOffset(): this method takes an input to represent the number of offset/ starting point in the encryption matrix.

encryptMessage(): this method generates the encryption matrix. It requires the string to encrypt, the encryption key and the matrix to be filled in
this method takes as input the encryption matrix and generate the encrypted text.

displayRailFence(): this method displays the rail fence. 

decryptMessage(): this method generates the decryption matrix from an encrypted text. this method takes as input the decryption matrix and generate the original text.



B. FileManager

Contains three methods:

selectFile(): this method allows users to select a file from their drive. user pass in absolute path (e.g. on a windows os the absolute path is c:\\)
readFile(): this method reads the content of a plain text file for the purpose of encryption or decryption.
writeToFile(): this method writes to file an encrypted and decrypted message.



C. Menu

Contains 2 methods for displaying the menu to the user.

start(): this method deals with the functioning of the menu options.
dispalyOptions(): this method when called by start(), displays the option to the user as follows:

("******************************")
("*   Rail Fence Menu Options  *")
("******************************")
("(1) Select File or URL        ")
("(2) Enter Rail Fence Key      ")
("(3) Encrypt                   ")
("(4) Decrypt                   ")
("(5) Display Rail Fence        ")
("(6) Quit                      ")
			
("Please select an option [1-6]>")


IV. Execution

•	The application contains a command-line menu (as shown above) that prompts the user to enter an encryption key and a file. 
It then parses the given file line-by-line, encrypt / decrypt the text and then appends to an output file.

After running the program, the user will see the main menu as follows:

OPTION 1:


c:\Workspace>java Runner
******************************
*   Rail Fence Menu Options  *
******************************
(1) Select File or URL
(2) Enter Rail Fence Key and offset
(3) Encrypt
(4) Decrypt
(5) Display Rail Fence
(6) Quit
Please select an option [1-6]>
1
Enter file path or URL:
c:\Workspace\text.txt
File path: c:\Workspace\text.txt

OPTION 2:

******************************
*   Rail Fence Menu Options  *
******************************
(1) Select File or URL
(2) Enter Rail Fence Key and offset
(3) Encrypt
(4) Decrypt
(5) Display Rail Fence
(6) Quit
Please select an option [1-6]>
2
Enter Rail Fence Key:
5
Enter offset:
1
Offset entered: 1

OPTION 3:

******************************
*   Rail Fence Menu Options  *
******************************
(1) Select File or URL
(2) Enter Rail Fence Key and offset
(3) Encrypt
(4) Decrypt
(5) Display Rail Fence
(6) Quit
Please select an option [1-6]>
3
Enter file path or URL:
c:\Workspace\text.txt
File path: c:\Workspace\text.txt

Enter Rail Fence Key:
5
Enter offset:
1
Offset entered: 1

Message: STOPTHEMATTHECASTLEGATES

Message encrypted and successfully written to file

OPTION 4:

******************************
*   Rail Fence Menu Options  *
******************************
(1) Select File or URL
(2) Enter Rail Fence Key and offset
(3) Encrypt
(4) Decrypt
(5) Display Rail Fence
(6) Quit
Please select an option [1-6]>
4
Enter file path or URL:
c:\Workspace\Encrypted.txt
File path: c:\Workspace\Encrypted.txt

Enter Rail Fence Key:
5
Enter offset:
1
Offset entered: 1

Message: TTLSOATTEPMHSGSTEEAAEHCT
Decrypted Text:  STOPTHEMATTHECASTLEGATES
Message encrypted and successfully written to file

OPTION 5:

******************************
*   Rail Fence Menu Options  *
******************************
(1) Select File or URL
(2) Enter Rail Fence Key and offset
(3) Encrypt
(4) Decrypt
(5) Display Rail Fence
(6) Quit
Please select an option [1-6]>
5
Enter file path or URL:
c:\Workspace\Encrypted.txt
File path: c:\Workspace\Encrypted.txt

Enter Rail Fence Key:
5
Enter offset:
1
Offset entered: 1

Message: STOPTHEMATTHECASTLEGATES

   T                       T                       L
S     O                 A     T                 T     E
         P           M           H           S           G           S
            T     E                 E     A                 A     E
               H                       C                       T
Message encrypted and successfully written to file

OPTION 6:

******************************
*   Rail Fence Menu Options  *
******************************
(1) Select File or URL
(2) Enter Rail Fence Key and offset
(3) Encrypt
(4) Decrypt
(5) Display Rail Fence
(6) Quit
Please select an option [1-6]>
6
Quit.....BYE!!!









































































if there are any issues please contact....... (put in email address)


