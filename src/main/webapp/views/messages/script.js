function createMessage(message, isUser) {
  const messageContainer = document.getElementById("message-container");

  const messageDiv = document.createElement("div");
  messageDiv.textContent = message;
  messageDiv.classList.add("message");
  messageDiv.classList.add(isUser ? "right" : "left");

  messageContainer.appendChild(messageDiv);

  // Scroll to the bottom to see the latest message
  messageContainer.scrollTop = messageContainer.scrollHeight;
}

function sendMessage() {
  const userMessageInput = document.getElementById("user-message");
  const message = userMessageInput.value.trim();

  if (message !== "") {
    createMessage(message, true);
    userMessageInput.value = "";
  }
}

// Example: Add some initial messages
createMessage("Hello there!", false);
createMessage("Hi! How are you?", true);
