package com.google.sps.servlets;

//Google Cloud DataStore Libraries
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
//Java HTTP Libraries
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
    // Save data into variables
    String title = request.getParameter("title-input");
    String content_text = request.getParameter("content-input");
    // Placeholder for images
    String content_image = "";
    // Placeholder for tags;
    String tag = "tag1, tag2";
    long timestamp = System.currentTimeMillis();
    // Calls datastore
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
    // Post into database
    datastore.put(PostOnPageEntity);
    // Goes back to index
    response.sendRedirect("/index.html");
  }
}
