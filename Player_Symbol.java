
import static sun.audio.AudioPlayer.player;

public class Player_Symbol extends player {

    private String symbolChoice;
    private int[][] symbolPosition;

    public void setSymbol (String symbol) {
        this.symbolChoice = symbol;
    }

    public void setSymbolPos(int[][] position) {
        this.symbolPosition = position;
    }

    public String getSymbol() {
        return symbolChoice;
    }

    public int[][] getSymbolPos() {
        return symbolPosition;
    }

}
