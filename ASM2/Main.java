import java.util.*;

// Class representing a student
class Student {
    private int id;
    private String name;
    private String contactNumber;
    private int marks;

    // Constructor
    public Student(int id, String name, String contactNumber, int marks) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.marks = marks;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public int getMarks() {
        return marks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // To String method for displaying student details
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', contactNumber='" + contactNumber + "', marks=" + marks + "}";
    }
}

// Class representing a stack for storing students
class StudentStack {
    private Node top;

    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    // Push a student onto the stack
    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = top;
        top = newNode;
    }

    // Pop a student from the stack
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        Student poppedStudent = top.student;
        top = top.next;
        return poppedStudent;
    }

    // Peek at the top student without removing it
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return top.student;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the size of the stack
    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

// Class for managing the student data
class StudentManagement {
    private StudentStack students;

    public StudentManagement() {
        this.students = new StudentStack();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.push(student);
    }

    // Update an existing student's details
    public void updateStudent(int id, String newName, String newContactNumber) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() == id) {
                student.setName(newName);
                student.setContactNumber(newContactNumber);
                found = true;
            }
            tempStack.push(student);
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() != id) {
                tempStack.push(student);
            } else {
                found = true;
            }
        }

        // Restore the original stack without the deleted student
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Search for a student by ID
    public Student searchStudent(int id) {
        StudentStack tempStack = new StudentStack();
        Student foundStudent = null;

        while (!students.isEmpty()) {
            Student student = students.pop();
            if (student.getId() == id) {
                foundStudent = student;
            }
            tempStack.push(student);
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        return foundStudent; // Returns null if not found
    }

    // Display all students
    public void displayStudents() {
        StudentStack tempStack = new StudentStack();

        while (!students.isEmpty()) {
            Student student = students.pop();
            System.out.println(student);
            tempStack.push(student);
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }
    }

    // Sort students by marks using a temporary list
    public void sortStudentsByMarks() {
        List<Student> studentList = new ArrayList<>();

        // Pop all students into the list
        while (!students.isEmpty()) {
            studentList.add(students.pop());
        }

        // Sort the list by marks in descending order
        Collections.sort(studentList, (s1, s2) -> Integer.compare(s2.getMarks(), s1.getMarks()));

        // Push sorted students back into the stack
        for (Student student : studentList) {
            students.push(student);
        }
    }
}

// Main class to test the program
public class Main {
    public static void main(String[] args) {
        // Create a StudentManagement instance
        StudentManagement management = new StudentManagement();

        // Add some students
        management.addStudent(new Student(1, "Alice", "1234567890", 85));
        management.addStudent(new Student(2, "Bob", "0987654321", 92));
        management.addStudent(new Student(3, "Charlie", "1122334455", 78));

        // Display students before sorting
        System.out.println("Students before sorting by marks:");
        management.displayStudents();

        // Sort students by marks
        management.sortStudentsByMarks();

        // Display students after sorting
        System.out.println("\nStudents after sorting by marks:");
        management.displayStudents();

        // Update a student's contact information
        management.updateStudent(2, "Bob Updated", "2223334444");

        // Display students after update
        System.out.println("\nStudents after update:");
        management.displayStudents();

        // Delete a student
        management.deleteStudent(1);

        // Display students after deletion
        System.out.println("\nStudents after deletion:");
        management.displayStudents();

        // Search for a student by ID
        Student searchedStudent = management.searchStudent(3);
        System.out.println("\nSearch result for student with ID 3: " + searchedStudent);
    }
}
