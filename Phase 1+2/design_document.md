# Design

## Class Breakdown

Our design is consistent with the SOLID design principles, Clean Architecture, and minimizes code smells. For some specific examples, consider the following classes. We will indicate which SOLID deign principle, Clean Architecture layer, or code smell is being referenced either directly or in brackets.

### ``MainActivity``

This class is the main class of the program and belongs to the outermost layer of Clean Architecture (Frameworks & Drivers). It interacts direclty with the View and delegates the main tasks. Since it is the default activity, it launches the user login page. For that reason, it only has a hard dependency on the ``LoginSystem`` class (Dependency Inversion Principle). The class is responsible to only one actor, the front-end designer, since it delegates user interactions to Controller classes (Single Responsibility Principle).

### ``RegisterActivity``

This Activity represents the actions of the Registration Page of our application. It contains a user registration form that a first-time user fills out. This form contains fields for information about the user that will be used in the MealGenerator API, but most importantly, it contains username and password fields. The method ``onClick`` checks if all fields have been entered and displays a message to the user if this is not the case. Otherwise, the user information is handled by the ``LoginSystem`` controller and a new account is created. Our original code for this, while correct, had several code smells.
