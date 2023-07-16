package ru.job4j.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class College {
    public static void main(String[] args) throws ParseException {
        Student student = new Student();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        student.setFullName("Robert John Downey");
        student.setGroup(111);
        student.setDateOfAdmission(format.parse("09/01/2022"));
        System.out.println(student.getFullName()
                + ", учится в группе № " + student.getGroup()
                + ", поступил в институт " + format.format(student.getDateOfAdmission()));
    }
}
