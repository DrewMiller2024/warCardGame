
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
    private boolean gameIsOver = false;
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
            System.out.println("--Player 1: "+play1.getDeckSize()+ " cards, Player 2: " + play2.getDeckSize() +" cards--");
            checkForWinner();

            if (turnNumber == 300 && !gameIsOver) {
                maxTurnsPlayed();
            }
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
            System.out.println("--Player 1 has won! After 300 turns, player 1 has more cards left");
        } else if (play2.getDeckSize() > play1.getDeckSize()) {
            System.out.println("--Player 2 has won! After 300 turns, player 2 has more cards left");
        } else {
            System.out.println("--Draw! After 300 turns, both players have the same number of cards left--");
        }
        gameIsOver = true;
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
