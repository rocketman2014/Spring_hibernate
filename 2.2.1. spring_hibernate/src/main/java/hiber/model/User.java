package hiber.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Car getCar() {
        return car;
    }

    public User setCar(Car car) {
        this.car = car;
        car.setUser(this);
        return car.getUser();
    }

    @OneToOne(mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User with model: \"" + car.getModel() + "\"  With serial: \"" + car.getSerial() + "\"\n" +
               "Id = " + id + "\n" +
               "FirstName = " + firstName + "\n" +
               "LastName = " + lastName + "\n" +
               "Email = " + email + "\n";
    }
}
