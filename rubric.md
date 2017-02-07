GRADE: 33/32
------------

See inline comments on code - TODO and NOTE.
(You do not actually need to do the TODOs for project 0.)

Functional requirements - 20 points
===================================
* 1/1 The board is initially empty.
* 1/1 The program chooses randomly which player goes first.
* 2/2 The user inputs their move as a pair of integers.
* 1/2 The computer chooses any legal move at random. *-You should not know when the computer has attempted an invalid move. - see spacetaken.txt*
* 1/1 The program reports the computer's move.
* 1/1 The board is displayed after each move by either player.

The program correctly reports wins and draws:
* 1/1     row
* 1/1     column
* 1/1     diagonals
* 2/2     draw (board filled, no wins)

* 1/1 The game ends after a win or draw.

The program is robust to invalid input, including
* 2/2     non-integers;
* 2/2     integers that are less than 1 or greater than 3;
* 2/2     invalid moves.

Implementation requirements - 8 points
======================================
* 2/2 There are two classes: TicTacToeBoard and TicTacToeGame.
* 1/1 The TicTacToeBoard class stores a 3x3 array of characters.
* 2/2 A suitable exception is thrown if either player attempts an invalid move.
* 1/1 The TicTacToeGame class should include a main method so it is executable.
* 1/2 Methods are documented with javadoc comments.

Stretch goal - Extra Credit
===========================
* 4/0 The user can choose between two difficulty levels, easy and hard.
      *The game is also visually lovely.  Note that in general I will not award 
      extra credit unless all requirements are completely met.*

Reflection - 4 points
=====================
* 1/1 What's the most important thing you learned?
* 1/1 How is your Java solution different from the Python solution?
* 1/2 How did the team share the work? What did each contribute?
      *I'm a little unclear on how you 'worked collaboratively.' Did you pair program? 
      Or discuss the design and each write your own code? Or...?*

