package com.multiplex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dto.MultiplexDetailsDto;
import com.multiplex.dto.MultiplexDto;
import com.multiplex.model.MultiplexModel;
import com.multiplex.model.ScreenModel;
import com.multiplex.repository.MultiplexRepository;
import com.multiplex.repository.ScreenRepository;

@Service
public class MultiplexServiceImp implements MultiplexService {

	@Autowired
	private MultiplexRepository multiplexRepo;

	@Autowired
	private ScreenRepository screenRepo;

	public MultiplexDetailsDto addMultiplexDetails(MultiplexDto multiplexDto) {

		Optional<MultiplexModel> multiplex = multiplexRepo
				.findByMultiplexNameAndLocation(multiplexDto.getMultiplexName(), multiplexDto.getLocation());

		if (multiplex.isEmpty()) {
			MultiplexModel newMultiplex = multiplexRepo.save(new MultiplexModel(null, multiplexDto.getMultiplexName(),
					multiplexDto.getLocation(), multiplexDto.getNumberOfScreens()));

			if (newMultiplex != null) {

				for (int i = 1; i <= multiplexDto.getNumberOfScreens(); i++) {
					screenRepo.save(new ScreenModel(null, "S" + i, newMultiplex.getMultiplexId(), null));
				}

				List<ScreenModel> screenObj = screenRepo.findByMultiplexId(newMultiplex.getMultiplexId());
				List<String> screens = getScreens(screenObj);

				return new MultiplexDetailsDto(newMultiplex.getMultiplexId(), newMultiplex.getMultiplexName(),
						newMultiplex.getLocation(), newMultiplex.getNumberOfScreens(), screens);
			}

		}
		return null;
	}

	public List<String> getScreens(List<ScreenModel> screenList) {
		List<String> screens = new ArrayList<>();
		screens = screenList.stream().map(ScreenModel::getScreenName).collect(Collectors.toList());
		return screens;
	}

	public String deleteMultiplex(MultiplexDto multiplexDto) {
		if (multiplexDto.getMultiplexId() != null) {
			String multiplexName = multiplexDto.getMultiplexName();
			Optional<MultiplexModel> multiplexObj = multiplexRepo.findById(multiplexDto.getMultiplexId());
			if (multiplexObj.isPresent()) {
				List<ScreenModel> screenObj = screenRepo.findByMultiplexId(multiplexDto.getMultiplexId());
				// screenObj.forEach(obj ->
				// screenRepo.deleteById(multiplexDto.getMultiplexId()));
				if (screenObj != null)
					screenRepo.deleteAll(screenObj);
				multiplexRepo.deleteById(multiplexDto.getMultiplexId());
				return multiplexName;
			}
		}
		return null;

	}

}
