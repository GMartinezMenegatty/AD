package model;

import java.io.Serial;

public class InventarioTenda {
    private Serial Id;
    private Videoxogo IdVideoxogo;
    private float PrezoMayorista;
    private float PrezoVenta;
    private int PorcentaxeOferta;

    public InventarioTenda(Serial Id, Videoxogo IdVideoxogo, float PrezoMayorista, float PrezoVenta, int PorcentaxeOferta) {
        this.Id = Id;
        this.IdVideoxogo = IdVideoxogo;
        this.PrezoMayorista = PrezoMayorista;
        this.PrezoVenta = PrezoVenta;
        this.PorcentaxeOferta = PorcentaxeOferta;
    }

    public void setId(Serial Id) {this.Id = Id;}
    public Serial getId() {return Id;}

    public void setIdVideoxogo() {this.IdVideoxogo = (Videoxogo) Id;}
    public Videoxogo getIdVideoxogo() {return IdVideoxogo;}

    public void setPrezoMayorista(float PrezoMayorista) {this.PrezoMayorista = PrezoMayorista;}
    public float getPrezoMayorista() {return PrezoMayorista;}

    public void setPrezoVenta(float PrezoVenta) {this.PrezoVenta = PrezoVenta;}
    public float getPrezoVenta() {return PrezoVenta;}

    public void setPorcentaxeOferta(int PorcentaxeOferta) {this.PorcentaxeOferta = PorcentaxeOferta;}
    public int getPorcentaxeOferta() {return PorcentaxeOferta;}

    public String toString() {
        return "(" + IdVideoxogo + ")" + ", " + PrezoMayorista + ", " + PrezoVenta + ", " + PorcentaxeOferta;
    }
}
