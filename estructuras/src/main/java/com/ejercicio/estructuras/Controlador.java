package com.ejercicio.estructuras;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {
	@PostMapping("/parImpar")
	public String ejercicio1(@RequestParam int numero) {
		if (numero % 2 == 0) {
			return "<h1>El número es par</h1>";
		}
		else {
			return "<h1>El número es impar</h1>";
		}

	}
	@PostMapping("/tablaMultiplicar")
	public String ejercicio2 (@RequestParam int numero) {
	    String tablaMulti = "";
	    int resultado = 0;
	    
	    if (numero > 10 || numero < 1) {
	        return "<h2>Introduce valores entre 1 y 10</h2> <br> <a href='tabla_multiplicar.html'>Volver</a>";
	    } else {
	        for (int i = 1; i <= 10; i++) {
	            resultado = numero * i;
	            tablaMulti += "<tr> <td>" + numero + " x " + i + " = " + resultado + "</td></tr>";
	        }
	    }
	    return "<table border='1'>" + tablaMulti + "</table>";
	}
	
	@PostMapping("/promedioCalificaciones")
	public String ejercicio3 (@RequestParam String calificaciones) {
		String[] arrayNotas = calificaciones.split(",");
		int[] arrayNotasInt = new int[arrayNotas.length];
		int promedio = 0;
		for (int i = 0; i < arrayNotas.length; i++) {
			arrayNotasInt[i] = Integer.parseInt(arrayNotas[i]);
		}
		for (int i = 0; i < arrayNotasInt.length;i++) {
			promedio += arrayNotasInt[i];
		}
		promedio = promedio / arrayNotasInt.length;
		return "<h1>El promedio de todas las notas es de "+promedio+"</h1>";
	}
}
