package ZADACA7;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TimeTable {
    private List<String> times;

    public TimeTable(){
        times = new ArrayList<String>();
    }

    private boolean isValidFormat(String format){
        return format.matches("\\d+[:.]\\d+");
    }
    private boolean isValidTime(String time){
        return time.matches("([0-9]|1[0-9]|2[0-3])[:.][0-5][0-9]");
    }

    public void readTimes(InputStream inputStream) throws UnsupportedFormatException, InvalidTimeException {
        Scanner scanner = new Scanner(inputStream);
        String[] parts;
        while(scanner.hasNextLine()){
            parts = scanner.nextLine().split("\\s+");
            for(String time : parts){
                if(!isValidFormat(time)){
                    throw new UnsupportedFormatException(time);
                }
                if(!isValidTime(time)){
                    throw new InvalidTimeException(time);
                }
                times.add(time.replace(".", ":"));
            }
        }

    }
    public void writeTimes(OutputStream outputStream, TimeFormat format){
        PrintWriter printWriter = new PrintWriter(outputStream);
        if(format == TimeFormat.FORMAT_24){
            times.stream().sorted(Comparator.comparing(i -> getTimeInMinutes(i)))
                    .forEach(i -> printWriter.printf("%5s\n", i));
        }
        else{
            times.stream().sorted(Comparator.comparing(i-> getTimeInMinutes(i)))
                    .forEach(i -> printWriter.printf("%8s\n", toAMPM(i)));
        }
        printWriter.flush();
    }
    public String toAMPM(String time){
        if(time.matches("0:[0-5][0-9]"))
            return time.replace("0:", "12:") +" AM";
        else if(time.matches("([1-9]|1[01]):[0-5][0-9]"))
            return time + " AM";
        else if(time.matches("12:[0-5][0-9]"))
            return time + " PM";
        else return String.format("%d:%s PM", Integer.parseInt(time.substring(0, 2)) - 12,
                    time.substring(3, 5));
    }
    public int getTimeInMinutes(String time){
        return Integer.parseInt(time.split(":")[0]) *60 + Integer.parseInt(time.split(":")[1]);
    }
}
