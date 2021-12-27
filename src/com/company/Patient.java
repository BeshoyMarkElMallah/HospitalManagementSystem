package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;


public class Patient extends Person implements Options, Cloneable {
    static ArrayList<Patient> patientArray = new ArrayList<Patient>();
    Date date = new Date();

    private String blood;
    private String arrivalDate;
    private String room;
    private String cases;
    private String doctor;

    public Patient(String id, String name, String departement, String address, String phone, String age, String gender, String blood, String Room, String Case, String doctor) {
        super(id, name, departement, address, phone, age, gender);
        this.blood = blood;
        this.room = Room;
        this.arrivalDate = date.toString();
        this.cases = Case;
        this.doctor = doctor;
        patientArray.add(this);
    }


    @Override
    public HashMap view_Details() {
        HashMap info = new HashMap<>();
        info.put("Patient Id", super.getId());
        info.put("Patient Name", super.getName());
        info.put("Departement Name", super.getDepartement());
        info.put("Address", super.getAddress());
        info.put("Phone", super.getPhone());
        info.put("Age", super.getAge());
        info.put("Gender", super.getGender());
        info.put("Blood", this.blood);
        info.put("Room", this.room);
        info.put("ArrivalDate", this.arrivalDate);
        info.put("Case", this.cases);
        info.put("Doctor", this.doctor);

        return info;
    }


    public void set_room(String Room) {
        this.room = Room;

    }

    public void set_doctor(String doctorID) {
        this.doctor = doctorID;

    }


    public void set_case(String Case) {
        this.cases = Case;
    }

    public void set_Blood(String blood) {
        this.blood = blood;
    }

    public String get_Blood() {
        return this.blood;
    }

    public String get_Room() {
        return this.room;
    }

    public String get_Case() {
        return this.cases;
    }

    public String get_Doctor() {
        return this.doctor;
    }

    //////////////////////////////////// Patient Data Read Method ////////////////////////////
    public static void PatientDataRead() {
        File patData = new File("src/com/company/Patient Data.txt");
        try (Scanner dataread = new Scanner(patData)) {
            String id, name, departement, address, phone, age, gender, Blood, Room, Case, Doctor;
            while (dataread.hasNext()) {
                id = dataread.nextLine();
                name = dataread.nextLine();
                departement = dataread.nextLine();
                address = dataread.nextLine();
                phone = dataread.nextLine();
                age = dataread.nextLine();
                gender = dataread.nextLine();
                Blood = dataread.nextLine();
                Room = dataread.nextLine();
                Case = dataread.nextLine();
                Doctor = dataread.nextLine();
                Patient patient = new Patient(id, name, departement, address, phone, age, gender, Blood, Room, Case, Doctor);
                Main.allData.add(patient);
            }
        } catch (Exception err) {
            System.out.println(" error in data read");
        }
    }

    /////////////////////////// write the data to a file & sort the array list //////////////////
    public static void WriteandsortPatient() {
        File patData = new File("src/com/company/Patient Data.txt");

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(patData, false));
        ) {
            Collections.sort(patientArray);
            for (Patient i : patientArray) {
                writer.println(i.getId());
                writer.println(i.getName());
                writer.println(i.getDepartement());
                writer.println(i.getAddress());
                writer.println(i.getPhone());
                writer.println(i.getAge());
                writer.println(i.getGender());
                writer.println(i.get_Blood());
                writer.println(i.get_Room());
                writer.println(i.get_Case());
                writer.println(i.get_Doctor());

            }


        } catch (Exception e) {
            System.out.println("Errroooooorrrrrrr ");
        }
    }

    /////////////////////////////////// Patient Method ////////////////////////

    public static void PatientMethod() {
        Scanner input = new Scanner(System.in);
        File patData = new File("src/com/company/Patient Data.txt");
        int numChoice = 0;
        do {
            System.out.println("\t\t\t\t\tEnter ");
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+");
            System.out.println("0 Add Patient");
            System.out.println("1 View Patients");
            System.out.println("2 Update Patient");
            System.out.println("3 Delete Patient");
            System.out.println("4 Go Back");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
            numChoice = input.nextInt();
            switch (numChoice) {
                //////// Case for add Patient //////////////
                case 0:

                        String id, name, departement, address, phone, age, gender, Blood, Room, Case, Doctor;


                        System.out.print("Enter the patient Id: ");
                        id = input.next();
                        while (!Options.isIdInt(id)) {
                            id = input.next();
                        }

                        System.out.print("Enter the patient Name: ");
                        name = input.nextLine();
                        name = input.nextLine();

                        System.out.print("Enter the patient Departement: ");
                        departement = input.nextLine();

                        System.out.print("Enter the patient address: ");
                        address = input.nextLine();

                        System.out.print("Enter the patient phone: ");
                        phone = input.next();
                        while (!Options.isPhone(phone)) {
                            phone = input.next();
                        }

                        System.out.print("Enter the patient age: ");
                        age = input.next();
                        while (!Options.isage(age)) {
                            age = input.next();
                        }

                        System.out.print("Enter the patient gender: ");
                        gender = input.next();
                        while (!Options.isGender(gender)) {
                            System.out.println("Please Enter a Valid Gender Male or Female");
                            gender = input.next();
                        }

                        System.out.print("Enter the patient Blood: ");
                        Blood = input.next();

                        System.out.print("Enter the patient Room: ");
                        Room = input.next();

                        System.out.print("Enter the patient Case: ");
                        Case = input.nextLine();
                        Case = input.nextLine();

                        System.out.print("Enter the patient Doctor: ");
                        Doctor = input.nextLine();

                        Patient patient = new Patient(id, name, departement, address, phone, age, gender, Blood, Room, Case, Doctor);
                        Main.allData.add(patient);

                    break;
                //////////////////////////////// Case for view Patients ////////////////////////////////////////////////
                case 1:
                    if (Patient.patientArray.isEmpty()) {
                        System.out.println("------------------------------------------------");
                        System.out.println("||\t\tThere is no Patients were Added\t\t  ||");
                        System.out.println("------------------------------------------------");

                    } else {
                        System.out.println("══════════════════════════════════════════════════════");
                        for (int i = 0; i < Patient.patientArray.size(); i++) {
                            Patient singlePatient = Patient.patientArray.get(i);
                            for (Object j : singlePatient.view_Details().keySet()) {
                                System.out.println(j + "\t\t||\t\t" + singlePatient.view_Details().get(j));
                                System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                            }
                            System.out.println("══════════════════════════════════════════════════════");
                        }
                    }

                    break;
                //////////////////////////// Case for Update Patients ////////////////////////////////////////////////////
                case 2:
                    Patient singlePatient;
                    if (Patient.patientArray.isEmpty()) {
                        System.out.println("------------------------------------------------");
                        System.out.println("||\t\tThere is no Patients were Added\t\t  ||");
                        System.out.println("------------------------------------------------");
                    } else {
                        Patient tempPatient = new Patient("", "", "", "", "", "", "", "", "", "", "");
                        System.out.print("What is the patient id that you want to update? ");
                        String takenId = input.next();

                        System.out.println("What is the information that you want to update? ");
                        int numUpdate = 0;
                        do {
                            System.out.println(" 0 Patient Name \n 1 Departement Name \n 2 Address \n 3 Phone \n 4 Age \n 5 Gender \n 6 Blood \n 7 Go Back");
                            numUpdate = input.nextInt();
                            switch (numUpdate) {
                                case 0:
                                    System.out.println("Enter the Patient Name");
                                    String PatientName = input.next();
                                    tempPatient.setName(PatientName);
                                    break;
                                case 1:
                                    System.out.println("Enter the Departement Name");
                                    String DepartementName = input.next();
                                    tempPatient.setDepartement(DepartementName);
                                    break;
                                case 2:
                                    System.out.println("Enter the Address");
                                    String Address = input.next();
                                    tempPatient.setAddress(Address);
                                    break;
                                case 3:
                                    System.out.println("Enter the  Phone");
                                    String Phone = input.next();
                                    tempPatient.setPhone(Phone);
                                    break;
                                case 4:
                                    System.out.println("Enter the Patient Age");
                                    String Age = input.next();
                                    tempPatient.setAge(Age);
                                    break;
                                case 5:
                                    System.out.println("Enter the Patient Gender");
                                    String Gender = input.next();
                                    tempPatient.setGender(Gender);
                                    break;
                                case 6:
                                    System.out.println("Enter the Patient Blood");
                                    String blood = input.next();
                                    tempPatient.set_Blood(blood);
                                    break;
                            }
                        } while (numUpdate != 7);
                        for (int i = 0; i < Patient.patientArray.size(); i++) {
                            singlePatient = Patient.patientArray.get(i);
                            if (singlePatient.getId().equals(takenId)) {
                                Patient.patientArray.remove(singlePatient);
                                if (tempPatient.getName() != "") {
                                    singlePatient.setName(tempPatient.getName());
                                }
                                if (tempPatient.getDepartement() != "") {
                                    singlePatient.setDepartement(tempPatient.getDepartement());
                                }
                                if (tempPatient.getAddress() != "") {
                                    singlePatient.setAddress(tempPatient.getAddress());
                                }
                                if (tempPatient.getPhone() != "") {
                                    singlePatient.setPhone(tempPatient.getPhone());
                                }
                                if (tempPatient.getAge() != "") {
                                    singlePatient.setAge(tempPatient.getAge());
                                }
                                if (tempPatient.getGender() != "") {
                                    singlePatient.setGender(tempPatient.getGender());
                                }
                                if (tempPatient.get_Blood() != "") {
                                    singlePatient.set_Blood(tempPatient.get_Blood());
                                }
                                Patient.patientArray.add(singlePatient);
                                Patient.patientArray.remove(tempPatient);
                            }


                        }
                    }
                    break;
                //////////////////////// case for Delete Patients ///////////////////////
                case 3:
                    if (Patient.patientArray.isEmpty()) {
                        System.out.println("------------------------------------------------");
                        System.out.println("||\t\tThere is no Patients to Delete\t\t  ||");
                        System.out.println("------------------------------------------------");
                    } else {
                        System.out.print("What is the patient id that you want to Delete? ");
                        String takenIdd = input.next();
                        for (int i = 0; i < Patient.patientArray.size(); i++) {
                            singlePatient = Patient.patientArray.get(i);
                            if (singlePatient.getId().equals(takenIdd)) {
                                Patient.patientArray.remove(i);
                            }
                        }
                    }

                    break;

            }


        } while (numChoice != 4);
    }
}
