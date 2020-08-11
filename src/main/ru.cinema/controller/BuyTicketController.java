package controller;

import model.Account;
import persistence.CinemaDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buy")
public class BuyTicketController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String[] paramArr = req.getParameter("place").split(" ");

        var session = req.getSession();

        session.setAttribute("ticketId", paramArr[0]);
        session.setAttribute("x", paramArr[1]);
        session.setAttribute("y", paramArr[2]);

        req.getRequestDispatcher("buy.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        int phone = Integer.valueOf(req.getParameter("phone"));
        int ticketId = Integer.valueOf((String) req.getSession().getAttribute("ticketId"));
        Account account = new Account(0, username, phone, ticketId);

        if (CinemaDB.getInstance().addAccount(account) == null) {
            req.setAttribute("usernameErr", "Username уже занят.");
            req.getRequestDispatcher("buy.jsp").forward(req, resp);
        } else {
            CinemaDB.getInstance().busyByTicketId(
                    ticketId, account.getName());

            resp.sendRedirect(req.getContextPath() + "/hall");
        }
    }
}
