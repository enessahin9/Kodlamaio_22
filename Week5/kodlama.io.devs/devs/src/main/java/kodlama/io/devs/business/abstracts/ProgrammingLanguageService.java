package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.GetByIdProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.responses.GetByIdProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	List<GetAllProgrammingLanguagesResponse> getAll();

	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;

	void update(UpdateProgrammingLanguageRequest updateProgramminLanguageRequest);

	void delete(DeleteProgrammingLanguageRequest deleteProgramminLanguageRequest);

	GetByIdProgrammingLanguageResponse getById(GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest);
}