package com.example.girl.service.impl;


import com.example.girl.pojo.Girl;
import com.example.girl.pojo.Girl_;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

//动态查询的第二种方法
public class GirlServiceImpl  {

    public static Specification<Girl> getSpec(final Integer age,final String cm){
        return new Specification<Girl>() {
            @Override
            public Predicate toPredicate(Root<Girl> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p1 = null;
                if(age !=0){
                    Predicate p2 = criteriaBuilder.equal(root.get(Girl_.age),age);
                    if(p1 !=null){
                        p1= criteriaBuilder.and(p1,p2);
                    }else {
                        p1 = p2;
                    }
                }

                if(cm !=null && !cm.equals("") ){
                    Predicate p2 = criteriaBuilder.equal(root.get(Girl_.cm),cm);
                    if (p1!=null){
                        p1 = criteriaBuilder.and(p1,p2);
                    }else {
                        p1 = p2;
                    }
                }

                return p1;
            }
        };
    }
}
