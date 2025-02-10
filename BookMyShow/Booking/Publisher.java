package Booking;

import Notification.Observer;

public interface Publisher {


    void adduser(Observer user);
    void removeUser(Observer user);
    void update();
}
