package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DoctorClass extends Person implements Options, Cloneable {
    static ArrayList<DoctorClass> doctorArray = new ArrayList<DoctorClass>();
    private String salary;
    private ArrayList<String> patientsarray;


    public DoctorClass(String id, String name, String departement, String address, String phone, String age,
                       String gender, String salary) {
        super(id, name, departement, address, phone, age, gender);
        this.salary = salary;
        doctorArray.add(this);

    }

    public String getSalary() {
        return this.salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public ArrayList<String> getPatientsarray() {
        return this.patientsarray;
    }

    public void setPatientsarray(ArrayList<String> patientsarray) {
        this.patientsarray = patientsarray;
    }

    @Override
    public HashMap view_Details() {
        HashMap info = new HashMap<>();
        info.put("Doctor Id", super.getId());
        info.put("Doctor Name", super.getName());
        info.put("Departement", super.getDepartement());
        info.put("Address", super.getAddress());
        info.put("Phone", super.getPhone());
        info.put("Age", super.getAge());
        info.put("Gender", super.getGender());
        info.put("Salary", this.salary);


        return info;
    }
//////////////////////////////////// Doctor Data Read Method ////////////////////////////

    public static void DoctorDataRead() {
        File docData = new File("src/com/company/Doctor Data.txt");
        try (Scanner dataread = new Scanner(docData)) {
            String id, name, departement, address, phone, age, gender, salary;
            while (dataread.hasNext()) {
                id = dataread.nextLine();
                name = dataread.nextLine();
                departement = dataread.nextLine();
                address = dataread.nextLine();
                phone = dataread.nextLine();
                age = dataread.nextLine();
                gender = dataread.nextLine();
                salary = dataread.nextLine();
                DoctorClass doctor = new DoctorClass(id, name, departement, address, phone, age,
                        gender, salary);
                Main.allData.add(doctor);
            }
        } catch (Exception err) {
            System.out.println(" error in data read");
        }

    }
    /////////////////////////// write the data to a file & sort the array list //////////////////
    public static void WriteandsortDoctor(){
        File docData = new File("src/com/company/Doctor Data.txt");

        try(PrintWriter writer = new PrintWriter(new FileOutputStream(docData,false));
            ){
        Collections.sort(doctorArray);

       for(DoctorClass i:doctorArray){
           writer.println(i.getId());
           writer.println(i.getName());
           writer.println(i.getDepartement());
           writer.println(i.getAddress());
           writer.println(i.getPhone());
           writer.println(i.getAge());
           writer.println(i.getGender());
           writer.println(i.getSalary());
       }


    }catch (Exception e) {
            System.out.println("Errroooooorrrrrrr ");
        }}

    ////////////////////////////////// Doctor Method /////////////////////////

    public static void DoctorMethod() {
Scanner input = new Scanner(System.in);

        int numChoice = 0;

        do {
            System.out.println("\t\t\t\t\tEnter ");
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+");
            System.out.println("0 Add Doctor");
            System.out.println("1 View Doctors");
            System.out.println("2 Update Doctor");
            System.out.println("3 Delete Doctor");
            System.out.println("4 Go Back");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");

            numChoice = input.nextInt();

            switch (numChoice) {
                //////// Case for add Doctor //////////////

                case 0:

                    String id, name, departement, address, phone, age, gender, salary;


                    System.out.print("Enter the Doctor Id: ");
                    id = input.next();

                    while (!Options.isIdInt(id)) {
                        id = input.next();
                    }

                    System.out.print("Enter the Doctor Name: ");
                    name = input.nextLine();

                    name = input.nextLine();

                    System.out.print("Enter the Doctor Departement: ");
                    departement = input.nextLine();



                    System.out.print("Enter the Doctor address: ");
                    address = input.nextLine();


                    System.out.print("Enter the Doctor phone: ");
                    phone = input.next();

                    while (!Options.isPhone(phone)) {
                        phone = input.next();
                    }

                    System.out.print("Enter the Doctor age: ");
                    age = input.next();

                    while (!Options.isage(age)) {
                        age = input.next();
                    }

                    System.out.print("Enter the Doctor gender: ");
                    gender = input.next();

                    while (!Options.isGender(gender)) {
                        System.out.println("Please Enter a Valid Gender Male or Female");
                        gender = input.next();
                    }

                    System.out.print("Enter the Doctor Salary: ");
                    salary = input.next();


                    DoctorClass doctor = new DoctorClass(id, name, departement, address, phone, age,
                            gender, salary);


                    Main.allData.add(doctor);


                    break;
                //////////////////////////////// Case for view Doctors ////////////////////////////////////////////////
                case 1:
                    if (DoctorClass.doctorArray.isEmpty()) {
                        System.out.println("------------------------------------------------");
                        System.out.println("||\t\tThere is no Doctors were Added\t\t\t||");
                        System.out.println("------------------------------------------------");
                    } else {
                        for (int i = 0; i < DoctorClass.doctorArray.size(); i++) {
                            System.out.println("══════════════════════════════════════════════════════");
                            DoctorClass singleDoctor = DoctorClass.doctorArray.get(i);
                            for (Object j : singleDoctor.view_Details().keySet()) {
                                System.out.println(j + "\t\t||\t\t" + singleDoctor.view_Details().get(j));
                                System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                            }
                            System.out.println("══════════════════════════════════════════════════════");
                        }

                    }
                    break;
                //////////////////////////// Case for Update Doctor ////////////////////////////////////////////////////
                case 2:
                    DoctorClass singleDoctor;
                    if (DoctorClass.doctorArray.isEmpty()) {
                        System.out.println("------------------------------------------------");
                        System.out.println("||\t\tThere is no Doctors were Added\t\t\t||");
                        System.out.println("------------------------------------------------");
                    } else {
                        DoctorClass tempDoctor = new DoctorClass("", "", "", "", "", "", "", "");
                        System.out.print("What is the Doctor id that you want to update? ");
                        String takenId = input.next();
                        System.out.println("What is the information that you want to update? ");
                        int numUpdate = 0;
                        do {
                            System.out.println(" 0 Doctor Name \n 1 Departement Name \n 2 Address \n 3 Phone \n 4 Age \n 5 Gender \n 6 Salary \n 7 Go Back");
                            numUpdate = input.nextInt();
                            switch (numUpdate) {
                                case 0:
                                    System.out.println("Enter the Patient Name");
                                    String DoctorName = input.next();
                                    tempDoctor.setName(DoctorName);
                                    break;
                                case 1:
                                    System.out.println("Enter the Departement Name");
                                    String DepartementName = input.next();
                                    tempDoctor.setDepartement(DepartementName);
                                    break;
                                case 2:
                                    System.out.println("Enter the Address");
                                    String Address = input.next();
                                    tempDoctor.setAddress(Address);
                                    break;
                                case 3:
                                    System.out.println("Enter the  Phone");
                                    String Phone = input.next();
                                    tempDoctor.setPhone(Phone);
                                    break;
                                case 4:
                                    System.out.println("Enter the Patient Age");
                                    String Age = input.next();
                                    tempDoctor.setAge(Age);
                                    break;
                                case 5:
                                    System.out.println("Enter the Doctor Gender");
                                    String Gender = input.next();
                                    tempDoctor.setGender(Gender);
                                    break;
                                case 6:
                                    System.out.println("Enter the Doctor Salary");
                                    String salaryy = input.next();
                                    tempDoctor.setSalary(salaryy);
                                    break;
                            }
                        } while (numUpdate != 7);
                        for (int i = 0; i < DoctorClass.doctorArray.size(); i++) {
                            singleDoctor = DoctorClass.doctorArray.get(i);
                            if (singleDoctor.getId().equals(takenId)) {
                                DoctorClass.doctorArray.remove(singleDoctor);
                                if (tempDoctor.getName() != "") {
                                    singleDoctor.setName(tempDoctor.getName());
                                }
                                if (tempDoctor.getDepartement() != "") {
                                    singleDoctor.setDepartement(tempDoctor.getDepartement());
                                }
                                if (tempDoctor.getAddress() != "") {
                                    singleDoctor.setAddress(tempDoctor.getAddress());
                                }
                                if (tempDoctor.getPhone() != "") {
                                    singleDoctor.setPhone(tempDoctor.getPhone());
                                }
                                if (tempDoctor.getAge() != "") {
                                    singleDoctor.setAge(tempDoctor.getAge());
                                }
                                if (tempDoctor.getGender() != "") {
                                    singleDoctor.setGender(tempDoctor.getGender());
                                }
                                if (tempDoctor.getSalary() != "") {
                                    singleDoctor.setSalary(tempDoctor.getSalary());
                                }
                                DoctorClass.doctorArray.add(singleDoctor);
                                DoctorClass.doctorArray.remove(tempDoctor);
                            }


                        }
                    }
                    break;
                //////////////////////// case for Delete Doctor ///////////////////////
                case 3:
                    if (DoctorClass.doctorArray.isEmpty()) {
                        System.out.println("------------------------------------------------");
                        System.out.println("||\t\tThere is no Doctors to Delete\t\t\t||");
                        System.out.println("------------------------------------------------");
                    } else {
                        System.out.print("What is the patient id that you want to Delete? ");
                        String takenIdd = input.next();
                        for (int i = 0; i < DoctorClass.doctorArray.size(); i++) {
                            singleDoctor = DoctorClass.doctorArray.get(i);
                            if (singleDoctor.getId().equals(takenIdd)) {
                                DoctorClass.doctorArray.remove(i);
                            }
                        }
                    }

                    break;

            }


        } while (numChoice != 4);

    }
}