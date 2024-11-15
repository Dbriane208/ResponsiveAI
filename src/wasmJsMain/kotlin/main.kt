import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement

fun main() {
    document.body?.landingPage()
}

fun Element.landingPage() {
    val container = (document.createElement("div") as HTMLDivElement).apply {
        className = "landing-page-container"
        style.display = "flex"
        style.flexDirection = "row"
        style.height = "100vh"
        style.width = "100vw"
    }

    // Add the sections
    container.appendChild(createSidebar())
    container.appendChild(createMainContent())
    container.appendChild(createFiltersPanel())

    // Append the container to the body
    appendChild(container)
}