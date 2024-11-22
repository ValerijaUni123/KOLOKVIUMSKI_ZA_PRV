package ZADACA19;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subtitles {
    private List<Subtitle> subtitles;

    public Subtitles() {
        subtitles = new ArrayList<Subtitle>();
    }
    public int loadSubtitles(InputStream inputStream){
        Scanner sc = new Scanner(inputStream);

        while(sc.hasNext()){
            int id = sc.nextInt();
            sc.nextLine();
            String time = sc.nextLine();
            List<String> strings = new ArrayList<>();

            while(sc.hasNext()){
                String line = sc.nextLine();

                if(line.trim().length()==0){
                    break;
                }
                strings.add(line);
            }
            subtitles.add(new Subtitle(id, String.join("\n", strings), time));
        }
        return subtitles.size();
    }
    public void print(){

    }
    public void shift(int ms){
        subtitles.forEach(s -> s.shi);

    }
}
