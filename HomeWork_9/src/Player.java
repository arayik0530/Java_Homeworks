public class Player {

    private String name;
    private final byte countOfCards = 5;

    public final Card[] cards;

    public Player(String name) {
        this.name = name;
        this.cards = new Card[countOfCards];
    }

}