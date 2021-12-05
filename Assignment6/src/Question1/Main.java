package Question1;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Tom", 3.1, "1999-03-11");
        Student student2 = new Student(2, "Jim", 3.7, "1998-03-12");
        Student student3 = new Student(3, "Danny", 3.4, "1990-05-13");
        Student student4 = new Student(4, "Red", 3.3, "2000-04-11");
        PriorityQueue<Student> nameQueue = new PriorityQueue<>(new NameComparator());
        nameQueue.offer(student1);
        nameQueue.offer(student2);
        nameQueue.offer(student3);
        nameQueue.offer(student4);
        Iterator<Student> iterator = nameQueue.iterator();
        System.out.println("Sort by ascending order of 'name'");
        for (int i = 0; i < 4; i++) {
            Student cur = nameQueue.poll();
            System.out.println(cur.getId() + "    " + cur.getName() + "    " + cur.getGpa() + "    " + cur.getDateOfBirth());
        }


        PriorityQueue<Student> gpaQueue = new PriorityQueue<>(new GpaComparator());
        gpaQueue.offer(student1);
        gpaQueue.offer(student2);
        gpaQueue.offer(student3);
        gpaQueue.offer(student4);
        System.out.println("Sort by descending order of 'gpa'");
        for (int i = 0; i < 4; i++) {
            Student cur = gpaQueue.poll();
            System.out.println(cur.getId() + "    " + cur.getName() + "    " + cur.getGpa() + "    " + cur.getDateOfBirth());
        }

        PriorityQueue<Student> dateQueue = new PriorityQueue<>(new DateOfBirthComparator());
        dateQueue.add(student1);
        dateQueue.add(student2);
        dateQueue.add(student3);
        dateQueue.add(student4);
        System.out.println("Sort by ascending order of 'dateOfBirth'");
        for (int i = 0; i < 4; i++) {
            Student cur = dateQueue.poll();
            System.out.println(cur.getId() + "    " + cur.getName() + "    " + cur.getGpa() + "    " + cur.getDateOfBirth());
        }
    }
}
