package ZADACA15I16;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final String id;
    private final List<Article> articles;

    public Receipt(String id, List<Article> articles) {
        this.id = id;
        this.articles = articles;
    }

    public static Receipt create(String line)  {
        String[] parts = line.split("\\s+");
        String id=parts[0];
        List<Article> list = new ArrayList<Article>();
        for(int i=1;i<parts.length;i+=2){
            list.add(new Article(Integer.parseInt(parts[i]), parts[i+1]));
        }
        Receipt receipt = new Receipt(id, list);
        try {
            if (receipt.totalAmount() > 30000) {
                throw new AmountNotAllowedException(receipt.totalAmount());
            } else {
                return receipt;
            }
        }
        catch (AmountNotAllowedException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int totalAmount(){
        return articles.stream().mapToInt(Article::getAmount).sum();
    }

    public double getTotalTaxReturn(){
        return articles.stream().mapToDouble(Article::getTax).sum();
    }

    @Override
    public String toString() {
        return String.format("%10s\t%10d\t%10.5f", id, totalAmount(), getTotalTaxReturn());
    }
}
