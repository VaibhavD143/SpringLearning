package com.example.restful;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DBOperation {
    private Session currentSession;
    private Transaction currentTransaction;
    public DBOperation(){}

    public Session openCurrentSession(){
        currentSession = (new SessionUtil()).getSessionFactory().openSession();
        return currentSession;
    }
    public void closeCurrentSession(){
        this.currentSession.close();
    }

    public Session openCurrentSessionWithTransaction(){
        currentSession = (new SessionUtil()).getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSessionWithTransaction(){
        if(currentTransaction.isActive())
            currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession(){
        return this.currentSession;
    }

    public Transaction getCurrentTransaction(){
        return this.currentTransaction;
    }

//    public Integer insert(Object object){
//        return (Integer)getCurrentSession().save(object);
//    }
    public Integer insert(Object object){
        return (Integer) getCurrentSession().save(object);
    }

    public <T> List<T> getList(Class<T> tClass, String query){
        Query<T> q = getCurrentSession().createQuery(query,tClass);
        return q.list();
    }

    public <T> T load(Class<T> type, int _id){
        return getCurrentSession().load(type,_id);
    }


    public void update(Object object){
        getCurrentSession().update(object);
    }


    public void delete(String _query){
        Query query = getCurrentSession().createQuery(_query);
        query.executeUpdate();
    }

    public boolean deleteById(Class<?> _class_type,int _object_id){
        Object persistence_object = getCurrentSession().load(_class_type,_object_id);
        if(persistence_object!=null){
            getCurrentSession().delete(persistence_object);
            return true;
        }
        return false;
    }
}
