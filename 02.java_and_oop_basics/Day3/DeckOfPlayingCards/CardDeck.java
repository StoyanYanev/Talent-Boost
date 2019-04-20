package DeckOfPlayingCards;

import java.util.*;

public class CardDeck {
    private LinkedList<Card> cards;
    private static final int ALL_CARDS = 52;

    CardDeck() {
        this.cards = new LinkedList<>();
    }

    CardDeck(Collection<Card> cards) {
        this.cards = new LinkedList<>(cards);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card getFromTheTop() {
        if (this.cards.isEmpty() == true) {
            throw new EmptyStackException();
        }
        return this.cards.getLast();
    }

    public Card findTheHighestCard() {
        return this.cards.stream().max(Card::compareTo).orElse(null);
    }


    public void printDeck() {
        for (Card c : this.cards) {
            System.out.println(c.getColor() + " " + c.getRank());
        }
    }

    public void swapDeck() {
        Collections.reverse(this.cards);
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    public void sortInASC() {
        this.cards.sort(Card::compareTo);
    }

    public void sortInDESC() {
        this.cards.sort((c1, c2) -> -1 * c1.compareTo(c2));
    }

    public CardDeck[] getDecksWithFullCards() {
        List<Card> temp = new LinkedList<>(this.cards);
        List<CardDeck> decks = new ArrayList<>();
        while (true) {
            Set<Card> allCards = new HashSet<>();
            Iterator<Card> cardIterator = temp.iterator();
            while (cardIterator.hasNext() == true) {
                if (allCards.contains(cardIterator.next()) == false) {
                    allCards.add(cardIterator.next());
                    cardIterator.remove();
                }
            }
            if (allCards.size() == ALL_CARDS) {
                CardDeck cardDeck = new CardDeck(allCards);
                decks.add(cardDeck);
            } else {
                break;
            }
        }

        CardDeck[] d = new CardDeck[decks.size()];
        return decks.toArray(d);
    }
}