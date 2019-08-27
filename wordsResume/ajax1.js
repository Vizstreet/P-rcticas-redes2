//console.log("activo");

document.querySelector('#boton').addEventListener('click',traerDatos);

function traerDatos(){
	//console.log("funcion activada");
	const xhttp = new XMLHttpRequest();
	xhttp.open('GET', 'out.txt', true);
	xhttp.send(null);
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){

			document.querySelector('#respuesta').innerHTML = this.responseText;
		}
	}


}