package at.tanguybernard.management_bc.application_core.employee.use_cases

import at.tanguybernard.management_bc.application_core.application.domain.models.Employee
import management_bc.application_core.employee.domain.models.EmployeeId

class EmployeeMapper {

    fun from(employee: CreateEmployeeDto): Employee{
        return Employee(EmployeeId.random(), employee.name, employee.age)
    }

}
