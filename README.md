# CS61B Project 1 - Deque & Guitar Hero Synthesizer

This project is part of the CS61B (Data Structures) coursework at UC Berkeley. It includes a full implementation of double-ended queues and an interactive sound synthesizer inspired by Guitar Hero.

## Features

### Part 1: Deques from Scratch
- `ArrayDeque`: A resizable circular array-based deque
- `LinkedListDeque`: A doubly linked list implementation
- `MaxArrayDeque`: Extension that supports `max()` using a custom comparator

All operations are written from scratch, without using Java collections. Supports:
- Add/remove from both ends
- `size()`, `get(index)`, `isEmpty()`, etc.

### Part 2: Guitar Hero Lite
- Simulates string vibration using the Karplus–Strong algorithm
- Plays different musical notes mapped to keyboard input
- Live interactive sound with Java audio

## Project Structure

```
proj1/
├── deque/                # All deque implementations
│   ├── Deque.java
│   ├── ArrayDeque.java
│   ├── LinkedListDeque.java
│   └── MaxArrayDeque.java
├── gh2/                  # Guitar string simulation
│   ├── GuitarString.java
│   └── GuitarHeroLite.java
├── pom.xml
└── .gitignore
```

## How to Run

1. Compile everything:
   ```bash
   javac *.java
   ```

2. Run the synthesizer:
   ```bash
   java gh2.GuitarHeroLite
   ```

Press the keyboard keys (e.g. a, s, d...) to play sounds.

## Technologies

- Java 17
- JUnit 4

## Learning Goals

- Practice implementing array & linked list based data structures
- Understand object-oriented design
- Explore real-time audio synthesis

---

Created by [@hikezhang](https://github.com/hikezhang)
