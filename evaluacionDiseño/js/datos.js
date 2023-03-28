$(document).ready(function(){
    //alert("Holaaaa")
    $("#Listar").on("click", function(){
        let tabla = document.querySelector("#tabla")
        tabla.innerHTML = "<thead><th>Codigo</th><th>Nombre</th><th>Categoria</th><th>Precio</th><th>Cantidad</th><th>Total</th><th>Total iva</th><th>Descuento</th></thead>";
        $.ajax({
            url: "http://localhost:8080/listar",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta){
                console.log(respuesta);
                for (i = 0; i <= respuesta.length; i++){
                    console.log(respuesta[i])
                    tabla.innerHTML += '<tr><td>' + respuesta[i].codigo + '</td><td>' +
                    respuesta[i].nombre + '</td><td>'+
                    respuesta[i].categoria + '</td><td>'+
                    respuesta[i].precio + '</td><td>'+
                    respuesta[i].cantidad + '</td><td>'+
                    respuesta[i].total + '</td><td>'+
                    respuesta[i].total_Iva + '</td><td>'+
                    respuesta[i].descuento + '</td></tr>'
                    
                }
                
            }
        })
    });
    
    $('#Actualizar').on('click', function(){
        let datos = {
            codigo : $('#codigo').val(),
            nombre : $('#nombre').val(),
            categoria : $('#categoria').val(),
            precio : parseInt($('#precio').val()),
            cantidad : parseInt($('#cantidad').val())  
        }
        console.log(datos);
        let datosEnvio = JSON.stringify(datos);
        console.log(datosEnvio);
        $.ajax({
            url: "http://localhost:8080/actualizar",
            type: "PUT",
            data: datosEnvio,
            contentType: "application/JSON",
            /* dataType: "JSON", */
            success: function(respuesta) {
                alert(respuesta);
            }
        });
    });

    $('#ActualizarDescuento').on('click', function(){
        let categoria = $('#categ').val();
        $.ajax({
            url: "http://localhost:8080/actualizar_descuento/" + categoria,
            type: "PUT",
            contentType: "application/JSON",
            /* dataType: "JSON", */
            success: function(respuesta) {
                alert(respuesta);
            }
        });
    });
});