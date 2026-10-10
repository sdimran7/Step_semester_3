
import java.util.Scanner;

class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter permanent employee details");
        System.out.print("Enter employee ID: ");
        String id1 = sc.nextLine();

        System.out.print("Enter employee name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        Employee permanent = new Employee(id1, name1, salary);

        System.out.println("Enter intern details");
        System.out.print("Enter employee ID: ");
        String id2 = sc.nextLine();

        System.out.print("Enter employee name: ");
        String name2 = sc.nextLine();

        Employee intern = new Employee(id2, name2);

        permanent.printProfile();
        intern.printProfile();

        sc.close();
    }
}
