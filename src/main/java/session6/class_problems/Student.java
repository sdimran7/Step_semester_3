
import java.util.Scanner;

class Student {
    String name;
    double attendance;

    static String collegeName;
    static int studentCount = 0;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter college name: ");
        collegeName = sc.nextLine();

        System.out.print("Enter first student name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter first student attendance: ");
        double attendance1 = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter second student name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter second student attendance: ");
        double attendance2 = sc.nextDouble();

        Student s1 = new Student(name1, attendance1);
        Student s2 = new Student(name2, attendance2);

        Student.printCollegeInfo();

        sc.close();
    }
}
