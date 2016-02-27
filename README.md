[![Codacy Badge](https://api.codacy.com/project/badge/grade/af8fe2f119454c799779aaac6f148a9f)](https://www.codacy.com/app/phe0nix/RandomNameGenerator)

# RandomNameGenerator
A little exercise in Java, following the concepts of "Clean Code" (Robert C. Martin)

I am also testing a few other clean code and style related things on the way.
Such as GitHub integrations and IDE-Plugins, later on dependency injection, probably Maven in some time.

## Purpose
The purpose of this program is to generate a name, based on the gender and the number of fore- and surnames.

Initially that was all about this project to say, until I chose to offer different user interfaces.
At the time writing, the implementations for a console interface, one for a swing interface and a JavaFX interface aredone and implemented.
The downside using JavaFX with heavy fxml use, as I chose to do, is, that I can not rise my test coverage as high as I wanted it.

All these steps are taken under the premise to stick to the lessons learned from Robert C. Martins "Clean Code".

## Usage
When compiled, run with the following arguments:  
`console` - Console interface (Question → Answer Style)  
`swing`   - Swing interface  
`fx`      - JavaFX interface  
everything else defaults to the console interface.
