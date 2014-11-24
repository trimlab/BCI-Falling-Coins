BCI-Falling-Coins
=================

Description
---------
Mini-game that uses the Emotiv EPOC as a control system. The objective is to move the bucket to collect all of the falling circles. 

Requirements
---------
- An up-to-date .jar file of the compiled BCI-Falling-Coins software.
- A Java 8 runtime environment on the computer.

Run
---------
Run from the system command prompt (or terminal).
For Windows users, use the following command:
	java -jar /path/to/the/jar.jar <arg1> <arg2> <arg3>
- arg1: The file that contains the testing duration OR an integer that is the testing duration.
- arg2: The name of the file where the data from the test will be stored (if it already exists, the new data will be appended, if it doesn't a new file will be created)
- arg3: The ID code for the test
The program will start executing immediately after using the command in the cmd.
Use the 'a' key to move left, the 'd' key to move right, and the 's' to stop moving.

Mapping the EPOC
---------
To map the EPOC to the program, train the user in the motions left and right in the Emotiv EPOC SDK. Then in the EmoKey program map left to 'a', right to 'd', and use 's' as a default value if left or right is not "strong" enough.

Uninstall
---------
The program does not install any dependencies, so to remove simply delete the .jar file.