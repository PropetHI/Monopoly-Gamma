package adrian.roszkowski.monopolygamma.vinnsla;

public class Player {

    private String name;
    private int money;
    private int position;

    public void setMoney(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }

    public Player(String name) {
        this.name = name;
        money = 1500;
        position = 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
