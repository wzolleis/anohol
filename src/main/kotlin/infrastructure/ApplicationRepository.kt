package infrastructure

import domain.model.Application
import domain.model.LeaveType
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

class ApplicationRepository {
    fun read(contentAsJson: String): List<Application> {
        val serializer = Json {
            ignoreUnknownKeys = true
        }
        val content: List<ApplicationData> = serializer.decodeFromString(contentAsJson)
        return content.map { it.toApplication() }
    }

    fun write(appliations: List<Application>, file: File) {
        val appliationData: List<ApplicationJson> = appliations.map { it.toApplicationData() }
        val jsonTxt = Json.encodeToString(appliationData)
        file.writeText(jsonTxt)
    }

    private fun Application.toApplicationData(): ApplicationJson {
        val applicationCore = ApplicationCoreJson(
            id = this.id,
            firstDay = this.firstDay,
            lastDay = this.lastDay,
            workdays = this.workdays,
            leaveType = this.leaveType.name
        )
        val x = this.withrawn
        return ApplicationJson(applicationCore, x)
    }

    private fun ApplicationData.toApplication(): Application {
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