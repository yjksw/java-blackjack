package blackjack.domain.user;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;

import java.util.List;

public abstract class User {

    protected Hand hand;
    protected final String name;
    protected final double bettingMoney;

    public User(String name, double bettingMoney, List<Card> cards, int stayLimit) {
        validateNotEmptyName(name);
        initialHands(cards, stayLimit);
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    private void validateNotEmptyName(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("빈 이름이 입력되었습니다.");
        }
    }

    private void initialHands(List<Card> cards, int stayLimit) {
        this.hand = new Hand(cards, stayLimit);
    }

    public abstract boolean draw(Deck deck);

    public boolean isHit() {
        return hand.isHit();
    }

    public boolean isBust() {
        return hand.isBust();
    }

    public boolean isBlackjack() {
        return hand.isBlackjack();
    }

    public void convertToStay() {
        hand.convertStatusToStay();
    }

    public List<Card> getCards() {
        return hand.getCards();
    }

    public int getScore() {
        return hand.getScore();
    }

    public String getName() {
        return this.name;
    }

    public double getBettingMoney() {
        return this.bettingMoney;
    }
}
