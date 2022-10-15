import at.tanguybernard.management_bc.application_core.application.use_cases.CreateEmployee
import at.tanguybernard.management_bc.application_core.application.use_cases.GetEmployees
import at.tanguybernard.management_bc.application_core.employee.use_cases.EmployeeMapper
import at.tanguybernard.management_bc.application_core.ports.EmployeeRepository
import at.tanguybernard.management_bc.application_core.ports.stubs.InMemoryEmployeeRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module



val appModule = module {
    single<EmployeeRepository> { InMemoryEmployeeRepository() }
    single {
        EmployeeMapper()
    }
    single { GetEmployees(get()) }
    single { CreateEmployee(get(), get()) }
}

