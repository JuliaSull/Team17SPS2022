package com.google.sps.servlets;

//Google Cloud Datastore Libraries
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import com.google.sps.data.PostOnPage;
//Java HTTP Libraries
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Jsoup Libraries
import org.jsoup.Jsoup;
/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/storePost")
public class storePostServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest requesst, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    response.getWriter().println("<h1>Hello world!</h1>");
  }
}
