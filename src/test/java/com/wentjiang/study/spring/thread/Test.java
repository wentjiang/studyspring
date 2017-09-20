package com.wentjiang.study.spring.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by wentj on 2017/5/14.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        List<Student> students = test.test();

        for (Student student : students) {
            System.out.println(student.getId() + " " + student.getName());
        }
    }

    public List<Student> test() {
        List<Student> students = new CopyOnWriteArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 100; i++) {
            pool.execute(new DrawStudentsData(students, i, latch));
        }
        try {
            pool.shutdown();
            pool.awaitTermination(30, TimeUnit.SECONDS);
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("error");
        }
        return students;
    }


    @Data
    @AllArgsConstructor
    class DrawStudentsData implements Runnable {

        private List<Student> students;
        private Integer id;
        private CountDownLatch latch;

        @Override
        public void run() {
            students.add(getStudent(id));
            latch.countDown();
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
