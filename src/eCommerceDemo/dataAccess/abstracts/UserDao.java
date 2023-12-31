package eCommerceDemo.dataAccess.abstracts;

import eCommerceDemo.entities.concretes.User;

import java.util.List;

public interface UserDao {
    public void add(User user);
    public void delete(User user);
    public void update(User user);
    public User get(int id);
    public List<User> getAll();
}
