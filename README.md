# **Prueba Rappi**

## Introduction 🚀


REQ | RES is a page that allows the simulation of consumption to services get, put, post delete.

The tests for this application are run on the following website: [REQ | RES] (https://reqres.in/).

## Pre requirements 📋
- Java version 1.8, update 191 or higher and JDK (environment variables configured).
- Eclipse IDE or IntelliJ IDEA (version 2019 or higher).
- Gradle version 5.5.1 or higher (environment variables configured).
- Cucumber for Java Plugin (updated version).
- Gherkin Plugin (updated version).
- ChromeDriver version 90.0.4430.24 for local runs of automations.

## Installation ⚙️
- To clone this repository locally, the following command must be run: 
```git clone https://github.com/williamb15/Prueba-Devco-Travelocity.git```
- Import the project from Eclipse or IntelliJ IDE under the structure of an existing Gradle project. 
- Configure JRE System Library with JavaSE-1.8.
- Configure the encoding to UTF-8 to the project once it is imported.

## Compile the project and generate Wrapper 🔧
- To build the project you must run the command:
```gradle clean build -x test```.

## Command for execution ▶️
- The project can be run from the console, being in the project folder with the following command:
```gradle clean test --tests=* aggregate --info```.
- The Serenity report will be generated in the folder ``/target/site/serenity/`` located in the root folder of the project.

## Building 🛠
Automation is developed with:
 - BDD (Behavior-Driven Development) - Development strategy
 - Screenplay pattern - Design pattern that applies SOLID principles
 - Gradle - Project and Dependency manager
 - Selenium Web Driver - Tool to automate actions in web browsers
 - Cucumber - Framework to automate BDD tests
 - Serenity BDD - Framework, Open source library for report generation
 - Gherkin - Business-readable domain specific language (DSL)

## Programming convention 🎨
The following writing styles are used in automations:
- Variables and functions: Lower Camel Case. Example: `nomenclatureExample`.
- Class names: PascalCase or Upper Camel Case. Example: `NomenclatureExample`.
- Feature names: Snake Case. Example: `nomenclature_example`.

## Versioning 🔀
