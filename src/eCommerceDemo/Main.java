package eCommerceDemo;

import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.core.concretes.GoogleUserInformationManagerAdapter;
import eCommerceDemo.dataAccess.concretes.HibernateUserDao;
import eCommerceDemo.entities.concretes.User;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1,"Onur","Çelik","tpmage@gmail.com","123753");
        User user2 = new User(2,"Ahmet","Demir","ahmet@gmail.com","987654");
        User user3 = new User(3,"Mehmet","Durmaz","mehmetgmailcom","369852147"); //regex kontrolü için maili mail formatında yazmadık
        User user4 = new User(4,"Veli","Solmaz","veli@gmail.com","123456");
        User user5 = new User(5,"Nurhan","Durur","tpmage@gmail.com","951753852a"); //Mail kontrolünü denemek amacıyla bu kaydın mailini 1. kayıtla aynı girildi

        UserManager manager1 = new UserManager(new HibernateUserDao(), new GoogleUserInformationManagerAdapter());

        manager1.add(user1);
        System.out.println();
        manager1.add(user2);
        System.out.println();
        manager1.add(user3);
        System.out.println();
        manager1.add(user4);
        System.out.println();
        manager1.add(user5);
        System.out.println();

        manager1.registerWithGoogle(new GoogleUserInformationManagerAdapter());

        System.out.println();

        manager1.getAll(); //Kayıt olan tüm kullanıcıları listeler

        manager1.login(); //Sisteme giriş simülasyonu

    }
}
