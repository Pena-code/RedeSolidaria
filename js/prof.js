const API_URL = "http://192.168.11.27:8080/redesolidaria1/api/";
const local = sessionStorage.getItem("prestadorId");

window.onload = function () {
    fetch(API_URL + 'prestadorsvc/' + local)
        .then((response) => response.json())
        .then((prestadorsvc) => {
            sessionStorage.removeItem("prestadorSvcId");
            populate(prestadorsvc);
        });
};
function populate(prestador) {
    const prest = document.getElementById('welcome');
    prest.innerHTML = ('<h1>Benvindo ' + prestador.nome + '</h1>');
    getServicoId(prestador);
}
function populateTickets(ticket) {
    const lista = document.getElementById("porfazer");
console.log(ticket);
    for (let i = 0; i < ticket.length; i++) {
        const formattedDate = getDate(ticket[i].dataPretendida);
        const row = `<li id="todo${ticket[i].id}" class="w3-bar">
    <span onclick="this.parentElement.style.display='none'" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">✖️</span>
    <span onclick="getTicketById(${ticket[i].id})" class="w3-bar-item w3-button w3-white w3-xlarge w3-right">✔️</span>
    <div class="w3-bar-item">
      <span class="w3-large">${ticket[i].entidade}</span><br>
      <span>${ticket[i].tipoTrabalho} | ${formattedDate}</span>
    </div>
  </li>
        `;
        lista.innerHTML += row;
        escreve.innerHTML += `<p>${tickets[i].tipoTrabalho}</p>`;
    };
}
function getServicoId(prestador) {
    fetch(API_URL + 'servico/')
        .then((response) => response.json())
        .then((servico) => {
            for (let i = 0; i < servico.length; i++) {
                if (servico[i].tipoServico === prestador.servico) {
                    getAllTickets(prestador, servico[i].id);
                    break;
                };
            }
        });
}
function getAllTickets(prestador, servico) {
    fetch(API_URL + 'ticket/emprogresso/' + servico)
        .then((response) => response.json())
        .then((tickets) => {
            populateTickets(tickets);
        });
}

function getDate(data){
    const date = new Date(data);
    const day = date.getDate().toString().padStart(2, '0');
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const year = date.getFullYear();
    return `${day}/${month}/${year}`;
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

function getTicketById(id) {
    fetch(API_URL + "ticket/one/" + id)
        .then((response) => response.json())
        .then((ticket) => {
            updateCalendar(ticket);
        });
}