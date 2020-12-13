
Program:
Execute program using jar:
1. Download project from Github
2. Open Command prompt --> Go to path of jar file (inculded in root folder CollinsonVendingMachineAssignment/VendingMachineProgram/)
e.g. C:\Users\Suchita.Thorat\git\CollinsonVendingMachineAssignment\VendingMachineProgram>
3. Run main class using jar (specifying main class including package)
java -cp VendingMachine.jar Collinson.VendingMachineProgram.RunVendingMachineProgram
-------------
Steps to execute Program directly (from command line) -
1. Download project from Github
2. Go to command prompt --> then path of VendingMachineProgram (till inside the package)
like /VendingMachineProgram/src/main/java/Collinson/VendingMachineProgram
3. Now Run below command for compiling
javac *.java 
e.g. C:\Users\Suchita.Thorat\git\CollinsonVendingMachineAssignment\VendingMachineProgram\src\main\java\Collinson\VendingMachineProgram>javac *.java
4. Now move up at folder level 
\VendingMachineProgram\src\main\java
Now run the program using below command(including package name)-
java Collinson.VendingMachineProgram.RunVendingMachineProgram
e.g C:\Users\Suchita.Thorat\git\CollinsonVendingMachineAssignment\VendingMachineProgram\src\main\java>java Collinson.VendingMachineProgram.RunVendingMachineProgram
-------------
Program execution from IDE-
Select RunVendingMachineProgram.java file from project structure --> Run as --> Java application

*****Please note:*****Main method currently executes just few hard coded functionalities (just to show sample run using main method), 
if needed it can be changed to accept inputs from user/file and using Scanner class to read the input (as per requirements)
Program's each functionality validated in Unit Tests separately.
 
Program Assumptions:
   - Vending Machine is single-threaded, only one user will operate at a time.
   - A call to reset() will reset item and balance to 5 each item and coins
******************************************************************
Tests:
Steps to execute Tests (as Maven test from command line) -
1. Download project from Github
2. Go to command prompt --> then path of VendingMachineProgram (root folder)
3. mvn test
e.g. C:\Users\Suchita.Thorat\git\CollinsonVendingMachineAssignment\VendingMachineProgram>mvn test
----
Tests run from IDE 
run as TestNG suite using testng.xml

******************************************************************
Extent Test Reports location (please open below path in web browser to view test run report) -
userDirectory\VendingMachineProgram\reports\ExtentTestReport.html

Listener and Extent Report implemented in below file-
userDirectory\VendingMachineProgram\src\test\java\Collinson\VendingMachineProgram\ListnerTest.java

As program is small, all tests are written in single Test file for convenience-
src\test\java\Collinson\VendingMachineProgram\VendingMachineTest.java

Tests execution decided based on testng.xml file, by using inclusion/exclusion of test methods we can customise it(right now executes all the tests present in VendingMachineTest)

TestNg is integrated with Maven by specifying testng.xml configuration under surefire plugin.




