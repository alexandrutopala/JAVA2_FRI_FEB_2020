package main;

public class Punct {

    @Valoare(value = 4)
    private int x;

    @Valoare(7)
    private int y;

    private Punct() {
    }

    private Punct(Integer i, String s) {
    }

    private void afis() {
        System.out.println(x + " " + y);
    }
}
