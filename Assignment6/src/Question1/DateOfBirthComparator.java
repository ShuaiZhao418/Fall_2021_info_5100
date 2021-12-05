package Question1;

import java.util.Comparator;

public class DateOfBirthComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getDateOfBirth().getTime() == o2.getDateOfBirth().getTime()) {
            return 0;
        }
        return o1.getDateOfBirth().getTime() - o2.getDateOfBirth().getTime() < 0 ? 1 : -1;
    }
}
