package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Car")
public class Car implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;

    @Column(name = "model")
    private String model;

    @Column(name = "serial")
    private int serial;

    public Car(String model, int serial) {
        this.model = model;
        this.serial = serial;
    }

    public Car() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
               "user=" + user +
               ", model='" + model + '\'' +
               ", serial=" + serial +
               '}';
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
}
