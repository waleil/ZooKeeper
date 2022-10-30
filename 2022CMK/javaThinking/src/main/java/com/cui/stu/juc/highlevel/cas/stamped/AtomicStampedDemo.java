package com.cui.stu.juc.highlevel.cas.stamped;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Auther: csx
 * @Date: 2022/9/1 23:25
 * @Description:
 */
public class AtomicStampedDemo {
    public static void main(String[] args) {
        Book javaBook = new Book(1,"javaBook");
        AtomicStampedReference<Book> stampedReference = new AtomicStampedReference<>(javaBook, 1);
        System.out.println(stampedReference.getReference()+"\t"+stampedReference.getStamp());

        Book mysql = new Book(2,"mysql");
        boolean b = stampedReference.compareAndSet(javaBook, mysql, stampedReference.getStamp(), stampedReference.getStamp()+1);
        System.out.println(b+"\t"+stampedReference.getReference()+"\t"+stampedReference.getStamp());
    }
}
