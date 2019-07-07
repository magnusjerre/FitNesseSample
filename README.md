# Fitnesse Sample
This project illustrates how to setup and use FitNesse and the FitNesse plugin "BrowserTest" for testing a tiny Spring Boot webapp.

# Structure
The FitNesse wiki files are located inside `JerreFitnesseRoot` instead of the normal `FitnesseRoot` by specifying `-r ./JerreFitnesseRoot/` in the fitnesse profile. The first time this fitnesse profile is run on a new project necessary files and folders will be generated. If the FitNesse root folder doesn't exist, a sample project will be created. If the root folder does exist, only a subset of the files and folders are created.

The following tree-structure shows which files and folders are generated when the empty root folder `JerreFitnesseRoot` already exists when the FitNesse server is started the first time.
```
JerreFitnesseRoot
│   ├── FitNesse
│   │   ├── ComponentsAndLicenses
│   │   ├── FullReferenceGuide
│   │   ├── ReleaseNotes
│   │   ├── SuiteAcceptanceTests
│   │   ├── SuiteFitAcceptanceTests
│   │   └── UserGuide
│   └── files
```

The following tree-structure shows which files and folders are generated when the empty root folder `JerreFitnesseRoot` doesn't exist when the FitNesse server is started the first time.
```
JerreFitnessRoot
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

# Starting the FitNesse server
`./mvnw clean install -Pfitnesse` starts the fitnesse server. 
