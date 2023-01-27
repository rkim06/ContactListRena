import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class ContactList
{
    private ArrayList<Person> contacts;

    public ContactList(){
        contacts = new ArrayList <Person>();
    }

    //prints the instructions
    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    //adds a contact to the ArrayLists
    public void addContact() {
        Scanner input = new Scanner(System.in);

        System.out.println("Select a type of contact to add: \n"+
                            "1. Student\n2. Worker");
        //stores either student or worker
        int num = input.nextInt();
        input.nextLine();

        System.out.println("Please fill in the following information:\nFirst name: ");
        String fname = input.nextLine();

        System.out.println("Last name: ");
        String lname = input.nextLine();

        System.out.println("Phone number: ");
        String phoneNum = input.nextLine();

        //if a student, then the grade is asked for
        if(num == 1){
            input.nextLine();
            System.out.println("Grade: ");
            int grade = input.nextInt();
            input.nextLine();

            Student stu = new Student(fname, lname, phoneNum, grade);
        }
        //if a student, then the occupation is asked for
        else{
            System.out.println("Occupation: ");
            String job = input.nextLine();

            Worker wor = new Worker(fname, lname, phoneNum, job);
        }

    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        for(int i = 0; i<contacts.size(); i++){
            System.out.println(contacts.get(i));
        }
    }


    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        int n = contacts.size();

        //loops through the contacts to compare the pairs
        for(int pass = 1; pass < n; pass++){
            for(int comp = 0; comp < n-pass; comp++){
                //sorts by first name if 0
                if(sortBy == 0){
                    //gets and compares the first name of the contact to the input
                    if(contacts.get(comp).getFirstName().compareTo(contacts.get(comp+1).getFirstName())>0){
                        //uses a temporary variable to swap the contacts
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp+1));
                        contacts.set(comp+1, temp);
                    }
                }
                else if(sortBy == 1){
                    //gets and compares the last name of the contact to the input
                    if(contacts.get(comp).getLastName().compareTo(contacts.get(comp+1).getLastName())>0){
                        //uses a temporary variable to swap the contacts
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp+1));
                        contacts.set(comp+1, temp);
                    }
                }
                else if(sortBy == 2){
                    //gets and compares the phone number of the contact to the input
                    if(contacts.get(comp).getPhoneNumber().compareTo(contacts.get(comp+1).getPhoneNumber())>0){
                        //uses a temporary variable to swap the contacts
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp+1));
                        contacts.set(comp+1, temp);
                    }
                }

            }
        }
    }

    //searches to find the contact by the first name
    public Person searchByFirstName(String firstName){
        Scanner input = new Scanner(System.in);

        //compares input to the current first name
        //checking to see if a contact with the first name exists
        for(int i = 0; i < contacts.size(); i++){
            if(firstName.equals(contacts.get(i).getFirstName())){
                return contacts.get(i);
            }
        }
        //no existence of contact with first name = null
        return null;
    }

    //searches to find the contact by the last name
    public Person searchByLastName(String lastName){
        //compares input to the current last name
        //checking to see if a contact with the last name exists
        for(int i = 0; i < contacts.size(); i++){
            if(lastName.equals(contacts.get(i).getLastName())){
                return contacts.get(i);
            }
        }
        //no existence of contact with last name = null
        return null;
    }

    //searches to find the contact by the phone number
    public Person searchByPhoneNumber(String phoneNumber){
        //compares input to the current phone number
        //checking to see if a contact with the number exists
        for(int i = 0; i < contacts.size(); i++){
            if(phoneNumber.equals(contacts.get(i).getPhoneNumber())){
                return contacts.get(i);
            }
        }
        //no existence of contact with phone number = null
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    //generates a list of just the students in contacts
    public ArrayList<Person> listStudents() {
        ArrayList<Person> students = new ArrayList<Person>();

        //loops through contacts to find students
        for(int i = 0; i < contacts.size(); i++){
            //if the contact at i is of the student class
            //we will add it to the students ArrayList
            if(contacts.get(i) instanceof Student){
                students.add(contacts.get(i));
            }
        }

        //returns the arraylist of just students
        return students;
    }


    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();
        int n = input.nextInt();
        input.nextLine();

        while(n != 0){
            if(n == 1){
                addContact();
            }
            else if(n == 2){
                sort(0);
                printContacts();
            }
            else if(n == 3){
                sort(1);
                printContacts();
            }
            else if(n == 4){
                sort(2);
                printContacts();
            }
            else if(n == 5){

            }
            else if(n == 6){
                Scanner s = new Scanner(System.in);
                System.out.println("Enter a name:\n");
                String firstName = s.nextLine();

                Person p = searchByFirstName(firstName);

                if(p == null){
                    System.out.println(firstName+" is not in the list");
                }
                else{
                    System.out.println(p);
                }
            }
            else if(n == 7){
                Scanner s = new Scanner(System.in);
                System.out.println("Enter a name:\n");
                String lastName = s.nextLine();

                Person p = searchByLastName(lastName);

                if(p == null){
                    System.out.println(lastName+" is not in the list");
                }
                else{
                    System.out.println(p);
                }
            }
            //8 searches by phone number
            else if(n == 8){
                Scanner s = new Scanner(System.in);
                System.out.println("Enter a number:\n");
                String phoneNum = s.nextLine();

                Person p = searchByPhoneNumber(phoneNum);

                if(p == null){
                    System.out.println(phoneNum+" is not in the list");
                }
                else{
                    System.out.println(p);
                }
            }
            printMenuOptions();
            n = input.nextInt();
            input.nextLine();
        }

    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
