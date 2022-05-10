# Game-of-Battleship-(Java)
Implementing a 2-player board game of Battleship using Java

Game1.java has the code for the classical Battleship game. 

Game2.java is a specialized version of the Battleship game where the last attack of both the players causes a special area-of-effect damage. The attack will cause damage on a radius of 2 in the horizontal and vertical directions and of radius 1 in the diagonal directions.

The inputs and outputs for this game is as follows:

--Game1--

Input:
4
2
1 2 2 0
2 1 2 1
1 1 1 0
3 0 3 1
2
0 0
1 1
3 0
1 2

Output:
---- ----
-BBB ----
---- -B--
---- BB--
---- X---
-XXB ----
---- -B--
---- XB—
Draw!


Input:
3
1
0 0 3 1
1 0 5 0
3
1 0
0 0
1 1
1 0
0 0
2 0

Output:
B-- ---
B-- BBB
B-- ---
X-- X--
X-- XXB
X-- ---
P2 Won!
________________________________________________________________________________________________


--Game2--

Input:
10
2
1 2 2 0
7 6 2 1
1 1 1 0
8 3 3 1
2
9 3
1 1
8 5
6 6

Output:
---------- ----------
-BBB------ ----------
---------- ----------
---------- ----------
---------- ----------
---------- ----------
---------- ----------
---------- ------B---
---------- ---B--B---
---------- ---B------
---------- ----------
-XBB------ ----------
---------- ----------
---------- ----------
------X--- ----------
-----XXX-- ----------
----XXXXX- -----X----
-----XXX-- ----XXX---
------X--- ---XXXXX--
---------- ---XXXX---
P1 Won!
