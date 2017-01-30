package com.allstate.services;

import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateTeacher() throws Exception {
        Teacher t = this.teacherService.create("dikshita", 23, "dikshi@gmail.com", Gender.FEMALE);
        assertEquals(2, t.getId());
    }

    @Test
    public void shouldFindTeacherById() throws Exception {
        Teacher teacher = this.teacherService.findById(1);
        assertEquals(1, teacher.getId());
        assertEquals("sameer", teacher.getName());
    }

    @Test
    public void shouldFindTeachersByGender() throws Exception {
       this.teacherService.create("dikshita", 23, "dikshi@gmail.com", Gender.FEMALE);
        this.teacherService.create("RITA", 23, "GFG@gmail.com", Gender.FEMALE);
        this.teacherService.create("DFD", 23, "diHGFkshi@gmail.com", Gender.FEMALE);
        ArrayList<Teacher> list = (ArrayList) this.teacherService.findTeachersByGender(Gender.FEMALE);
        assertEquals(3, list.size());
    }

}