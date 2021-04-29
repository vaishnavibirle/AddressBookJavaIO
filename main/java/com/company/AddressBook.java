package com.company;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {

    static Scanner sc = new Scanner(System.in);
    static List<Contact> list = new LinkedList<Contact>();

    //Created method for adding contact
    public static void addContact()
    {
        System.out.println("Enter your firstName : ");
        String firstName = sc.nextLine();
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getFirstName().equalsIgnoreCase(firstName))
            {
                System.out.println("Name already exists. Try another name");
                addPersons();
                break;
            }
        }

        System.out.println("Enter your lastName : ");
        String lastName = sc.nextLine();
        System.out.println("Enter your address : ");
        String address = sc.nextLine();
        System.out.println("Enter your city : ");
        String city = sc.nextLine();
        System.out.println("Enter your state : ");
        String state = sc.nextLine();
        System.out.println("Enter your zipCode : ");
        String zip = sc.nextLine();
        System.out.println("Enter your phoneNo : ");
        long phoneNo = sc.nextLong();
        System.out.println("Enter your emailId : ");
        String email = sc.nextLine();
        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNo, email);
        list.add(contact);
    }

    //Created method for editing contact details
    public static void editContact() {
        System.out.println("Enter first name: ");
        String firstName = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                list.remove(i);
                addContact();
            } else {
                System.out.println("No data found in Address Book");
            }
        }
    }

    //Creating deleteContact() for deleting contact details using first name
    public static void deleteContact() {
        System.out.println("Enter first name : ");
        String firstName = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                list.remove(i);
            } else {
                System.out.println("No data found");
            }
        }
    }

    //Adding Multiple persons i.e contacts in address book
    public static void addPersons() {
        System.out.println("Enter number of persons added to be in address book : ");
        int noOfPersons = sc.nextInt();
        int count  = 1;
        while (count <= noOfPersons) {
            addContact();
            count++;
        }
    }

    //Called method searchByCity for searching contact details by city name
    public void searchByCity() {
        System.out.println("Enter City Name : ");
        String city = sc.next();
        list.stream().filter(n -> n.getCity().equals(city)).forEach(i -> System.out.println("Result: "+i.getFirstName()));
    }

    //calling method to view contact details by using city name
    public void viewByCity() {
        System.out.println("Enter City Name : ");
        String city = sc.nextLine();
        list.stream().filter(n -> n.getCity().equals(city)).forEach(i -> System.out.println(i));
    }

    /*Count number of contact persons based on city*/
    public void countBasedOnCity()
    {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter city name : ");
        String city = sc.nextLine();
        count = (int) list.stream().filter(n -> n.getCity().equals(city)).count();
        System.out.println("TotalNo : " + count);
    }

    //Sorted contact by contact names
    public void sortByName() {
        list = list.stream().sorted(Comparator.comparing(Contact :: getCity)).collect(Collectors.toList());
        list.forEach(i -> System.out.println(i));
    }

    //Sorted all entries in alphabetically by contact city names
    public void sortByCity() {
        list = list.stream().sorted(Comparator.comparing(Contact :: getCity)).collect(Collectors.toList());
        list.forEach(i -> System.out.println(i));
    }
    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();
        //Displaying the welcome message
        System.out.println("WELCOME TO ADDRESS BOOK PROBLEM");
        addressBook.addPersons();
        System.out.println(list);

    }
}
