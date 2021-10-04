# Phone Book

Phone Book is a server part (no UI) of an application for a management of users and their phone books. It a REST API application based on Spring framework.
#### Functional ####
1. User (first name, last name)
   + Add a user
   + Remove a user
   + Change a user
   + Find users by name
   + Get a list of all users
2. Contact (phone number, first name, last name, email)
   + Add a contact
   + Remove a contact
   + Change a contact
   + Find contacts in a user's phone book by a phone number or contact's ID
   + Get a list of all user's contacts
#### Application launch ####
You'll need Java 11 - Java 15.

Execute a command:
 ```
  java -jar phonebook.jar
 ```
#### Default application parameters #### 
Host: `localhost`
Port: `8080`

#### Application API ####
API entrypoint:
 ```
http://localhost:8080/
 ```

Swagger specification:
 ```
http://localhost:8080/phonebook-api.html
 ```
