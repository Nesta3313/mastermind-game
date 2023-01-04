# Mastermind CommandLine Game

## About this game

This program implements the Mastermind game, where a user can play against the computer to guess a 4-digit number combination. After each attempt, the computer will provide feedback on the accuracy of the user's guess. The user must correctly guess the number combination within 10 tries to win the game.

At the end of each guess, computer will provide one of the following response as
feedback:
- The player had guess a correct number(s)
- The player had guessed a correct number(s) and correct digit(s) of the number(s)
- The player guessed a totally incorrect number(s)

Users are able to see their guess and feedback histories during each attempt.

The computer calls out to an external API to generate a 4-digit code that ranges from 0 to 7 inclusive. Due to the scope of this game, generated code can contain repeated numbers.
Game includes additional features like total duration of game and scores for current game and total score for overall game played.


## Installing game
Clone this repository and run in your favorite IDE, Java 17 was used to develop this game

AssertJ was used for testing and should be added to classpath

Alternatively, game can be played through the terminal/command prompt by following these steps:
- docker pull richard1008/mastermind 
- docker run --rm -it mastermind  

Note: You need to have docker installed on your machine to run docker commands
