package domain.saga

import domain.model.Application
import infrastructure.ApplicationRepository
import java.io.File

class DatenSerialisierenUC {
    private val repository: ApplicationRepository = ApplicationRepository()

    fun deserialize(contentAsJson: String): List<Application> {
        return repository.read(contentAsJson)
    }

    fun serialize(applications: List<Application>, file: File) {
        repository.write(applications, file)
    }


}