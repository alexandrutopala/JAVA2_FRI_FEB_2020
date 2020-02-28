package main;



public class Exemplu1 {

    @MyAnnonation(value = "world", other = 2, array = {3.14, 2.70})
    int x;

    // in cazul in care o adnotare are o singura proprietate
    // nespecificata, si aceea se numeste value, o putem subintelege
    @MyAnnonation("world")
    public static void main(String[] args) {

    }
}
