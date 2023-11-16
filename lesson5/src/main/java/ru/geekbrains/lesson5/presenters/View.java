package ru.geekbrains.lesson5.presenters;

import ru.geekbrains.lesson5.models.Table;

import java.util.Collection;

public interface View {

    void showTables(Collection<Table> tables);

    void showReservationTableResult(int reservationNo);

    void registerObserver(ViewObserver observer);

    void showChangeReservationTableResult(int reservationNo);

}
