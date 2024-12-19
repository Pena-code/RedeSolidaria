const API = "http://192.168.11.27:8080/redesolidaria/api/";
$(function() {

  var siteSticky = function() {
		$(".js-sticky-header").sticky({topSpacing:0});
	};
	siteSticky();

	var siteMenuClone = function() {

		$('.js-clone-nav').each(function() {
			var $this = $(this);
			$this.clone().attr('class', 'site-nav-wrap').appendTo('.site-mobile-menu-body');
		});


		setTimeout(function() {
			
			var counter = 0;
      $('.site-mobile-menu .has-children').each(function(){
        var $this = $(this);
        
        $this.prepend('<span class="arrow-collapse collapsed">');

        $this.find('.arrow-collapse').attr({
          'data-toggle' : 'collapse',
          'data-target' : '#collapseItem' + counter,
        });

        $this.find('> ul').attr({
          'class' : 'collapse',
          'id' : 'collapseItem' + counter,
        });

        counter++;

      });

    }, 1000);

		$('body').on('click', '.arrow-collapse', function(e) {
      var $this = $(this);
      if ( $this.closest('li').find('.collapse').hasClass('show') ) {
        $this.removeClass('active');
      } else {
        $this.addClass('active');
      }
      e.preventDefault();  
      
    });

		$(window).resize(function() {
			var $this = $(this),
				w = $this.width();

			if ( w > 768 ) {
				if ( $('body').hasClass('offcanvas-menu') ) {
					$('body').removeClass('offcanvas-menu');
				}
			}
		})

		$('body').on('click', '.js-menu-toggle', function(e) {
			var $this = $(this);
			e.preventDefault();

			if ( $('body').hasClass('offcanvas-menu') ) {
				$('body').removeClass('offcanvas-menu');
				$this.removeClass('active');
			} else {
				$('body').addClass('offcanvas-menu');
				$this.addClass('active');
			}
		}) 

		// click outisde offcanvas
		$(document).mouseup(function(e) {
	    var container = $(".site-mobile-menu");
	    if (!container.is(e.target) && container.has(e.target).length === 0) {
	      if ( $('body').hasClass('offcanvas-menu') ) {
					$('body').removeClass('offcanvas-menu');
				}
	    }
		});
	}; 
	siteMenuClone();

});


window.onload=function(){
 fetch(API + 'prestadorsvc')
  .then((response)=> response.json())
  .then((prestadorsvc)=>{
	populateDrop(prestadorsvc);

  });
}
 function populateDrop(prestadorsvc){
	const drop = document.getElementById("dropdownMenu1");
  prestadorsvc.forEach((prestador) => {
	const nome= prestador.nome;
    const row = `<a href="#" onclick="goToPrestador(${prestador.id})" >${nome}</a>`;
        
    drop.innerHTML += row;
  });
  getEntidades();
}
function goToPrestador(id){
  sessionStorage.setItem('prestadorId', id);
  window.location.replace('profissionais.html', true);
}

function getEntidades(){
	fetch(API + 'entidade')
	.then((response)=> response.json())
	.then((entidade)=>{
	  populateDrop1(entidade);
  
	});
}
function populateDrop1(entidade){
	const drop = document.getElementById("dropdownMenu");
  entidade.forEach((ent) => {
    const row = `<a href="entidade.html">${ent.nome}</a>`;
        
    drop.innerHTML += row;
  });
}
function login(nome1){
	const drop = document.getElementById("dropdownMenu1");
	console.log(nome1);
	const entrar= document.getElementById("showPopup");
    closePopup3()
	
	var botao = document.createElement("button");

	// Definindo o texto do botão
	

	// Definindo o ID para o botão (opcional, mas útil para referenciação)
	botao.id = "meu-botao";

	// Definindo a posição do botão
	 // Define a posição como absoluta em relação ao body
	

	// Adicionando o botão ao body da página
	document.getElementById("navbar").appendChild(botao);
	entrar.remove();

}


const popup = document.getElementById('popup');
const showPopupBtn = document.getElementById('showPopup');
const closePopupBtn = document.getElementById('closePopup');
const overlay = document.getElementById('overlay');
const body = document.body;
const voluntario= document.getElementById('voluntario')
const entidade=document.getElementById('entidade')
let div=document.getElementById('1')

const popup2 = document.getElementById('popup2');

const popup3 = document.getElementById('popup3');
// Função para abrir o pop-up
function openPopup() {
    popup.style.display = 'flex';  // Exibe o pop-up
    overlay.style.display = 'block';  // Exibe a camada de fundo com blur
    body.classList.add('blur');  // Aplica o efeito de blur no fundo
}

// Função para fechar o pop-up
function closePopup() {
    popup.style.display = 'none';   // Esconde o pop-up
    overlay.style.display = 'none';  // Esconde a camada de fundo com blur
    body.classList.remove('blur');  // Remove o blur do fundo
}
function closePopup2() {
    popup2.style.display = 'none';   // Esconde o pop-up
    overlay.style.display = 'none';  // Esconde a camada de fundo com blur
    body.classList.remove('blur');  // Remove o blur do fundo
}
function closePopup3() {
    popup3.style.display = 'none';   // Esconde o pop-up
    overlay.style.display = 'none';  // Esconde a camada de fundo com blur
    body.classList.remove('blur');  // Remove o blur do fundo
}
function ent() {
	popup.style.display = "none"; // Fecha o primeiro pop-up
    popup3.style.display = "flex";
	overlay.style.display="block";
	
}

function vol() {
	popup.style.display = "none"; // Fecha o primeiro pop-up
    popup2.style.display = "flex";
	overlay.style.display="block";
}

// Eventos
const dropdownBtn = document.getElementById("dropdownBtn");
const dropdownMenu = document.getElementById("dropdownMenu");

// Toggle dropdown visibility on button click
dropdownBtn.addEventListener("click", function() {
    // Toggle the display property between "none" and "block"
    if (dropdownMenu.style.display === "none" || dropdownMenu.style.display === "") {
        dropdownMenu.style.display = "block";  // Show the dropdown menu
    } else {
        dropdownMenu.style.display = "none";   // Hide the dropdown menu
    }
});

// Close the dropdown if clicked outside
window.addEventListener("click", function(event) {
    if (!dropdownBtn.contains(event.target) && !dropdownMenu.contains(event.target)) {
        dropdownMenu.style.display = "none";  // Hide the dropdown if clicked outside
    }
});
showPopupBtn.addEventListener('click', openPopup);   // Abre o pop-up quando clicar no botão
closePopupBtn.addEventListener('click', closePopup);  // Fecha o pop-up quando clicar no X
overlay.addEventListener('click', closePopup);        // Fecha o pop-up ao clicar no fundo (overlay)
overlay.addEventListener('click', closePopup2);
overlay.addEventListener('click', closePopup3);
closePopupBtn.addEventListener('click', closePopup2);
closePopupBtn.addEventListener('click', closePopup3);

const dropdownBtn1 = document.getElementById("dropdownBtn1");
const dropdownMenu1 = document.getElementById("dropdownMenu1");

// Toggle dropdown visibility on button click
dropdownBtn1.addEventListener("click", function() {
    // Toggle the display property between "none" and "block"
    if (dropdownMenu1.style.display === "none" || dropdownMenu1.style.display === "") {
        dropdownMenu1.style.display = "block";  // Show the dropdown menu
    } else {
        dropdownMenu1.style.display = "none";   // Hide the dropdown menu
    }
});

// Close the dropdown if clicked outside
window.addEventListener("click", function(event) {
    if (!dropdownBtn1.contains(event.target) && !dropdownMenu1.contains(event.target)) {
        dropdownMenu1.style.display = "none";  // Hide the dropdown if clicked outside
    }
});

