package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.presenters.BookingPresenter;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.Date;

public class Program {

    //TODO: Метод changeReservationTable должен заработать!
    public static void main(String[] args) {

        TableModel tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.updateTablesUI();
        bookingView.reservationTable(new Date(), 3, "Станислав");
        bookingView.reservationTable(new Date(), 3, "Николай");


        bookingView.changeReservationTable(1004, new Date(), 2, "Станислав");
        bookingView.changeReservationTable(1002, new Date(), 3, "Борис");

    }

}
