package DeckOfPlayingCards;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardDeckTest {
    @Test
    public void testCardDeck() {
        CardDeck deck = new CardDeck();

        Card card1 = new Card(Color.Clubs, Rank.Ace);
        Card card2 = new Card(Color.Spade, Rank.Jack);
        Card card3 = new Card(Color.Hearts, Rank.Ten);
        Card card4 = new Card(Color.Spade, Rank.Ace);
        Card card5 = new Card(Color.Diamonds, Rank.Seven);

        deck.addCard(card1);
        deck.addCard(card2);
        deck.addCard(card3);
        deck.addCard(card4);
        deck.addCard(card5);

        assertEquals(new Card(Color.Diamonds, Rank.Seven), deck.getFromTheTop());

        deck.sortInASC();
        assertEquals(new Card(Color.Spade, Rank.Ace), deck.getFromTheTop());
        assertEquals(new Card(Color.Spade, Rank.Ace), deck.findTheHighestCard());
        //deck.printDeck();

        deck.sortInDESC();
        assertEquals(new Card(Color.Clubs, Rank.Ace), deck.getFromTheTop());
        //deck.printDeck();


        deck.swapDeck();
        //deck.printDeck();

        deck.shuffleDeck();
        //deck.printDeck();
    }
}