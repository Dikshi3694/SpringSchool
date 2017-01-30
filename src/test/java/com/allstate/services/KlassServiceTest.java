package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.enums.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KlassServiceTest {

    @Autowired
    private KlassService service;

    @Test
    public void shouldCreateNewKlass() throws Exception {
        Klass k = this.service.create("sameer1",new Date(2016,5,5),9, 20000 , Department.PHILOSOPHY);
        assertEquals(3,k.getId());
    }

    @Test
    @Transactional
    public void shouldFindOneKlassById() throws Exception {
        Klass klass = this.service.findById(1);
        assertEquals("sameer", klass.getName());
    }

    @Test
    @Transactional
    public void shouldFindOneKlassByName() throws Exception {
        Klass klass = this.service.findByName("sameer");
        assertEquals(1, klass.getId());
    }

}