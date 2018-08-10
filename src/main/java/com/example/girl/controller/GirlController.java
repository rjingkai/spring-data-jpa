package com.example.girl.controller;

import com.example.girl.pojo.Girl;
import com.example.girl.service.GirlDao;
import com.example.girl.service.GirlService;
import com.example.girl.service.impl.GirlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class GirlController  {

    @Autowired
    private GirlService girlService;

    @Autowired
    private GirlServiceImpl girlService1;    //第二种方式

    @Autowired
    private GirlDao girlDao;     //第一种方式

    @RequestMapping("/add")
    public void insert(){

    }

    @RequestMapping("/getAll")
    public List<Girl> getAll(){
        List<Girl> list = girlService.findAll();
        return list;
    }

    @RequestMapping("/chaxun")
    public List<Girl> chaxun(Integer age,String cm){
        //第二种方法测试，感觉没有第一种方便
//        List<Girl> list = girlService.findAll(girlService1.getSpec(age,cm));
//        return list;

        //第一种方法，在dao中直接写动态查询，
       return girlDao.getGirl(age,cm);


    }

    @RequestMapping("/fenye")
    public Page<Girl> fenye(Integer page,Integer pageSize){
        Pageable pageable = new PageRequest(page,pageSize,Sort.Direction.ASC,"id");
        return girlService.findAll(pageable);
    }
}
