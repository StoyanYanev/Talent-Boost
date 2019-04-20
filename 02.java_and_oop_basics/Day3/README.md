**Task 1**

Define an interface Shape with a getAreaa method. Define and implement classes
Square, Circle Rectangle which implement this interface, and have the necessary
properties.

Implement unit tests for the getArea method on all classes.

What is the object hierarchy you ended up with?

Second part: make the classes immutable.

**Task 2**

Define an interface List, representing a list of Integers, which the following
methods:

Integer get(int index);

void put(int index, Integer value);

void add(Integer value); // at the end of the list

int size();

Provide two implementations: one bucked by an array, and one by linked list.

Define unit tests for two implementations. What’s the difference between the
tests for the array-bucked and linked list-bucked list?

**Task 3**

Write a class which represents a two-dimensional matrix. Implement methods to 

>   check if it is a square matrix 

>   return the element on a certain position

**Task 4**

Write a generic *KeyValue* class. Implement a method taking in two arguments – a
Collection of *KeyValue* instances and an array of keys. The method should
return an array of the values for the supplied keys. Try to not use loop
embedded in another loop.

**Task 5**

Write a class for a non-balanced binary tree. Specifically, the class should
represent a tree node with its two children. Each tree node should be able to
hold any comparable type. Implement iterators for Depth-First and Breadth-First
Search.

**Task 6**

**Write a class that represents a deck of playing cards (also write the Card
class). Your deck should be able to hold more than a single playing card set (52
cards). Implement methods to **

-   **Put a card on the top **

-   **Get the card from the top **

-   **Find and get the highest-ranked card **

-   **Return "printable" string of all the cards in the deck **

-   **Swap the deck (top to bottom) **

-   **Shuffle all the cards in the deck **

-   **Sort the cards in DESC order**

-   **Find and get the first card matching a user-supplied condition
    (predicate) **

-   **Return an (possibly empty) array of decks where each has a full card set
    (all 52 cards)**

**Color Order (DESC):**

>   **Spades**

>   **Hearts**

>   **Diamonds**

>   **Clubs**

**Rank Order (DESC):**

>   **Ace**

>   **King**

>   **Queen**

>   **Jack**

**10**
