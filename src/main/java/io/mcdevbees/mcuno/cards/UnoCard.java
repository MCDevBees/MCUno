package io.mcdevbees.mcuno.cards;

public class UnoCard {

    private int cardType;
    private UnoColor color;

    /**
     * Constructor for a basic Uno Card of any type
     * @param cardType integer valued between 1 and 14 representing the type of card it is
     * @param color UnoColor for what color the card is
     */
    public UnoCard(int cardType, UnoColor color) {
        this.cardType = cardType;
        this.color = color;
    }

    /**
     * getter for the card type
     * @return integer 1-14 representing card type
     */
    public int getCardType() {
        return this.cardType;
    }

    /**
     * getter for card color
     * @return UnoColor representing card color
     */
    public UnoColor getColor() {
        return this.color;
    }

    public boolean performAction(UnoCard currentCard, boolean direction, int drawOnNextTurn, boolean skipNextTurn) {
        //the parameters are just temporary, what should eventually be passed in is a game instance

        if (currentCard.color == UnoColor.WILD) {
            //have an inventory choice of picking the color
            if (currentCard.cardType == UnoCardType.WILD_DRAW_FOUR) {
                drawOnNextTurn = 4;
                skipNextTurn = true;
            }
            return true;
        }

        //only check needed to see if card can be played
        if ((currentCard.cardType != this.cardType) && (currentCard.color != this.color)) {
            return false;
        }


        if (currentCard.cardType == UnoCardType.SKIP) {
            skipNextTurn = true;
        } else if (currentCard.cardType == UnoCardType.REVERSE) {
            direction = !direction;
        } else if (currentCard.cardType == UnoCardType.DRAW_TWO) {
            drawOnNextTurn = 2;
            skipNextTurn = true;
        }

        //possibly set next card here???

        return true;
    }

}
