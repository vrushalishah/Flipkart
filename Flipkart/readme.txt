Flipkart Test case execution Guide


Project Flow :

1)In project user need to pass two parameter 1.project environment (stage,uat,prod) and 2.browser type(firefox ,chrome) , thses parameters we need to pass when we are reading the configuration file

2)I have created "ConfigReader" class and inside this class I have created a method name "configParameterReader" this method will return  a list of parameters based on selected environment and browser type .on the basis of selected environment user will get "URL" (either of stage ,uat or of production) and browser type (either chrome or firefox)

3)user can able to change the login credential from "Config.properties" file in this file add your username and password .
as off now I have created a dummy account and default  I have added those credentialto config file .
below are the login credential for dummy account on flipkart for testing purpose :
 USERNAME : 9975719261
 PASSWORD : vrush2112
you can able to change these value.

4)Once your parameters are ready you can able execute all testcases from "MainExecution" class .
for that you need run the class a TestNg class .

5)This class will read parameters from config file pass these parameters to methos I have written for every testcase in different class (Page Object Class)

6)you will be able to see the testcases success and failure result on console.

7)You can able to see all errors and debugging steps in the Log file which I have created using "Log4j" this file will be getting generated where user will save the Project .

path foe log file = prject_path/Flipkart_log/flipkar_log.log


8)When you execute last test case i.e TestcaseEight then user will able to see screen shot of page in which "Mototrola 5g plus" phone is added to the cart , this screen shot is .png format 

path for screenshot = prject_path/ScreenShot/MobileAddToCartCaputre.png


Environment Setup :

System Requirenment :

1)Java installed on machine (any version e.g -jdk 1.7)
2)Firefox 46.0.1 (This version of firefox is require to view the results)
3)After downloading the project from git :

To download project from git use below credential of git account :

	UserName : vrushalishah
	Password : vrush2112
If above credential not able to Login use below direct link to clone and read the project from git:
"https://github.com/vrushalishah/Flipkart" 

4)Import the project in eclipse
5)After that check whether TestNg is installed or not
6)If not then in eclipse go to Help->Eclipse marketplace then search for "testng" then you will find plugin name "TestNg for Eclipse" click on install button and then it will ask you to restart you eclipse do restart your eclipse and run the "MainExecution" as TestNg Test





