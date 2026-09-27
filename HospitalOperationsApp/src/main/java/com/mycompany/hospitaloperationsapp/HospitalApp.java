/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospitaloperationsapp;

/**
 *st10490392
 * @author ripfumelo ngobeni
 */


import java.util.Scanner;

public class HospitalApp {

    public static void main(String[] args) {

        int[][] operationsData = {
                { 120, 150, 160, 140 },
                { 180, 200, 170, 190 }
        };

        Operations op = new Operations();
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            
            do {
                System.out.println("\n========= HOSPITAL OPERATIONS MENU =========");
                System.out.println("1. Total Operations");
                System.out.println("2. Average Operations");
                System.out.println("3. Maximum Operations");
                System.out.println("4. Minimum Operations");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                
                choice = sc.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.println("Total Operations: " + op.getTotal(operationsData));
                        break;
                        
                    case 2:
                        System.out.printf("Average Operations: %.2f\n", op.getAverage(operationsData));
                        break;
                        
                    case 3:
                        System.out.println("Maximum Operations: " + op.getMax(operationsData));
                        break;
                        
                    case 4:
                        System.out.println("Minimum Operations: " + op.getMin(operationsData));
                        break;
                        
                    case 5:
                        System.out.println("Exiting program...");
                        break;
                        
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 5);
        }
    }

}