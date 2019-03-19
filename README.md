# MavenAssignment

This is a project for a university assignment to help students learn about Maven and its features.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

In order to build the project you will have to install [JDK version 1.8.0_201](https://www.oracle.com/technetwork/java/javase/downloads/index.html) or later.

You will also have to download and install [Apache Maven 3.6.0](https://maven.apache.org/download.cgi) to your system.
Here is a quick guide on how to install Maven: https://maven.apache.org/install.html

### Installing

To build the project, open a command line and navigate to the folder seip2019 where the pom is located.

```
your\file\path\seip2019>
```

And execute the following command:

```
mvn package
```

After the execution is completed, you will find a new directory called ```target``` with two jar files,
located in ```seip2019\gradehistogram\```.

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

We use git for versioning. For the versions available, see the [commits on this repository](https://github.com/chrisfaltsetas/MavenAssignment/commits). 

## Authors

**Christos-Michail Faltsetas** - [chrisfaltsetas](https://github.com/chrisfaltsetas)
**Antonis Gkortzis** - [AntonisGkortzis](https://github.com/AntonisGkortzis)

See also the list of [contributors](https://github.com/chrisfaltsetas/MavenAssignment/contributors) who participated in this project.

## License

This project is not currently licensed. 
