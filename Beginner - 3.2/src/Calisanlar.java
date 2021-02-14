
public class Calisanlar {

    private String isim;
    int maas;

    public Calisanlar(String isimString, int maas) {
        this.isim = isimString;
        this.maas = maas;
    }

    public String getIsimString() {
        return isim;
    }

    public void setIsimString(String isimString) {
        this.isim = isimString;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public void bilgileri_goster(){
        System.out.println("Isim :" + isim);
        System.out.println("Maaş : " + maas);
         
    }
    
    


    
}
