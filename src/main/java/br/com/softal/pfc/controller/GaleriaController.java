package br.com.softal.pfc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.softal.pfc.dto.FotogaleriaDTO;
import br.com.softal.pfc.dto.GaleriaDTO;
import br.com.softal.pfc.service.GaleriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Controller
@RequestMapping("/galerias")
@Api(value = "Galeria", produces = "application/json")
public class GaleriaController {
	
	@Autowired
	private GaleriaService galeriaService;	
	
	@GetMapping("/fotos")
	@ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Galerias - Busca a galeria de fotos")
    @ApiResponses(value = { @ApiResponse(code = 200, response = GaleriaDTO.class, message = "Operação realizada."), 
                            @ApiResponse(code = 400, message = "Argumentos inválidos."), 
                            @ApiResponse(code = 401, message = "Sem permissão."), 
                            @ApiResponse(code = 500, message = "Erro durante o processamento.") })
	public List<GaleriaDTO> findGalerias() {
		return galeriaService.findAllGalerias();
	}
	
	@GetMapping("/fotos/{cdGaleria}")
	@ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Galerias - Busca a galeria de fotos")
    @ApiResponses(value = { @ApiResponse(code = 200, response = FotogaleriaDTO.class, message = "Operação realizada."), 
                            @ApiResponse(code = 400, message = "Argumentos inválidos."), 
                            @ApiResponse(code = 401, message = "Sem permissão."), 
                            @ApiResponse(code = 500, message = "Erro durante o processamento.") })
	public List<FotogaleriaDTO> findFotosGaleria(@PathVariable Integer cdGaleria) {
		return galeriaService.findFotosGaleria( cdGaleria );
	}
}
