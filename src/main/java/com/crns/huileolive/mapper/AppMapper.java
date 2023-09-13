package com.crns.huileolive.mapper;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.crns.huileolive.dto.BergerDto;
import com.crns.huileolive.dto.LotoliveDto;
import com.crns.huileolive.dto.MoulinDto;
import com.crns.huileolive.dto.MoulinageDto;
import com.crns.huileolive.entities.Berger;
import com.crns.huileolive.entities.Lotolive;
import com.crns.huileolive.entities.Moulin;
import com.crns.huileolive.entities.Moulinage;
import com.crns.huileolive.entities.Variete;

@Service
public class AppMapper {

	private ModelMapper mapper = new ModelMapper();

	public MoulinageDto mapMoulinage(Moulinage entity) {
		MoulinageDto dto = mapper.map(entity, MoulinageDto.class);
		dto.setMoulin(mapMoulin(entity.getMoulin()));
		dto.setLotOlives(mapLotOlive(entity.getLotolives()));
		Optional<Variete> lotolives = entity.getLotolives().stream().map(o -> o.getVariete()).findAny();
		if (lotolives.isPresent())
			dto.setVariete(lotolives.get().name());
		return dto;
	}

	public List<MoulinageDto> mapMoulinages(List<Moulinage> entities) {
		return entities.stream().map(o -> mapMoulinage(o)).toList();
	}

	public List<LotoliveDto> mapLotOlive(List<Lotolive> entities) {
		return entities.stream().map(o -> mapLotOlive(o)).toList();
	}

	public LotoliveDto mapLotOlive(Lotolive entity) {
		LotoliveDto dto = mapper.map(entity, LotoliveDto.class);
		return dto;
	}

	public MoulinDto mapMoulin(Moulin entity) {
		MoulinDto dto = mapper.map(entity, MoulinDto.class);
		return dto;
	}

	public Moulin mapMoulin(MoulinDto dto) {
		Moulin entity = mapper.map(dto, Moulin.class);
		return entity;
	}

	public List<MoulinDto> mapMoulin(List<Moulin> entities) {
		return entities.stream().map(o -> mapMoulin(o)).toList();
	}

	public BergerDto mapBerger(Berger entity) {
		BergerDto dto = mapper.map(entity, BergerDto.class);
		return dto;
	}

}
