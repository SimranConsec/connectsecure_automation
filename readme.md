
# java-testng framework

## Features and specification required

- This is java selenium and testng based framework
- Java 11 or above version
- selenium 4 or above version
- Any IDE like eclipse, intellij, vsc etc



## Authors

- [@simran kumari]

General Project Structure:
---------------------------------
    ├── automationfolder               # Main automation module
    │  ├── code-compliances            # code compliance files           
    │  ├── drivers  
    │  │   └── chromedriver.exe        # browser drivers like chromedrivers, geckodrivers etc
    │  └── src
    │     ├── main
    │     │  └──  java 
    │     │  	└─ com	 
    │     │  	  └─ oneframe  
    │     │             └─ constants   # keep all the constants here.
    │     │             └─ helper      # keep all the helper files here.
    │     │             └─ reporting   # keep the all reporting related files here.
    │     │             └─ utils       # keep all the framework related utility classes here.
    │     │  └── resources  
    │     │      └── payloads          # keep all the API related payloads here               
    │     ├── test
    │     │  └── java                  # keep all the test cases files, listeners files here.
    │     │  └── resources             # keep all the configurations files, test data files here
    └── target
    │    └── all the compiled classes will be here and you can find the test execution reports here
    └── README.md
    └── testng.xml   	  	  # this is one of the most important files, do not forgot to update the class name you are adding as a part of automation testing.
    

## Coding standard/Code style & Code formatter:

It is mandatory to follow code style and conventions. Follow few simple steps to apply code style:

* If you are using eclipse, follow below steps


    Project -> Preferences -> JavaCode style -> import -> import the *.xml(java-google-style.xml) and apply

## Important commands to run the project
* If you are running this project for the very 1st time, then run the command
	
	 mvn clean install

* To run the entire automation suite, run the below commands

	 mvn clean test





