package ru.geekbrains.lesson5.models;

import ru.geekbrains.lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {

        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {

        for (Table table : loadTables()) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }

        throw new RuntimeException("Некорректный номер столика.");
    }

    /**
     * TODO: Разработать самостоятельно
     * Поменять бронь столика
     * @param oldReservation номер старого резерва (для снятия)
     * @param reservationDate дата резерва столика
     * @param tableNo номер столика
     * @param name Имя
     */
    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        for (Table table : loadTables()) {
            if (table.getReservations() != null){
                for (Reservation reserv: table.getReservations()) {
                    if (reserv.getId() == oldReservation){
                        table.getReservations().remove(reserv);
                        return reservationTable(reservationDate,tableNo,name);
                    }
                }
            }
        }
        throw new RuntimeException("Некорректный номер брони!");
    }



}
