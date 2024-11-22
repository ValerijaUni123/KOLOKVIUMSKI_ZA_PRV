package ZADACA8;

import java.util.Date;

public class SpecialArchive extends Archive{
    private int maxOpen;
    private int currentOpen;

    public SpecialArchive(int id, int maxOpen) {
        super(id);
        this.maxOpen = maxOpen;
        this.currentOpen = 0;
    }

    public void increaseCurrentOpen(){
        currentOpen++;
    }

    public int getCurrentOpen(){
        return currentOpen;
    }

    public int getMaxOpen() {
        return maxOpen;
    }
}
