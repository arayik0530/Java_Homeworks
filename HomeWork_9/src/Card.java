public class Card {

    private String type;
    private char suit;

    public Card(String type, char suit) {
        this.type = type;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return  type + " " + suit;
    }
}
