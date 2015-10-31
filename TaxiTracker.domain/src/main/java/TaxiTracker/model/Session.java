package TaxiTracker.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * Created by hanjo on 31.10.15.
 */
@Entity
public class Session implements Serializable {
    private Long id;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Car car;

    @OneToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    private Driver driver;

    @OneToOne
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    private Date startTime;

    @Temporal(TemporalType.DATE)
    @Basic
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    private Date endTime;

    @Temporal(TemporalType.DATE)
    @Basic
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
