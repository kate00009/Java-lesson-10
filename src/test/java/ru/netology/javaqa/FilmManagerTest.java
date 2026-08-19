package ru.netology.javaqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilmManagerTest {

    PurchaseItem item1 = new PurchaseItem("Исчезнувшая");
    PurchaseItem item2 = new PurchaseItem("Человек паук");
    PurchaseItem item3 = new PurchaseItem("Один дома");
    PurchaseItem item4 = new PurchaseItem("Дэдпул");
    PurchaseItem item5 = new PurchaseItem("Форрест Гамп");
    PurchaseItem item6 = new PurchaseItem("Дневник памяти");

    FilmManager manager = new FilmManager();

    @BeforeEach
    public void setup () {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
    }

    //ВЫВОД ПО ОЧЕРЕДИ ВСЕХ ФИЛЬМОВ
    @Test
    public void get() {
        PurchaseItem[] expected = {item1, item2, item3, item4, item5, item6};
        PurchaseItem[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    //ВЫВОД В ОБРАТНОМ ПОРЯДКЕ ЛИМИТА ФИЛЬМОВ
    @Test
    public void getReversed() {
        PurchaseItem[] expected = {item6, item5, item4, item3, item2};
        PurchaseItem[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    //ВЫВОД В ОБРАТНОМ ПОРЯДКЕ ЗАДАННОГО ЛИМИТА ФИЛЬМОВ
    @Test
    public void getReversedLimit() {
        FilmManager manager = new FilmManager(4);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        PurchaseItem[] expected = {item6, item5, item4, item3};
        PurchaseItem[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getReversedLimit2() {
        FilmManager manager = new FilmManager(9);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        PurchaseItem[] expected = {item6, item5, item4, item3, item2, item1};
        PurchaseItem[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

}