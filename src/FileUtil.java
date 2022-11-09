import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileUtil {
    private FileUtil() {
    }

    public static void writeObjectToFile(String filepath, Object serObj) {
    }

    public static String cutString(String str, String beginString, String endString) {
        int beginIndex = str.indexOf(beginString) + beginString.length();
        int endIndex = str.indexOf(endString, beginIndex);
        return str.substring(beginIndex, endIndex);
    }

    public static Object dataToObject(String dataString) {
        Object data = new Object();
        // get type of class
        int beginIndex = 0;
        String str = "";
        int endIndex = dataString.indexOf(" ", beginIndex);
        if (dataString.substring(beginIndex, endIndex).equals("Account")) {
            data = new Account();
            ((Account) data).setId(Integer.parseInt(cutString(dataString, "id='", "'")));
            ((Account) data).setUsername(cutString(dataString, "username='", "'"));
            ((Account) data).setPassword(cutString(dataString, "password='", "'"));
            str = "person='";
            beginIndex = dataString.indexOf(str, endIndex) + str.length();
            endIndex = dataString.indexOf(" ", beginIndex);
            if (cutString(dataString, "person='", " ").equals("Manager")) {
                ((Account) data).setPerson(new Manager());
                ((Employee) ((Account) data).getPerson())
                        .setSalary(Integer.parseInt(cutString(dataString, "salary='", "'")));
            } else if (cutString(dataString, "person='", " ").equals("Salesman")) {
                ((Account) data).setPerson(new Salesman());
                ((Employee) ((Account) data).getPerson())
                        .setSalary(Integer.parseInt(cutString(dataString, "salary='", "'")));
            } else if (cutString(dataString, "person='", " ").equals("Customer")) {
                ((Account) data).setPerson(new Customer());
                ((Customer) ((Account) data).getPerson())
                        .setPoint(Integer.parseInt(cutString(dataString, "point='", "'")));
            }
            ((Account) data).getPerson().setName(cutString(dataString, "name='", "'"));
            ((Account) data).getPerson().setAddress(cutString(dataString, "address='", "'"));
            try {
                ((Account) data).getPerson().setDateOfBirth(
                        new SimpleDateFormat("dd-MM-yyyy").parse(cutString(dataString, "dateOfBirth='", "'")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static ArrayList readObjectFromFile(String filepath) {
        ArrayList arrayList = new ArrayList();
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                arrayList.append(dataToObject(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void main(String[] args) {
        System.out.println(
                readObjectFromFile("/home/alex/Documents/Food-Drink-Ordering-Management-System/src/accountList.txt"));
    }
}
