#Shopping Automation Assessment

## This is a Selenium based project using Java, TestNg for automating 6 test cases using the Chrome browsed project using Chromedriver to test the website http://automationpractice.com/index.php

 
Get the repository from GITHUB and copy command you find below:
https://github.com/JimProfit1980/iNeedToBuyThings.git

#Software required in order to run project on windows machine Windows 10 machine, sorry did not test this on a Mac machine:

#Download Eclipse IDE software, the version I am using Version: 2021-09 (4.21.0):
##https://www.eclipse.org/downloads/packages/release/2021-09/r/eclipse-ide-java-developers 


Check if you have Java on your machine 
Go to the search bar by typing on the Ctrl + S and type Java, if nothing comes up then you don't have it installed. 
Also check on the command line, go to the search bar and type Ctrl + S and type cmd then select the command prompt, then type Java -version if you get an error "unregonized command" then you might not have Java installed. 
https://www.oracle.com/za/java/technologies/javase/jdk11-archive-downloads.html
If you don't have an account you have to sign up and download and install. 

Download Maven and follow those steps on the URL below:
https://maven.apache.org/install.html


You need to setup your system variables:
https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html that can be helpful but install jdk-11.0.10 or higher as I have that version installed. 
Or follow the steps below:
Go to this PC and right click and go to properties, advanced system settings click it, Environmental variables click it.
Click System Variables:
add or edit variable name JAVA_HOME and go to your JDK file you have downloaded. e.g. C:\Program Files\Java\jdk-11.0.10 as the variable value
add or edit MAVEN HOME the variable name and go to your apache file mine C:\Users\ShaneS\Documents\Learning\Automation\Maven\apache-maven-3.8.5 is variable value and file you have downloaded. e.g. C:\Program Files\Java\jdk-11.0.10

Once done close and open up the command prompt again and type in echo %JAVA_HOME you should see a path to your JDK or JRE installation then you are good to go as far as system vairables are concerned.

Open Eclipse IDE
Click File, import then Import from Git. Follow the steps and take from the develop branch that is the latest code.   
Follow the steps below from the URL:
https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html

Once the project has been opened up from the Eclipse
Go to the SRC folder, then Test and then Java

Double Click on file searchForAnItemTest.java

Right click and run as TESTNG app then the chrome driver will open and the tests will commence
Once done the results will be shown, 6 tests which would give you a pass or fail outcome

After the tests have run then go to test-output foler, expand and double click on the index.html file
Go to the passed methods show, shows the tests methods that passed

To run the maven command and run the project. Go to the taskbar and go Ctrl + S and run the mvn command clean, then mvn command test:
Chrome browser will open and the tests will run like and display the results once done in the command prompt. 

