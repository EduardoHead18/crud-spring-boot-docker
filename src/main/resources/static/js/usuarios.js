// Call the dataTables jQuery plugin
$(document).ready(function () {
  loadingUser();
  $("#usuarios").DataTable();
});

//fetching the data
const loadingUser = async () => {
  const response = await fetch("api/usuarios");
  const responseJson = await response.json();

  let listadoHtml = "";
  responseJson.map((item) => {
    let buttonDelete = `<a href='#' onclick=deleteUser(${item.id}) class='btn btn-danger btn-circle'><i class='fas fa-trash'></i></a>`;
    let userStructureHtml = `<tr><td>${item.id}</td><td>${item.nombre}</td><td>${item.email}</td><td>${item.telefono}</td><td>${buttonDelete}</td></tr>`;
    listadoHtml += userStructureHtml;
  });
  document.querySelector("#usuarios tbody").outerHTML = listadoHtml;
};

const deleteUser = async (id) => {
  // code
  if (!confirm("Quieres eliminar un usuario?")) {
    return;
  }

  const response = await fetch("api/usuarios/" + id, {
    method: "DELETE",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });
  location.reload()
};
