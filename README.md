
# Exercise 1
# Design Patterns in Java

## Behavioral Design Patterns

1. **Observer Pattern**: Defines a one-to-many dependency, so when one object changes state, all its dependents are notified automatically.
   - **Example**: Weather Station notifying multiple display devices of a temperature change.

2. **Command Pattern**: Encapsulates a request as an object, allowing the parameterization of clients with different requests.
   - **Example**: Home Automation system where a remote control operates lights.

## Creational Design Patterns

1. **Factory Pattern**: Defines an interface for creating objects but lets subclasses alter the type of objects that will be created.
   - **Example**: Shape Factory that creates Circle or Rectangle objects.

2. **Singleton Pattern**: Ensures that a class has only one instance and provides a global point of access to it.
   - **Example**: Single Database instance across the application.

## Structural Design Patterns

1. **Adapter Pattern**: Allows incompatible interfaces to work together by acting as a bridge.
   - **Example**: Adapter that allows a 3-pin plug to work with a 2-pin socket.

2. **Decorator Pattern**: Dynamically attaches additional responsibilities to an object, providing flexible functionality extension.
   - **Example**: Adding extra toppings to a base pizza like cheese and pepperoni.


# Exercise 2
# Smart Office Booking System

## Overview

The Smart Office Booking System is a Spring Boot application that helps manage meeting room bookings and occupancy in an office environment. The API provides endpoints for configuring rooms, managing bookings, and checking room statuses. It also interacts with an SQL database for persistent storage of users, rooms, and bookings.

## Features

- Configure and manage office rooms.
- Book and cancel meeting room bookings.
- Update and monitor room occupancy status.
- User management for tracking room bookings.
- Health check endpoint to verify if the backend is running correctly.

## Technologies Used

- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework for building the backend application.
- **Spring Data JPA**: For data persistence and interaction with the SQL database.
- **MySQL**: Relational database management system for storing persistent data.
- **Maven**: Dependency management and build automation tool.

## Database Schema 

![ei_java_app](https://github.com/user-attachments/assets/b3a151f7-ed33-4e46-9191-8fe07e33b3cb)

## Backend Structure

### Package Descriptions

### 1. Controller Package
- **`OfficeController.java`**: Manages HTTP requests related to office operations, including booking and cancelling rooms.

### 2. Service Package
- **`OfficeService.java`**: Contains business logic for managing office resources and operations.
- **`RoomBookingService.java`**: Handles the booking and cancellation of rooms, ensuring proper status updates.
- **`OccupancyService.java`**: Manages room occupancy, updating room status based on user presence.

### 3. Repository Package
- **`RoomRepository.java`**: Interface for database operations related to room entities.
- **`BookingRepository.java`**: Interface for handling bookings, including querying and modifying booking records.
- **`UserRepository.java`**: Interface for managing user data and interactions with the database.

### 4. Model Package
- **`Room.java`**: Represents a meeting room entity, including room number and status.
- **`Booking.java`**: Represents a booking entity that links users to rooms with details like start time and duration.
- **`User.java`**: Represents a user entity, containing user-specific details such as username and email.

### 5. Patterns Package
- **Singleton Pattern**
  - **`OfficeSingleton.java`**: Implements the Singleton design pattern to ensure a single instance of office resources is managed.
  
- **Command Pattern**
  - **`BookingCommand.java`**: Abstract command class for executing room booking operations.
  - **`BookRoomCommand.java`**: Concrete command for booking a room.
  - **`CancelRoomCommand.java`**: Concrete command for canceling a room booking.

- **Observer Pattern**
  - **`RoomObserver.java`**: Interface for observers interested in room state changes.
  - **`ACControl.java`**: Observer that manages air conditioning based on room occupancy.
  - **`LightControl.java`**: Observer that controls lighting based on room occupancy.

### 6. Resources Package
- **`application.properties`**: Configuration file containing database connection settings and application properties.


