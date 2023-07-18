package eCommerceDemo.business.concretes;



import java.util.Scanner;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.abstracts.GoogleUserInformationService;
import eCommerceDemo.core.concretes.Validators;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class UserManager implements UserService{

    UserDao userDao;
    GoogleUserInformationService userInfo;



    public UserManager(UserDao userDao, GoogleUserInformationService userInfo) {

        this.userDao = userDao;
        this.userInfo = userInfo;

    }


    @Override
    public void add(User user) {

        if(!Validators.isUsedMail(userDao.getAll(),user)) {

            System.out.println("Girmiş olduğunuz mail kullanımda lütfen farklı bir mail adresi girin.");


        }else if(!Validators.isPasswordValidator(user) && !Validators.isMailValidator(user) &&
                !Validators.isNameLastNameValidator(user)) {
            System.out.println("Şifreniz en az 6 karakterden oluşmalıdır.\nMail adresiniz mail formatında olmalıdır.\nAdınız ve Soyadınız en az 2 karkaterden oluşmalıdır.");

        }else if(!Validators.isPasswordValidator(user) && !Validators.isMailValidator(user)) {
            System.out.println("Şifreniz en az 6 karakterden oluşmalıdır.\nMail adresiniz mail formatında giriniz.");
        }else if(!Validators.isPasswordValidator(user) && !Validators.isNameLastNameValidator(user)) {
            System.out.println("Şifreniz en az 6 karakterden oluşmalıdır.\nAdınız ve Soyadınız en az 2 karkaterden oluşmalıdır.");
        }else if(!Validators.isMailValidator(user) && !Validators.isNameLastNameValidator(user)) {
            System.out.println("Mail adresiniz mail formatında giriniz.\nAdınız ve Soyadınız en az 2 karkaterden oluşmalıdır.");
        }else if(!Validators.isMailValidator(user)){
            System.out.println("Mail adresiniz mail formatında giriniz.");
        }else if(!Validators.isPasswordValidator(user)){
            System.out.println("Şifreniz en az 6 karakterden oluşmalıdır.");
        }else if(!Validators.isNameLastNameValidator(user)){
            System.out.println("Adınız ve Soyadınız en az 2 karkaterden oluşmalıdır.");
        }else {


            if(Validators.isMailConfirmation(true)) {
                System.out.println(user.getFirstName() + " tebrikler başarıyla kayıt oluşturuldu.");
                userDao.add(user);

            }else {
                System.out.println("Mail adresinize bir mail gönderdik maili doğrulayın lütfen.");
            }

        }
    }

    @Override
    public void delete(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public User getUser(int id) {
        return null;
        // TODO Auto-generated method stub

    }

    @Override
    public void getAll() {

        for(User user : userDao.getAll()) {

            System.out.println("Id : " + user.getId());
            System.out.println("Ad : " + user.getFirstName());
            System.out.println("Soyad : " + user.getLastName());
            System.out.println("E-mail : " + user.getEmail());
            System.out.println();
        }
    }


    Scanner input = new Scanner(System.in);
    @Override
    public void login() {
        System.out.println("--------Giriş sayfası-----");
        System.out.print("E-mail : ");
        String  mail = input.next();
        System.out.print("Şifre : ");
        String password = input.next();

        if(!mail.isEmpty() && !password.isEmpty()) {

            for(User userControl : userDao.getAll()) {
                if(mail.equals(userControl.getEmail()) && password.equals(userControl.getPassword())) {
                    System.out.println("Giriş yapıldı.");
                    return;
                }

            }
            System.out.println("Bilgiler uyuşmamaktadır.");

        }else {
            System.out.println("Mail alanı ve şifre alanı boş geçilemez.");
        }

    }


    @Override
    public void registerWithGoogle(GoogleUserInformationService info) {
        User user = new User();
        user.setId(info.getUserInfo().getId()); //Veri tabanı kullandığımızda idyi otomatik veritabanı verekcek
        user.setFirstName(info.getUserInfo().getName());
        user.setLastName(info.getUserInfo().getLastName());
        user.setEmail(info.getUserInfo().getMail());
        user.setPassword(info.getUserInfo().getPassword());
        if(!Validators.isUsedMail(userDao.getAll(),user)) {

            System.out.println("Girmiş olduğunuz mail kullanımda lütfen farklı bir mail adresi girin.");


        }else {
            if(Validators.isMailConfirmation(true)) {
                System.out.println(user.getFirstName() + " tebrikler google hesabımız ile başarıyla kayıt oluşturuldu.");
                userDao.add(user);

            }else {
                System.out.println("Mail adresinize bir mail gönderdik maili doğrulayın lütfen.");
            }



        }

    }


}