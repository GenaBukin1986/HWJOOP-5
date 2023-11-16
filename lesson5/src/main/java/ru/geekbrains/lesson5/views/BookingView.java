package ru.geekbrains.lesson5.views;

import ru.geekbrains.lesson5.models.Table;
import ru.geekbrains.lesson5.presenters.View;
import ru.geekbrains.lesson5.presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {


    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showChangeReservationTableResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Бронь успешно изменена. Номер резерва: #%d\n", reservationNo);
        }
        else {
            System.out.println("Произошла ошибка изменения бронирования столика.\nПовторите операцию позже!");
        }
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер резерва: #%d\n", reservationNo);
        }
        else {
            System.out.println("Произошла ошибка бронирования. Повторите операцию позже.");
        }
    }


    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void reservationTable(Date orderDate, int tableNo, String name){
        System.out.println("Возбуждается событие бронирования столика");
        System.out.println("Происходит уведомление наблюдателей ...");
        for (ViewObserver observer : observers){
            observer.onReservationTable(orderDate, tableNo, name);
        }
    }

    /**
     * TODO: метод должен заработать!
     * Действие клиента (пользователь нажал на кнопку), изменение бронирования столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void changeReservationTable(int oldReservation, Date orderDate, int tableNo, String name){
        System.out.println("Возбуждается событие изменение бронирования столика.");
        System.out.println("Происходит уведомления наблюдателей ...");
        observers.forEach(n -> n.onChangeReservationTable(oldReservation,orderDate,tableNo,name));
    }

}
