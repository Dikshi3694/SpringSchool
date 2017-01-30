package com.allstate.services;


import com.allstate.entities.Klass;
import com.allstate.enums.Department;
import com.allstate.repositories.IKlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class KlassService {

    private IKlassRepository klassRepository;
    @Autowired

    public void setKlassRepository(IKlassRepository klassRepository) {
        this.klassRepository = klassRepository;
    }

    public Klass create(String name, Date semester, int credits, double fee, Department department){
        return this.klassRepository.save(new Klass(name,semester,credits, department,fee));
    }

    public Klass findById(int id){
        return this.klassRepository.findOne(id);
    }

    public Klass findByName(String name){
        return this.klassRepository.findByName(name);
    }
}
