package at.tanguybernard.management_bc.application_core.ports

import at.tanguybernard.management_bc.application_core.application.domain.models.Employee

interface EmployeeRepository {

    fun getEmployees(): List<Employee>

    fun save(employee: Employee)
    fun save(employees: ArrayList<Employee>)
}