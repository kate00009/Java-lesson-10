package ru.netology.javaqa;

public class FilmManager {
    private MoviePoster[] films = new MoviePoster[0];
    private int limit;

    //ПО УМОЛЧАНИЮ ЛИМИТ ВЫВОДИМЫХ ФИЛЬМОВ 5
    public FilmManager() {
        this.limit = 5;
    }

    //УКАЗАНИЕ ЗНАЧЕНИЯ ЛИМИТА
    public FilmManager(int limit) {
        this.limit = limit;
    }

    //ДОБАВЛЕНИЕ ФИЛЬМА
    public void add(MoviePoster film) {
        MoviePoster[] tmp = new MoviePoster[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    //ВЫВОД ПО ПОРЯДКУ
    public MoviePoster[] findAll() {
        return films;
    }

    //ВЫВОД В ОБРАТНОМ ПОРЯДКЕ


    //ВЫВОД В ОБРАТНОМ ПОРЯДКЕ ЛИМИТА ФИЛЬМОВ
    public MoviePoster[] findLast() {
        if (limit > films.length) {
            limit = films.length;
        }
        MoviePoster[] reversed = new MoviePoster[limit];
        for (int i = 0; i < limit; i++) {
            reversed[i] = films[films.length - 1 - i];
        }
        return reversed;
    }
}
