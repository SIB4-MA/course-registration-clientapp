document.addEventListener("DOMContentLoaded", () => {
  const buttonUpdateEL = document.querySelectorAll("#btn-updateStatus");
  const btnSaveEL = document.querySelector("#btn-save");
  const modal = document.querySelector("#update-status-modal");

  buttonUpdateEL.forEach((btn) => {
    btn.addEventListener("click", (e) => {
      const id = e.target.getAttribute("data-id");
      modal.setAttribute("dataId", id);
    });
  });

  btnSaveEL.addEventListener("click", () => {
    const id = modal.getAttribute("dataId");

    const statusRadios = document.getElementsByName("radiostatus");
    let selectedValue = "";

    for (let i = 0; i < statusRadios.length; i++) {
      if (statusRadios[i].checked) {
        selectedValue = statusRadios[i].value;
        break;
      }
    }
    console.log(selectedValue);

    $.ajax({
      method: "PUT",
      url: "rest/transaction/" + id,
      dataType: "JSON",
      contentType: "application/json",
      beforeSend: addCsrfToken(),
      data: JSON.stringify({
        statusUpdate: selectedValue,
      }),
      success: (res) => {
        $("#update-status-modal").modal("hide");
        location.reload();
      },
    });
  });
});
