package domain.user;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private final List<Player> players = new ArrayList<>();

    public Players(List<String> playerNames) {
        if (playerNames == null || playerNames.isEmpty()) {
            throw new NullPointerException("이름이 비어있습니다.");
        }
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
    }
}
