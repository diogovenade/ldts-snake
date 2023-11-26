# LDTS - Project 1: Snake

## Description:
The game to be implemented in our project is going to be a recreation of the classic game "Snake". The player must control a snake in a grid and eat the fruit on the grid. When the fruit is eaten, another one pops up at a random position. As the player eats the fruits, the snake grows in size, making it more difficult to move it around the grid. The player loses if the head of the snake hits one of the edges of the grid or a part of its own body.

## List of features:
- A menu that allows the player to start and quit the game, as well as adjust speed and grid size through the settings;
- Movement using the arrow keys;
- "Game Over" conditions for when the player hits one of the edges of the grid or themselves;
- A score system that also records the current High Score.

## Graphics Mockup
![Graphics Mockup](docs/image.png)

## UML Diagram
![LDTS Project - UML drawio (1)](https://github.com/FEUP-LDTS-2023/project-l03gr05/assets/132618557/ebefb5a4-0f99-4b78-9127-dd9a98c1f4ed)

## Patterns
- Model-View-Controller (MVC) architectural pattern, which essentially divides our project into three parts: the model, which represents the data of the project; the view, which displays the data to the user; and the controller, which handles user input

- State Pattern, given that our game can either be in the menu or in the actual gameplay (it has 2 states), which means that it can have different behaviours which have to be switched during runtime (going from the menu to the game and vice-versa)

- Game Loop Pattern, considering that a game loop runs continously during runtime, constantly updating the game state, handling user input and rendering the game's output
