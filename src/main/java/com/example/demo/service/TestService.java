package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.swagger.request.InsertRequest;

public interface TestService {

  String getUser(Long id);

  int insert(InsertRequest request);

  User update(InsertRequest request);

  void error();

  void delete(String id) throws Exception;
}
