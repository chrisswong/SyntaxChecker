# SyntaxChecker

This repo keeps differernt languages of implmentating the solution of [this interview questions](https://www.interviewcake.com/question/bracket-validator])

Solution :

First , we have a mapping for openers ( **[,(,{** ) to corresponding to the closers ( **],),}** )

Second , we have a empty and mutable stack.

Then , we loop though the whole syntax and enumerate each character.

for every one characters, we check if that belongs to openers, we push it to the stack. 

If that character belongs to closers , we pop one element from the stack and see if both are in pair.

If both are not in pair, the whole syntax is invalid.

If that character does not belongs any group, we show unrecoginzed syntax.


Languages used:
* Java
* Objective-C
* PHP


