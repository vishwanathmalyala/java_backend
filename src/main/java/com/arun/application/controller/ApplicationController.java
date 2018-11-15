package com.arun.application.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.application.entity.WelcomeTable;

@RestController
public class ApplicationController {

  @Autowired
  private SessionFactory sessionFactory;

  @GetMapping(value = "/ping", produces = {MediaType.TEXT_PLAIN_VALUE})
  public String pingMsg(HttpServletRequest httpServletRequest) {
    return "Ping";
  }

  @GetMapping(value = "/msg", produces = {MediaType.APPLICATION_JSON_VALUE})
  public WelcomeTable msgResponse() {
    Session session = sessionFactory.openSession();
    // session.beginTransaction();
    WelcomeTable welcomeTalbe = session.get(WelcomeTable.class, 1);
    // session.getTransaction().commit();
    session.close();
    return welcomeTalbe;

  }

}
