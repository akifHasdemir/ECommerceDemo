package eCommerceDemo.core.concretes;

import eCommerceDemo.entities.concretes.User;

import java.util.List;
import java.util.regex.Pattern;

public class Validators {


    public static boolean isPasswordValidator(User user) {

        if(user.getPassword().length() >= 6 ) {

            return true;
        }

        return false;
    }


    public static boolean isMailValidator(User user) {

        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern)
                .matcher(user.getEmail())
                .matches();


    }

    public static boolean isNameLastNameValidator(User user) {

        if(user.getFirstName().length() >= 2 && user.getLastName().length() > 2) {

            return true;
        }

        return false;
    }

    public static boolean isUsedMail(List<User> users, User user) {

        for(User userControl : users ) {

            if(userControl.getEmail().equals(user.getEmail())) {

                return false;
            }
        }

        return true;

    }

    public static boolean isMailConfirmation(boolean linkVerify) {
        //Burada kullanıcının mailini onaylayıp onaylamadığına dair kodlar olmalı
        //Şimdilik kendimiz methoda true veya false değer göndererek simüle ediyoruz

        if(linkVerify) {
            System.out.println("Mail onaylandı.");
            return true;
        }
        return false;


    }

}
