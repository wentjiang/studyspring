package com.wentjiang.study.spring.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wentj on 2017/5/14.
 */
public class Test {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        ExecutorService pool = Executors.newFixedThreadPool(200);
//        pool.execute();
    }


    @Data
    @AllArgsConstructor
    class DrawStudentsData implements Runnable {

        private List<Student> students;
        private Integer id;

        @Override
        public void run() {
            students.add(getStudent(id));
        }

        private Student getStudent(Integer id) {
            Student student = new Student(id.toString(), "学生" + id);
            return student;
        }
    }

    @Data
    @AllArgsConstructor
    class Student {
        private String id;
        private String name;
    }
}
