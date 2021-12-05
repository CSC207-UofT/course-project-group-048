# Design

## Class Breakdown

Our design is consistent with the SOLID design principles, Clean Architecture, and minimizes code smells. For some specific examples, consider the following classes. We will indicate which SOLID deign principle, Clean Architecture layer, or code smell is being referenced either directly or in brackets.

### ``MainActivity``

This class is the main class of the program and belongs to the outermost layer of Clean Architecture (**Frameworks & Drivers**). It interacts direclty with the View and delegates the main tasks. Since it is the default activity, it launches the user login page. For that reason, it only has a hard dependency on the ``LoginSystem`` class (**Dependency Inversion Principle**). The class is responsible to only one actor, the front-end designer, since it delegates user interactions to Controller classes (**Single Responsibility Principle**). 

The only major code smell was a **bloated** ``MainActvity.onClick`` method. This method checks the login fields for an entered username and password and logs in the user if their credentials are valid. Originally, we had created an instance of  ``LoginSystem`` from inside the method and called the ``LoginSystem.checkUsernamePassword`` method to validate a user's credentials. As per the [Long Method Bloater](https://refactoring.guru/smells/long-method) code smell guidelines, we noticed this was an example of "if you feel the need to comment on something inside a method, you should take this code and put it in a new method". This prompted the creation of ``MainActivity.checkFields`` and ``MainActivity.handleLogin`` to fix the code smell, which we resolved in issue [#9](https://github.com/CSC207-UofT/course-project-group-048/issues/9). Also, inside the ``MainActivity.onClick`` method, a previous implementation required a for loop to call a method with numerous parameters and iterate through a **bloated** list containing the id's for the views that we instanciated. However, this was bad design as the method was not clear or easy to understand. To resolve this issue we removed the long list of parameters and ...

### ``RegisterActivity``

This Activity represents the actions of the Registration Page of our application. It contains a user registration form that a first-time user fills out. This form contains fields for information about the user that will be used in the ``MealGenerator`` API, but most importantly, it contains username and password fields. The method ``RegisterActivity.onClick`` checks if all fields have been entered and displays a message to the user if this is not the case. Originally, this entire process was done, without delegating tasks to other classes and methods, directly inside the ``RegisterActivity.onClick`` method. While the code was correct and understandable, it was a **Long Method Bloater** that violated the **Open/Closed Design Principle** and did not adhere to Clean Architecture. 

Otherwise, the user information is handled by the ``LoginSystem`` **controller** and a new account is created.

Our original code for this class, while correct, had several code smells.
