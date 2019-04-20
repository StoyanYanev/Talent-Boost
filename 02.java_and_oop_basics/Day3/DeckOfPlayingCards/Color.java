package DeckOfPlayingCards;

public enum Color {
    Spade(4),
    Hearts(3),
    Diamonds(2),
    Clubs(1);

    private int colorOrder;

    Color(int i) {
        this.colorOrder = i;
    }

    int getColorOrder() {
        return this.colorOrder;
    }
    }
