
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    private Deck pile = new Deck();
    private Deck play1;
    private Deck play2;
    private boolean gameIsOver;
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
       Deck deck = new Deck();
       deck.initializeNewDeck();
       deck.shuffle();
       Deck[] halves = deck.dealDeck();
       play1 = halves[0];
       play2 = halves[1];
        this.gameIsOver = false;
        // ...then run the event loop
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flWhy Teams?
owchart you created for this game
     */
    public void runEventLoop() {
        int turnNumber = 1;
        while (turnNumber <= 300 && !gameIsOver) {
            System.out.println("--Turn: " + turnNumber + "--");
            System.out.println("Cards; P1: "+play1.getDeckSize()+ ", P2: " + play2.getDeckSize() +"");
            
            checkForWinner();
            playCard();

            if (turnNumber == 300) {
                maxTurnsPlayed();
            }
            turnNumber++;
        }
    }
    
    private void checkForWinner() {
        if (play1.getDeckSize() == 0) {
            if (play2.getDeckSize() == 0) {
                System.out.println("--Draw! Both players have run out of cards--");
            } else {
                System.out.println("--Player 2 has won! Player 1 has run out of cards--");
            }
            gameIsOver = true;
        } else if (play2.getDeckSize() == 0) {
            System.out.println("--Player 2 has won! Player 1 has run out of cards--");
            gameIsOver = true;
        }
    }

    private void maxTurnsPlayed() {
        if (play1.getDeckSize() > play2.getDeckSize()) {
            System.out.println("--Player 1 has won! After 300 turns, P1: "+play1.getDeckSize() + " cards, P2: " +play2.getDeckSize()+ " cards");
        } else if (play2.getDeckSize() > play1.getDeckSize()) {
            System.out.println("--Player 2 has won! After 300 turns, P2: "+play2.getDeckSize() + " cards, P1: " +play1.getDeckSize()+ " cards");
        } else {
            System.out.println("--Draw! After 300 turns, both players have " + play1.getDeckSize() + " cards left");
        }
    }

    private void playCard() {
        pile.addCardToDeck(play1.dealCardFromDeck());
        pile.addCardToDeck(play2.dealCardFromDeck());

        printCardsPlayed();
        checkEncounter();
    }

    private void printCardsPlayed() {
        System.out.println("P1: " + pile.getCardFace(pile.getDeckSize()-2) + " Of " + pile.getCardSuit(pile.getDeckSize()-2) + "");
        System.out.println("P2: " + pile.getCardFace(pile.getDeckSize()-1) + " Of " + pile.getCardSuit(pile.getDeckSize()-1) + "");
    }

    private void checkEncounter() {
        if (pile.getCardRank(pile.getDeckSize()-2) > pile.getCardRank(pile.getDeckSize()-1)) {
            System.out.println("P1 wins the encounter, pile goes to P1");
            while (pile.getDeckSize() > 0) {
                play1.addCardToDeck(pile.dealCardFromDeck());
            }
        } else if (pile.getCardRank(pile.getDeckSize()-1) > pile.getCardRank(pile.getDeckSize()-2)) {
            System.out.println("P2 wins the encounter, pile goes to P2");
            while (pile.getDeckSize() > 0) {
                play2.addCardToDeck(pile.dealCardFromDeck());
            }
        } else {
            playWar();
        }
    }

    private void playWar() {
        System.out.println("War!");
        for (int i = 0; i < 2; i++) {
            checkForWinner();
            pile.addCardToDeck(play1.dealCardFromDeck());
            pile.addCardToDeck(play2.dealCardFromDeck());
        }
        System.out.println("Both players place a card face down");
        printCardsPlayed();
        checkEncounter();
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
