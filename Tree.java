package praktikum.modul3.tiket2;

public class Tree {
    Node root;
    int jumlahKeluarga=0,ke=0;

    void addNode(Node node){
        jumlahKeluarga++;
        if (root==null){
            root = node;
        }
        else {
            insert(root, node);
        }
    }
    void insert(Node parent, Node child){
        if(child.nama.compareTo(parent.nama) < 0){
            if (parent.first == null){
                child.ortu = parent.nama;
                parent.first = child;
            }
            else
                insert(parent.first, child);
        }
        else{
            if (parent.second == null){
                child.ortu= parent.nama;
                parent.second = child;
            }
            else
                insert(parent.second, child);
        }
    }
    void cariHubungan(String nama, String dari){
        hubung(nama,dari);
        hubung(dari,nama);
    }
    void hubung(String nama, String dari){
        int tingkat=0,selisih;
        String hubungan = null;
        Node bantu = root;
        Node orang1 = search(bantu,nama,tingkat);
        Node orang2 = search(bantu,dari,tingkat);
        selisih=orang1.tingkat-orang2.tingkat;
        if (selisih==0){
            if (orang1.ortu.equalsIgnoreCase(orang2.ortu)){
                if (orang1.gender.equalsIgnoreCase("Pria"))
                    hubungan = "Saudara";
                else hubungan = "Saudari";
            }else{
                Node ortu2=search(root,orang2.ortu,tingkat);
                Node ortu1=search(root,orang1.ortu,tingkat);
                if(ortu2.ortu.equalsIgnoreCase(ortu1.ortu))
                    hubungan="Sepupu 1";
                else hubungan="Sepupu 2";
            }
        }
        if (selisih==-1){
            if(orang2.ortu.equals(orang1.nama)){
                if (orang1.gender.equalsIgnoreCase("Pria"))
                    hubungan="Ayah";
                else hubungan="Ibu";
            } else {
                if (orang1.gender.equalsIgnoreCase("Pria"))
                    hubungan="Paman";
                else hubungan="Bibi";
            }
        }
        else if(selisih==1){
            if((orang2.first!=null&&orang2.first.nama.equalsIgnoreCase(orang1.nama))
                    || (orang2.second!=null&&orang2.second.nama.equalsIgnoreCase(orang1.nama)))
                hubungan="Anak";
            else{
                Node ortu1=search(root,orang1.ortu,tingkat);
                if(ortu1.ortu.equalsIgnoreCase(orang2.ortu))
                    hubungan="Keponakan 1";
                else hubungan="Keponakan 2";
            }
        }
        else if(selisih==-2){
            if (orang1.ortu!=null) {
                Node ortu1=search(root, orang1.ortu, tingkat);
                Node ortu2=search(root,orang2.ortu,tingkat);
                Node kanek=search(root,ortu2.ortu,tingkat);
                if (ortu1.nama.equalsIgnoreCase(kanek.ortu)){
                    if (orang1.gender.equalsIgnoreCase("Pria"))
                        hubungan="Kakek";
                    else hubungan="Nenek";
                }
                else{
                    if (orang1.gender.equalsIgnoreCase("Pria"))
                        hubungan="Kakek";
                    else hubungan="Nenek";
                }
            }
            else{
                if (orang1.gender.equalsIgnoreCase("Pria"))
                    hubungan="Kakek";
                else hubungan="Nenek";
            }
        }
        else if(selisih==2)
            hubungan="Cucu";
        else if(selisih==-3){
            if (orang1.gender.equalsIgnoreCase("Pria"))
                hubungan="Kakek Buyut";
            else hubungan="Nenek Buyut";
        }
        else if(selisih==3)
            hubungan="Cicit";
        else if(selisih==-4)
            if (orang1.gender.equalsIgnoreCase("Pria"))
                hubungan="Kakek Buyut";
            else hubungan="Nenek Buyut";
        else if(selisih==4)
            hubungan="Canggah";
        System.out.println("["+orang1.nama+" adalah "+hubungan+" dari "+orang2.nama+"]");
    }

    Node search(Node root, String nama, int tingkat){
        if(root == null) {
            return null;
        }
        else{
            if (root.nama.compareToIgnoreCase(nama) == 0){
                root.tingkat=tingkat;
                return root;
            }
            else if (root.nama.compareToIgnoreCase(nama) > 0){
                tingkat++;
                return search(root.first, nama,tingkat);
            }
            else {
                tingkat++;
                return search(root.second, nama,tingkat);
            }
        }
    }
    void daftarAnak(Node root){
        if(root != null){
            ke++;
            if (root.first==null&&root.second==null)
                System.out.print("\n"+ke+". "+root.nama+" ("+ root.gender+") : "+" Tidak memiliki anak");
            if(root.first!=null||root.second!=null)
                System.out.print("\n"+ke+". "+root.nama+" ("+ root.gender+") : ");
            if (root.first!=null) {
                System.out.print(root.first.nama+" ("+ root.first.gender+")");
                if (root.second!=null)
                    System.out.print(" dan ");
            }
            if (root.second!=null)
                System.out.print(root.second.nama+" ("+ root.second.gender+")");
            daftarAnak(root.first);
            daftarAnak(root.second);
        }
    }
}