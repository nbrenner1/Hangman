#makefile for hangman

all: hangman

hangman:
        javac main.java hangman.java

run:
        java main

clean:
        rm *.class
