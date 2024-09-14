
# Memoir 44 - Strategy Game Simulation

This project is a console-based simulation of the strategy game **Memoir 44**, developed as part of the **Advanced Programming Course** (Fall 2020-2021). The goal of this project is to implement a turn-based war strategy game, where players control units like infantry, tanks, and artillery on a hexagonal grid, following specific rules for movement, attacks, and victory conditions.

## Project Overview

In this game, two players take on the roles of opposing factions: the **Axis** and the **Allied** forces. Each player must deploy and command their units to achieve objectives and secure victory based on the scenario rules.

### Game Features

- **Turn-based gameplay**: Players alternate turns, each selecting cards that determine how many units can be activated and moved.
- **Unit types**: Infantry, tanks, and artillery with distinct movement and attack abilities.
- **Hexagonal grid map**: Different types of terrain like forests, hills, and cities that affect movement and combat.
- **Combat mechanics**: Attack rolls are determined based on unit type and distance from the target, with custom rules for dice-based combat resolution.
- **Winning conditions**: The first player to earn a set number of victory medals by eliminating enemy units or capturing strategic positions wins the game.

## Key Concepts Implemented

- **Object-Oriented Programming (OOP)**: The project makes extensive use of OOP principles such as inheritance, polymorphism, and encapsulation to model game entities and behaviors.
- **Console-based UI**: The game runs entirely in the console, where the map is displayed, and players input commands to move units and resolve combat.
- **Randomized Combat Outcomes**: The combat system involves dice rolls that introduce randomness into the outcome of attacks, similar to the physical board game.
- **Scenario Customization**: Predefined scenarios are provided, and players can design their own maps and unit deployments for added challenge.

## How to Play

- **Setup**: The game prompts players to input their names and select a scenario.
- **Gameplay**: Players take turns activating units, moving them across the map, and engaging in combat based on dice rolls.
- **Winning**: Players score victory medals by either destroying enemy units or capturing strategic objectives.

## Installation and Running the Game

1. **Clone the repository**:
   ```bash
   git clone https://github.com/rezaeim748/Advanced-Programming-course.git
   ```

2. **Navigate to the specific project directory**:
   ```bash
   cd Advanced-Programming-course/Project1
   ```

3. **Compile the game** (assuming it's written in Java or your preferred language):
   ```bash
   javac Memoir44Game.java
   ```

4. **Run the game**:
   ```bash
   java Memoir44Game
   ```

## Future Improvements

- Adding more complex AI for single-player mode.
- Introducing more detailed graphics or transitioning the console UI to a GUI.
- Implementing additional scenarios and unit types for more variety.

