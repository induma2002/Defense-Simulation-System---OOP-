# Defense Simulation System

This project is a Java-based Defense Simulation System. It simulates the operation and coordination of multiple defense units (`Hellicopter` and `Tank`) controlled by a central controller (`MainController`). The system demonstrates a graphical user interface (GUI) that allows for real-time interaction with the components.

## Table of Contents

- [Overview](#overview)
- [Components](#components)
  - [Hellicopter](#hellicopter)
  - [Tank](#tank)
- [Controller](#controller)
  - [MainController](#maincontroller)
  - [Obsever](#obsever)
- [Interfaces](#interfaces)
  - [Component](#component)
  - [ObseverInterface](#obseverinterface)
- [Usage](#usage)
- [How to Run](#how-to-run)
- [License](#license)

## Overview

The Defense Simulation System consists of various defense components that can perform specific actions based on user input and internal state changes. The components communicate with a central controller that manages their state and actions.

## Components

### Hellicopter

The `Hellicopter` class represents a helicopter unit in the defense system. It implements the `Component` interface and provides several actions through a GUI.

#### Features
- **Area Information**: Displays the status of the operational area.
- **Weapon Operations**: Allows shooting, missile operations, and laser operations.
- **Status Indicators**: Shows soldier and ammo counts, and position status.
- **Communication**: Sends and receives messages.

#### Key Methods
- `void buttonHideer(int value)`: Adjusts the visibility and enablement of buttons based on the given value.
- `void areaInfo(String lblInfo)`: Updates the label with area information.
- `void brodcast(String bmsg)`: Displays a broadcast message in the text area.
- `void mainConConnecter(MainController mainControllerob)`: Connects the helicopter to the main controller.
- `String sendmsg()`: Retrieves the message from the text field.

### Tank

The `Tank` class represents a tank unit in the defense system. It also implements the `Component` interface and provides similar functionalities with additional operations.

#### Features
- **Area Information**: Displays the status of the operational area.
- **Weapon Operations**: Allows shooting, missile operations, rotating shooting, and rendering.
- **Status Indicators**: Shows soldier and ammo counts, and position status.
- **Communication**: Sends and receives messages.

#### Key Methods
- `void buttonHideer(int value)`: Adjusts the visibility and enablement of buttons based on the given value.
- `void areaInfo(String lblInfo)`: Updates the label with area information.
- `void brodcast(String bmsg)`: Displays a broadcast message in the text area.
- `void mainConConnecter(MainController mainControllerob)`: Connects the tank to the main controller.
- `String sendmsg()`: Retrieves the message from the text field.

## Controller

### MainController

The `MainController` class acts as the central control unit managing the different defense components. It provides a GUI for controlling and monitoring the components.

#### Features
- **Component Management**: Manages the state and actions of connected components.
- **Position Control**: Uses a slider to control the position and strength of the units.
- **Broadcasting**: Sends broadcast messages to all components.
- **Status Display**: Shows collected information from the components.

#### Key Methods
- `void stateChanged(ChangeEvent e)`: Responds to changes in the slider's value.
- `void actionPerformed(ActionEvent e)`: Handles various button click events.
- `void rsvmsg(String msg)`: Receives and displays messages from components.

### Obsever

The `Obsever` class implements the `ObseverInterface` and manages a list of components. It coordinates state changes and broadcasts messages to all connected components.

#### Features
- **Component Registration**: Adds components to the observer list.
- **State Management**: Manages the strength, area status, and broadcast messages.
- **Broadcasting**: Broadcasts messages to all components.

#### Key Methods
- `void setComponents(Component components)`: Adds a component to the observer.
- `void setStrenth(int strenth)`: Sets the strength value and updates all components.
- `void setarea(String area)`: Sets the area value and updates all components.
- `void setbmsg(String bmsg)`: Sets the broadcast message and updates all components.

## Interfaces

### Component

The `Component` interface defines the methods that all components must implement.

#### Methods
- `void buttonHideer(int value)`: Adjusts the button visibility and enablement.
- `void areaInfo(String lblInfo)`: Updates area information.
- `void brodcast(String bmsg)`: Displays a broadcast message.
- `void mainConConnecter(MainController mainControllerob)`: Connects to the main controller.
- `String sendmsg()`: Retrieves the message to be sent.

### ObseverInterface

The `ObseverInterface` defines the methods that the observer must implement.

#### Methods
- `void setComponents(Component components)`: Registers a component.
- `void setStrenth(int strenth)`: Sets the strength value.
- `void callbuttonHideer()`: Calls `buttonHideer` on all components.
- `void setarea(String area)`: Sets the area status.
- `void callareaInfo()`: Calls `areaInfo` on all components.
- `void setbmsg(String bmsg)`: Sets the broadcast message.
- `void callbrodcast()`: Calls `brodcast` on all components.
- `void setMainControllerob(MainController mainControllerob)`: Sets the main controller.

## Usage

1. **Initialize Components**: Create instances of `Hellicopter` and `Tank`.
2. **Initialize Controller**: Create an instance of `MainController` and pass the observer instance.
3. **Connect Components**: Connect the components to the observer and the main controller.
4. **Interact via GUI**: Use the provided GUI to control and monitor the components.

## How to Run

1. Ensure you have Java installed on your machine.
2. Compile all the Java files:
   ```bash
   javac *.java
