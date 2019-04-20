package DeckOfPlayingCards;

import java.util.Objects;

public class Card implements Comparable<Card> {
    private Color color;
    private Rank rank;

    Card(Color color, Rank rank) {
        this.color = color;
        this.rank = rank;
    }

    public Color getColor() {
        return this.color;
    }

    public Rank getRank() {
        return this.rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return color == card.color && rank == card.rank;
    }


    @Override
    public int compareTo(Card o) {
        if (this.getColor().getColorOrder() < o.getColor().getColorOrder()) {
            return -1;
        } else if (this.getColor().getColorOrder() == o.getColor().getColorOrder()) {
            return Integer.compare(this.getRank().getRankOrder(), o.getRank().getRankOrder());
        }
        return 1;
    }
}