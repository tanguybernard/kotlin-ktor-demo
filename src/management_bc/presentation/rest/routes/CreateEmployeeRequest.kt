package at.tanguybernard.management_bc.presentation.rest.routes

import at.tanguybernard.management_bc.application_core.employee.use_cases.CreateEmployeeDto

@kotlinx.serialization.Serializable
class CreateEmployeeRequest(override val name: String, override val age: Int) : CreateEmployeeDto {
}