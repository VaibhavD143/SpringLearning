package com.example.restful.VO;

public class AccountAddRequest {
    private Account account;
    private Integer emp_id;

    public AccountAddRequest(Account account, Integer emp_id){
        this.account = account;
        this.emp_id = emp_id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public String toString() {
        return "AccountAddRequest{" +
                "account=" + account +
                ", emp_id=" + emp_id +
                '}';
    }
}
