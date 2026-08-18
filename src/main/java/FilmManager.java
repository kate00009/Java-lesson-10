public class FilmManager {
    private PurchaseItem[] items = new PurchaseItem[0];
    private int limit;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    //ПО УМОЛЧАНИЮ ЛИМИТ ВЫВОДИМЫХ ФИЛЬМОВ 5
    public FilmManager() {
        this.limit = 5;
    }

    //УКАЗАНИЕ ЗНАЧЕНИЯ ЛИМИТА
    public FilmManager(int limit) {
        this.limit = limit;
    }

    //ДОБАВЛЕНИЕ ФИЛЬМА
    public void add(PurchaseItem item) {
        PurchaseItem[] tmp = new PurchaseItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    //ВЫВОД ПО ПОРЯДКУ
    public PurchaseItem[] findAll() {
        return items;
    }

    //ВЫВОД В ОБРАТНОМ ПОРЯДКЕ



    //ВЫВОД В ОБРАТНОМ ПОРЯДКЕ ЛИМИТА ФИЛЬМОВ
    public PurchaseItem[] findLast() {
        PurchaseItem[] reversed = new PurchaseItem[limit];
        for (int i = 0; i < limit - 1; i++) {
            reversed[i] = items[items.length - 1 - i];
        }
        return reversed;
    }

}
