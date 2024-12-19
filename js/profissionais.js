/*const API_URL = "http://192.168.11.27:8080/redesolidaria/api/";
const local = sessionStorage.getItem("prestadorId");
// buttons
let btnAdd;
let btnUpdate;
let btnReset;
window.onload = function () {
    fetch(API_URL)
        .then((response) => response.json())
        .then((tickets) => {
            populateTable(tickets);
        });
        fillWelcome(2);
};
function populateTable(tickets) {
    const lista = document.getElementById("porfazer");

    tickets.forEach((ticket) => {
        const formattedDate = getDate(ticket.dataPretendida);
        const row = `<li id="todo${ticket.id}" class="w3-bar">
    <span onclick="this.parentElement.style.display='none'" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">✖️</span>
    <span onclick="getTicketById(${ticket.id})" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">✔️</span>
    <div class="w3-bar-item">
      <span class="w3-large">${ticket.entidade}</span><br>
      <span>${ticket.tipoTrabalho} | ${formattedDate}</span>
    </div>
  </li>
        `;
        lista.innerHTML += row;
    });
}

function getTicketById(id) {
    fetch("http://192.168.11.27:8080/redesolidaria/api/ticket/one/" + id)
        .then((response) => response.json())
        .then((ticket) => {
            updateCalendar(ticket);
        });
}

function updateCalendar(ticket) {
    const aceite = document.getElementById("aceite");
    aceite.innerHTML += `<div class="dia">
    <h2>${getDate(ticket.dataPretendida)}</h2>
    <ul>
        <li>${ticket.tipoTrabalho}</li>
        <li>${ticket.entidade}</li>
    </ul>
</div>`;
document.getElementById('todo' + ticket.id).style.display='none';
}
function getDate(data){
        const date = new Date(data);
        const day = date.getDate().toString().padStart(2, '0');
        const month = (date.getMonth() + 1).toString().padStart(2, '0');
        const year = date.getFullYear();
        return `${day}/${month}/${year}`;
}
function fillWelcome(id){
    const prest = document.getElementById('welcome');
    fetch("http://192.168.11.27:8080/redesolidaria/api/prestadorsvc/" + id) //colocar o ID
    .then ((response) => response.json())
    .then((prestadorsvc) => {prest.innerHTML = ('<h1>Benvindo ' + prestadorsvc.nome + '</h1>');})
}*/