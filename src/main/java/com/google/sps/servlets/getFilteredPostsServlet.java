package com.google.sps.servlets;

//Google Cloud Datastore Libraries
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
//Jsoup Libraries
import org.jsoup.Jsoup;
//Gson Library
import com.google.gson.Gson;
import com.google.sps.data.PostOnPage;

//Java List
import java.util.*;;

/**
 * Handles requests sent to the /hello URL. Try running a server and navigating
 * to /hello!
 */
@WebServlet("/getFilteredPosts")
public class getFilteredPostsServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<String> tags = new ArrayList<>();
    tags = List.of("Tag1", "Tag2");
    long timestamp = 23409872349L;
    PostOnPage post = new PostOnPage(1234,"Julia",tags ,"Some text for the content", "Image metadata here", timestamp);
    Gson gson = new Gson();
    String json = gson.toJson(post);
    System.out.println(json);
    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(post));
  }
}
