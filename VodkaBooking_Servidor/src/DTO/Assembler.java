package DTO;

import java.util.ArrayList;
import java.util.List;

import Data.Vuelo;


public class Assembler {
	public List<VueloDTO> assemble(List<Vuelo> vuelos) {
		List<VueloDTO> VuelosDTO = new ArrayList<>();

		for (Vuelo v : vuelos) {
			VuelosDTO.add(new VueloDTO(v.getOrigen(),v.getDestino(),v.getFecha()));
		}

		System.out.println("* Assembling all flights ...");
		
		return VuelosDTO;
	}
}
