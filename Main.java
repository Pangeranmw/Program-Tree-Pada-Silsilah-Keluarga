package praktikum.modul3.tiket2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree t = new Tree();
        int aksi=0;
        boolean aksi2;
        Scanner in = new Scanner(System.in);
        String nama,nama2;

        System.out.println("\nPROGRAM BINARY TREE PADA SILSILAH KELUARGA\n===================================");
        awal:
        while(aksi!=4){
            System.out.println("\nPilih Opsi: ");
            System.out.println("1. Buat silsilah keluarga");
            System.out.println("2. Daftar Anak");
            System.out.println("3. Ketahui hubungan");
            System.out.println("4. Keluar");
            System.out.print("Aksi: ");
            aksi = in.nextInt();
            switch(aksi){
                case 1:
                    if(t.root==null) {
                        t.addNode(new Node("Pangeran", "Pria"));
                        t.addNode(new Node("Fefin", "Pria"));
                        t.addNode(new Node("Aura", "Wanita"));
                        t.addNode(new Node("Ardha", "Pria"));
                        t.addNode(new Node("Audi", "Pria"));
                        t.addNode(new Node("Ega", "Wanita"));
                        t.addNode(new Node("Husnul", "Wanita"));
                        t.addNode(new Node("Putri", "Wanita"));
                        t.addNode(new Node("Fei", "Pria"));
                        t.addNode(new Node("Pramudya", "Pria"));
                        t.addNode(new Node("Galang", "Pria"));
                        t.addNode(new Node("Iyan", "Pria"));
                        t.addNode(new Node("Yud", "Pria"));
                        t.addNode(new Node("Piki", "Pria"));
                        t.addNode(new Node("Rizal", "Pria"));
                        t.addNode(new Node("Fariz", "Pria"));
                        t.addNode(new Node("Indira", "Wanita"));
                        t.addNode(new Node("Zian", "Wanita"));
                        t.addNode(new Node("Putam", "Wanita"));
                        t.addNode(new Node("Raja", "Pria"));
                        t.addNode(new Node("Zaki", "Pria"));
                        System.out.println("Keluarga berhasil ditambahkan ke silsilah");
                    } else {
                        System.out.println("Keluarga sudah dibuat");
                    }
                    continue awal;
                case 2:
                    if(t.root!=null) {
                        t.ke=0;
                        t.daftarAnak(t.root);
                        System.out.println("\nJumlah Keluarga = "+t.jumlahKeluarga+" Orang");
                    }
                    else System.out.println("Buat silsilah keluarga terlebih dahulu, pilih opsi 1");
                    continue awal;
                case 3:
                    if(t.root!=null) {
                        aksi2=true;
                        while(aksi2) {
                            System.out.print("\nMasukkan karakter 'x' untuk kembali ke menu awal");
                            System.out.print("\nNama orang ke-1: ");
                            nama = in.next();
                            System.out.print("Nama orang ke-2: ");
                            nama2 = in.next();
                            if (nama.equals("x") || nama2.equals("x")) aksi2=false;
                            else t.cariHubungan(nama, nama2);
                        }
                    }
                    else System.out.println("Buat silsilah keluarga terlebih dahulu, pilih opsi 1");
                    continue awal;
                case 4:
                    System.out.println("Terima kasih, sampai jumpa");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input Salah, Ulangi");
                    continue awal;
            }
        }
    }
}