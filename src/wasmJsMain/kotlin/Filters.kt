import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLButtonElement


fun createFiltersPanel(): HTMLDivElement {
    return (document.createElement("div") as HTMLDivElement).apply {
        className = "filters-panel"
        style.display = "flex"
        style.flexDirection = "column"
        style.backgroundColor = "#3C1A5B"
        style.padding = "16px"
        style.width = "20%"
        style.color = "white"
        style.height = "100vh"

        appendChild(responseType())
        appendChild(responseStyle())
        appendChild(age())
        appendChild(personality())
        appendChild(addFilterButton())
    }
}

fun responseType(): HTMLDivElement {
    return (document.createElement("div") as HTMLDivElement).apply {
        className = "filter-section"
        innerHTML = """
            <div style="margin-bottom: 8px; font-size: 16px;">Response Type</div>
            <button style="background-color: #FF00FF; color: white; padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Text</button>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Image</button>
            <button style="padding: 4px 8px; border: none; border-radius: 4px;">Voice</button>
        """.trimIndent()
    }
}

fun responseStyle(): HTMLDivElement {
    return (document.createElement("div") as HTMLDivElement).apply {
        className = "filter-section"
        style.marginTop = "16px"
        innerHTML = """
            <div style="margin-bottom: 8px; font-size: 16px;">Response Style</div>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Voice</button>
            <button style="padding: 4px 8px; border: none; border-radius: 4px;">Voice</button>
        """.trimIndent()
    }
}

fun age(): HTMLDivElement {
    return (document.createElement("div") as HTMLDivElement).apply {
        className = "filter-section"
        style.marginTop = "16px"
        innerHTML = """
            <div style="margin-bottom: 8px; font-size: 16px;">Age</div>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Baby</button>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Child</button>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Teen</button>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Young</button>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Adult</button>
            <button style="padding: 4px 8px; border: none; border-radius: 4px;">Old</button>
        """.trimIndent()
    }
}

fun personality(): HTMLDivElement {
    return (document.createElement("div") as HTMLDivElement).apply {
        className = "filter-section"
        style.marginTop = "16px"
        innerHTML = """
            <div style="margin-bottom: 8px; font-size: 16px;">Personality</div>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Optimist</button>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Realist</button>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Dreamer</button>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Analytical</button>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Empath</button>
            <button style="padding: 4px 8px; margin-right: 8px; border: none; border-radius: 4px;">Leader</button>
        """.trimIndent()
    }
}

fun addFilterButton(): HTMLDivElement {
    return (document.createElement("div") as HTMLDivElement).apply {
        className = "filter-button"
        style.marginTop = "16px"
        style.textAlign = "center"

        val button = document.createElement("button") as HTMLButtonElement  // Changed from HTMLDivElement to HTMLButtonElement
        button.className = "add-filter-button"
        button.textContent = "Add Filter"  // Changed from innerHTML to textContent for better practice
        button.style.apply {
            padding = "8px 16px"
            backgroundColor = "#FF00FF"
            color = "white"
            border = "none"
            borderRadius = "8px"
            cursor = "pointer"
        }

        appendChild(button)
    }
}