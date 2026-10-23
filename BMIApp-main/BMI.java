//A BMI Caculator 
//Program takes 2 user inputs: Height and weight
//Caculates BMI based on input
//Outputs the corresponding weight category
import java.util.Scanner;

public class BMI {

    //caluclate the users BMI
    private static void calBMI(float h,float w){
     float heightInches = h * 12; //convert height to inches
     float userBMI = 703 * w / (heightInches * heightInches); //703 is the conversion factor for BMI when using pounds and inches

        //if statment to handle the four ranges
        if (userBMI <= 18.5){
            //underweight range
            System.out.println("Your BMI is: " + userBMI + " you are underweight" );
        }else if(userBMI >= 18.5 && userBMI<=24.9 ){ //normal range
             System.out.println("Your BMI is: " + userBMI + " your BMI is in normal range");
        }else if(userBMI >= 25.0 && userBMI <= 29.9){ //overweight range
             System.out.println("Your BMI is: " + userBMI + " you are overweight");
        }else{ //obese range
             System.out.println("Your BMI is: " + userBMI + " your bmi is in the obese range");
        }

    }
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     System.out.println("Enter Height(feet/inches) and Weight (pounds) to calculate BMI");
     System.out.print("Please enter Height (ft,in): ");
    String heightInput = sc.next();
    String[] heightParts = heightInput.replace("\"", "").split("'"); //allows user to input height in feet and inches format (e.g., 5'10")
    float height = Float.parseFloat(heightParts[0]) + Float.parseFloat(heightParts[1]) / 12; //convert height to feet in decimal format
     System.out.println("Please enter Weight in pounds: ");
    float weight = sc.nextFloat();
    calBMI(height, weight);

   }
}