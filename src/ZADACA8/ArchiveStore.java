package ZADACA8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArchiveStore {
    private final List<Archive> archives;
    private final StringBuilder stringBuilder;

    public ArchiveStore() {
        this.stringBuilder = new StringBuilder();
        archives = new ArrayList<Archive>();
    }
    public void archiveItem(Archive item, LocalDate date){
        item.setDateArchived(date);
        archives.add(item);
        stringBuilder.append(String.format("Item %d archived at %s\n", item.getId(), date.toString()));

    }
    public void openItem(int id, LocalDate date) throws NonExistingItemException {
        Archive archive = null;
        for (Archive a : archives) {
            if(a.getId() == id){
                archive = a;
                break;
            }
        }
        if(archive == null){
            throw new NonExistingItemException(id);
        }
        else if(archive instanceof LockedArchive){
            if(date.isBefore(((LockedArchive)archive).getDateToOpen())){
                stringBuilder.append(String.format("Item %d cannot be opened before %s\n", id, ((LockedArchive)archive).getDateToOpen()));
            }
            else{
                stringBuilder.append(String.format("Item %d opened at %s\n", id, date.toString()));
            }
        }
        else{
            if(((SpecialArchive) archive).getCurrentOpen() == ((SpecialArchive) archive).getMaxOpen()){
                stringBuilder.append(String.format("Item %d cannot be opened more than %d times", id, ((SpecialArchive) archive).getMaxOpen()));
            }
            else{
                stringBuilder.append(String.format("Item %d opened at %s\n", id, date.toString()));
                ((SpecialArchive) archive).increaseCurrentOpen();
            }
        }



    }
    public String getLog(){
        return stringBuilder.toString();
    }
}
