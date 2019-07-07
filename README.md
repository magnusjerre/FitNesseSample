# Fitnesse Sample
This project illustrates how to setup and use FitNesse and the FitNesse plugin "BrowserTest" for testing a tiny Spring Boot webapp.

# Structure
## FitNesse folder structure
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
`./mvnw clean install -Pfitnesse` starts the fitnesse server.
