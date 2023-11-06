package LE_4_1;

public class Grades {
    public static void main(String[] args) {
        GradeDistribution gradeDistribution = new GradeDistribution();
        gradeDistribution.setGrades(4, 11, 3, 7, 5);

        gradeDistribution.displayGraph();
//        System.out.println(gradeDistribution.getTotalGrades());
    }
}

class GradeDistribution {
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

    public double getPercentage(char grade) {
        switch (grade) {
            case 'A':
                return ((double) A / getTotalGrades() * 100);
            case 'B':
                return ((double) B / getTotalGrades() * 100);
            case 'C':
                return ((double) C / getTotalGrades() * 100);
            case 'D':
                return ((double) D / getTotalGrades() * 100);
            case 'F':
                return ((double) F / getTotalGrades() * 100);
            default:
                return 0;
        }
    } 

    public void displayGraph() {
        int barWidth = 50;
        
        System.out.println("0   10   20   30    40   50   60   70   80   90  100%");
        System.out.println("|    |	  |    |     |    |    |    |    |    |    |");
        System.out.println("****************************************************");
        for (char grade = 'A'; grade <= 'F'; grade++) {
            double percentage = getPercentage(grade);
            int numAsterisks = Math.round((float) percentage / 2);

            if (grade == 'E') {
            	continue;
            }
            
            for (int i = 0; i < barWidth; i++) {
            	
                if (i < numAsterisks) {
                    System.out.print("*");
                }
            }
            System.out.print(" " + grade + " - " + percentage);
            System.out.println();
        }
    }
}
