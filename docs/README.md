# LDTS - Project 1: Snake

## Description:
The game to be implemented in our project is a recreation of the classic game "Snake". The player must control a snake in a grid and eat the fruit on the grid. When the fruit is eaten, another one pops up at a random position. As the player eats the fruits, the snake grows in size, making it more difficult to move it around the grid. The player loses if the head of the snake hits one of the edges of the grid or a part of its own body.

## Implemented Features

- **Main Menu** - The Main Menu is shown when the player boots up the game and lets the player start the game with the default settings or access the Settings Menu.
- **Settings Menu** - The user can access the Settings Menu from the main menu where they can change the game size, speed and obstacle appearence rules.
- **Different configurations** - The user can pick from 18 total possible settings configurations according to their tastes. They can pick from 3 different game speeds, 3 different window sizes and a toggle for the appearence of walls that make it more difficult to traverse the game area.
- **Player movement** - Once in-game, the player's snake will automatically move foward at the speed defined in the Settings menu and the player can change direction by pressing the arrow keys.
- **Collision detection** - Once in-game, if the player's snake runs into an obstacle, one of the edges of the grid or itself the game will end and the player will be brought to the Game Over Menu.
- **Game Over menu** - The Game Over Menu is shown whenever the player fullfills the conditions necessary to lose the game. The player has the option to try again using the same settings.

## Planned Features

- The only planned feature that wasn't implemented was the High Score system.
- The appearence of walls as obstacles was implemented despite not being in the planned features.

## Design

### Class UML Diagram

The following image is the Class UML Diagram of the project.

<p align="center" justify="center">
  <img src="docs/images/Class UML Diagram.png"/>
</p>
<p align="center">
  <b><i>Fig 1. Class UML Diagram</i></b>
</p>


### General Structure

#### The Patters:
In this project we utilized the Model-View-Controller **Architectural Pattern**, which allowed us to handle the data structure, the visuals and the internal logic separately. This made it easier to follow the Single Responsibility Principle.
We also used the **State Pattern**, which lets the behavior of an object easily change depending on what its internal state is.

#### Implementation:
Regarding the implementation, the MVC pattern lets us maintain classes with different functions. The model classes store and structure the game's data, the viewer classes deal with everything related to displaying the UI and other graphical elements while the controller classes manage the underlying logic of the game.
The way these elements interact with each other are explained in the following image:

<p align="center" justify="center">
  <img src="docs/MVC pattern design interactions.png"/>
</p>
<p align="center">
  <b><i>
  Fig 2. MVC pattern design interactions.<br>
  </i></b>
</p>

Attributions and copyright licensing by [Mozilla Contributors](https://developer.mozilla.org/en-US/docs/Glossary/MVC/contributors.txt) is licensed under [CC-BY-SA 2.5](https://creativecommons.org/licenses/by-sa/2.5/)

#### Consequences:
The use of these patterns in the current design lead to the following benefits, besides the ones already mentioned:
- The adherence to SOLID principles make development of new features easier and less prone to needing major structural changes.
- It is easier to work with separate menus in a clearer and safer ways due to the fact they each belong to a separate class.

### State Structure

#### Problem in Context:
The game's behavior changes depending on the current situation. We implemented this using the State pattern in order to define what conditions lead to the change in the game's behavior in accordance with SOLID principles.

#### Implementation

<p align="center" justify="center">
  <img src="docs/State UML Diagram.png"/>
</p>
<p align="center">
  <b><i>Fig 3. State UML Diagram</i></b>
</p>

These classes can be found in the following files:
- [State](src/main/java/l03gr05/states/State.java)
- [SettingsState](src/main/java/l03gr05/states/SettingsState.java)
- [MainMenuState](src/main/java/l03gr05/states/MainMenuState.java)
- [GameState](src/main/java/l03gr05/states/GameState.java)
- [GameOverState](src/main/java/l03gr05/states/GameOverState.java)


### Game Loop Pattern

#### Problem in Context:
The game should not wait for player input in order to move the snake. In order to make the snake move on its own we used the **Game Loop Pattern**. This ensured that the game would only need player inputs to change the direction of the snake.

#### Implementation
The Game Loop pettern doesn't use distinct classes but rather dictates how the Controller classes act. Instead of waiting for user inputs they periodically run the *step()* function, which acts differently depending on the direction value of the Snake element. That value can be changed between steps by the player input.


### Arena Builder Pattern

#### Problem in Context:
Our game needed a way to build Arenas of different sizes according to the game settings. To do this we utilized the **Builder Pattern**.
The Builder pattern is a creational pattern that allows the creation of complex objects step-by-step, which allowed us to simplify the creation process.

#### Implementation:

### Screenshot of coverage report
<p align="center" justify="center">
  <img src="docs/images/Builder UML.png"/>
</p>
<p align="center">
  <b><i>Fig 4. Builder UML</i></b>
</p>

These classes can be found in the following files:
- [Arena](src/main/java/l03gr05/model/game/arena/Arena.java)
- [ClassicArenaBuilder](src/main/java/l03gr05/model/game/arena/ClassicArenaBuilder.java)
- [ArenaBuilder](src/main/java/l03gr05/model/game/arena/ArenaBuilder.java)

### Template Pattern

#### Problem in Context:
In many instances we benefited from having separate classes for separate game elements, menus, states, etc.
We decided to use the **Template pattern** to be able to do this while still keeping superclasses containing the common characteristics of these classes, as well as having default implementations for some of their methods which could be overwritten by the subclasses if needed.

#### Implementation:

### Screenshot of coverage report
<p align="center" justify="center">
  <img src="docs/images/Templates UML.png"/>
</p>
<p align="center">
  <b><i>Fig 5. Templates UML</i></b>
</p>

Sinse the Template Pattern was used multiple times we decided to highlight and number all of them in the class UML.
The files of the template classes are the following:

These classes can be found in the following files:
- [Element(1)](src/main/java/l03gr05/model/game/elements/Element.java)
- [Viewer(2)](src/main/java/l03gr05/viewer/Viewer.java)
- [ElementViewer(3)](src/main/java/l03gr05/viewer/game/ElementViewer.java)
- [Controller(4)](src/main/java/l03gr05/controller/Controller.java)
- [State(5)](src/main/java/l03gr05/states/State.java)
- [MenuModel(6)](src/main/java/l03gr05/model/menu/MenuModel.java)
- [ArenaBuilder(7)](src/main/java/l03gr05/model/game/arena/ArenaBuilder.java)



## Known-code smells

We fixed most code smells identified by IntelIJ error-prone. The only one remaining was the following:

 "duplicate code on 'SettingsController' and 'MainMenuController'."

 The removal of this smell implied larger scale changes to the code as the automatic IntelIJ changes resulted in errors,

## Testing

### Screenshot of coverage table
<p align="center" justify="center">
  <img src="docs/images/Test Coverage Table.png"/>
</p>
<p align="center">
  <b><i>Fig 6. Test Coverage Table</i></b>
</p>

### Screenshot of coverage report
<p align="center" justify="center">
  <img src="docs/images/Pit Test Coverage Report.png"/>
</p>
<p align="center">
  <b><i>Fig 7. Pit Test Coverage Report</i></b>
</p>

### Link to testing report
[Mutation tests](docs/index.html)

## Self-evaluation

- Diogo C. Pinto: 33.3%
- Diogo M. S. Venade: 33.3%
- Tiago D. M. Santos 33.3%