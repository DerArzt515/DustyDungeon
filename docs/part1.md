# So you want to summon a dungeon troll?

This is the first part of a mutlipart project to build out a Rougelike dungeon crawler. We won't lie, this project can
be rather involved (after all we aren't building hello world), but we have confidence in you!

In this project you will get comfortable with the Kotlin language, learn some algo's and data structures, and hopefully
pull some random person over to your computer to say "look at what I built!".

There are multiple parts to this project, and you are free to tweak the specs to what you think would be the coolest.

As far as the overall structure of this, here it is:

## Part 1: Dungeon Generation

## Part 2: Ctrl-s Ctrl-s Ctrl-s Ctrl-s Ctrl-s (save your work)

## Part 3: Finding yourself (path finding)

# Goal

# Specs

| Spec                         |  amount  |
|------------------------------|:--------:|
| height                       | 21 cells |
| width                        | 80 cells |
| minimum number of rooms      |    5     |
| room minimum height          | 2 cells  |
| room minimum width           | 3 cells  |
| minimum buffer between rooms |  1 cell  |
| Game area boarder width      |  1 cell  |

- Each spot in the dungeon (rooms and hallways) must be reachable from any other spot in the dungeon
- Walls have a hardness rating from 1 to 10 hardness
    - Why? Well in the future we will add digging into the game at some point.