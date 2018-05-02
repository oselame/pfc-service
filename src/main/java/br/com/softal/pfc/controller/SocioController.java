package br.com.softal.pfc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.softal.pfc.dto.SocioAniversarianteDTO;
import br.com.softal.pfc.service.SocioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/socios")
@Api(value = "Socio", produces = "application/json")
public class SocioController {
	
	@Autowired
	private SocioService socioService;	
	
	@GetMapping("/aniversariantes")
	@ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Socio - Busca os aniversariantes")
    @ApiResponses(value = { @ApiResponse(code = 200, response = SocioAniversarianteDTO.class, message = "Operação realizada."), 
                            @ApiResponse(code = 400, message = "Argumentos inválidos."), 
                            @ApiResponse(code = 401, message = "Sem permissão."), 
                            @ApiResponse(code = 500, message = "Erro durante o processamento.") })

	public List<SocioAniversarianteDTO> findAllAniversariantes() {
		return socioService.findAllAniversariantes();
	}
	
}
