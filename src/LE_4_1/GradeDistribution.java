package LE_4_1;

public class GradeDistribution {
    private int A;
    private int B;
    private int C;
    private int D;
    private int F;

    public void setGrades(int gradeA, int gradeB, int gradeC, int gradeD, int gradeF) {
        A = gradeA;
        B = gradeB;
        C = gradeC;
        D = gradeD;
        F = gradeF;
    }

    public int[] getGrades() {
        return new int[]{A, B, C, D, F};
    }

    public int getTotalGrades() {
        return A + B + C + D + F;
    }

    public int getPercentage(char grade) {
        switch (grade) {
            case 'A':
                return (int) Math.round((double) A / getTotalGrades() * 100);
            case 'B':
                return (int) Math.round((double) B / getTotalGrades() * 100);
            case 'C':
                return (int) Math.round((double) C / getTotalGrades() * 100);
            case 'D':
                return (int) Math.round((double) D / getTotalGrades() * 100);
            case 'F':
                return (int) Math.round((double) F / getTotalGrades() * 100);
            default:
                return 0;
        }
    }

    public void displayGraph() {
        int totalGrades = getTotalGrades();
        int barWidth = 50;

        System.out.println("\nGrade Distribution Graph:");
        for (char grade = 'A'; grade <= 'F'; grade++) {
            int percentage = getPercentage(grade);
            int numAsterisks = Math.round((float) percentage / 2);

            System.out.printf("%c: %d%% |", grade, percentage);
            for (int i = 0; i < barWidth; i++) {
                if (i < numAsterisks) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("   0%   10%   20%   30%   40%   50%   60%   70%   80%   90%   100%");
    }

    public static void main(String[] args) {
        GradeDistribution gradeDistribution = new GradeDistribution();
        gradeDistribution.setGrades(1, 4, 6, 2, 1);

        int[] grades = gradeDistribution.getGrades();
        System.out.println("Total Grades: " + gradeDistribution.getTotalGrades());
        for (char grade = 'A'; grade <= 'F'; grade++) {
            System.out.printf("Percentage of %c: %d%%\n", grade, gradeDistribution.getPercentage(grade));
        }

        gradeDistribution.displayGraph();
    }
}
