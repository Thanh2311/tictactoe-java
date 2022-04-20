# Adapted for use in York University EECS4315 Project

## Build
In order to build the project, ensure the environment variable JPF_HOME is set properly as in the book   
Java PathFinder: a tool to detect bugs in Java code, Section 1.1.

Then run the following maven command in a terminal in the root directory. You can also import it into eclipse as an existing maven project and running Maven Build with using the same parameters.

    mvn package -DskipTests

Some members had problems building due to the Path in the pom.xml, so please correct line 33 of the pom.xml with the location of your jpf installation. Specifically, it required the members to provide an absolute path instead of a relative path.

## Running JPF
There are serveral application properties files in the the project.
To run them, open a terminal in the project's root directory and run 

    jpf TicTacToeMain.jpf
    jpf tictactoebrian.jpf
Then change to the model-checking directory and run

    jpf CheckCycles.jpf
    jpf tictactoebrian2.jpf


## Modifications:
* replacing user inputs with random inputs, automating the entire game.
* removed all output except the winner 
* requires Java 8 
* Added a listener to count wins, losses, and draws
* Added a listener to help fix cycles in the tic tac toe game
* Added a listener to determine the average move attempts per game.




***
# Simple TicTacToe Game #
by Tim Tsu

<strike>

## Getting started ##
### Prerequisites ###
* JRE 1.6
* Maven 2 or Gradle

### Build and Run ###
#### Maven ####
    mvn package
    java -jar target/tictactoe-1.0.jar
#### Gradle ####
    gradle installApp
    ./build/install/tictactoe-java/bin/tictactoe-java

</strike>
