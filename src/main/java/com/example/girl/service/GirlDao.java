package com.example.girl.service;

import com.example.girl.pojo.Girl;
import com.example.girl.pojo.Girl_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class GirlDao {
    @Autowired
    EntityManager em;

    public List<Girl> getGirl(Integer age,String cm){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Girl> query = cb.createQuery(Girl.class);
        //这里相当于SQL语句的from
        Root<Girl> root = query.from(Girl.class);
        //where
        Predicate p1 = null;
        if (age!=null){
            Predicate p2 = cb.equal(root.get(Girl_.age),age);   //放入条件
            if (p1 != null)     //如果不为空的话代表着这不是第一个参数
            {
                p1 = cb.and(p1,p2);    //要加and
            }else {
                p1 = p2;
            }
        }
        if (cm != null && !cm.equals("")){
            Predicate p2 = cb.equal(root.get(Girl_.cm),cm);

            if (p1 != null) {
                p1 = cb.and(p1,p2);
            }else{
                p1 = p2;
            }
        }
        //把组合好的条件放到查询中
        query.where(p1);

        List<Girl> list = em.createQuery(query).getResultList();

        return list;
    }
}
