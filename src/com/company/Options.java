package com.company;

import java.util.HashMap;

public interface Options extends Cloneable{
    public HashMap view_Details();
    public static boolean isIdInt(String num) {
        int intValue;

        if (num == null || num.equals("")) {
//            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {

            intValue = Integer.valueOf(num);


            return true;
        } catch (NumberFormatException e) {
            System.out.println("Please Enter A Valid Id");
        }
        return false;
    }

    public static boolean isPhone(String phone) {
        int intValue;

        if (phone == null || phone.equals("")) {
//            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(phone);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Please Enter A Valid Phone Number");
        }
        return false;
    }


    public static boolean isage(String age) {
        int intValue;

        if (age == null || age.equals("")) {
//            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(age);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Please Enter A Valid Age");
        }
        return false;
    }

    static boolean isGender(String gender) {
        if (gender.toLowerCase().equals("female") || gender.toLowerCase().equals("male")) {
            return true;
        }
        return false;
    }
}
