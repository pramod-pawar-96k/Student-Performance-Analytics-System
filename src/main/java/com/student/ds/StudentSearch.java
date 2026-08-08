package com.student.ds;

import java.util.List;
import com.student.model.Student;

public class StudentSearch {

    // LINEAR SEARCH (O(n))
    public static Student linearSearch(List<Student> list, String rollNo) {
        for (Student s : list) {
            if (s.getRollNo().equalsIgnoreCase(rollNo)) {
                return s;
            }
        }
        return null;
    }

    // BINARY SEARCH (O(log n)) — list MUST be sorted by rollNo
    public static Student binarySearch(List<Student> list, String rollNo) {

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Student midStudent = list.get(mid);

            int cmp = midStudent.getRollNo().compareToIgnoreCase(rollNo);

            if (cmp == 0)
                return midStudent;
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }
}
