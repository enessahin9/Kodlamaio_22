package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.GetByIdProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.responses.GetByIdProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programminglanguage")
public class ProgrammingLanguageController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		return programmingLanguageService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		programmingLanguageService.add(createProgrammingLanguageRequest);
	}

	@DeleteMapping("/deleteById")
	public void delete(@PathVariable DeleteProgrammingLanguageRequest deleteProgramminLanguageRequest)
			throws Exception {
		programmingLanguageService.delete(deleteProgramminLanguageRequest);
	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateProgrammingLanguageRequest updateProgramminLanguageRequest) throws Exception {
		programmingLanguageService.update(updateProgramminLanguageRequest);
	}

	@GetMapping("getById")
	public GetByIdProgrammingLanguageResponse getById(
			GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) {
		return programmingLanguageService.getById(getByIdProgrammingLanguageRequest);
	}
}
