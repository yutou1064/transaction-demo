package com.example.demo.swagger;

import com.example.demo.service.TestService;
import com.example.demo.service.UpdateService;
import com.example.demo.swagger.request.InsertRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApiController implements DemoApi{

  @Autowired
  private TestService testService;

  @Autowired
  private UpdateService updateService;

  @Override
  public ResponseEntity<String> get(String id) throws Exception {
    return new ResponseEntity<>(testService.getUser(Long.valueOf(id)), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> insert(InsertRequest request) throws Exception {
    testService.insert(request);
    return new ResponseEntity<>(null, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> update(InsertRequest request) throws Exception {
    return new ResponseEntity<>(updateService.update(request), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> delete(String id) throws Exception {
    return new ResponseEntity<>(updateService.delete(id), HttpStatus.OK);
  }
}
