package com.example.restful;

import com.example.restful.VO.Account;
import com.example.restful.VO.Employee;
import com.example.restful.utils.DBOperation;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws InterruptedException {
//        (new SessionUtil()).getSessionFactory();
//	kya baat hai, nai chal rha tu!
        DBOperation dbOperation = new DBOperation();
        dbOperation.openCurrentSessionWithTransaction();

        Account account1 = new Account();
        account1.setAccountNumber("a1");

        Account account2 = new Account();
        account2.setAccountNumber("b1");

        Account account3 = new Account();
        account3.setAccountNumber("a2");


        Employee emp1 = new Employee();
        emp1.setFirstName("Vaibhav");
        emp1.setLastName("Dodiya");
        emp1.setEmail("vaibha@dodiya.iiitb");

        Employee emp2 = new Employee();
        emp2.setFirstName("Gauri");
        emp2.setLastName("Rawat");
        emp2.setEmail("gauri@rawat.iiitb");

        Employee emp3 = new Employee();
        emp3.setFirstName("Jhanvi");
        emp3.setLastName("Chanababa");
        emp3.setEmail("chanababa.jhanvi15@gmail.com");


        Set<Account> accountsEmp1 = new HashSet<>();
        accountsEmp1.add(account1);
        accountsEmp1.add(account2);

        Set<Account> accountsEmp2 = new HashSet<>();
        accountsEmp2.add(account3);

//        emp1.setAccounts(accountsEmp1);
//        emp2.setAccounts(accountsEmp2);

        account1.setEmployee(emp1);
        account2.setEmployee(emp1);
        account3.setEmployee(emp2);

        dbOperation.insert(emp1);
        dbOperation.insert(emp2);
        dbOperation.insert(emp3);

        dbOperation.insert(account1);
        dbOperation.insert(account2);
        dbOperation.insert(account3);

        System.out.println("here!");
        dbOperation.closeCurrentSessionWithTransaction();
        System.out.println("there!");
        System.out.println("Emplyees Inserted succesfully");
        dbOperation.openCurrentSessionWithTransaction();
//        Employee emp = dbOperation.load(Employee.class,1);
//        System.out.println(emp);

////        dbOperation.openCurrentSessionWithTransaction();
        Account account4 = new Account();
        account4.setAccountNumber("a3");

//        account4.setEmployee(emp);
        dbOperation.insert(account4);
//
//        Employee emp = dbOperation.load(Employee.class,1);
//
//        emp.getAccounts().add(account4);
//        account4.setEmployee(emp);
//        dbOperation.insert(account4);
//
//        Account account5 = new Account();
//        account5.setAccountNumber("b2");
//
//        emp.getAccounts().add(account5);
//        account5.setEmployee(emp1);
//        dbOperation.insert(account5);
////        dbOperation.closeCurrentSessionWithTransaction();
//        dbOperation.getCurrentTransaction().commit();
////        dbOperation.insert(account1);
////        dbOperation.insert(account2);
////        dbOperation.insert(account3);
//
////        dbOperation.openCurrentSessionWithTransaction();
//        dbOperation.getCurrentTransaction().begin();
//        Account acc = dbOperation.load(Account.class,5);
//        emp = acc.getEmployee();
////
////        for(Account acc: accs){
////            System.out.println(acc);
////        }
//        System.out.println(emp);
        dbOperation.closeCurrentSessionWithTransaction();
        dbOperation.openCurrentSessionWithTransaction();
//        Employee empt = dbOperation.load(Employee.class,1);
//        System.out.println(empt);
        dbOperation.closeCurrentSessionWithTransaction();


    }
}
