import java.util.Scanner;
class student{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Kindly enter the number of subjects you have:");
        int n=sc.nextInt();
        System.out.println("Kindly enter the number of marks in the respective subject:");
        int sum=0;
        for(int i=1;i<=n;i++){
            System.out.println("Enter subject "+i+" marks:");
            sum+=sc.nextInt();
        }
        double avg=(float)sum/3.0;
        String grade="";
        System.out.println("Let's find the grade that you've achieved:");
        if(avg<=100 && avg>=90){
            grade="A";
            System.out.println("Grade A!");
        }
        else if(avg<90 && avg>=80){
            grade="B";
            System.out.println("Grade B!");
        }
        else if(avg<80 && avg>=70){
            grade="C";
            System.out.println("Grade C!");
        }
        else if(avg<70 && avg>=60){
            grade="D";
            System.out.println("Grade D!");
        }
        else if(avg<60){
            grade="F";
            System.out.println("Grade F!");
        }
        System.out.println("This is your report card:");
        System.out.println("Total marks obtained: "+sum);
        System.out.println("Average obtained: "+avg);
        System.out.println("Grade obtained: "+grade);
        sc.close();
    }
}
