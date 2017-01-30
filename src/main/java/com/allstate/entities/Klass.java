package com.allstate.entities;

import com.allstate.enums.Department;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Table(name="klasses")
public class Klass {
    private int id;
    private int version;
    private String name;
    private Date semester;
    private int credits;
    private Department department;
    private double fee;
    private Timestamp created;
    private Timestamp modified;

    public Klass() {
    }

    public Klass(String name, Date semester, int credits, Department department, double fee) {
        this.name = name;
        this.semester = semester;
        this.credits = credits;
        this.department = department;
        this.fee = fee;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false)
    public Date getSemester() {
        return semester;
    }
    public void setSemester(Date semester) {
        this.semester = semester;
    }

    @Column(nullable = false)
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Column(columnDefinition = "ENUM('SCIENCE', 'ENGINEERING', 'LITERATURE', 'PHILOSOPHY')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
}
