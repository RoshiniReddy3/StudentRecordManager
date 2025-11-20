import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        int choice;
        do {
            System.out.println("==== Student Record Manager ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter Grade (e.g. 8.5): ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine();

                    Student student = new Student(id, name, course, grade);
                    service.addStudent(student);
                    break;

                case 2:
                    List<Student> allStudents = service.getAllStudents();
                    if (allStudents.isEmpty()) {
                        System.out.println("No students found.\n");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (Student s : allStudents) {
                            System.out.println(s);
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    Student found = service.findStudentById(searchId);
                    if (found != null) {
                        System.out.println("Student found: " + found + "\n");
                    } else {
                        System.out.println("Student not found.\n");
                    }
                    break;

                case 4:
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }

        } while (choice != 4);

        scanner.close();
    }
}
