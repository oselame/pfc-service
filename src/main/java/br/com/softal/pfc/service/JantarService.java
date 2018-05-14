package br.com.softal.pfc.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.softal.pfc.dto.JantaDTO;
import br.com.softal.pfc.dto.JantaJsonDTO;
import br.com.softal.pfc.dto.SocioJantaDTO;
import br.com.softal.pfc.exception.PfcException;

@Service
public class JantarService {

	private String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}
	
/*	private static JantaJsonDTO gerar() {
		JantaJsonDTO dto = new JantaJsonDTO();
		SocioJantaDTO socioJantaDTO = new SocioJantaDTO();
		socioJantaDTO.getSocios().add("xxx");
		socioJantaDTO.getSocios().add("yyyy");
		socioJantaDTO.getDatas().add("aaaa");
		socioJantaDTO.getDatas().add("bbbb");
		socioJantaDTO.getDatas().add("cccc");
		
		dto.getJantas().add(socioJantaDTO);
		dto.getJantas().add(socioJantaDTO);
		dto.getJantas().add(socioJantaDTO);
		return dto;
	}*/
	
	
	public JantaJsonDTO readJsonWithObjectMapper(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JantaJsonDTO emp = objectMapper.readValue(json, JantaJsonDTO.class);
        return emp;
    }


	private JantaJsonDTO carregaDadosJson() throws FileNotFoundException {
		try {
			URL urlObject = new URL("http://www.peladafc.com.br/fotos/jantas.json");
			URLConnection urlConnection = urlObject.openConnection();
			InputStream inputStream = urlConnection.getInputStream();
			
			String data = readFromInputStream(inputStream);
			return readJsonWithObjectMapper(data);
		} catch (Exception e) {
			throw new FileNotFoundException(e.getMessage());
		}
	}
	
	public List<JantaDTO> findAllJantas() {
		List<JantaDTO> listRetorno = new ArrayList<JantaDTO>();
		try {
			Date dtAtual = Calendar.getInstance().getTime();
			
			JantaJsonDTO jantaJson = carregaDadosJson();
			Map<String, String> datas = new HashMap<>();
			for ( SocioJantaDTO dto : jantaJson.getJantas() ) {
				for (String key: dto.getDatas()) {
					datas.put(key, dto.getSociosFmt());
				}
			}
			
			for (String key: datas.keySet()) {
				String[] vDia = key.split("/");
				Calendar dia = Calendar.getInstance();
				dia.set(Calendar.DAY_OF_MONTH, Integer.valueOf(vDia[0]));
				dia.set(Calendar.MONTH, Integer.valueOf(vDia[1]) - 1);
				dia.set(Calendar.YEAR, Integer.valueOf(vDia[2]));
				
				if (dia.getTimeInMillis() > dtAtual.getTime() ) {					
					JantaDTO janta = new JantaDTO();
					janta.setData( key );
					janta.setSocios( datas.get(key) );
					listRetorno.add(janta);
				}
			}
			Collections.sort(listRetorno, new Comparator<JantaDTO>() {
				@Override
				public int compare(JantaDTO o1, JantaDTO o2) {
					return o1.getDate().compareTo(o2.getDate());
				}
			});
		} catch (Exception e) {
			throw new PfcException(e.getMessage());
		}
		
		return listRetorno;
	}


}
