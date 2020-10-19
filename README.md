# Simple Web-app

It is a small web application that built with [Spring Boot](https://spring.io/), [Thymeleaf](https://www.thymeleaf.org/), [Bootstrap](https://getbootstrap.com/) 
and [Hummer.js](https://hammerjs.github.io/) and have the features of registering,
authorizing users and posting messages with rating.


## Description

This small web application that built on the [Spring Boot](https://spring.io/) engine has several functions.

 Each new User can register in the System via his/her own email, name and password.
 Information about each new user is stored in the [MongoDB database](https://www.mongodb.com/).
 The User's password is kept in the database by an encrypted [Bcrypt script](https://en.wikipedia.org/wiki/Bcrypt), which makes its storage secure.
 The User can log in by using their password and email as a login.
 There is also a logout button if it is necessary.
 
 Due to the specifics of the registration and authorization modal windows, 
 I had to configure custom handlers for successful and failure login, logout and registration.
  For example, the registration process is handled by the jQuery script, which replaces the usual submit bottom action 
  with a custom one, which sends user data to the controller, receives the response code from the controller and in 
  case of an error, displays the error message on the special area on the modal form without closing the modal window.
 
 The content of each page changes if the user is authorized in the system.
 This realization was made possible by [thymeleaf](https://www.thymeleaf.org/)
 Only authorized users can post messages, but all users may 'like' posts.
 
---
 
 During creation, I focused on the frontend side and using jQuery scripts. This gave me many new skills. 
 
 By using Bootstrap, I realized a slider on the homepage, which with an additional 
 script from [Hummer.js](https://hammerjs.github.io/) became controllable by swipes on smartphones.
 
 Also, by using jQuery script it is realized a stars rating system on the community page.
 
 Each page has adaptive design and adapts to the screen size of your device.  For example, 
 the button of personal profile in the navigation bar changes to a small icon, on a small size screen etc.
 
 
## Launch manual

*To launch the program you should have installed [JRE](https://java.com/ru/download/) and [MongoDB](https://www.mongodb.com/) 
on your computer. Please install it if there are no exists.*

* Clone repository to your machine
* Open the root folder of the project
* Run the following command
``` 
$ java -jar target/*.jar
```
* Wait until finished loading

> *The first launch of service creates a database*

* Next you should go to http://localhost:8080/ to open a home page.

> *Do not close the terminal - it will cause the shutdown of the service.*

## 'In the future' and problems

* At now, I could not find a solution to the problem of full page reload after a 'like' 
a certain post. One of my solutions was to add a custom handler to 'like' element, 
send POST request to controller with disabled CSRF and use jquery .load() method to update 
'likes' quantity. For some reason, with each press of a 'like', the quantity of automatically 
sent requests grew exponentially, thus breaking the all algorithm. 

* Unfortunately, due to the previous problem, I didn't have time to finish realization 
of the personal profile page of a user and access of users to personal profiles of other users.
There are age and last name fields in the User document model, which I will use to expand 
information about users in the user's personal profile.

* I also want realize the possibility of adding a user photo in user's personal profile.  Photos of users are added 
to posts, when they are published. At now there is a dummy in the controller that allows use Thymeleaf function, which sets 
a special 'no photo' picture for users who have not yet installed their photos.

* It is necessary to improve the adaptability of some graphic elements and fonts - the view 
on small screens was far from perfect.

* In the future, I will also need to implement pagination on the community page for comfortable and customizable display of posts. 

* There is a problem with displaying posts, when a new published post is added to the end of the list. Pagination should solve this problem too.

## Built with

* [Spring Boot](https://spring.io/)
* [Thymeleaf](https://www.thymeleaf.org/)
* [MongoDB](https://www.mongodb.com/)
* [Bootstrap](https://getbootstrap.com/)
* [Hummer.js](https://hammerjs.github.io/)

## Authors

* [Nikita-prF](https://github.com/Nikita-prF)

### Just a little about

*This was my first more or less serious project with frontend side and using jQuery scripts. 
It was great, and the new skills of jquery gave a lot of features to extend the standard functionality of the 
usual Spring Boot project.*
 
 
 
 


