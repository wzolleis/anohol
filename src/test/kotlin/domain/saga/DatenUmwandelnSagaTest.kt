package domain.saga

import domain.model.Application
import domain.model.LeaveType
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.io.File

class DatenUmwandelnSagaTest : FunSpec({
    test("daten einlesen und umwandeln") {
        val underTest = DatenUmwandelnSaga()
        val fileName = DatenUmwandelnSaga::class.java.getResource("/urlaub_test.json")?.toURI()
        fileName shouldNotBe null
        val file = File(fileName!!)
        val result: List<Application> = underTest.readFile(file)
        result shouldHaveSize 1
        val application = result[0]
        application.firstDay shouldBe "2021-02-09"
        application.lastDay shouldBe "2021-02-09"
        application.leaveType shouldBe LeaveType.COMPENSATORY
        application.id shouldBe "fca12163-f85f-4b3e-afb0-2d3a0c9461e8"
        application.workdays shouldBe 1
    }

})
