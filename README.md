# AODP
AODP - Active-Object design pattern 

GPL v3 - Copyright Gautier and Gwénolé

This project was created within the ISTIC Rennes school for the AOC module.

It corresponds to the implementation of two active object design pattern to link a generator of value and some monitor to display values asynchronously, likes a observer pattern through a network.
To manage the diffusion of a new value we used an strategy to apply different methods to transmit values, by default we can chose an atomic diffusion to always diffuse the same value to all monitors, a sequential diffusion to diffuse all value with the same sequence to all monitors and the causal diffusion to diffuse the value at the time when a get value is called.

# User interface

![ClassUpdate](https://raw.githubusercontent.com/ISTIC-M2-ILa-GM/aodp/dev/spec/img/gui.png)

An user can change the different diffusion with the help of the radio button. The user can also generate a new value and see how each monitor will displey them.
Each monitor use a different retard, by default the retard is 500/800/1000/1200 ms.
Each monitor use the two same scheduler (one for update and one for get value). We can't use one scheduler, because with only one scheduler, all threads of the pool could be filled by update and all get value called by the monitors will wait indefinitely.

# Architecture

## Diagrams

The main representation of these diagrams are the active object pattern, all others patterns aren't displayed.

We have represent the workflow with 3 diagrams on different point of view:
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

* Design pattern used: active object, strategy, observer, memento, factory and facade.

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

This project help us to make an architecture with many design pattern for the function we want to implement. 
We also learned to make an interface with JavaFX.