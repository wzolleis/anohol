package infrastructure

import domain.model.Application
import domain.model.LeaveType
import infrastructure.read.ApplicationDataRead
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import infrastructure.write.ApplicationWrite as WriteModel

class ApplicationRepository {
    fun read(contentAsJson: String): List<Application> {
        val serializer = Json {
            ignoreUnknownKeys = true
        }
        val content: List<ApplicationDataRead> = serializer.decodeFromString(contentAsJson)
        return content.map { it.toDomain() }
    }

    fun write(appliations: List<Application>, file: File) {
        val appliationData: List<WriteModel> = appliations.map { it.toWriteModel() }
        val jsonTxt = Json.encodeToString(appliationData)
        file.writeText(jsonTxt)
    }

    private fun Application.toWriteModel(): WriteModel {
        return WriteModel(
            id = this.id,
            firstDay = this.firstDay,
            lastDay = this.lastDay,
            workdays = this.workdays,
            withrawn = this.withrawn,
            leaveType = this.leaveType.name
        )
    }

    private fun ApplicationDataRead.toDomain(): Application {
        val details = this.application.applicationCore
        return Application(
            id = details.id,
            firstDay = details.firstDay,
            lastDay = details.lastDay,
            leaveType = LeaveType.fromString(details.leaveType)
                ?: throw IllegalArgumentException("invalid leave type ${details.leaveType}"),
            withrawn = this.application.withdrawn,
            workdays = details.workdays
        )
    }
}