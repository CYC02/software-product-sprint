package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {
  //POST request handler
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String textValue = request.getParameter("text-input");
    long timestamp = System.currentTimeMillis();
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Comment");
    
    FullEntity commentEntity =
        Entity.newBuilder(keyFactory.newKey())
        .set("text", textValue)
        .set("timestamp", timestamp)
        .build();
    datastore.put(commentEntity);
    response.sendRedirect("/index.html");

  }
}