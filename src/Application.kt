package at.tanguybernard

import appModule
import at.tanguybernard.management_bc.presentation.rest.routes.apiRoute
import createEmployeeModule
import employeeRepositoryModule
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import mapper
import myModule
import org.jetbrains.exposed.dao.exceptions.EntityNotFoundException
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@JvmOverloads
fun Application.module(testing: Boolean = false) {


    install(CallLogging)
    install(ContentNegotiation) {
        gson {
        }
        json()
    }
    install(StatusPages) {
        exception<EntityNotFoundException> { call, cause ->
            call.respond(HttpStatusCode.NotFound)
        }

    }
    install(Koin) {
        //modules(myModule, employeeRepositoryModule, mapper,createEmployeeModule)
        modules(appModule)
    }
    // start Koin!
    /*startKoin {
        // declare modules
        modules(myModule)
    }*/



    println("test")



    routing {
        apiRoute()
    }

}