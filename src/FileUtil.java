import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileUtil {
    private FileUtil() {
    }

    public static String cutString(String str, String beginString, String endString) {
        int beginIndex = str.indexOf(beginString) + beginString.length();
        int endIndex = str.indexOf(endString, beginIndex);
        return str.substring(beginIndex, endIndex);
    }

    public static Object dataToObject(String dataString) {
        Object data = new Object();
        switch (cutString(dataString, "", " ")) {
            case "Account" -> {
                data = new Account();
                ((Account) data).setId(Integer.parseInt(cutString(dataString, "id='", "'")));
                ((Account) data).setUsername(cutString(dataString, "username='", "'"));
                ((Account) data).setPassword(cutString(dataString, "password='", "'"));
                switch (cutString(dataString, "person='", " ")) {
                    case "Manager" -> {
                        ((Account) data).setPerson(new Manager());
                        ((Employee) ((Account) data).getPerson())
                                .setSalary(Integer.parseInt(cutString(dataString, "salary='", "'")));
                    }
                    case "Salesman" -> {
                        ((Account) data).setPerson(new Salesman());
                        ((Employee) ((Account) data).getPerson())
                                .setSalary(Integer.parseInt(cutString(dataString, "salary='", "'")));
                    }
                    case "Customer" -> {
                        ((Account) data).setPerson(new Customer());
                        ((Customer) ((Account) data).getPerson())
                                .setPoint(Integer.parseInt(cutString(dataString, "point='", "'")));
                    }
                }
                ((Account) data).getPerson().setName(cutString(dataString, "name='", "'"));
                ((Account) data).getPerson().setAddress(cutString(dataString, "address='", "'"));
                try {
                    ((Account) data).getPerson().setDateOfBirth(
                            new SimpleDateFormat("dd-MM-yyyy").parse(cutString(dataString, "dateOfBirth='", "'")));
                } catch (ParseException e) {
                    ((Account) data).getPerson().setDateOfBirth(new Date());
                }
            }
        }
        return data;
    }

    public static ArrayList readDataFromFile(String filepath) {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                arrayList.append(dataToObject(data));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void writeDataToFile(String filepath, Object data) {
        try {
            FileOutputStream file = new FileOutputStream(filepath);
            PrintStream output = new PrintStream(file);
            output.print(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
