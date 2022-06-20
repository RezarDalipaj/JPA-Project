package org.example.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true)
        private Integer id;
        @Column
        private Date bookingDate;
        @Column
        private String status;
        @ManyToOne
        @JoinColumn(name = "user_id",nullable = false)
        private User user;
        @ManyToMany
        @JoinTable(
                name = "booking_flight",
                joinColumns = @JoinColumn(name = "flight_id"),
                inverseJoinColumns = @JoinColumn(name = "booking_id"))
        private List<Flight> flights;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", status='" + status + '\'' +
                ", user id=" + user.getId()+ "username: " + user.getUserName() +
                '}';
    }
}
