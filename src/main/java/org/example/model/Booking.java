package org.example.model;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table
public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(unique = true)
        private Integer id;
        @Column
        private Date bookingDate;
        @Column
        private String status;

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
    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", status='" + status + '\'' +
                '}';
    }
}
