package Persistence;

import Model.Account;
import Model.Place;

import java.util.*;

public interface WorkerDB {
    List<Place> getHall();

    void busyByTicketId(int id, String userName);

    Account addAccount(Account account);

    Account getAccByName(String name);

}
