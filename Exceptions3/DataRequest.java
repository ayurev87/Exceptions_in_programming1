import java.io.FileWriter;
import java.util.Scanner;

//Data FIO,Tel
public class DataRequest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String yearOfBirth;
    private long numberPhone;
    private char gender;
    private final Scanner scan = new Scanner(System.in);

    // Methods for assigning values to fields
    private void EnterFirstName() {
        System.out.println("Enter first name:");
        firstName = scan.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("The entered value cannot be empty,\nTry again!");
        }
    }

    private void EnterLastName() {
        System.out.println("Enter last name:");
        lastName = scan.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("The entered value cannot be empty,\nTry again!");
        }
    }

    private void EnterMiddleName() {
        System.out.println("Enter middle name");
        middleName = scan.nextLine();
        if (middleName.equals("")) {
            throw new RuntimeException("The entered value cannot be empty,\nTry again!");
        }
    }

    private void EnterYearOfBirth() {
        System.out.println("Enter year of birth:");
        yearOfBirth = scan.nextLine();
        if (yearOfBirth.equals("")) {
            throw new RuntimeException("The entered value cannot be empty,\nTry again!");
        }
    }

    private void EnterNumberPhone() {
        try {
            System.out.println("Enter number phone:");
            String number = scan.nextLine();
            if (number.equals("")) {
                throw new RuntimeException("The entered value cannot be empty,\nTry again!");
            }
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Wrong format, Try again!!");
        }
    }

    private void EnterGender() {
        System.out.println("Enter gender (f, m):");
        String gen;
        String f = "f";
        String m = "m";
        gen = scan.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("You have entered too many characters \nTry again!");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("You entered the wrong character!");
        }
    }

    // Method for outputting received values to the console
    private void OutPutData() {
        System.out.println("\nFirst name \t- \t" + firstName + "\n" + "Last name \t- \t" + lastName + "\n"
                + "Middle name \t- \t" + middleName + "\n" + "Year of birth \t- \t" + yearOfBirth + "\n"
                + "Number phone \t- \t" + numberPhone + "\n" + "Gender   \t- \t" + gender);
    }

    // Method for combining all methods into one
    private void DataEnter() {
        EnterFirstName();
        EnterLastName();
        EnterMiddleName();
        EnterYearOfBirth();
        EnterNumberPhone();
        EnterGender();
        OutPutData();
    }

    // Method for saving data to a file
    public void SaveDataEnter() {

        DataEnter();
        String file = "data/" + lastName + ".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("<" + firstName + "> " + "<" + lastName + "> " + "<" + middleName + "> " + "<" + yearOfBirth + "> "
                    + "<" + numberPhone + "> " + "<" + gender + ">\n");
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }

    // Getters for fields

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public char getGender() {
        return gender;
    }

}
