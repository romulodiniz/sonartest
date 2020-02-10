package training.security;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Insecure1 {

  public String testSQL(HttpServletRequest request1, Connection connection) throws Exception {
    String user = request1.getParameter("user");
	String test1 = "Adding stuff here too!";
    String query2 = "SELECT userid FROM users WHERE username = '" + user  + "'";
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(query2);
    return resultSet.getString(0);
  }
}
