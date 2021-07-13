package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TestService;
import com.example.demo.swagger.request.InsertRequest;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional(readOnly = true)
  public String getUser(Long id) {
    Optional<User> user = userRepository.findById(id);
    return JSON.toJSONString(user);
  }

  @Override
  @Transactional
  public int insert(InsertRequest request) {
    User user = new User();
    user.setAge(Integer.valueOf(request.getAge())).setEmail(request.getEmail()).setName(request.getName()).setId(Long.valueOf(request.getId()));
    User save = userRepository.save(user);
    System.out.println(JSON.toJSONString(save));
    return 1;
  }

  //Propagation.REQUIRES_NEW,外层事务不会影响内层事务，内层会影响外层
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public User update(InsertRequest request) {
    User save = userRepository.findById(Long.valueOf(request.getId())).get();
    save.setName(request.getName()).setEmail(request.getEmail()).setAge(Integer.valueOf(request.getAge()));
    return save;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void error() {
    int i = 1/0;
  }

  @Override
  //@Transactional(propagation = Propagation.NEVER)
  @Transactional
  public void delete(String id) throws Exception{

    userRepository.deleteById(Long.valueOf(id));
    throw new IOException();
    //System.out.println("success");
  }
}
