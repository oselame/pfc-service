package br.com.softal.pfc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.softal.pfc.dto.UltimapartidaDTO;
import br.com.softal.pfc.service.PartidaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Controller
@RequestMapping("/partidas")
@Api(value = "Partida", produces = "application/json")
public class PartidaController {
	
	@Autowired
	private PartidaService partidaService;	
	
	@GetMapping("/ultimaPartida")
	@ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Partida - Busca dados da última partida")
    @ApiResponses(value = { @ApiResponse(code = 200, response = UltimapartidaDTO.class, message = "Operação realizada."), 
                            @ApiResponse(code = 400, message = "Argumentos inválidos."), 
                            @ApiResponse(code = 401, message = "Sem permissão."), 
                            @ApiResponse(code = 500, message = "Erro durante o processamento.") })

	public UltimapartidaDTO findUltimaPartidaResultado() {
		return partidaService.findUltimaPartidaResultado();
	}
}
