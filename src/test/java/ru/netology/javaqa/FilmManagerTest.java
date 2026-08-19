package ru.netology.javaqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FilmManagerTest {

    MoviePoster film1 = new MoviePoster("Исчезнувшая");
    MoviePoster film2 = new MoviePoster("Человек паук");
    MoviePoster film3 = new MoviePoster("Один дома");
    MoviePoster film4 = new MoviePoster("Дэдпул");
    MoviePoster film5 = new MoviePoster("Форрест Гамп");
    MoviePoster film6 = new MoviePoster("Дневник памяти");

    FilmManager manager = new FilmManager();

    @BeforeEach
    public void setup() {
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
    }

    //ВЫВОД ПО ОЧЕРЕДИ ВСЕХ ФИЛЬМОВ
    @Test
    public void get() {
        MoviePoster[] expected = {film1, film2, film3, film4, film5, film6};
        MoviePoster[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    //ВЫВОД В ОБРАТНОМ ПОРЯДКЕ ЛИМИТА ФИЛЬМОВ
    @Test
    public void getReversed() {
        MoviePoster[] expected = {film6, film5, film4, film3, film2};
        MoviePoster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    //ВЫВОД В ОБРАТНОМ ПОРЯДКЕ ЗАДАННОГО ЛИМИТА ФИЛЬМОВ
    @Test
    public void getReversedLimit() {
        FilmManager manager = new FilmManager(4);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        MoviePoster[] expected = {film6, film5, film4, film3};
        MoviePoster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getReversedLimitAboveSize() {
        FilmManager manager = new FilmManager(9);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        MoviePoster[] expected = {film6, film5, film4, film3, film2, film1};
        MoviePoster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

}