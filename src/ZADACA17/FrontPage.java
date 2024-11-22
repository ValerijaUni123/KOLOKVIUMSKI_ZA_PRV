package ZADACA17;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FrontPage {
    private List<NewsItem> newsItems;
    private Category[] categories;

    public FrontPage(Category[] categories){
        this.newsItems = new ArrayList<>();
        this.categories = Arrays.copyOf(categories, categories.length);
    }
    public void addNewsItem(NewsItem newsItem){
        newsItems.add(newsItem);
    }
    public List<NewsItem> listByCategory(Category category){
        return newsItems.stream().filter(i -> i.getCategory().equals(category)).collect(Collectors.toList());
    }

    public List<NewsItem> listByCategoryName(String category) throws CategoryNotFoundException {
        for(Category c : categories){
            if(c.getName().equals(category)){
                return newsItems.stream().filter(i -> i.getCategory().getName().equals(category)).collect(Collectors.toList());
            }
        }
        throw new CategoryNotFoundException(String.format("Category %s was not found", category));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        newsItems.forEach(i -> sb.append(i.getTeaser() + "\n"));
        return sb.toString();
    }
}
