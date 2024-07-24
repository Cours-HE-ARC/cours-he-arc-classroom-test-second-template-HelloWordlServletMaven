package ch.hearc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet(
	name="heloWordlServlet",
	urlPatterns = "/hello"
			
)
public class HelloWorldServlet extends HttpServlet{
	
	Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Qui qui = gson.fromJson(req.getReader(), Qui.class);
		
		resp.setContentType("application/json");
		
		HelloWorld hello = new HelloWorld(qui.qui);
		
		String res = gson.toJson(hello);
		
		PrintWriter out = resp.getWriter();
		  
		out.print(res);
		
		out.flush();
	}
	
	
	class Qui{
		private String qui;
		
		
		public String getQui() {
			return this.qui;
		}
	}
	
	
	class HelloWorld{
		private String hello;
		
		public HelloWorld(String hello) {
			this.hello = hello;
		}
		
		public String getHello() {
			return this.hello;
		}
	}

	
}
