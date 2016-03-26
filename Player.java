public class Player {

    private String PlayerName;

    public Player(String name) {
        PlayerName = name;
    }

    /**
     * This set method sets the name of the player.
     * 
     *  @param Takes in a String as name.
     */
    public void setName(String name) {
        this.PlayerName = name;
    }

    /**
     * This get method returns the String value of player name.
     * 
     *  @return PlayerName, a String value.
     */
    public String getName() {
        return PlayerName;
    }

}