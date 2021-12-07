# Design

## Class Breakdown

Our design is consistent with the SOLID design principles, Clean Architecture, and minimizes code smells. For some specific examples, consider the following classes. We will indicate which SOLID deign principle, Clean Architecture layer, or code smell is being referenced either directly or in brackets.

### ``MainActivity``

This class is the main class of the program and belongs to the outermost layer of Clean Architecture (**Frameworks & Drivers**). It interacts direclty with the View and delegates the main tasks. Since it is the default activity, it launches the user login page. For that reason, it only has a hard dependency on the ``LoginSystem`` class (**Dependency Inversion Principle**). The class is responsible to only one actor, the front-end designer, since it delegates user interactions to Controller classes (**Single Responsibility Principle**). 

The only major code smell was a **bloated** ``MainActvity.onClick`` method. This method checks the login fields for an entered username and password and logs in the user if their credentials are valid. Originally, we had created an instance of  ``LoginSystem`` from inside the method and called the ``LoginSystem.checkUsernamePassword`` method to validate a user's credentials. As per the [Long Method Bloater](https://refactoring.guru/smells/long-method) code smell guidelines, we noticed this was an example of "if you feel the need to comment on something inside a method, you should take this code and put it in a new method". This prompted the creation of ``MainActivity.checkFields`` and ``MainActivity.handleLogin`` to fix the code smell, which we resolved in issue [#9](https://github.com/CSC207-UofT/course-project-group-048/issues/9). I

Inside the ``MainActivity.onClick`` method, a previous implementation required a for loop to call a method with numerous parameters and iterate through a **bloated** list containing the id's for the views that we instanciated. However, this was bad design as the method was not clear or easy to understand. To resolve this issue we removed the long list of parameters and ...

### ``RegisterActivity``

This Activity represents the actions of the Registration Page of our application. It contains a user registration form that a first-time user fills out. This form contains fields for information about the user that will be used in the ``MealGenerator`` API, but most importantly, it contains username and password fields. The method ``RegisterActivity.onClick`` checks if all fields have been entered and displays a message to the user if this is not the case. 

Originally, this entire process was done, without delegating tasks to other classes and methods, directly inside the ``RegisterActivity.onClick`` method. While the code was correct and understandable, it was a **Long Method Bloater** that violated the **Open/Closed Design Principle** and the **Single Responsibility Principle** .

The ``RegisterActivity`` class is dependent on both the ``LoginSystem`` and ``MyDBHandler`` classes. This meant that the ``RegisterActivity`` class would be responsible to the actor that manages the database **and** the actor that manages login security, a violation of the **Single-Responsibility Principle**. It also meant our code was more closed to future change, as other members of our team that were not familiar with how ``MyDBHandler`` worked could not modify code in the ``RegisterActivity.onClick`` method. In order to refactor this, we made ``LoginSystem`` dependent on ``MyDBHandler``, which will be discussed in a later section. We then created methods  ``RegisterActivity.checkAllFieldsAndSignUp`` and ``RegisterActivity.performSignUp`` to fix the code smell, which we resolved in issue [#12](https://github.com/CSC207-UofT/course-project-group-048/issues/12).

### ``ProfileActivity``

When creating the Profile page, it became apparent that we would need to access the SQL database to view information about a specific ``User`` instance. Our current code had violated the **Open/Closed Principle** by only reading in a username and password pair in ``LoginSystem``. In order to access this information, the ``LoginSystem``, ``MyDBHandler``, ``MainActivity``, as well as this class needed many modifications. This resulted in a ``Shotgun Surgery`` in pull request [#26](https://github.com/CSC207-UofT/course-project-group-048/pull/26). This was the only major **Change Preventer** code smell in our program.

### ``LoginSystem`` and ``MyDBHandler``

An **Inappropriate Intimacy** code smell became apparent when trying to refactor the ``RegisterActivity.onClick`` method. The class ``LoginSystem`` required a HashMap of user information when being instantiated, which came from a method in ``MyDBHandler``:

``LoginSystem loginSystem = new LoginSystem(dbHandler.GetLoginData());``

This code smell violated Clean Architecture as a Framework & Driver class needed to instantiate a Use Case class (``MyDBHandler``) and then call one of its methods to instantiate a Controller class (``LoginSystem``). 
