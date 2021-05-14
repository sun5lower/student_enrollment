package studentManagement;

import java.util.Scanner;

public class Student {
    private  String name;
    private  String surname;
    private  int gradeYear;
    private String studentID;
    private  String courses = "";
    //static means value is not specific to object,but to class
    private  int costOfCoursesBalance = 0;
    private static  int  tuitionFees = 400;
    private static int id = 1000;
    /*constructor will ask for name ,year
    generate ID
    enroll in classes
    view balance
    pay for classes
    show status
     */
    public Student(){

        System.out.println("Hello, welcome to new year at school!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        this.name = scanner.nextLine();

        System.out.print("Please enter your surname: ");
        this.surname = scanner.nextLine();

        System.out.println("What year are you at? ");
        System.out.print("1 - 1st year\n2 - 2nd year\n3 - 3rd year\n4 - 4th year ");
        this.gradeYear = scanner.nextInt();

        setStudentID();

        // every next students id will be 1 greater than previous

    }
    //make an id
    private void setStudentID(){
        //grade level + ID
        id++;
        this.studentID = gradeYear + " " + id;

    }
    //join the classes
    public void enroll(){
        //make a loop
        do {
            System.out.print("Enter class you want to join( x to quit): ");
            Scanner scanner = new Scanner(System.in);
            String course = scanner.nextLine();
            if (!course.equals("x")) {
                courses = courses + "\n " +course;
                costOfCoursesBalance = costOfCoursesBalance + tuitionFees;
            }
            else {
                break;
            }
        }while (1 != 0);

    }
    //view balance
    public void viewBalance(){
        System.out.println("Your balance is £" + costOfCoursesBalance);
    }
    //study fees
    public void payForStudies(){
        viewBalance();
        System.out.println("How much would you like to pay? ");
        Scanner scanner = new Scanner(System.in);
        int payment = scanner.nextInt();
        costOfCoursesBalance = costOfCoursesBalance - payment;
        System.out.println("Thank you for your payment of £" + payment);
        viewBalance();
    }
    //view status
    public String toString(){
        return "Name: " + name + " " + surname +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nClasses enrolled: " + courses +
                "\nBalance: £" + costOfCoursesBalance;
    }
}
