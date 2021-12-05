# Design

## Class Breakdown

Our design is consistent with the SOLID design principles, Clean Architecture, and minimizes code smells. For some specific examples, consider the following classes. We will indicate which SOLID deign principle, Clean Architecture layer, or code smell is being referenced either directly or in brackets.

### ``MainActivity``

This class is the main class of the program and belongs to the outermost layer of Clean Architecture (Frameworks & Drivers). It interacts direclty with the View and delegates the main tasks. Since it is the default activity, it launches the user login page. For that reason, it only has a hard dependency on the ``LoginSystem`` class (Dependency Inversion Principle). The class is responsible to only one actor, the front-end designer, since it delegates user interactions to Controller classes (Single Responsibility Principle). 

The only major code smell was a Bloater in the ``MainActvity.onClick`` method. This method checks the login fields for an entered username and password and logs in the user if their credentials are valid. Originally, we had created an instance of  ``LoginSystem`` from inside the method and called the ``LoginSystem.checkUsernamePassword`` method to validate a user's credentials. As per the Long Method Bloater code smell guidelines, we noticed this was an example of "if you feel the need to comment on something inside a method, you should take this code and put it in a new method". This prompted the creation of ... Also inside the ``MainActivity.onClick`` method, there was previously a **bloated** onClick method, the implementation for which required the call for a for loop with numerous parameters to iterate through a **bloated** list containing the id's for the views that we instanciated. However, this was bad design as the method was not clear or easy to understand. To resolve this issue we removed the long list of parameters... 

### ``RegisterActivity``

This Activity represents the actions of the Registration Page of our application. It contains a user registration form that a first-time user fills out. This form contains fields for information about the user that will be used in the MealGenerator API, but most importantly, it contains username and password fields. The method ``onClick`` checks if all fields have been entered and displays a message to the user if this is not the case. Otherwise, the user information is handled by the ``LoginSystem`` controller and a new account is created.

Our original code for this class, while correct, had several code smells.
