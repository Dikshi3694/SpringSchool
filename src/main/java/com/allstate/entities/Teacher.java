package com.allstate.entities;


import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name="teachers")
public class Teacher {
    private int id;
    private int version;
    private String name;
    private int age;
    private String email;
    private Gender gender;
    private Klass klass_id;

    public Teacher() {
    }

    public Teacher(String name, int age,String email, Gender gender) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Column(nullable = false, columnDefinition = "ENUM('MALE', 'FEMALE')")
    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @ManyToOne
    @JoinColumn(name = "klass_id")
    @JsonIgnore
    public Klass getKlass_id() {
        return klass_id;
    }
    public void setKlass_id(Klass klass_id) {
        this.klass_id = klass_id;
    }
}
