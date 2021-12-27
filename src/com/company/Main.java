package com.company;

import java.util.ArrayList;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main implements MethodsMain, Cloneable {
    static Scanner input = new Scanner(System.in);

    static ArrayList<Person> allData = new ArrayList<>();


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int numChoice = 0;
        DoctorClass.DoctorDataRead();
        Patient.PatientDataRead();
        do {

            System.out.println(" ══════════════════════════════════════════════════════");
            System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t  |");
            System.out.println("|\t Welcome to Hospital Management System \t\t\t  |");
            System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t  |");
            System.out.println(" ══════════════════════════════════════════════════════");
            System.out.println();
            System.out.println("\tEnter the number you want to enter");
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+");
            System.out.println("0 Doctor");
            System.out.println("1 Patient");
            System.out.println("2 View All Data Stored (Doctors & Patients)");
            System.out.println("3 Quit");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
            numChoice = input.nextInt();

            switch (numChoice) {
                ////////////////////// Case for entering the doctors Screen ////////////////////////////
                case 0:
                    DoctorClass.DoctorMethod();
                    break;
                ////////////////////// Case for entering the Patients Screen ////////////////////////////
                case 1:
                    Patient.PatientMethod();
                    break;

                case 2:
                    MethodsMain.viewAllData();
                    break;

                case 3:
                    DoctorClass.WriteandsortDoctor();
                    Patient.WriteandsortPatient();
                    System.out.println(" ══════════════════════════════════════════════════════");
                    System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t  |");
                    System.out.println("|\t\t\t\t\t\tGood Bye \t\t\t\t\t  |");
                    System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t  |");
                    System.out.println(" ══════════════════════════════════════════════════════");
            }
        } while (numChoice != 3);
    }












}
