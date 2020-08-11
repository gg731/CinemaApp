package persistence;

import model.Account;
import model.Place;

import java.util.*;

public interface WorkerDB {

    List<Place> getHall();

    void busyByTicketId(int id, String userName);

    Account addAccount(Account account);

}
