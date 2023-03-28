package com.example.evaluacion.Servicio;

import com.example.evaluacion.Entidad.Producto;

import java.util.ArrayList;

public class Servicio_Producto {

    private ArrayList<Producto> lista = new ArrayList<>();
    Producto producto = new Producto();

    public Servicio_Producto(){
        lista.add(new Producto(1, "banano", "fruta", 1000,5));
        lista.add(new Producto(2, "fresa", "fruta", 500,6));
        lista.add(new Producto(3, "limon", "fruta", 800,10));
        lista.add(new Producto(4, "brocoli", "verdura", 1200,4));
        lista.add(new Producto(5, "pimenton", "verdura", 1800,20));
        lista.add(new Producto(6, "lechuga", "verdura", 2000,3));
        lista.add(new Producto(7, "sandia", "fruta", 4500,18));
        lista.add(new Producto(8, "pera", "fruta", 700,34));
        lista.add(new Producto(9, "mora", "fruta", 400,21));
        lista.add(new Producto(10, "cebolla", "verdura", 950,25));
    }

    public ArrayList<Producto> listar(){
        return lista;
    }

    public boolean actualizar(Producto produc){
        boolean result = false;
        for (int cont = 0; cont < lista.size(); cont++){
            if(lista.get(cont).getCodigo() == produc.getCodigo()){
                result = true;
                lista.set(cont,produc);
            }
        }
        return result;
    }
    public void total(){
        double iva;
        for(Producto i: lista){
            i.setTotal(i.getPrecio() * i.getCantidad());
            iva = i.getTotal() * 0.19;
            i.setTotal_Iva(i.getTotal() + iva);
        }

    }
    public boolean actualizar_descuento(String categoria){
        double cont = 0;
        boolean result = false;
        double desc = 0.05, descPro,tot;
        cont += desc;
        for(Producto i: lista){
            if(i.getCategoria().equals(categoria)){
                result = true;
                descPro = i.getPrecio() * cont;
                tot = i.getPrecio() - descPro;
                System.out.println("tot ;" + tot);
                i.setPrecio(tot);
                i.setDescuento(descPro);

            }
        }
        return  result;
    }
}
