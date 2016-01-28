package rachast.com.rachast.model;

/**
 * Created by Cliente on 14/12/2015.
 */
public class MatchEvent {

    public static enum EventType {
        GOAL(1), FAULT(2);
        private final int codigo;
        EventType(int codigo) {
            this.codigo = codigo;
        }
        int codigo() {
            return codigo;
        }
    }

    private Player player;
    private int eventType;

    public MatchEvent(Player p, int eventType) {
        this.player = p;
        this.eventType = eventType;
    }

}
