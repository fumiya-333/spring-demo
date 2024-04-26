const modalBackdrop = document.getElementById("modalBackdrop");
const confirmButton = document.getElementById("confirmButton");
const cancelButton = document.getElementById("cancelButton");
let deleteForm = null;

confirmButton.addEventListener("click", () => {
  deleteForm.submit();
  closeModal();
});

cancelButton.addEventListener("click", () => {
  closeModal();
});

const deleteButtons = document.querySelectorAll('[id^="deleteButton"]');
deleteButtons.forEach((button, index) => {
  button.addEventListener("click", (e) => {
    e.preventDefault();
    const id = button.id.slice(-1);
    deleteForm = document.getElementById(`deleteForm${id}`);
    modalBackdrop.classList.remove("hidden");
  });
});

const closeModal = () => modalBackdrop.classList.add("hidden");
