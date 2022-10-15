package at.tanguybernard.management_bc.application_core.application.use_cases

import at.tanguybernard.management_bc.application_core.employee.use_cases.EmployeeMapper
import at.tanguybernard.management_bc.application_core.ports.EmployeeRepository
import at.tanguybernard.management_bc.application_core.employee.use_cases.CreateEmployeeDto

class CreateEmployee(
    private val mapper: EmployeeMapper,
    private val employeeRepository: EmployeeRepository) {


    fun createEmployee(employeeDto: CreateEmployeeDto){

        val employee = mapper.from(employeeDto)
        employeeRepository.save(employee);



    }

}