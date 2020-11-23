package praktikum.modul3.tiket2;

public class Node {
    String nama, gender,ortu;
    int tingkat;
    Node first,second;

    Node (String nama, String gender){
        this.nama = nama;
        this.gender = gender;
        ortu=null;
        tingkat = 0;
    }
}
