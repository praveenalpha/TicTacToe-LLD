package Model;

public class Symbol {
    private char symbol;
    private String avatarUrl;

    public Symbol(char symbol, String avatarUrl){
        this.symbol = symbol;
        this.avatarUrl = avatarUrl;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
