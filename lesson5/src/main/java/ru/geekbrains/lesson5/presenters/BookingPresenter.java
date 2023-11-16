package ru.geekbrains.lesson5.presenters;


import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTablesUI(){
        view.showTables(model.loadTables());
    }


    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        System.out.println("Презентер реагирует на событие");
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            view.showReservationTableResult(reservationNo);
        }
        catch (RuntimeException e){
            view.showReservationTableResult(-1);
        }

    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date orderDate, int tableNo, String name) {
        System.out.println("Презентер реагирует на событие");
        try {
            int reservationNo = model.changeReservationTable(oldReservation,orderDate,tableNo,name);
            view.showChangeReservationTableResult(reservationNo);
        }
        catch (RuntimeException e){
            view.showChangeReservationTableResult(-1);
        }
    }
}
