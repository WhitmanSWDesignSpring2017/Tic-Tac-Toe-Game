Reflection - Pablo Fernandez, Tyler Maule
==

What's the most important thing you learned from this project?
--
The most important thing we learned from this project was simply Java syntax and organization — how to use a main function, javadoc comments, exceptions, obtaining user input, and the like. We found that Java is often more restrictive than Python or C++ (and sometimes frustrating) when it comes to organization. Finally, we got a bit of experience with refactoring code in attempt to make things “more elegant.”



What's the most significant way your solution diverges from the sample solution in Python? (Explain in English; don't include more than very short snippets of code.)
--
I think we simplified the design in some areas; instead of creating a separate method for checking the bounds of the game board, we integrated bounds-checking into the isOpen() method. Obviously, adding heuristics and creating an “intelligent” computer player involved a lot of code, so we chose to break the Stretch goal material into a separate class and distinct Java file. In moving from Python to Java, we also had to add a lot of complexity in how we got user input. On the whole, we generally followed the design given to us in Python.



How did you and your partner share the work? What did each team member contribute?
--
We usually worked collaboratively, but alternated on different parts of the code. For example, Tyler focused more on the Board, whereas Pablo spent more time with the Game class. While Pablo used knowledge from his Artificial Intelligence class to fulfill the stretch goal (TicTacToeBoardAI), Tyler created the nearlyWonBy() method and spent some time debugging/testing the code as a whole.
