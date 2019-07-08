# Fitnesse Sample
This project illustrates how to setup and use FitNesse and the FitNesse plugin "BrowserTest" for testing a tiny Spring Boot webapp packaged as a jar which is included in a docker image. The "shell-fixture" (`jerre.fixture.Shell`) is the code-layer letting FitNesse start a docker container that hosts the Spring Boot web app. This project also contains a few tests for a simple "dice game" to illustrate how tests work.

# Structure
## This project structure
This project consists of three different maven modules, `dice-game`, `fitnesse`and `web-page`. The `fitnesse` module implements FitNesse tests and fixtures for both `dice-game` and `web-page`. `dice-game` is a basic `jar`-build. `web-page` is a Spring Boot project serving up a simple web page, and is packaged in a jar which is included in the docker image specified by `Dockerfile` in the project root.
```
├── Dockerfile
├── README.md
├── buildDockerImage.sh
├── dice-game
│   ├── pom.xml
│   ├── src
│   └── target
├── fitnesse
│   ├── FitNesseRoot
│   ├── pom.xml
│   ├── src
│   └── webdrivers
├── mvnw
├── mvnw.cmd
├── pom.xml
├── startFitnesse.sh
└── web-page
    ├── pom.xml
    ├── src
```
## General FitNesse folder structure
The FitNesse wiki files will by default be located at `FitNesseRoot`, this can be overriden by specifying `-r ./JerreFitnesseRoot/` in the fitnesse profile. The first time this fitnesse profile is run on a new project necessary files and folders will be generated. If the FitNesse root folder doesn't exist, a sample project will be created. If the root folder does exist, only a subset of the files and folders are created.

The following tree-structure shows which files and folders are generated when the empty root folder `FitnesseRoot` already exists when the FitNesse server is started the first time.
```
FitnesseRoot
│   ├── FitNesse
│   │   ├── ComponentsAndLicenses
│   │   ├── FullReferenceGuide
│   │   ├── ReleaseNotes
│   │   ├── SuiteAcceptanceTests
│   │   ├── SuiteFitAcceptanceTests
│   │   └── UserGuide
│   └── files
```

The following tree-structure shows which files and folders are generated when the empty root folder `FitnesseRoot` doesn't exist when the FitNesse server is started the first time.
```
FitnessRoot
│   ├── FitNesse
│   │   ├── ComponentsAndLicenses
│   │   ├── FullReferenceGuide
│   │   ├── ReleaseNotes
│   │   ├── SuiteAcceptanceTests
│   │   ├── SuiteFitAcceptanceTests
│   │   ├── UserGuide
│   │   ├── content.txt
│   │   └── properties.xml
│   ├── FrontPage
│   │   ├── content.txt
│   │   └── properties.xml
│   ├── PageFooter
│   │   ├── content.txt
│   │   └── properties.xml
│   ├── PageHeader
│   │   ├── content.txt
│   │   └── properties.xml
│   ├── PlugIns
│   │   ├── content.txt
│   │   └── properties.xml
│   ├── TemplateLibrary
│   │   ├── StaticPage
│   │   ├── SuitePage
│   │   ├── TestPage
│   │   ├── content.txt
│   │   └── properties.xml
│   ├── content.txt
│   ├── files
│   ├── properties
│   └── properties.xml
```

## BrowserTest and FitNesse folder structure
The BrowserTest plugin can be included as a pom-dependency, but if we choose to do it that way (instead of the recommended `mvn archetype` generation) we need to manually create a special folder named `webdrivers` in the same folder as `pom.xml` that contains the necessary webdrivers for Selenium. In this project the `webdrivers`-folder was copied from the standalone project `hsac-fitnesse-fixtures-4.5.3-standalone.zip` which can be download from [here](https://github.com/fhoeben/hsac-fitnesse-fixtures/releases/).

```
├── fitnesse
│   ├── FitNesseRoot
│   ├── pom.xml
│   └── webdrivers
```

# Starting the FitNesse server
Before starting the FitNesse server, ensure that the docker image has been built by running `./buildDockerImage.sh`. The FitNesse server can be started through either `./startFitnesse.sh` or `./mvnw clean install -Pfitnesse` starts the fitnesse server.
