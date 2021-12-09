# Design Document

## Refactoring, SOLID, and Clean Architecture Examples

Our design is consistent with the SOLID design principles, Clean Architecture, and minimizes code smells. For some specific examples, consider the following classes. We will indicate which SOLID deign principle, Clean Architecture layer, or code smell is being referenced either directly or in brackets.

#### ``MainActivity``

This class is the main class of the program and belongs to the outermost layer of Clean Architecture (**Frameworks & Drivers**). It interacts direclty with the View and delegates the main tasks. Since it is the default activity, it launches the user login page. For that reason, it only has a hard dependency on the ``LoginSystem`` class (**Dependency Inversion Principle**). The class is responsible to only one actor, the front-end designer, since it delegates user interactions to Controller classes (**Single Responsibility Principle**). 

The only major code smell was a **bloated** ``MainActvity.onClick`` method. This method checks the login fields for an entered username and password and logs in the user if their credentials are valid. Originally, we had created an instance of  ``LoginSystem`` from inside the method and called the ``LoginSystem.checkUsernamePassword`` method to validate a user's credentials. As per the [Long Method Bloater](https://refactoring.guru/smells/long-method) code smell guidelines, we noticed this was an example of "if you feel the need to comment on something inside a method, you should take this code and put it in a new method". This prompted the creation of ``MainActivity.checkFields`` and ``MainActivity.handleLogin`` to fix the code smell, which we resolved in issue [#9](https://github.com/CSC207-UofT/course-project-group-048/issues/9). I

Inside the ``MainActivity.onClick`` method, a previous implementation required a for loop to call a method with numerous parameters and iterate through a **bloated** list containing the id's for the views that we instanciated. However, this was bad design as the method was not clear or easy to understand. To resolve this issue we removed the long list of parameters and ...

### ``RegisterActivity``

This Activity represents the actions of the Registration Page of our application. It contains a user registration form that a first-time user fills out. This form contains fields for information about the user that will be used in the ``MealGenerator`` API, but most importantly, it contains username and password fields. The method ``RegisterActivity.onClick`` checks if all fields have been entered and displays a message to the user if this is not the case. 

Originally, this entire process was done, without delegating tasks to other classes and methods, directly inside the ``RegisterActivity.onClick`` method. While the code was correct and understandable, it was a **Long Method Bloater** that violated the **Open/Closed Design Principle** and the **Single Responsibility Principle** .

The ``RegisterActivity`` class is dependent on both the ``LoginSystem`` and ``MyDBHandler`` classes. This meant that the ``RegisterActivity`` class would be responsible to the actor that manages the database **and** the actor that manages login security, a violation of the **Single-Responsibility Principle**. It also meant our code was more closed to future change, as other members of our team that were not familiar with how ``MyDBHandler`` worked could not modify code in the ``RegisterActivity.onClick`` method. In order to refactor this, we made ``LoginSystem`` dependent on ``MyDBHandler``, which will be discussed in a later section. We then created methods  ``RegisterActivity.checkAllFieldsAndSignUp`` and ``RegisterActivity.performSignUp`` to fix the code smell, which we resolved in issue [#12](https://github.com/CSC207-UofT/course-project-group-048/issues/12).

### ``ProfileActivity``

When creating the Profile page, it became apparent that we would need to access the SQL database to view information about a specific ``User`` instance. Our current code had violated the **Open/Closed Principle** by only reading in a username and password pair in ``LoginSystem``. In order to access this information, the ``LoginSystem``, ``MyDBHandler``, ``MainActivity``, as well as this class needed many modifications. This resulted in a ``Shotgun Surgery`` in pull request [#26](https://github.com/CSC207-UofT/course-project-group-048/pull/26). This was the biggest **Change Preventer** code smell in our program.

### ``LoginSystem`` and ``MyDBHandler``

An **Inappropriate Intimacy** code smell became apparent when trying to refactor the ``RegisterActivity.onClick`` method. The class ``LoginSystem`` required a HashMap of user information when being instantiated, which came from a method in ``MyDBHandler``:

``LoginSystem loginSystem = new LoginSystem(dbHandler.GetLoginData());``

This code smell violated Clean Architecture as a Framework & Driver class needed to instantiate a Use Case class (``MyDBHandler``) and then call one of its methods to instantiate a Controller class (``LoginSystem``). This was then fixed by refactoring the code such that the ''Main Activity'' class now only depends on the Controller Class (``LoginSystem``) which in turn retrieves the user data from the Use Case (``MyDBHandler``) when an instance of it is created. Therefore we don't have to create a seperate dbHandler object to pass on the user information to ``LoginSystem``. Thus the above code snippet was be replaced by,

``LoginSystem loginSystem = new LoginSystem(this);``

where ''this'' refers to the Activity Class the code was called in. This is required by ``LoginSystem`` to access the database via children of ``MyDBHandler``. 

Another example of a code smell that was refactored was **Dispensable Duplicate Code** in the way data was stored and accessed. We initially had two Use Case classes ``MyDBHandler`` and ``MealDBHandler`` which had very similar methods to deal with two different databases. These classes stored the user and meal information respectively and only differed in the structure of SQL tables.

Refactoring this code was a bit challenging but we ended up creating a parent class ``MyDBHandler`` which handles the creation of a singular database (NutritionApp.db) that stores both the user login information and the meal nutritional information. These are stored in two different tables and seperately accessed by the children, namely ``LoginDataHandler`` and ``MealDataHandler``. This enabled a change in dependency of the ``LoginSystem`` class from ``MyDBHandler`` to its child class ``LoginDataHandler`` which was responsible for parsing and retrieving the login information from the database. Hence, the refactoring resulted in the avoidance of duplicate code and a dispensable secondary database.

We have also ensured that the code for in accordance with the **Open/Closed Design Principle** for ``MealDataHandler``. While no user of the app is able to change data containing food items in the database, a developer would be able to integrate such changes with the use of the ``MealDataHandler.addFood`` method. Therefore unlike ``LoginDataHandler``, the class ``MealDataHandler`` does not edit any information present in the meal data once the database has been created. This wasn't what we had planned at the beginning of the term but due to a lack of time we weren't able to add features that would allow the user to add more options to their meal plan.

### ``Meal Class``

The Meal Class currently contains an attribute called "type" which denotes the type of the meal - breakfast, lunch, or dinner. This is a **Change Preventer** code smell that does not fully adhere to the **Open/Closed Principle** that we did not refactor. As a result, if we were to try and incorporate a new type (i.e. "Snack") we would have to change classes and bits of code. With more time, we would have improved this design by making ``Breakfast``, ``Lunch``, and ``Dinner`` subclasses of an abstract class ``Meal``. This would mean creating new Meals could be done using the **Factory Design Pattern**.


## Design Patterns





## GitHub Features
In Phase 1 of our project, we decided to incorporate the Android Studio IDEA, which resulted in a conflict with our pre-existing code working in the Intelli-J IDEA. Consequently, we were unable to correctly upload our project onto GitHub - preventing us from collaborating effectively using the power of Version Control. Once we resolved this issue, we were able to create individual branches which were either working on particular features of the app, or tracking the Main branch. We also began incorporating GitHub Issues and Pull Requests to adequately communicate the issues we encountered within our code. This allowed us to be very specific with what Issues the Pull Requests were resolving. Further, we made an attempt to make use of GitHub Actions to run our tests automatically, however, we encountered an error when attempting to do so. With the limited time we had remaining, we were unable to troubleshoot the error and get the GitHub Actions to work correctly with out tests.

## Code Style, Organization, and Documentation

## Functionality

## Testing






