package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.GetByIdProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {

		List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> languagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>();

		for (ProgrammingLanguage programmingLanguage : languages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());

			languagesResponses.add(responseItem);
		}
		return languagesResponses;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		ProgrammingLanguage language = new ProgrammingLanguage();

		if (language.getName().isEmpty()) {
			throw new Exception("Name cannot be empty");
		}

		for (GetAllProgrammingLanguagesResponse languagesResponse : getAll()) {
			if (languagesResponse.getName().equals(language.getName())) {
				throw new Exception("Language already exists");
			}
		}

		this.programmingLanguageRepository.save(language);
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgramminLanguageRequest) {
		ProgrammingLanguage language = new ProgrammingLanguage();

		for (GetAllProgrammingLanguagesResponse languagesResponse : getAll()) {
			if (languagesResponse.getName() == updateProgramminLanguageRequest.getName()) {
				language.setName(updateProgramminLanguageRequest.getName());
			}
		}
		this.programmingLanguageRepository.save(language);
	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgramminLanguageRequest) {
		this.programmingLanguageRepository.deleteById(deleteProgramminLanguageRequest.getId());

	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(
			GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) {
		ProgrammingLanguage language = programmingLanguageRepository.findById(getByIdProgrammingLanguageRequest.getId())
				.get();
		GetByIdProgrammingLanguageResponse languagesResponse = new GetByIdProgrammingLanguageResponse();
		languagesResponse.setId(language.getId());
		return languagesResponse;
	}

}