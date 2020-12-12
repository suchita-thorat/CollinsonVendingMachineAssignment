
Program:
Steps to execute Program (from command line) -
1. Download project from Github
2. Go to command prompt --> then path of VendingMachineProgram (till inside the package)
like /VendingMachineProgram/src/main/java/Collinson/VendingMachineProgram
3. Now Run below command for compiling
javac -Xlint:unchecked RunVendingMachineProgram.java VendingMachine.java VendingMachineFactory.java VendingMachineImpl.java Inventory.java Coin.java Bucket.java Item.java NotFullPaidException.java NotSufficientChangeException.java SoldOutException.java

e.g. C:\Users\Suchita.Thorat\eclipse-workspace\VendingMachineProgram\src\main\java\Collinson\VendingMachineProgram>javac -Xlint:unchecked RunVendingMachineProgram.java VendingMachine.java VendingMachineFactory.java VendingMachineImpl.java Inventory.java Coin.java Bucket.java Item.java NotFullPaidException.java NotSufficientChangeException.java SoldOutException.java
4. Now move up in path at folder level 
\VendingMachineProgram\src\main\java
Now run the program using below command(path including package name)-
java Collinson.VendingMachineProgram.RunVendingMachineProgram
e.g C:\Users\Suchita.Thorat\eclipse-workspace\VendingMachineProgram\src\main\java>java Collinson.VendingMachineProgram.RunVendingMachineProgram
-------------
Program run from IDE Eclipse/Intellij -
By choosing RunVendingMachineProgram.java file from project structure --> Run as --> Java application

Program Assumptions:
   - Vending Machine is single-threaded, only one user will operate at a time.
   - A call to reset() will reset item and balance to 5 each item and coins
******************************************************************
Tests:
Steps to execute Tests (as Maven test from command line) -
1. Download project from Github
2. Go to command prompt --> then path of VendingMachineProgram (root folder)
3. mvn test
e.g. C:\Users\Suchita.Thorat\eclipse-workspace\VendingMachineProgram>mvn test
----
Tests run from IDE Eclipse/Intellij 
run as TestNG suite using testng.xml

******************************************************************
Extent Test Reports location (please open below html path in web browser to view test run report) -
userDirectory\VendingMachineProgram\reports\ExtentTestReport.html

FYI,Listner and Extent Report coded in below file-
userDirectory\VendingMachineProgram\src\test\java\Collinson\VendingMachineProgram\ListnerTest.java

As program is small all tests are written in one Test file for convenience-
src\test\java\Collinson\VendingMachineProgram\VendingMachineTest.java

Test execution inclusion/exclusion methods can be controlled via testng.xml file (right now it executes all tests present in VendingMachineTest)

TestNg is integrated with Maven by specifying testng.xml configuration for surefire plugin.




