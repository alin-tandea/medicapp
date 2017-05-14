<<<<<<< HEAD
# medicapp

This project represents an application for managing the patients arrival and appointment
at a medical institution 

The system can be accesed by 3 types of users :
	
	* medic
	* administrator
	* secretary
	
You can use the provided sources to test the functions of the system  . The SQL script contains
some mock data with an account for each type of user .

### Mock user accounts

Account usernames : 
	
	*medic : "medic"
	*administrator : "admin"
	*secretary : "secretary"
	

All the above accounts use the same password : "123456"

#### Backend server

The JAVA part of the application runs on an Apache Tomcat 8.5 server  . You can import the provided
source into the Eclipse IDE ( that's the one i've used , it might work on other IDE ) and choose
the "Run on server option" . 


### Angular 2 server

The initial project was generated using the Angular - CLI tool which also generated a README.md 
file in the "medicapp-ng2" folder . You should also check that out for more information about 
the project

Before starting you must make sure you have NodeJS and NPM installed on your machine (just use Google 
for information about how to install those ) 

The project hosted on GitHub does not contain the packages needed in this project  , that means
you have to download those in the current project . You can do that by following these steps :
	
	* open a Command Prompt window
	* change directory to the medicapp-ng2 directory
	* run the following commands
		* npm install
		* npm install materialize-css --save
		* npm install angular2-materialize --save
		* npm install --save ng2-loading-animate
		* npm install file-saver --save
	* you have to wait for each of those commands to download and install the required packages(it will take a while)
	* now you are ready to start the angular 2 server by typing : ng serve -o
	* you can see the website on http://localhost:4200
