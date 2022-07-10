# This Old Dungeon

Welcome to part 1!

Today we will tackle building out the foundation of our game; the dungeon. At
the end of this part you will have built a dungeon floor that is procedurally
generated. This is important as we will need a place for the player and the
npc's to exist and explore in.

What you will have full control over how the dungeon looks after being
generated. If you want circular rooms, have at it! If you want to have hallways
that are straight and 5 tiles wide, good for you. That being said each decision
that you make can make this part more or less challenging.

Overall, there are a few specifications that should get you started. Our
suggestion to you is to have these be settings that are used during generation
that exist as part of a settings object, that way you can avoid hard coding
things throughout your codebase and possibly extract the settings to an external
config file.

# Specs

| Spec                                |  amount  |
|-------------------------------------|:--------:|
| height                              | 21 cells |
| width                               | 80 cells |
| minimum number of rooms             |    5     |
| room minimum height                 | 2 cells  |
| room minimum width                  | 3 cells  |
| minimum buffer between rooms        |  1 cell  |
| Game area boarder width             |  1 cell  |
| maximum hardness                    |    10    |
| minimum hardness (rooms & hallways) |    0     |

- Each spot in the dungeon (rooms and hallways) must be reachable from any other
  spot in the dungeon
- Walls have a hardness rating from 1 to 10 hardness
  - Why? Well in the future we will add digging into the game at some point.
- If you plan to write this game in kotlin, then this project has already been
  set up for you to utilize swing for drawing to screen.

# Hints

These are tips that you can choose to view that may help point you in the right
direction. Use them as you see fit (or ignore them!).

<details>

<summary>Procedural Generation</summary>

Every programming language will generally include a section of its standard
library (the base bits of the language that are always there) that can generate
random numbers for you.

Go and find out what random number generation looks like for your language, and
you can use this to get random values for your wall hardness, along with where
the rooms could be placed (x & y coordinates).

</details>
<details>

<summary>Dungeon Representation</summary>

When it comes to representing your dungeon, you will probably want to have the
dungeon be a 2D list or array that holds what kind of thing exists at each x y
location (coordinate).

</details>
<details>

<summary>Hallways</summary>

Getting the hallway pathing figured out may be the most difficult task in part

1. A rudamentary way to get this working is to look at the top left coordinate
   of each room and make a direct path from one to another for each room in the
   dungon. As in if you have rooms A,B,C then there is a hallway from A to B, a
   hallway from B to C, and a hallway from C to A each being roughly straight.

If you want these hallways to be a little more realistic, then you could start
looking at different algorithms to achieve your goal. A few that come to mind
are:

- Breadth First Search (BFS)
- Dijkstra's Algorithm
- A*

At the end of the day A* is where it's at for path finding due to it's
efficiency, and is used a lot in modern games. You can find a helpful write up
at [this website](https://www.redblobgames.com/pathfinding/a-star/introduction.html)
.

</details>