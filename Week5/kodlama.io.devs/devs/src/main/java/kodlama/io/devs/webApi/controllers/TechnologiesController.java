package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.GetAllTechnologiesRequest;
import kodlama.io.devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}

	@GetMapping("/getallTechnologiesByProgrammingLanguageId")
	public List<GetAllTechnologiesResponse> getAllByProgrammingLanguageId(
			GetAllTechnologiesRequest getAllTechnologiesRequest) {
		return technologyService.getAllByProgrammingLanguageId(getAllTechnologiesRequest);
	}

	@PostMapping("/addTechnologiesByProgrammingLanguageId")
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		technologyService.add(createTechnologyRequest);
	}

	@PutMapping("/updateTechnology")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(updateTechnologyRequest);
	}

	@DeleteMapping("/deleteTechnology")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyService.delete(deleteTechnologyRequest);
	}

}
