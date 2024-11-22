package ZADACA15I16;

import java.io.*;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MojDDV {
    private List<Receipt> receipts;

    public MojDDV() {
        this.receipts = new ArrayList<>();
    }

    public void readRecords (InputStream inputStream){
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
        receipts = bfr.lines().map(Receipt::create).collect(Collectors.toList());

    }

    public void printTaxReturns (OutputStream outputStream){
        PrintWriter pw = new PrintWriter(outputStream);
        for(Receipt receipt : receipts){
            if(receipt != null)
                pw.println(receipt.toString());
        }
        pw.flush();
    }

    public void printStatistics (OutputStream outputStream){
        PrintWriter pw = new PrintWriter(outputStream);
        DoubleSummaryStatistics doubleSummaryStatistics = receipts
                .stream()
                .filter(Objects::nonNull)
                .mapToDouble(Receipt::getTotalTaxReturn)
                .summaryStatistics();
        pw.printf("min:\t%5.3f\n" +
                "max:\t%5.3f\n" +
                "sum:\t%5.3f\n" +
                "count:\t%5d\n" +
                "avg:\t%5.3f",
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getMax(),
                doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getCount(),
                doubleSummaryStatistics.getAverage());
        pw.flush();
    }

}
