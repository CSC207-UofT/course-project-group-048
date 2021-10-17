# Progress Report


We are developing an app that provides nutritional suggestions to a user depending on their age, sex, BMI, height, weight, and goal weight over a certain time frame. The app produces a specific meal plan which accommodates the user's inputted goals and provides various options for different food preferences while still reaching nutritional goals. The app uses web scraping to gather comprehensive nutritional facts and optimize the meal plan, giving the users a food journal to keep record of their diet and its breakdown.

The app also provides the user with an option to input their daily meals and gives a progressive report on their health. This tracks and compares the user's progress to their set health goals and suggests the appropriate course of future action based on their current health status. In short, the app provides interactive and live nutritional guidance to the user based on their current health status and the goal they want to achieve. Users log into the system with their individual username and password to retain their information.

### Summary of CRC cards
The main classes involved in the functioning of the app are given below.

We plan to add more classes in the future if required but currently we have implemented the above mentioned classes and also discussed how they are going to work with each other to produce our desired result.

A more comprehensive understanding of their working can be understood through the CRC cards we have prepared which we will briefly summarise here.

The ``User`` class is one of the main classes of our program. It stores the user's inputted details such has their name, height, weight, BMI, age, password and activity level. Each of these parameters has an attribute that stores the corresponding values. This class works with \texttt{FoodItem} to keep track of the user's periodic intake.

The ``Stat`` class stores the user's daily statistics which include their caloric intake along with food items intake. It also records the start and end date of the tracking period. This class will have to store instances of ``FoodItem`` to keep record of the daily food intake of the user.

The ``FoodItem`` class stores all the information about any food item that the user intakes including the name, type, nutrient content and the amount taken. This class will have instances of the ``Nutrient`` class to store the nutrient content of each food item.

The ``Nutrient`` class makes proper comparisons in terms of nutritional values in addition to keeping track of the totality of nutrient intake.

The ``Goal`` stores the user's planned goal level of fitness. This includes the height and weight the user plans to achieve and the due date by which they plan to achieve it.

The ``MealGenerator`` is used to generate a meal plan for the user based on the goal set and the dietary restrictions (if any) the user has.

The ``Progress`` class stores and updates the user's weight, BMI and nutritional levels. This can be used to allow users to keep track of their progress and the app will use this to give live suggestions to best help users achieve their goal.

The ``App`` controls the program itself and is designed to be extended by a User Interface class.

``Main`` creates the command line environment, prompts users for information and allows users to interact and use the programs functionality. It launches ``ConsoleApp`` and runs the program.

``Util`` implements methods that are used in order to get input from the console. This class is used in the ``LoginSystem`` and in other places where user interaction and input is required.

``ConsoleApp`` runs the program through the console by asking
for user input with ``Scanner`` objects.

### Member Contribution and Future Plans

Aryamann helped with writing the specification, developing the CRC cards and writing the skeleton code for the ``Progress`` class. He also assisted in drafting the progress report for Phase 0 of the project. Now he plans on developing the \texttt{Progress} code that will enable the user to track their progress and also looks forward to working on methods that the app can interact with ``User`` and ``Goal`` to give live suggestions to the user based on their current progress compared to their end goal.

Harsh assisted in developing the original framework for the program, making the CRC cards and identifying the required classes and integrating them together into a functional program that a user could navigate through. He worked on the user class and helped formulate a command line interface for users. He looks forward to using APIs to enhance the functionality of the program and develop a useful meal generator.

Paula has helped with making the CRC cards and has been working on the ``FoodItem`` and ``FoodItems`` classes that store information of the food items. She is planning to work on the Nutrient class and the interactions between FoodItem class, User class and Nutrient class in the future.

Will has been working on making a secure login system with password hashing in ``LoginSystem``, custom exceptions to handle invalid login credentials in the exceptions package, a parent class to represent a general controller class for our app in ``App``, a simple console version of our app in ``ConsoleApp``, and proper documentation on all classes. He plans to make a subclass of App to represent a graphical UI (web component), store the user login information in a database and access it with the ``LoginSystem`` class, and incorporate the Goal class with User.

Ram has worked on the specification, CRC model, Scenario walk through, and a few small fixes within the skeleton program. He looks forward to working on the web application development part of the program

### What Has Worked Well
The ``LoginSystem`` and ``User`` classes have worked well in terms of design. It is intuitive and efficient to store a list of ``User`` in ``LoginSystem`` and compare the provided username upon login with each ``User``'s username. 

### Open Questions
There are still a lot of undecided features we might implement in our app. For example we had initially planned to have a Digital Recognition feature that would help the user to click photos of food items to get information on its nutritional value and whether that item could be incorporated into their food plan.

Although it seems to be a promising feature we still haven't given enough thought on how we would implement this and whether or not it would be feasible in the given time frame.

Our main questions are:
1. What is the best way to store data for the app? The ``LoginSystem`` class must store credentials and data for each user that signs up for the app. ``FoodItems`` must store many instances of ``FoodItem``.
2. Should ``Nutrient`` be a parent class of ``FoodItem`` or an interface? Each instance of ``FoodItem`` must have nutritional value that will be calculated and compared to with other instance of ``FoodItem``.
3. How should we design the graphical user-interface for the app? Is a web application best? If so, what is the best approach to take?
4. A ``LoginException`` may be thrown by ``LoginSystem.registerUser`` or ``LoginSystem.loginUser`` given an invalid username or password. Where should this exception be handled? In the controller? It is currently being handled in the ``ConsoleApp`` class.
