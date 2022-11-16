package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.GetAllTechnologiesRequest;
import kodlama.io.devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository,
			ProgrammingLanguageRepository programmingLanguageRepository) {
		this.technologyRepository = technologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllTechnologiesResponse> getAllByProgrammingLanguageId(
			GetAllTechnologiesRequest getAllTechnologiesRequest) {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> technologiesResponses = new ArrayList<GetAllTechnologiesResponse>();

		for (Technology technology : technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();

			if (getAllTechnologiesRequest.getId() == technology.getProgrammingLanguage().getId()) {
				responseItem.setId(technology.getId());
				responseItem.setName(technology.getName());

				technologiesResponses.add(responseItem);
			}
		}

		return technologiesResponses;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();

		technology.setName(createTechnologyRequest.getName());
		this.technologyRepository.save(technology);
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = technologyRepository.findById(updateTechnologyRequest.getTechnologyId()).get();

		technology.setName(updateTechnologyRequest.getTechnologyName());
		this.technologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		ProgrammingLanguage language = programmingLanguageRepository.findById(deleteTechnologyRequest.getId()).get();
		Technology technology = technologyRepository.findById(deleteTechnologyRequest.getId()).get();

		technology.setId(language.getId());
		this.technologyRepository.delete(technology);
	}

}