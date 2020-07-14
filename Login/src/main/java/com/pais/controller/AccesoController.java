package com.pais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pais.bean.ColeccionMenu;
import com.pais.bus.AccesoBus;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class AccesoController {

	@Autowired
	private AccesoBus accesoBus;

	@ApiOperation(value = "Status token", tags = "seguridad")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Consulta exitosa!"),
			@ApiResponse(code = 404, message = "El cliente ID no existe en la base de datos!"),
			@ApiResponse(code = 500, message = "Error al realizar la consulta en la base de datos!") })
	@GetMapping("/status")
	public boolean status() {

		return true;

	}

	@ApiOperation(value = "Menu opciones", tags = "seguridad")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Consulta exitosa!"),
			@ApiResponse(code = 404, message = "El cliente ID no existe en la base de datos!"),
			@ApiResponse(code = 500, message = "Error al realizar la consulta en la base de datos!") })
	@GetMapping("/menu")
	public List<ColeccionMenu> menu(@RequestHeader(name = "idUsuario", required = true) int idUsuario) {

		return accesoBus.menu(idUsuario);

	}
	
}
