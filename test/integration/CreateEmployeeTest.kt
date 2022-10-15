package integration

import at.tanguybernard.management_bc.presentation.rest.routes.CreateEmployeeRequest
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.testing.*
import kotlin.test.*
import io.ktor.server.application.*
import kotlinx.serialization.json.Json


class CreateEmployeeTest {

    @Test
    fun testRoot() = testApplication {
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        val response = client.post("/api/v1/employees") {
            contentType(ContentType.Application.Json)
            setBody(CreateEmployeeRequest("Jean-Baptiste", 45))
        }
        assertEquals(HttpStatusCode.Created, response.status)
    }


    @Test
    fun testGet() = testApplication {
        val response = client.get("/api/v1/employees")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Hello, world!", response.bodyAsText())
    }
}