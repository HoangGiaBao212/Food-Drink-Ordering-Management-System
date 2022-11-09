import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class FileUtil {
    private FileUtil() {
    }

    public static void writeObjectToFile(String filepath, Object serObj) {
    }

    public static Object dataToObject(String dataString) {
        Object data = new Object();
        // get type of class
        int beginIndex = 0;
        String str = "";
        int endIndex = dataString.indexOf(" ", beginIndex);
        if (dataString.substring(beginIndex, endIndex).equals("Account")) {
            data = new Account();
            str = "id='";
            beginIndex = dataString.indexOf(str, endIndex) + str.length();
            endIndex = dataString.indexOf("'", beginIndex);
            ((Account) data).setId(Integer.parseInt(dataString.substring(beginIndex, endIndex)));
            str = "username='";
            beginIndex = dataString.indexOf(str, endIndex) + str.length();
            endIndex = dataString.indexOf("'", beginIndex);
            ((Account) data).setUsername(dataString.substring(beginIndex, endIndex));
            str = "password='";
            beginIndex = dataString.indexOf(str, endIndex) + str.length();
            endIndex = dataString.indexOf("'", beginIndex);
            ((Account) data).setPassword(dataString.substring(beginIndex, endIndex));
            str = "person='";
            beginIndex = dataString.indexOf(str, endIndex) + str.length();
            endIndex = dataString.indexOf(" ", beginIndex);
            if (dataString.substring(beginIndex, endIndex).equals("Manager")) {
                ((Account) data).setPerson(new Manager());
                str = "name='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                ((Account) data).getPerson().setName(dataString.substring(beginIndex, endIndex));
                str = "address='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                ((Account) data).getPerson().setAddress(dataString.substring(beginIndex, endIndex));
                str = "dateOfBirth='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                try {
                    ((Account) data).getPerson().setDateOfBirth(
                            new SimpleDateFormat("dd-MM-yyyy").parse(dataString.substring(beginIndex, endIndex)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                str = "salary='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                ((Employee) ((Account) data).getPerson())
                        .setSalary(Integer.parseInt(dataString.substring(beginIndex, endIndex)));
            } else if (dataString.substring(beginIndex, endIndex).equals("Salesman")) {
                ((Account) data).setPerson(new Manager());
                str = "name='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                ((Account) data).getPerson().setName(dataString.substring(beginIndex, endIndex));
                str = "address='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                ((Account) data).getPerson().setAddress(dataString.substring(beginIndex, endIndex));
                str = "dateOfBirth='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                try {
                    ((Account) data).getPerson().setDateOfBirth(
                            new SimpleDateFormat("dd-MM-yyyy").parse(dataString.substring(beginIndex, endIndex)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                str = "salary='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                ((Employee) ((Account) data).getPerson())
                        .setSalary(Integer.parseInt(dataString.substring(beginIndex, endIndex)));
            } else if (dataString.substring(beginIndex, endIndex).equals("Customer")) {
                ((Account) data).setPerson(new Customer());
                str = "name='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                ((Account) data).getPerson().setName(dataString.substring(beginIndex, endIndex));
                str = "address='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                ((Account) data).getPerson().setAddress(dataString.substring(beginIndex, endIndex));
                str = "dateOfBirth='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                try {
                    ((Account) data).getPerson().setDateOfBirth(
                            new SimpleDateFormat("dd-MM-yyyy").parse(dataString.substring(beginIndex, endIndex)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                str = "point='";
                beginIndex = dataString.indexOf(str, endIndex) + str.length();
                endIndex = dataString.indexOf("'", beginIndex);
                ((Customer) ((Account) data).getPerson())
                        .setPoint(Integer.parseInt(dataString.substring(beginIndex, endIndex)));
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
