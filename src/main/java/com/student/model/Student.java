package com.student.model;

public class Student {

    private String rollNo;
    private String name;
    private String password;

    private int physics;
    private int chemistry;
    private int maths;
    private int total;

    // ===== ANALYTICS FIELDS =====
    private double average;
    private String grade;
    private String result;
    private String bestSubject;
    private String weakSubject;

    // ===== CONSTRUCTOR =====
    public Student(String rollNo, String name, int physics, int chemistry, int maths, int total) {
        this.rollNo = rollNo;
        this.name = name;
        this.physics = physics;
        this.chemistry = chemistry;
        this.maths = maths;
        this.total = total;

        calculateAnalytics(); // IMPORTANT
    }
    public Student(String rollNo, String name, String password,
            int physics, int chemistry, int maths, int total) {

 this.rollNo = rollNo;
 this.name = name;
 this.password = password;   // 🔥 IMPORTANT
 this.physics = physics;
 this.chemistry = chemistry;
 this.maths = maths;
 this.total = total;

 calculateAnalytics();
}

    // ===== ANALYTICS LOGIC =====
    private void calculateAnalytics() {

        this.average = total / 3.0;

        // Pass / Fail logic
        if (physics < 35 || chemistry < 35 || maths < 35) {
            this.result = "Fail";
            this.grade = "F";
        } else {
            this.result = "Pass";

            if (average >= 75)
                grade = "A";
            else if (average >= 60)
                grade = "B";
            else if (average >= 50)
                grade = "C";
            else
                grade = "D";
        }

        // Best & Weak subject
        int max = Math.max(physics, Math.max(chemistry, maths));
        int min = Math.min(physics, Math.min(chemistry, maths));

        if (max == physics)
            bestSubject = "Physics";
        else if (max == chemistry)
            bestSubject = "Chemistry";
        else
            bestSubject = "Maths";

        if (min == physics)
            weakSubject = "Physics";
        else if (min == chemistry)
            weakSubject = "Chemistry";
        else
            weakSubject = "Maths";
    }

    // ===== GETTERS =====
    public String getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getPassword() { return password; }

    public int getPhysics() { return physics; }
    public int getChemistry() { return chemistry; }
    public int getMaths() { return maths; }
    public int getTotal() { return total; }

    public double getAverage() { return average; }
    public String getGrade() { return grade; }
    public String getResult() { return result; }
    public String getBestSubject() { return bestSubject; }
    public String getWeakSubject() { return weakSubject; }
}
