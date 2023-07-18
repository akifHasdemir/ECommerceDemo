package eCommerceDemo.dataAccess.concretes;

import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;


public class HibernateUserDao implements UserDao {

    List<User> userList = new ArrayList<User>();

    @Override
    public void add(User user) {
        System.out.println("Hibernate ile kaydedildi : " + user.getFirstName()+ " " + user.getLastName());
        userList.add(user);

    }

    @Override
    public void delete(User user) {
        System.out.println("Hibernate ile silindi : " + user.getFirstName()+ " " + user.getLastName());
        userList.remove(user);

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return userList;
    }
}
