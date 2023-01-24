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
    public void addContact() {
        Scanner input = new Scanner(System.in);

        System.out.println("Select a type of contact to add: \n"+
                            "1. Student\n2. Worker");
        int num = input.nextInt();

        System.out.println("Please fill in the following information:\nFirst name: ");
        String fname = input.nextLine();
        System.out.println();
        System.out.println("Last name: ");
        String lname = input.nextLine();
        System.out.println();
        System.out.println("Phone number: ");
        String phoneNum = input.nextLine();

        if(num == 1){
            System.out.println("Grade: ");
            int grade = input.nextInt();

            Student stu = new Student(fname, lname, phoneNum, grade);
        }
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
        // TODO: Complete the printContacts method
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        int n = contacts.size();

        for(int pass = 1; pass < n; pass++){
            for(int comp = 0; comp < n-pass; comp++){
                if(sortBy == 0){
                    if(contacts.get(comp).getFirstName().compareTo(contacts.get(comp+1).getFirstName())>0){
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp+1));
                        contacts.set(comp+1, temp);
                    }
                }
                else if(sortBy == 1){
                    if(contacts.get(comp).getLastName().compareTo(contacts.get(comp+1).getLastName())>0){
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp+1));
                        contacts.set(comp+1, temp);
                    }
                }
                else{
                    if(contacts.get(comp).getPhoneNumber().compareTo(contacts.get(comp+1).getPhoneNumber())>0){
                        Person temp = contacts.get(comp);
                        contacts.set(comp, contacts.get(comp+1));
                        contacts.set(comp+1, temp);
                    }
                }

            }
        }
    }

    // TODO: Write searchByFirstName

    // TODO: Write searchByLastName

    // TODO: Write searchByPhoneNumber

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();

        // TODO: Complete the run method
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
