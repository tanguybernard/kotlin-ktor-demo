package at.tanguybernard.management_bc.presentation.rest.routes

import at.tanguybernard.management_bc.application_core.application.use_cases.GetEmployees
import at.tanguybernard.management_bc.application_core.application.use_cases.CreateEmployee as CreateEmployeeUseCase
import io.ktor.http.*

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.employees() {

    val getEmployeesUseCase: GetEmployees by inject()
    val createEmployeeUseCase: CreateEmployeeUseCase by inject()


    get("/employees") {
        val employees = getEmployeesUseCase.getEmployees()
        call.respond(employees)
    }

    post("/employees") {
        val employeeRequest = call.receive<CreateEmployeeRequest>()
        createEmployeeUseCase.createEmployee(employeeRequest)
        call.respond(HttpStatusCode.Created)
    }
/*
    delete("book/{id}") {
        val bookId = call.parameters["id"]?.toIntOrNull() ?: throw NotFoundException()
        bookService.deleteBook(bookId)
        call.respond(HttpStatusCode.OK)
    }*/
}