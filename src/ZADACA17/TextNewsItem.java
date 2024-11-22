package ZADACA17;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TextNewsItem extends NewsItem{
    private String text;

    public TextNewsItem(String title, Date date, Category category, String text) {
        super(title, date, category);
        this.text = text;
    }

    @Override
    public String getTeaser() {
        long duration = Calendar.getInstance().getTime().getTime() - date.getTime();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        return String.format("%s\n%d\n%.80s", title, TimeUnit.MILLISECONDS.toMinutes(duration), text);
    }
}
