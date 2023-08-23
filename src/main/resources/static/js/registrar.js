// Call the dataTables jQuery plugin
$(document).ready(function () {});

//fetching the data

const registerUser = async () => {
  //data
  let datos = {};
  datos.apellido = document.getElementById("txtApellido").value;
  datos.nombre = document.getElementById("txtNombre").value;
  datos.email = document.getElementById("txtEmail").value;
  datos.password = document.getElementById("txtPassword").value;
  datos.telefono = document.getElementById("txtNumber").value;
  let repetirPassword = document.getElementById("txtRepeatPassword").value;

  if (repetirPassword != datos.password) {
    alert("diferent password");
    return;
  }

  await fetch("api/usuarios", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(datos),
  });
};
