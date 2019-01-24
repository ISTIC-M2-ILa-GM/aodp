# AODP
AODP - Active-Object design pattern 

GPL v3 - Copyright Gautier and Gwénolé

This project was created within the ISTIC Rennes school for the AOC module.

It corresponds to the implementation of two active object design pattern to link a generator of value and some monitor to display values asynchronously.

# Design

## Diagrams

### Class
![ClassUpdate](https://raw.githubusercontent.com/ISTIC-M2-ILa-GM/aodp/dev/spec/img/UpdateClass.png)
![ClassGetValue](https://raw.githubusercontent.com/ISTIC-M2-ILa-GM/aodp/dev/spec/img/getValueClass.png)

### Update Sequence
![UpdateAsync1](https://raw.githubusercontent.com/ISTIC-M2-ILa-GM/aodp/dev/spec/img/UpdateAsync1.png)
![UpdateAsync2](https://raw.githubusercontent.com/ISTIC-M2-ILa-GM/aodp/dev/spec/img/UpdateAsync2.png)
![UpdateAsync3](https://raw.githubusercontent.com/ISTIC-M2-ILa-GM/aodp/dev/spec/img/UpdateAsync3.png)

### GetValue Sequence
![getValueAsync1](https://raw.githubusercontent.com/ISTIC-M2-ILa-GM/aodp/dev/spec/img/getValueAsync1.png)
![getValueAsync2](https://raw.githubusercontent.com/ISTIC-M2-ILa-GM/aodp/dev/spec/img/getValueAsync2.png)
![getValueAsync3](https://raw.githubusercontent.com/ISTIC-M2-ILa-GM/aodp/dev/spec/img/getValueAsync3.png)

## Architecture

Part of this project is developed using test driven development (TDD) and pair programming.

## Technology

* Language: Java 8
* Front end: JavaFx
* Build: maven


* Package: fr.istic.gm
* Artifact: aodp


* Design pattern used: active object, strategy, observer, memento, factory.

## Build

    mvn install
    
### Quicker build without starting tests

    mvn install -DskipTests
    
## Start

    Main class: fr.istic.gm.aodp.Main

### Features done

- [X] Generator
- [X] Monitor
- [X] MainController
- [X] Canal
- [X] AtomicDiffusion
- [X] CausalDiffusion
- [X] SequentialDiffusion
- [X] GetValueCallable
- [X] UpdateRunnable