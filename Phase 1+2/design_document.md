# Design

## SOLID Design Principles

Our design is consistent with the SOLID design principles. For some specific example, consider the following classes. We will indicate which deign principle is being used in brackets with one letter. For example, (S) would refer to adherence to the Single-Responsibility Principle.

### MainActivity

This class is the main class of the program. Since it is the default activity, it launches the user login page. For that reason, it only has a hard dependency on the LoginSystem class (D). 

``

