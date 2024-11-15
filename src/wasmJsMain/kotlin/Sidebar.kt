import kotlinx.browser.document
import org.w3c.dom.HTMLDivElement

fun createSidebar(): HTMLDivElement {
    return (document.createElement("div") as HTMLDivElement).apply {
        className = "sidebar-item"
        style.backgroundColor = "#3C1A5B"
        style.color = "white"
        style.width = "20%"
        style.height = "100vh"
        style.padding = "16px"
        style.display = "flex"
        style.flexDirection = "column"
        style.justifyContent = "space-between"

        appendChild(newChatButton())
        appendChild(latestChats())
        appendChild(icons())
    }
}

private fun newChatButton(): HTMLDivElement {
    return (document.createElement("div") as HTMLDivElement).apply {
        className = "button"
        innerHTML = """
            <button style="
                background-color: #57397D;
                color: white;
                font-size: 16px;
                padding: 10px;
                width: 100%;
                border: none;
                border-radius: 8px;
                cursor: pointer;
                margin-bottom: 16px;
            ">New Chat</button>
        """.trimIndent()
    }
}

private fun latestChats(): HTMLDivElement {
    return (document.createElement("div") as HTMLDivElement).apply {
        className = "latest-chats"
        style.display = "flex"
        style.flexDirection = "column"
        style.justifyContent = "space-evenly"

        innerHTML = """
            <div style="font-size: 14px; margin-bottom: 8px;">Latest Chats</div>
            <ul style="list-style-type: none; padding: 0; font-size: 14px;">
                <li style="margin: 14px 0;">How can I use Figma?</li>
                <li style="margin: 14px 0;">What is the most popular fonts?</li>
                <li style="margin: 14px 0;">Project Mapping tips</li>
                <li style="margin: 14px 0;">AI Development</li>
                <li style="margin: 14px 0;">Marketing Strategy</li>
                <li style="margin: 14px 0;">Movie recommendations?</li>
                <li style="margin: 14px 0;">Workout tips</li>
                <li style="margin: 14px 0;">How to stay productive?</li>
            </ul>
        """.trimIndent()
    }
}

private fun icons(): HTMLDivElement {
    return (document.createElement("div") as HTMLDivElement).apply {
        className = "icons"
        style.marginBottom = "20px"
        innerHTML = """
            <div style="font-size: 14px; margin-top: 16px;">Help</div>
            <div style="font-size: 14px; margin-top: 8px;">Settings</div>
            <div style="font-size: 14px; margin-top: 8px;">Profile</div>
        """.trimIndent()
    }
}
