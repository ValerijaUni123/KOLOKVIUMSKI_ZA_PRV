package ZADACA19;

import java.time.LocalTime;

public class Subtitle {
    private int id;
    private LocalTime from;
    private LocalTime to;
    private String text;


    /*
        this.from = LocalTime.of(Integer.parseInt(timeFrom[0]), Integer.parseInt(timeFrom[1]),
        Integer.parseInt(timeFrom[2]), 1 000 000 * Integer.parseInt(timeFrom[3]));
        this.to = LocalTime.of(Integer.parseInt(timeTo[0]), Integer.parseInt(timeTo[1]),
        Integer.parseInt(timeTo[2]), 1000000 * Integer.parseInt(timeTo[3]));
     */
    public Subtitle(int id, String text, String time) {
        this.id = id;
        this.text = text;
        String[] times = time.split("-->");
        String[] timeFrom = times[0].trim().split("[:,]");
        String[] timeTo = times[1].trim().split("[:,]");

        this.from = LocalTime.of(Integer.parseInt(timeFrom[0]), Integer.parseInt(timeFrom[1]),
                Integer.parseInt(timeFrom[2]), 1000000 * Integer.parseInt(timeFrom[3]));
        this.to = LocalTime.of(Integer.parseInt(timeFrom[0]), Integer.parseInt(timeFrom[1]),
                Integer.parseInt(timeFrom[2]), 1000000 * Integer.parseInt(timeFrom[3]));
    }

}
