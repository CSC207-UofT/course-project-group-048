# Design

## SOLID Design Principles

Our design is consistent with the SOLID design principles. For some specific example, consider the following classes.

### MainActivity

This class is the main class of the program. Since it is the default activity, it launches the user login page. For that reason, it only has a hard dependency on the LoginSystem class. 

