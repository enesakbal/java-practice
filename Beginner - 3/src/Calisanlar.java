
public class Calisanlar {
    
    private String isim;
    private int maas;
    private String departman;

    public Calisanlar(String isim, int maas, String departman) {
        this.isim = isim;
        this.maas = maas;
        this.departman = departman;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }
    
    
    
    public void bilgileri_goster(){
        
        System.out.println("Calisan isim :" + isim);
        System.out.println("Maas :" + maas);
        System.out.println("Departman :" + departman);
    
    }
    
    public void departman_degistir(String yenidepartman){
        
        System.out.println("Departman degistiriliyor....");
        departman = yenidepartman;
        
        System.out.println("Yeni departman :" + departman);
        
        
    }
    
    public void zam_yap(int zam){
        
        maas = getMaas()+zam;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
