package model;

import java.io.Serial;

public class InventarioTenda {
    private int Id;
    private int IdVideoxogo;
    private double PrezoMayorista;
    private double PrezoVenta;
    private int PorcentaxeOferta;

    public InventarioTenda(int Id, int IdVideoxogo, double PrezoMayorista, double PrezoVenta, int PorcentaxeOferta) {
        this.Id = Id;
        this.IdVideoxogo = IdVideoxogo;
        this.PrezoMayorista = PrezoMayorista;
        this.PrezoVenta = PrezoVenta;
        this.PorcentaxeOferta = PorcentaxeOferta;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setIdVideoxogo(int IdVideoxogo) {
        this.IdVideoxogo = IdVideoxogo;
    }

    public int getIdVideoxogo() {
        return IdVideoxogo;
    }

    public void setPrezoMayorista(double PrezoMayorista) {
        this.PrezoMayorista = PrezoMayorista;
    }

    public double getPrezoMayorista() {
        return PrezoMayorista;
    }

    public void setPrezoVenta(double PrezoVenta) {
        this.PrezoVenta = PrezoVenta;
    }

    public double getPrezoVenta() {
        return PrezoVenta;
    }

    public void setPorcentaxeOferta(int PorcentaxeOferta) {
        this.PorcentaxeOferta = PorcentaxeOferta;
    }

    public int getPorcentaxeOferta() {
        return PorcentaxeOferta;
    }

}
