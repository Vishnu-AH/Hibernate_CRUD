package com.pace.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,length = 10,nullable = false)
    private int id;
    @Column(name = "name",unique = false,length = 30,nullable = false)
    private String name;
    @Column(name = "address",length = 100,nullable = false)
    private String address;
    @Column(name = "phone",unique = true,length = 10,nullable = false)
    private long phone;

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
