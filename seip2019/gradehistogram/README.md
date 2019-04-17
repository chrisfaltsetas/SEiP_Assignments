# Grade Histogram

This is a project containing an assignment to get familiar with the Maven building tool.
The program receives a file with grades and shows a histogram with the frequency of those grades.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Follow the instructions in the projects's [Prerequisites](https://github.com/chrisfaltsetas/SEiP_Assignments/blob/master/README.md#prerequisites) in order to download and install the required tools to build and run this program.

### Running the program

After building the project with Maven from the [instructions](https://github.com/chrisfaltsetas/SEiP_Assignments/blob/master/README.md#installing), you will find a new directory called ```target``` with two jar files, located in ```seip2019\gradehistogram\```.

To run the program place your .txt file in the ```target``` directory and execute the command:

```
your\file\path\seip2019\gradehistogram\target>java -jar gradehistogram-1.0-SNAPSHOT-jar-with-dependencies.jar <your_file_name.txt>
```

Note: In order to successfully read the grades, your file must have a specific format.
Each grade has to be in a new line, for example:

```
5
1
6
9
10
4
7
4
4
```

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
