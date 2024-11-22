package ZADACA14;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherStation {
    private List<WeatherData> list;
    private int days;

    public WeatherStation(int n){
        this.list = new ArrayList<>();
        this.days =n;
    }
    public void addMeasurment(float temperature, float wind, float humidity, float visibility, Date date){
        Date cutOffDate = new Date(date.getTime() - (days * 24 * 60 * 60 * 1000));
        list.removeIf(i -> i.getDate().before(cutOffDate));

        for(WeatherData wd : list){
            if(Math.abs(date.getTime() - wd.getDate().getTime()) < (2.5 * 60 * 1000)){
                return;
            }
        }
        list.add(new WeatherData(temperature, wind, humidity, visibility, date));

    }
    public int total(){
        return list.size();
    }
    public void status(Date from, Date to){
        List<WeatherData> wdList;

        wdList = list.stream().filter(i -> (i.getDate().after(from) || i.getDate().equals(from)) &&
                (i.getDate().before(to) || i.getDate().equals(to))).collect(Collectors.toList());

        if(wdList.isEmpty()){
            throw new RuntimeException();
        }

        double average = wdList.stream().mapToDouble(i -> i.getTemperature()).average().getAsDouble();

        for(WeatherData wd : wdList){
            System.out.println(wd.toString());
        }

        System.out.printf("Average temperature: %.2f", average);

    }
}
