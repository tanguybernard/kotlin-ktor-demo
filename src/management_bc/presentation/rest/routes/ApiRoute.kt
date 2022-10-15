package at.tanguybernard.management_bc.presentation.rest.routes

import io.ktor.server.routing.*


fun Routing.apiRoute() {

    route("/api/v1") {
        employees()
    }
}