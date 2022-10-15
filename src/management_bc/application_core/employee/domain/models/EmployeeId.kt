package management_bc.application_core.employee.domain.models

import at.tanguybernard.management_bc.application_core.application.domain.models.Employee
import java.util.*

const val UUID_V4_STRING = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-4[a-fA-F0-9]{3}-[89abAB][a-fA-F0-9]{3}-[a-fA-F0-9]{12}"
val pattern = UUID_V4_STRING.toRegex()

data class EmployeeId(val value: String) {

    init {
        require(pattern.matches(value)) {
            "The ID $value does not match the pattern $pattern."
        }
    }

    companion object{
        fun random() =
            EmployeeId(value = UUID.randomUUID().toString())
    }


}
