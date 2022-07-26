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

/** Handles post request to the project */
@WebServlet("/storePost")
public class storePostServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String title = request.getParameter("title");
    String content_text = request.getParameter("post-content");

    response.getWriter().println(title);
    response.getWriter().println(content_text);




    // Placeholder for images
    String content_image = "";

    // Placeholder for tags;
    String tag = "tag1, tag2";
    long timestamp = System.currentTimeMillis();
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("PostOnPage");

    // Creates data in entity
    FullEntity PostOnPageEntity = Entity.newBuilder(keyFactory.newKey())
        .set("title", title)
        .set("tag", tag)
        .set("content_text", content_text)
        .set("content_image", content_image)
        .set("timestamp", timestamp)
        .build();
    datastore.put(PostOnPageEntity);
    response.sendRedirect("/index.html");

  }
}
