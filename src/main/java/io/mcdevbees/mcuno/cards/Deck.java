package io.mcdevbees.mcuno.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

ArrayList<UnoCard> deck;

    /**
     * constructor of a deck of uno cards
     * @param fillDeck boolean, if false, deck will be empty, else will fill deck with normal uno cards
     */
    public Deck(boolean fillDeck) {
        deck = new ArrayList<>();
        if (fillDeck) {
            //just one
            addCardOfEveryColor(UnoCardType.ZERO);

            //two
            for (int i = 0; i < 2; i++) {
                addCardOfEveryColor(UnoCardType.ONE);
                addCardOfEveryColor(UnoCardType.TWO);
                addCardOfEveryColor(UnoCardType.THREE);
                addCardOfEveryColor(UnoCardType.FOUR);
                addCardOfEveryColor(UnoCardType.FIVE);
                addCardOfEveryColor(UnoCardType.SIX);
                addCardOfEveryColor(UnoCardType.SEVEN);
                addCardOfEveryColor(UnoCardType.EIGHT);
                addCardOfEveryColor(UnoCardType.NINE);
                addCardOfEveryColor(UnoCardType.DRAW_TWO);
                addCardOfEveryColor(UnoCardType.REVERSE);
                addCardOfEveryColor(UnoCardType.SKIP);
            }

            //four
            for (int i = 0; i < 4; i++) {
                deck.add(new UnoCard(UnoCardType.WILD, UnoColor.WILD));
                deck.add(new UnoCard(UnoCardType.WILD_DRAW_FOUR, UnoColor.WILD));
            }
        }
    }

    private void addCardOfEveryColor(int cardType) {
        deck.add(new UnoCard(cardType, UnoColor.BLUE));
        deck.add(new UnoCard(cardType, UnoColor.GREEN));
        deck.add(new UnoCard(cardType, UnoColor.RED));
        deck.add(new UnoCard(cardType, UnoColor.YELLOW));
    }

    /**
     * shuffles deck of cards (not initially called on constructor)
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * draws top card of deck
     * @return null if deck empty, else the first UnoCard in deck
     */
    public UnoCard drawCard() {
        if (deck.size() == 0) {
            return null;
        }
        return deck.remove(0);
    }

}
