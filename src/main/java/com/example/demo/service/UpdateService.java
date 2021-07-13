package com.example.demo.service;

import com.example.demo.swagger.request.InsertRequest;

public interface UpdateService {

  String update(InsertRequest request);

  String delete(String id) throws Exception;
}
