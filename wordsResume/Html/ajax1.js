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
			processText(this.responseText);
		}
	}


}

function processText(text) {
	var allTexts = text.split("#");
	crearDiccionario(allTexts);
}

function crearDiccionario(arreglo) {
	var diccionario = [];
	var palabras = [];
	for(var index = 0; index < arreglo.length; index++) {
		var aux = arreglo[index].split("\n");
		var diccionarioAuxiliar = {};
		for(var j = 0; j < aux.length; j++ ) {
			var aux2 = aux[j].split(",");
			if(index == 0)
				palabras.push(aux2[0]);
			if(aux2.length != 1 && aux2[0] != undefined) {
				diccionarioAuxiliar[aux2[0]] = aux2[1];
			}
		}
		diccionario.push(diccionarioAuxiliar);
	}
	// console.log(diccionario[0][palabras[1]]);
}

//crearTemplate(){
//	cadena = "";
//	por cada elemento del diccionario
//	cadena += "<div class'Clase'>";
//	cadena += diccionario[0] + " : " +
//	document.getElementById("Id_central").innerHTML = cadena; 
//	return cadena;
//}