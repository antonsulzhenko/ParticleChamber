# Particle Chamber

## Project Description
 - Language: Java 15
 - Build: Gradle 6.8
 - Unit Tests: JUnit 5, Mockito 3.10 

## How to run

###Build

`./gradlew clean build`

###Code

`Chamber chamber = new Chamber("LLLR");`

`List<String> animations = chamber.animate(1);`

## What was implemented 
 - chamber animation / rendering
 - validation
 - unit tests for all base classes

## Next Steps (TODO)
 - unit tests for all validators & model classes
 - logging