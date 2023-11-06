//Engineering Mathematics IV PBL
// Roll no. 2200430130021-2200430130030

import java.text.DecimalFormat;
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;



public class maths_pbl {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


//   Taking entries of two populations

//        FIRST POPULATION
        System.out.println("Enter the number of entries in first population");
        int n1 = sc.nextInt();
        System.out.println("Enter the "+ n1 +" entries of first population");
        int [] first_population = entries(n1);

//      SECOND POPULATION
        System.out.println("Enter the number of entries in second population");
        int n2 = sc.nextInt();
        System.out.println("Enter the "+ n2 +" entries of second population ");
        int [] second_population = entries(n2);


//        Taking the size of sample and calculating their mean

//        FIRST POPULATION MEAN
        System.out.println("Enter the size of Sample of first population(<16)");
        int N1 = sc.nextInt();
        double X_Bar = mean(first_population, N1);

//        SECOND POPULATION MEAN
        System.out.println("Enter the size of Sample of second population (<16)");
        int N2 = sc.nextInt();
        double Y_Bar = mean(second_population, N2);

//        printing the mean values
        System.out.println("Sample mean of first Population = "+ X_Bar);
        System.out.println("Sample mean of second Population = " + Y_Bar);

        System.out.println("Null Hypothesis  H: X_Bar =  Y_Bar");   // printing null hypothesis


        int dof = (N1+N2-2); // Calculating degree of freedom

        // Calculation of Sigma Square
        double sigma_square = (summation(first_population, X_Bar)+ summation(second_population, Y_Bar))/(dof);
        System.out.println("sigma_square=" + sigma_square);
        // Calculating Standard Deviation
       double Standard_Deviation =  Math.sqrt(sigma_square);
        System.out.println("Standard Deviation= "+ Standard_Deviation);

       // Calculating the value of t
        double j =  ((1.0/N1) + (1.0/N2));
       double z =  Math.sqrt(j);

       double t = (X_Bar - Y_Bar)/(Standard_Deviation*z);
       double t_cal = Math.abs(t);

       DecimalFormat decimalFormat = new DecimalFormat("#.##");

        System.out.println("Degree of freedom = " +dof);
       System.out.println("t calculated = "+decimalFormat.format(t_cal));
        System.out.println("t tabulated = " +t_dist(dof));


        // Comparing the value of t calculated and t tabulated and printing the statement
       if(t_cal>t_dist(dof)){
           System.out.println("Since calculated value of t_cal is greater than the tabulated value "+ t_dist(dof)+ "\n Hence Hypothesis REJECTED!!!");
       }else
       {
           System.out.println("Since calculated value of t_cal is less than the tabulated value "+ t_dist(dof)+ "\n Hence Hypothesis Accepted!!!");
       }


    }


//    Method for taking population entries
    static int[] entries(int n) {
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) {
            System.out.print("Enter value " + (j + 1) + ": ");
            arr[j] = sc.nextInt();
        }
        return arr;
    }


//    Method for calculating mean Value
    static double mean(int []array, int n){
        Random random = new Random();

        int data = 0;
        for (int i = 0; i <n ; i++) {
            int randomIndex = random.nextInt(array.length);
            data += array[randomIndex];
        }
        double meanValue = data/n;
        return meanValue;
    }

//    Method for calculating the sum of difference of mean and elements

    static double summation(int []array , double meanValue){
        double totalSummation = 0;
        for(int i = 0; i < array.length ; i++) {
            totalSummation += (array[i]-meanValue);
        }
        double finalValue = totalSummation;
        return finalValue;
    }


    static double t_dist(int d){
        Map<Integer, Double> integerDoubleMap = new HashMap<>();

        integerDoubleMap.put(1,12.71);
        integerDoubleMap.put(2,4.3);
        integerDoubleMap.put(3,3.18);
        integerDoubleMap.put(4,2.78);
        integerDoubleMap.put(5,2.57);
        integerDoubleMap.put(6,2.45);
        integerDoubleMap.put(7,2.37);
        integerDoubleMap.put(8,2.31);
        integerDoubleMap.put(9,2.26);
        integerDoubleMap.put(10,2.23);
        integerDoubleMap.put(11,2.2);
        integerDoubleMap.put(12,2.18);
        integerDoubleMap.put(13,2.16);
        integerDoubleMap.put(14,2.15);
        integerDoubleMap.put(15,2.13);
        integerDoubleMap.put(16,2.12);
        integerDoubleMap.put(17,2.11);
        integerDoubleMap.put(18,2.1);
        integerDoubleMap.put(19,2.09);
        integerDoubleMap.put(20,2.09);
        integerDoubleMap.put(21,2.05);
        integerDoubleMap.put(22,2.07);
        integerDoubleMap.put(23,2.07);
        integerDoubleMap.put(24,2.06);
        integerDoubleMap.put(25,2.06);
        integerDoubleMap.put(26,2.06);
        integerDoubleMap.put(27,2.05);
        integerDoubleMap.put(28,2.05);
        integerDoubleMap.put(29,2.05);
        integerDoubleMap.put(30,2.04);

        return (double) integerDoubleMap.get(d);
    }


}
