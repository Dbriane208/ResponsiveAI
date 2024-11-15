import kotlinx.browser.document
import org.w3c.dom.*

fun createMainContent(): HTMLElement {
    val mainContent = document.createElement("div") as? HTMLDivElement
        ?: throw IllegalStateException("Failed to create main content div")
    mainContent.className = "chat-area"
    mainContent.style.display = "flex"
    mainContent.style.width = "60%"
    mainContent.style.flexDirection = "column"
    mainContent.style.backgroundColor = "#3C1A5B"
    mainContent.style.padding = "16px"
    mainContent.style.flexGrow = "1"
    mainContent.style.justifyContent ="space-between"

    mainContent.appendChild(nameTag())
    mainContent.appendChild(
        responseCard(
            "I need to write a product introduction. I’ve launched a new software project aimed at small businesses.",
            "Dilan K."
        )
    )
    mainContent.appendChild(
        responseCard(
            "Got it! What key points should we focus on? Think about your project's purpose, target audience, and the main benefits of the software. Also, how would you like the tone—formal, casual, or technical?",
            "Response AI"
        )
    )
    mainContent.appendChild(
        responseCard(
            "The target is small business owners with limited tech knowledge, so I’d prefer simple yet professional language. I want to highlight how easy it is to use and how much time it can save.",
            "Dilan K."
        )
    )
    mainContent.appendChild(
        responseCard(
            "Here’s a draft for your product introduction: \"Our software is designed specifically for small business owners, making technology easy and accessible. With an intuitive interface, you can streamline daily tasks and save valuable time—no technical expertise required. Start focusing on what really matters: growing your business.\"",
            "Response AI"
        )
    )
    mainContent.appendChild(inputTextArea())

    return mainContent
}

private fun nameTag(): HTMLElement {
    val nameTag = document.createElement("div") as? HTMLDivElement
        ?: throw IllegalStateException("Failed to create name tag div")
    nameTag.className = "name-tag"
    nameTag.style.fontSize = "24px"
    nameTag.style.color = "white"
    nameTag.style.marginBottom = "16px"
    nameTag.innerHTML = "Product Introduction"
    return nameTag
}

private fun responseCard(text: String, author: String): HTMLElement {
    val container = document.createElement("div") as? HTMLDivElement
        ?: throw IllegalStateException("Failed to create container div")
    container.style.display = "flex"
    container.style.flexDirection = "column"
    container.style.alignItems = if (author == "Response AI") "flex-start" else "flex-end"
    container.style.marginBottom = "12px"


    val card = document.createElement("div") as? HTMLDivElement
        ?: throw IllegalStateException("Failed to create response card div")
    card.className = "response-card"
    card.style.display = "flex"
    card.style.flexDirection = "column"
    card.style.backgroundColor = if (author == "Response AI") "#57397D" else "#4A2E6E"
    card.style.color = "white"
    card.style.padding = "12px"
    card.style.borderRadius = "8px"
    card.style.maxWidth = "60%"
    card.style.border = "2px solid #8d2b9c"

    card.innerHTML = """
        <div style="font-size: 16px; margin-top: 4px;">$text</div>
    """.trimIndent()


    val authorElement = document.createElement("div") as? HTMLDivElement
        ?: throw IllegalStateException("Failed to create author div")
    authorElement.style.fontSize = "12px"
    authorElement.style.color = "#AAAAAA"
    authorElement.style.marginTop = "4px"
    authorElement.style.alignSelf = if (author == "Response AI") "flex-start" else "flex-end"
    authorElement.textContent = author


    container.appendChild(card)
    container.appendChild(authorElement)

    return container
}


private fun inputTextArea(): HTMLElement {
    val inputContainer = document.createElement("div") as HTMLDivElement
    inputContainer.className = "input-text-area"
    inputContainer.style.apply {
        display = "flex"
        marginTop = "16px"
        fontSize = "16px"
    }


    val styleElement = document.createElement("style")
    styleElement.textContent = """
        .input-box::placeholder {
            font-size: 16px; 
            color: lightgray;
            text-align: left; /* Horizontal start */
            line-height: 30px; /* Matches the height of the input box for vertical center */
        }
    """.trimIndent()
    document.head?.appendChild(styleElement)


    val inputBox = document.createElement("input") as HTMLInputElement
    inputBox.apply {
        className = "input-box"
        type = "text"
        placeholder = "Type your message here..."
        style.apply {
            flexGrow = "1"
            height = "30px"
            padding = "8px"
            borderRadius = "8px"
            fontSize = "16px"
            border = "1px solid #57397D"
            backgroundColor = "#4A2E6E"
            color = "white"
            textAlign = "left"
        }
    }


    val sendButton = document.createElement("button") as HTMLButtonElement
    sendButton.apply {
        className = "send-button"
        textContent = "Generate"
        style.apply {
            marginLeft = "8px"
            padding = "8px 16px"
            borderRadius = "8px"
            border = "none"
            backgroundColor = "#FF00FF"
            color = "white"
            cursor = "pointer"
        }
    }

    inputContainer.appendChild(inputBox)
    inputContainer.appendChild(sendButton)
    return inputContainer
}

