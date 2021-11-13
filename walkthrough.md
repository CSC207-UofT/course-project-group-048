# Scenario Walk-Through

For the purposes of this phase of the project, our scenario walk through will run through what the user will experience through the final version of our app; as a result, some components of our specification such as the generation of the meal plan, as well as the food journal are not present due to the limitations of the command line interface. 

Upon running the code in the console or command line, users will be prompted to declare their status as a new or existing user. New users will be required to complete a personal information intake form, which gathers information about their username, password, and other personal information. This information will then be inputted into an algorithm to determine the user's Body Mass Index (BMI). Using this, alongside the user's goals, the program arrives at a goal caloric intake --- either putting the user in a caloric deficit or caloric surplus --- which is what the subsequent meal plan is based around.

The aforementioned meal plan will require the user to select their preferred style of diet: paleo, vegetarian, vegan, keto, or anything. Their selection and the goal caloric intake that the program arrives at are then used collaboratively to scrape the web and find pre-existing meal plans which satisfy the requirements. The meal plans provide various options for each meal; for example, if the user does not like the option for breakfast, they can simply click the refresh button and the program will provide an alternative option with similar nutritional values.

Thereafter, the new users are caught up with the progress of the existing users; and now, with each subsequent login, users can use the app as a food journal and keep track of their intake. They are asked to log if they ate the specified meal, and if they ate a different serving size or a completely different meal, they can choose to input the amount of their serving. The information inputted is used to create a graphical representation of their nutritional breakdown --- the percentage breakdown of macro-nutrients and weekly progress report outlining intake levels throughout the previous week. This will allow users to monitor their progress and see how their intake levels differ on a day to day basis.

As users progress toward their goal, they are to update their profile accordingly and potentially modify their goal to line up with their current progress. That is, if a user is finding their goal to be too ambitious and their weight is not decreasing at the expected level, they can input their updated weight and revamped goal to adjust as they see fit. 