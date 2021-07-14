package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TestService;
import com.example.demo.service.UpdateService;
import com.example.demo.swagger.request.InsertRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateServiceImpl implements UpdateService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TestService testService;

  @Override
  //@Transactional
  public String update(InsertRequest request) {
    User update = userRepository.findById(Long.valueOf(request.getId())).get();
    update.setName(request.getName()).setEmail(request.getEmail()).setAge(Integer.valueOf(request.getAge()));
    //User update = testService.update(request);
    //int i = 1/0;
    testService.error();
    String user = JSON.toJSONString(update);
    System.out.println("update success");
    return user;
  }

  @Override
  @Transactional
  public String delete(String id) throws Exception {
    testService.delete(id);
    //int i = 1/0;
    return "success!";
  }
}
