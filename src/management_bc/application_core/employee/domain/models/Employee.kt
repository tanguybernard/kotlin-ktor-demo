package at.tanguybernard.management_bc.application_core.application.domain.models

import management_bc.application_core.employee.domain.models.EmployeeId
import java.util.UUID

data class Employee(val id: EmployeeId, val name: String, val age: Int) {


    companion object {
        fun random() =
            Employee(id = EmployeeId(UUID.randomUUID().toString()), name = "Johnny Depp", age = 18)
    }

    init {
        require(name.length > 8) { "The username must be larger than 8 characters." }
    }
}