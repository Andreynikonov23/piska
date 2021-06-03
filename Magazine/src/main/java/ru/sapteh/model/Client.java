package ru.sapteh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "client")
    public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    private String FirstName;

    @Column
    private String LastName;

    @Column
    private String Patronymic;

    @Column
    private int Birthday;

    @Column
    private int RegistrationDate;

    @Column
    private String Email;

    @Column
    private String Phone;

    @Column
    private String PhotoPath;
}
