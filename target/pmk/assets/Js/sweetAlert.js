$("#addBloque").click(function(e){
    e.preventDefault();
    //let accion = 'add'; 
    const datos = {
        idSemana  : $("#idSemana").val(),
        accion : $("#accion").val(),
        diaBloque : $("#diaBloque").val(),
        horaInicioBloque : $("#horaInicioBloque").val(),
        horaFinalizacionBloque : $("#horaFinalizacionBloque").val(),
        estadoBloque : $("#estadoBloque").val()
    } 
    $.ajax({
        url: 'bloque',
        type: 'POST',
        data: datos,
        success:function(resultado){
            console.log(resultado)
            Swal.fire(
                'Registro!',
                'Bloque creado correctamente!',
                'success'
              )
           // recargar();
        }
    })
})

$("#addSemana").click(function(e){
    e.preventDefault();
    //let accion = 'add'; 
    const datos = {
        nombreSemana  : $("#nombreSemana").val(),
        accion : $("#accion").val(),
        fechaInicio : $("#fechaInicio").val(),
        fechaFinalizacion : $("#fechaFinalizacion").val(),
        estadoSemana : $("#estadoSemana").val(),
    } 
    $.ajax({
        url: 'semana',
        type: 'POST',
        data: datos,
        success:function(resultado){
            console.log(resultado)
            Swal.fire(
                'Registro!',
                'Semana creada correctamente!',
                'success'
              )
           // recargar();
        }
    })
})

$("#addCliente").click(function(e){
    e.preventDefault();
    //let accion = 'add'; 
    const datos = {
        nombreCliente  : $("#nombreCliente").val(),
        accion  : $("#accion").val(),
        apellidoCliente : $("#apellidoCliente").val(),
        tipoIdentificacion : $("#tipoIdentificacion").val(),
        identificacionCliente : $("#identificacionCliente").val(),
        direccionCliente : $("#direccionCliente").val(),
        correoCliente : $("#correoCliente").val(),
        telefonoCliente : $("#telefonoCliente").val(),
    } 
    $.ajax({
        url: 'cliente',
        type: 'POST',
        data: datos,
        success:function(resultado){
            console.log(resultado)
            Swal.fire(
                'Registro!',
                'Cliente creado correctamente!',
                'success'
            )
            setTimeout(function () {
                window.location.href = "/pmk/cliente?action=consultar";
            }, 3000)
        }
    })
})

$("#addMascota").click(function(e){
    e.preventDefault();
    //let accion = 'add'; 
    const datos = {
        idCliente  : $("#idCliente").val(),
        accion  : $("#accion").val(),
        nombreMascota  : $("#nombreMascota").val(),
        tipoMascota : $("#tipoMascota").val(),
        razaMascota : $("#razaMascota").val(),
        pesoMascota : $("#pesoMascota").val(),
        comportamientoMascota : $("#comportamientoMascota").val(),
    } 
    $.ajax({
        url: 'mascota',
        type: 'POST',
        data: datos,
        success:function(resultado){
            console.log(resultado)
            Swal.fire(
                'Registro!',
                'Mascota creada correctamente!',
                'success'
              )
           // recargar();
        }
    })
})
///////////////////////////////////////////////////////////
///////////////////////// CITAS ///////////////////////////
///////////////////////////////////////////////////////////


$("#btn_add_cita").click(function(){
    let accion = "add";
    console.log('funciona el boton')
    const datos = {
        tipoServicio : $("#tipoServicio").val(),
        idMascota : $("#idMascota").val(),
        idBloque : $("#idBloque").val(),
        idRecepcionista : $("#idRecepcionista").val(),
        idCliente : $("#idCliente").val(),
        accion
    } 
    $.ajax({
        url: 'cita',
        type: 'POST',
        data: datos,
        success:function(resultado){
            console.log(resultado)
            console.log("regresp")
            Swal.fire(
                'Registro!',
                'Cita creada correctamente!',
                'success'
              )
           recargar();
        }
    })
})


function AlertaEliminar()
{
Swal.fire({
    title: 'Are you sure?',
    text: "You won't be able to revert this!",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes, delete it!'
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire(
        'Deleted!',
        'Your file has been deleted.',
        'success'
      )
    }
  })
}