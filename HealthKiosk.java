import java.util.Scanner;
import java.util.Random;
public class HealthKiosk {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Kindly select a service: \nP: Pharmacy \nL: Lab\nT: Triage \nC: Counseling\n");
        char service = scan.next().charAt(0);
        double bmi = 00; //For if BMI is not accessed
        switch (service){
            case 'P':
            case 'p':
                System.out.println("Welcome to the Pharmacy Desk");
                break;
            case 'L':
            case 'l':
                System.out.println("Welcome to the Lab Desk");
                break;
            case 'T':
            case 't':
                System.out.println("Welcome to Triage Desk");
                System.out.print("Enter health metric: \n1. BMI \n2. Dosage round-up \n3. Simple trig helper\n");
                int metric = scan.nextInt();
            
                switch (metric){
                    case 1:
                        System.out.print("Enter weight (kg): ");
                        double weight = scan.nextDouble();
                        System.out.print("Enter height (m): ");
                        double height = scan.nextDouble();
                        bmi = weight / (height * height);
                        bmi = Math.round(bmi * 10) / 10.0;
                        if (bmi <18.5){
                            System.out.println("BMI: " + bmi + " - Underweight");
                        }
                        else if (bmi >=18.5 && bmi <24.9){
                            System.out.println("BMI: " + bmi + " - Normal");
                        }
                        else if (bmi >=25 && bmi <29.9){
                            System.out.println("BMI: " + bmi + " - Overweight");
                        }
                        else if (bmi >=30){
                            System.out.println("BMI: " + bmi + " - Obese");
                        }
                        break;

                    case 2:
                        System.out.print("Enter dosage (mg): ");
                        double dosage = scan.nextDouble();
                        int tabletCount = (int) Math.ceil(dosage/250.0);
                        System.out.println("Collect " + tabletCount + " tablets of 250mg ONLY");
                        break;

                    case 3:
                        System.out.print("Enter angle (degrees): ");
                        double angle = scan.nextDouble();
                        angle = Math.toRadians(angle);
                        angle = Math.round(angle * 1000.0) / 1000.0;
                        double sin = Math.sin(angle);
                        double cos = Math.cos(angle);
                        System.out.println("Sine: " + sin + ", Cosine: " + cos);
                        break;
                    default:
                        System.out.println("Invalid input");
                }
                        
                break;
                //Placeholder: This break is actually important. Dont del
            case 'C':
            case 'c':
                System.out.println("Welcome to Counseling Desk");
                break;
            default:
                System.out.println("Invalid service code");
            
        }
        Random random = new Random();
        char randychar = (char) (random.nextInt(26) + 'A');
        // Random number syntax: nextInt((max - min) + 1) + min
        int num1 = random.nextInt((9-3)+1) + 3;
        int num2 = random.nextInt((9-3)+1) + 3;
        int num3 = random.nextInt((9-3)+1) + 3;
        int num4 = random.nextInt((9-3)+1) + 3;
        // You cant convert to string by the same method as int. Use String.valueOf()
        String IDcode = randychar + String.valueOf(num1) + String.valueOf(num2) + String.valueOf(num3) + String.valueOf(num4);

        if (IDcode.length() != 5){
            System.out.println("!!Error: Invalid ID length!!");
        }
        else if(!Character.isLetter(IDcode.charAt(0))){
            System.out.println("!!Error: First character must be a letter!!");
        }
        else if(!(Character.isDigit(IDcode.charAt(1)))){
            System.out.println("!!Error: Second character must be a digit!!");
        }
        else if(!(Character.isDigit(IDcode.charAt(2)))){
            System.out.println("!!Error: Third character must be a digit!!");
        }
        else if(!(Character.isDigit(IDcode.charAt(3)))){
            System.out.println("!!Error: Fourth character must be a digit!!");
        }
        else if(!(Character.isDigit(IDcode.charAt(4)))){
            System.out.println("!!Error: Fifth character must be a digit!!");
        }
        else{
            System.out.println("Your ID: " + IDcode + " is valid");
        }
        System.out.print("Enter your first name: ");
        scan.nextLine(); //Consume newline.IDk why this is needed. but it is
        String first_name = scan.nextLine();
        first_name = first_name.toUpperCase();
        char first_initial = first_name.charAt(0);
        char shift_char = (char)('A' + (first_initial - 'A' +2) % 26);
        String disp_code = String.valueOf(shift_char) + String.valueOf(IDcode.charAt(3)) + String.valueOf(IDcode.charAt(4)) + "-" + String.valueOf(Math.round(bmi*10)/10);
        System.out.println("Your display code is: " + disp_code);
        System.out.println("PHARMACY | ID = " + IDcode + " | Code = " + disp_code);
        System.out.println("LAB | ID = " + IDcode + " | Code = " + disp_code);
        System.out.println("COUNSELLING | ID = " + IDcode + " | Code = " + disp_code);
        System.out.println("TRIAGE | ID = " + IDcode + "|BMI = "+ bmi +" | Code = " + disp_code);
        scan.close();
    }
    
}