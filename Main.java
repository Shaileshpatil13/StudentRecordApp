import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    double marks;

    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        
    System.out.printf("%-10d %-20s %-10.2f\n", rollNo, name, marks);


    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
    System.out.println("\n--- Student Record Menu ---");
    System.out.println("1. Add Student");
    System.out.println("2. Display All Students");
    System.out.println("3. Search Student by Roll No");
    System.out.println("4. Delete Student by Roll No");
    System.out.println("5. Exit");
    System.out.print("Enter your choice: ");
    choice = sc.nextInt();

    switch (choice) {
        case 1:
            addStudent(students, sc);
            break;
        case 2:
            displayStudents(students);
            break;
        case 3:
            searchStudent(students, sc);
            break;
        case 4:
            deleteStudent(students, sc);
            break;
        case 5:
            System.out.println("Exiting...");
            break;
        default:
            System.out.println("Invalid choice. Try again.");
    }
} while (choice != 5);

        sc.close();
    }
    static void addStudent(ArrayList<Student> students, Scanner sc) {
    System.out.print("Enter Roll No: ");
    int roll = sc.nextInt();
    sc.nextLine(); // consume newline

    boolean exists = false;
    for (Student st : students) {
        if (st.rollNo == roll) {
            exists = true;
            break;
        }
    }

    if (exists) {
        System.out.println("A student with this roll number already exists!");
    } else {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(roll, name, marks);
        students.add(s);
        System.out.println("Student Added!");
    }
}

static void displayStudents(ArrayList<Student> students) {
    if (students.isEmpty()) {
        System.out.println("No students to display.");
        return;
    }

    System.out.printf("\n%-10s %-20s %-10s\n", "Roll No", "Name", "Marks");
    System.out.println("--------------------------------------------------");

    for (Student st : students) {
        st.display();
    }
}

static void searchStudent(ArrayList<Student> students, Scanner sc) {
    System.out.print("Enter Roll No to search: ");
    int searchRoll = sc.nextInt();
    boolean found = false;

    for (Student st : students) {
        if (st.rollNo == searchRoll) {
            System.out.println("Student Found:");
            System.out.printf("\n%-10s %-20s %-10s\n", "Roll No", "Name", "Marks");
            System.out.println("--------------------------------------------------");
            st.display();
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Student not found!");
    }
}

static void deleteStudent(ArrayList<Student> students, Scanner sc) {
    System.out.print("Enter Roll No to delete: ");
    int deleteRoll = sc.nextInt();
    boolean found = false;

    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).rollNo == deleteRoll) {
            students.remove(i);
            System.out.println("Student deleted successfully!");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Student not found!");
    }
}

}