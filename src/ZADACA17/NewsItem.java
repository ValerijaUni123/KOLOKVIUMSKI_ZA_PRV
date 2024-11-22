package ZADACA17;

import java.util.Date;

public abstract class NewsItem {
    protected String title;
    protected Date date;
    protected Category category;

    public NewsItem(String title, Date date, Category category) {
        this.title = title;
        this.date = date;
        this.category = category;
    }

    public abstract String getTeaser();

    public Category getCategory(){
        return category;
    }

}
