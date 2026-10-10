
import java.util.Scanner;

class Employee {
    String empName;
    double salary;

    static String companyName;
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

class CompanyInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter company name: ");
        Employee.companyName = sc.nextLine();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter employee " + i + " details");

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(sc.nextLine());

            new Employee(name, salary);
        }

        Employee.printCompanyInfo();

        sc.close();
    }
}
