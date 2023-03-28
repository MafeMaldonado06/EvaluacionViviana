package com.example.evaluacion.Controlador;

import com.example.evaluacion.Entidad.Producto;
import com.example.evaluacion.Servicio.Servicio_Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class Controlador_Producto {

    Servicio_Producto servicio = new Servicio_Producto();

    @GetMapping("/listar")
    public ArrayList<Producto> listar(){
        servicio.total();
        return servicio.listar();
    }

    @PutMapping("/actualizar")
    public boolean actualizar(@RequestBody Producto producto){
        return servicio.actualizar(producto);
    }

    @PutMapping("/actualizar_descuento/{cat}")
    public boolean actualizar_descu(@PathVariable("cat") String categoria){
        return servicio.actualizar_descuento(categoria);
    }
}
