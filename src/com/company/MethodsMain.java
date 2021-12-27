package com.company;


import java.util.HashMap;

public interface MethodsMain extends Cloneable {


    static void PatientMethod() {

    }

    static void DoctorMethod() {
    }







    static void isGender() {
    }

    public static void viewAllData() {
        try {
            if (Main.allData.isEmpty()) {
                System.out.println("------------------------------------------------");
                System.out.println("|| There is no Doctors or Patients were Added ||");
                System.out.println("------------------------------------------------");
                System.out.println("");
            } else {
                for (int i = 0; i < Main.allData.size(); i++) {
                    System.out.println();
                    System.out.println("══════════════════════════════════════════════════════");

                    if (Main.allData.get(i) instanceof DoctorClass) {
                        System.out.println("\t\tDoctor");
                        HashMap doc1 = ((DoctorClass) Main.allData.get(i)).view_Details();
                        for (Object j : doc1.keySet()) {
                            System.out.println(j + "\t\t\t||\t\t\t" + doc1.get(j));
                            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                        }
                        System.out.println("══════════════════════════════════════════════════════");
//                        System.out.println(doc1);
                    }
                    if (Main.allData.get(i) instanceof Patient) {
                        System.out.println("\t\tPatient");
                        HashMap pat1 = ((Patient) Main.allData.get(i)).view_Details();
//                    Patient pat=Patient.patientArray.get(i);
                        for (Object j : pat1.keySet()) {
                            System.out.println(j + "\t\t\t||\t\t\t" + pat1.get(j));
                            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                        }
                        System.out.println("══════════════════════════════════════════════════════");
                    }

                }
            }
        } catch (IndexOutOfBoundsException error) {
            System.out.println("the Error is : " + error);
            System.out.println(Main.allData);
        } catch (Exception err) {
            System.out.println("the Error is : " + err);
        }
    }

}
