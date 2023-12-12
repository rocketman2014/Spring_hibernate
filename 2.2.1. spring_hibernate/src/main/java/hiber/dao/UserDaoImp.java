package hiber.dao;

import hiber.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getByModelAndSerial(String model, int serial) {
//        String HQL = "FROM User u WHERE u.car.model = :model AND u.car.serial = :serial";
        Query<User> user = sessionFactory.openSession()
                .createQuery("FROM User u WHERE u.car.model = :model AND u.car.serial = :serial", User.class);
        user.setParameter("model", model);
        user.setParameter("serial", serial);
        return user.getResultStream().findFirst().orElse(null);
    }

}
