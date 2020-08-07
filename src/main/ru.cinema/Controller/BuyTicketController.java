package Controller;

import Model.Account;
import Persistence.CinemaDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BuyTicketController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] paramArr = req.getParameter("place").split(" ");

        req.getSession().setAttribute("ticketId", paramArr[0]);
        req.getSession().setAttribute("x", paramArr[1]);
        req.getSession().setAttribute("y", paramArr[2]);

        req.getRequestDispatcher("buy.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        int phone = Integer.valueOf(req.getParameter("phone"));
        int ticketId = Integer.valueOf((String) req.getSession().getAttribute("ticketId"));

        if (CinemaDB.getInstance().getAccByName(username) != null) {
            req.setAttribute("usernameErr", "Username уже занят.");
            req.getRequestDispatcher("buy.jsp").forward(req, resp);
        } else {
            Account account = CinemaDB.getInstance().addAccount(
                    new Account(username, phone, ticketId));

            CinemaDB.getInstance().busyByTicketId(
                    ticketId, account.getName());

            resp.sendRedirect(req.getContextPath() + "/hall");
        }
    }
}
