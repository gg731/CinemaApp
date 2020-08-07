package Controller;

import Persistence.CinemaDB;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hall")
public class HallController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write(new Gson().toJson(CinemaDB.getInstance().getHall()));

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String json = new Gson().toJson(CinemaDB.getInstance().getHall());

        resp.setContentType("JSON");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
