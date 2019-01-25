# AODP
AODP - Active-Object design pattern 

GPL v3 - Copyright Gautier and Gwénolé

This project was created within the ISTIC Rennes school for the AOC module.

This project implements two active-object design patterns to link a random value generator with some monitors in order to display these values asynchronously; it acts like an observer pattern through a network.

To manage the broadcast of a new value we used a strategy to allow several methods to transmit values. By default we can choose the atomic broadcast to always send the same value to all monitors, the sequential broadcast to send all values in the same order to all monitors and the causal broadcast to send values at the moment the getValue method is called.

# User interface

![ClassUpdate](https://raw.githubusercontent.com/ISTIC-M2-ILa-GM/aodp/dev/spec/img/gui.png)

The user can change the different broadcast method using the radio buttons. The user can also generate a new value and see how each monitor will display them using the "Generate" button.

Each monitor has different delay, by default the delay is 500/800/1000/1200 ms.

Every monitor uses both schedulers (one scheduler to update and one other to get value). We can't use one scheduler, because with only one scheduler, all threads of the pool could be filled by update and all get value called by the monitors will wait indefinitely.

# Architecture

## Diagrams

The main representation of these diagrams are the active object pattern, all others patterns aren't displayed.

We have represent the workflow with diagrams on different point of view:
* from the generator,
* from the scheduler,
* from the monitor.

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

We also used different design pattern likes active object, strategy, observer, memento, factory, and facade.

## Technology

* Language: Java 8
* Front end: JavaFX
* Build: maven

## Package

* Package: fr.istic.gm
* Artifact: aodp

## Build

    mvn install
    
### Quicker build without starting tests

    mvn install -DskipTests
    
## Start

    Main class: fr.istic.gm.aodp.Main
    
Or with a jar:

    java -jar aodp.jar

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

## Conclusion

This project help us to build an architecture with many design patterns for the feature we want to implement. 
We also learned to build an interface with JavaFX.

We also learned how the active-object pattern is, by default, integrated in the Java API. This project also helps us to investigate some race condition and to keep in mind that it can be difficult to find this sort of error.
