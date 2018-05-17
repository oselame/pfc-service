package br.com.softal.pfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.softal.pfc.dto.RankingDTO;
import br.com.softal.pfc.service.RankingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/ranking")
@Api(value = "Ranking", produces = "application/json")
public class RankingController {
	
	@Autowired
	private RankingService rankingService;	
	
	@GetMapping("/quadrimestreAtual")
	@ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Busca ranking do quadrimestre atual")
    @ApiResponses(value = { @ApiResponse(code = 200, response = RankingDTO.class, message = "Operação realizada."), 
                            @ApiResponse(code = 400, message = "Argumentos inválidos."), 
                            @ApiResponse(code = 401, message = "Sem permissão."), 
                            @ApiResponse(code = 500, message = "Erro durante o processamento.") })
	public RankingDTO findRankingQuadrimestreAtual() {
		return rankingService.findRankingQuadrimestreAtual();
	}
	
	@GetMapping("/quadrimestreAnual")
	@ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Busca ranking do quadrimestre anual")
    @ApiResponses(value = { @ApiResponse(code = 200, response = RankingDTO.class, message = "Operação realizada."), 
                            @ApiResponse(code = 400, message = "Argumentos inválidos."), 
                            @ApiResponse(code = 401, message = "Sem permissão."), 
                            @ApiResponse(code = 500, message = "Erro durante o processamento.") })
	public RankingDTO findRankingQuadrimestreAnual() {
		return rankingService.findRankingQuadrimestreAnual();
	}
	
	@GetMapping("/quadrimestre")
	@ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Busca ranking do quadrimestre")
    @ApiResponses(value = { @ApiResponse(code = 200, response = RankingDTO.class, message = "Operação realizada."), 
                            @ApiResponse(code = 400, message = "Argumentos inválidos."), 
                            @ApiResponse(code = 401, message = "Sem permissão."), 
                            @ApiResponse(code = 500, message = "Erro durante o processamento.") })
	public RankingDTO findRankingQuadrimestre(@RequestParam Integer nuAno, @RequestParam Integer cdQuadrimestre) {
		return rankingService.findRankingQuadrimestre(nuAno, cdQuadrimestre);
	}

	@GetMapping("/artilheiro")
	@ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Busca artilheiros do quadrimestre")
    @ApiResponses(value = { @ApiResponse(code = 200, response = RankingDTO.class, message = "Operação realizada."), 
                            @ApiResponse(code = 400, message = "Argumentos inválidos."), 
                            @ApiResponse(code = 401, message = "Sem permissão."), 
                            @ApiResponse(code = 500, message = "Erro durante o processamento.") })
	public RankingDTO findArtilheiroQuadrimestre(@RequestParam Integer nuAno, @RequestParam Integer cdQuadrimestre) {
		return rankingService.findArtilheirosQuadrimestre(nuAno, cdQuadrimestre);
	}	
	
}
