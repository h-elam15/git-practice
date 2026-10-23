//A BMI Caculator 
//Program takes 2 user inputs: Height and weight
//Caculates BMI based on input
//Outputs the corresponding weight category
package com.bmiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BMIApplication {

    public static void main(String[] args) {
        // This boots up the embedded cloud server
        SpringApplication.run(BMIApplication.class, args);
    }

    // This exposes the calculator to the web browser
    @GetMapping("/calculate-bmi")
    public String calculateBmi(
            @RequestParam float feet, 
            @RequestParam(defaultValue = "0") float inches, 
            @RequestParam float weight) {
        
        float totalInches = (feet * 12) + inches;
        float userBMI = 703 * weight / (totalInches * totalInches);
        
        String resultMessage = String.format("Your BMI is: %.1f. ", userBMI);

        // Return text to the browser instead of the console
        if (userBMI < 18.5) {
            resultMessage += "You are underweight.";
        } else if (userBMI < 25.0) { 
            resultMessage += "Your BMI is in normal range.";
        } else if (userBMI < 30.0) { 
            resultMessage += "You are overweight.";
        } else { 
            resultMessage += "Your BMI is in the obese range.";
        }

        return resultMessage; // Sends the final text directly to the web browser
    }
}