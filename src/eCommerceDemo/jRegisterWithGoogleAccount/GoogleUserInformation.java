package eCommerceDemo.jRegisterWithGoogleAccount;

public class GoogleUserInformation {

    //Bu aşamada direkt kullanıcının bilgilerinin geldiğini farz ediyoruz.

    private int id = 1;
    private String name = "Akif";
    private String lastName = "Hasdemir";
    private String mail = "hasdemir.akif@gmail.com";
    private String password = "951753852a";

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


}
