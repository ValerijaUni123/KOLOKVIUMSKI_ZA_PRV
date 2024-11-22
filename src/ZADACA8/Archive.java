package ZADACA8;

import java.time.LocalDate;
import java.util.Date;

public abstract class Archive {
    private int id;
    private LocalDate dateArchived;

    public Archive(int id) {
        this.id = id;
    }
    void setDateArchived(LocalDate dateArchived) {
        this.dateArchived = dateArchived;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateArchived() {
        return dateArchived;
    }
}
