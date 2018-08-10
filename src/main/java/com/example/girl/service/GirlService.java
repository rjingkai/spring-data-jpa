package com.example.girl.service;

import com.example.girl.pojo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


//这里必须继承后边(动态查询的第二种方式)
public interface GirlService extends JpaRepository<Girl,Integer>,JpaSpecificationExecutor<Girl> {


}
