package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Resume resume = new Resume(reader.readLine());


        ResumeStorage resumeStorage = new ResumeStorage();
        Resume resume = new Resume(resumeStorage.toString());
        /*resumeStorage.save(resume);
        resumeStorage.get(resumeStorage.toString());
        resumeStorage.update(resume);
        resumeStorage.delete(resumeStorage.toString());*/

        for (; ; ) {
            System.out.println("ResumeMenu");
            System.out.println("1 - Create");
            System.out.println("2 - Read");
            System.out.println("3 - Update");
            System.out.println("4 - Delete");
            System.out.print("Enter a number: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Integer choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    resumeStorage.save(resume);
                    break;
                case 2:
                    resumeStorage.get(resumeStorage.toString());
                    break;
                case 3:
                    resumeStorage.update(resume);
                    break;
                case 4:
                    resumeStorage.delete(resumeStorage.toString());
                    break;
                case 5:
                    System.out.println("The program is closing");
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            if (choice == 5){
                break;
            }
        }
    }
}
