package com.diplom.kozlov.rest;

import com.diplom.kozlov.db.dto.VesselDto;
import com.iba.kozlov.web.VesselDtoJson;

public class Mapper {

	public VesselDtoJson vesselDtoToDtoJson(VesselDto vesselDtoItem) {
		VesselDtoJson vesselDtoJson = new VesselDtoJson();
		vesselDtoJson.setId(vesselDtoItem.getId());
		vesselDtoJson.setLength(vesselDtoItem.getLength());
		vesselDtoJson.setLoadCapacity(vesselDtoItem.getLoadCapacity());
		vesselDtoJson.setType(vesselDtoItem.getType());
		return vesselDtoJson;
	}

}
