package blackjack.domain.user;

public enum MatchResult {
    WIN_BLACKJACK(1.5),
    WIN_NORMAL(1.0),
    DRAW(0),
    LOSE(-1.0);

   private final double earningRate;

    MatchResult(double earningRate) {
        this.earningRate = earningRate;
    }

    public static MatchResult calculateResult(User player, User dealer) {
        if (player.isBust()) {
            return MatchResult.LOSE;
        }
        if (dealer.isBust()) {
            return checkPlayerBlackjack(player);
        }
        if (dealer.isBlackjack() && player.isBlackjack()) {
            return MatchResult.DRAW;
        }
        return compareScore(player, dealer);
    }

    private static MatchResult compareScore(User player, User dealer) {
        if (player.getScore() < dealer.getScore()) {
            return MatchResult.LOSE;
        }
        if (player.getScore() == dealer.getScore()) {
            return MatchResult.DRAW;
        }
        return checkPlayerBlackjack(player);
    }

    private static MatchResult checkPlayerBlackjack(User player) {
        if (player.isBlackjack()) {
            return MatchResult.WIN_BLACKJACK;
        }
        if (player.isBust()) {
            return MatchResult.LOSE;
        }
        return MatchResult.WIN_NORMAL;
    }

    public double getEarningRate() {
        return earningRate;
    }
}
