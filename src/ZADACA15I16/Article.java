package ZADACA15I16;

public class Article {
    private int amount;
    private String type;

    public Article(int amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getTax(){
        if(type.equals("A")){
            return amount * 0.18 * 0.15;
        }
        else if(type.equals("B")){
            return amount * 0.05 * 0.15;
        }
        else{
            return 0;
        }
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
