package com.pace.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,length = 10,nullable = false)
    private int id;
    @Column(name = "name",unique = false,length = 25,nullable = false)
    private String name;
    @Column(name = "email",unique = true,length = 25,nullable = false)
    private String email;
    @Column(name = "address",length = 100,nullable = false)
    private String address;
    @Column(name = "phone",unique = true,length = 10,nullable = false)
    private long phone;
    @OneToOne
    private School school;
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", school=" + school +
                '}';
    }
}
