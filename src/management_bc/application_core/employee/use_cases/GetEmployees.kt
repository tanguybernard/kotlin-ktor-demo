package at.tanguybernard.management_bc.application_core.application.use_cases

import at.tanguybernard.management_bc.application_core.application.domain.models.Employee
import at.tanguybernard.management_bc.application_core.ports.EmployeeRepository

class GetEmployees(private val employeeRepository: EmployeeRepository) {

    fun getEmployees(): List<Employee> {
        return this.employeeRepository.getEmployees()
    }

    fun getEmployeesAllowedToWorkOnSunday(): List<Employee> {
        return this.employeeRepository
            .getEmployees()
            .filter {t-> t.age >= 18}
    }

}