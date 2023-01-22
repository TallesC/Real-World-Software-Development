package extratobancario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/resources/";

    public static void main(final String... args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;

        for (final String line: lines){
            final String[] colums = line.split(",");
            final double amount = Double.parseDouble(colums[1]);
            total += amount;
        }
        System.out.println("The total for all transactions is " + total);

        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int cont = 0;
        for (final String line : lines){
            final String[] colums = line.split(",");
            final LocalDate date = LocalDate.parse(colums[0], DATE_PATTERN);
            if(date.getMonth() == Month.JANUARY){
                cont++;
            }
        }
        System.out.println("The number of transactions in this month is " + cont);

    }



    
}
