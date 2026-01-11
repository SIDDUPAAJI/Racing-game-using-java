Below is **professional, submission-ready documentation** for the **Java Dice Game Applet** you provided.
Structured, technical, and suitable for academic evaluation.

---

# Dice Game Using Java Applet and AWT

## Project Overview

This project implements a **two-player dice game** using **Java Applet**, **AWT**, and **event-driven programming**. Each player rolls a virtual die alternately. The first player to reach or exceed a predefined score threshold wins the game. The application visually renders dice faces, tracks scores, and displays the winner graphically.

---

## Objective

> Demonstrate Java Applet programming concepts
> Apply AWT graphics rendering and event handling
> Simulate a turn-based dice game for two players
> Implement basic game state management and UI interaction

---

## Technologies Used

> Java
> Java Applet API
> AWT (Abstract Window Toolkit)
> Event Handling (`ActionListener`)
> Graphics and Canvas rendering

---

## Application Architecture

### Main Components

> `SagarApplet` – Applet lifecycle management and UI control
> `DiceGame` – Game logic, rendering, and state handling

---

## Class Description

### 1. `SagarApplet`

Responsible for:

> Initializing the applet environment
> Creating and arranging UI components
> Handling player button actions
> Delegating game logic to `DiceGame`

#### Key Responsibilities

> Sets background and layout
> Adds control buttons for Player 1 and Player 2
> Captures button click events using `ActionListener`

---

### 2. `DiceGame`

Extends `Canvas` and encapsulates:

> Game state
> Dice rolling logic
> Score tracking
> Graphics rendering
> Win condition evaluation

---

## Game Logic

### Dice Rolling

> Dice values are generated using `Math.random()`
> Each roll produces a value between 1 and 6
> Score accumulates with each roll

### Turn Handling

> Each player rolls independently via button clicks
> Rolls are ignored once a player reaches the winning score

---

## Game Rules

> Two players participate
> Each roll adds 1–6 points
> First player to reach **30 points** wins
> Game visually announces the winner

---

## Graphics and UI Rendering

### Dice Rendering

> Dice faces drawn using `fillRoundRect`
> Dots rendered using `fillOval`
> Dot positions vary based on dice value

### Score Display

> Player scores displayed at top of screen
> Updated dynamically after each roll

### Winner Display

> Winner message displayed in a highlighted banner
> Rendered only when win condition is met

---

## Event Handling

> Button clicks captured via `ActionListener`
> Each button triggers respective player roll
> Game canvas is repainted after every action

---

## Key Methods

### In `SagarApplet`

> `init()` – Initializes UI and layout
> `actionPerformed()` – Handles button clicks

### In `DiceGame`

> `paint(Graphics g)` – Main rendering method
> `rollPlayer1()` – Player 1 dice logic
> `rollPlayer2()` – Player 2 dice logic
> `drawDie()` – Dice face rendering
> `checkWinner()` – Win condition evaluation

---

## Program Flow

> Applet initializes UI
> Player clicks roll button
> Dice value generated
> Score updated
> Canvas repainted
> Winner checked and displayed

---

## Limitations

> Uses deprecated Java Applet technology
> No turn enforcement logic (players can roll repeatedly)
> No reset or restart functionality
> No sound or animation effects

---

## Possible Enhancements

> Convert to Swing or JavaFX application
> Enforce turn-based play
> Add restart/reset button
> Introduce dice roll animation
> Improve UI responsiveness
> Store game history

---

## Educational Value

> Demonstrates Java graphics programming
> Reinforces event-driven design
> Illustrates basic game state management
> Suitable for learning AWT and Canvas rendering

---

## Conclusion

This project effectively demonstrates **Java Applet development**, **AWT graphics**, and **event handling** through a simple yet complete two-player dice game. While applets are now obsolete, the underlying principles remain valuable for understanding GUI programming and interactive application design in Java.

---
