# Battleship

This project is a Java implementation of the classic Battleship game. It allows two players to place their ships on a board and compete by trying to sink the opponent's ships.

## Features

- **Ship Placement:** Each player can place a predefined number of ships on their board, choosing the position and orientation (horizontal or vertical).
- **Turn-Based Attacks:** Players take turns guessing the locations of the opponent's ships. Attacks are registered as "hits" or "misses."
- **Customizable Board and Ships:** The size of the ships and the board can be easily modified in the code.
- **Victory Detection:** The game automatically determines the winner when all ships of a player have been sunk.
- **Unit Testing:** A set of unit tests is included to verify the behavior of the main game components.

## Project Structure

- **Controller**: Contains the main game logic, such as the `Game` class that manages the game flow.
- **Model**: Includes the classes that represent game elements, such as `Boat` (ship) and `Player`.
- **View**: Handles the display of the board, representing the state of the ships and attacks in the console.
- **Test**: Unit tests that validate the behavior of the main classes using JUnit.

## How to Play

1. Each player places their ships on the board by specifying the row, column, and direction.
2. Players take turns guessing the positions of the opponent's ships.
3. The game continues until all of a player's ships are sunk.
4. The player who sinks all of the opponent's ships wins.
