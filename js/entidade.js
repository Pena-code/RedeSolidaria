const API_URL = "http://192.168.11.27:8080/redesolidaria/api/";
// buttons
let btnAdd;
let btnUpdate;
let btnReset;
window.onload = function () {
        fillWelcome(2);
};
function fillWelcome(id){
    const prest = document.getElementById('welcome');
    fetch("http://192.168.11.27:8080/redesolidaria/api/entidade/" + id) //colocar o ID
    .then ((response) => response.json())
    .then((entidade) => {prest.innerHTML = ('<h1>Benvindo ' + entidade.nome + '</h1>');})
}