package com.example.girl.pojo;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Girl.class)
public class Girl_ {
    public static volatile SingularAttribute<Girl,Integer> id;

    public static volatile SingularAttribute<Girl,Integer> age;

    public static volatile SingularAttribute<Girl,String> cm;

}
