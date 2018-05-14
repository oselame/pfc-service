package br.com.softal.pfc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.softal.pfc.dto.QuadrimestreDTO;
import br.com.softal.pfc.service.QuadrimestreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/quadrimestre")
@Api(value = "Quadrimestre", produces = "application/json")
public class QuadrimestreController {
	
	@Autowired
	private QuadrimestreService service;	
	
	@GetMapping("/lista")
	@ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Busca a lista de quadrimestres do ano atual")
    @ApiResponses(value = { @ApiResponse(code = 200, response = QuadrimestreDTO.class, message = "Operação realizada."), 
                            @ApiResponse(code = 400, message = "Argumentos inválidos."), 
                            @ApiResponse(code = 401, message = "Sem permissão."), 
                            @ApiResponse(code = 500, message = "Erro durante o processamento.") })
	public List<QuadrimestreDTO> findListaQuadrimestre(Integer nuAno) {
		return service.findListaQuadrimestre(nuAno);
	}
	
	@GetMapping("/atual")
	@ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Busca o quadrimestre atual")
    @ApiResponses(value = { @ApiResponse(code = 200, response = QuadrimestreDTO.class, message = "Operação realizada."), 
                            @ApiResponse(code = 400, message = "Argumentos inválidos."), 
                            @ApiResponse(code = 401, message = "Sem permissão."), 
                            @ApiResponse(code = 500, message = "Erro durante o processamento.") })
	public QuadrimestreDTO findQuadrimestreAtual() {
		return service.findQuadrimestreAtual();
	}
}
