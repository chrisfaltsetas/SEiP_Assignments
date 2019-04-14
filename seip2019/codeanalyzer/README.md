# Code Analyzer

This is a project containing an assignment to get familiar with programming patterns,
including the Strategy, Factory, Utility and Facade patterns.
The program receives a java source file and save in a csv file three metrics:
(1) Lines of Code, (2) Number of Classes, (3) Number of Methods.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Follow the instructions in the projects's [Prerequisites](https://github.com/chrisfaltsetas/SEiP_Assignments/blob/master/README.md#prerequisites) in order to download and install the required tools to build and run this program.

### Running the program

After building the project with Maven from the [instructions](https://github.com/chrisfaltsetas/SEiP_Assignments/blob/master/README.md#installing), you will find a new directory called ```target``` with a jar file, located in ```seip2019\codeanalyzer\```.

To run the program place your .java source code file in the ```target``` directory and execute the command:

```
your\file\path\seip2019\codeanalyzer\target>java -jar codeanalyzer-1.0-SNAPSHOT.jar <your_file_name.java> <regex||string>
```

Note: The second argument sets the type of the analysis. If an invalid argument is given, the program will analyze the code with regex.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use git for versioning. For the versions available, see the [commits on this repository](https://github.com/chrisfaltsetas/SEiP_Assignments/commits). 

## Authors

**Christos-Michail Faltsetas** - [chrisfaltsetas](https://github.com/chrisfaltsetas)
**Antonis Gkortzis** - [AntonisGkortzis](https://github.com/AntonisGkortzis)

See also the list of [contributors](https://github.com/chrisfaltsetas/SEiP_Assignments/contributors) who participated in this project.

## License

This project is not currently licensed. 
