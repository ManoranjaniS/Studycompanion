function addGoal() {
  const goalInput = document.getElementById("goalInput");
  const goalList = document.getElementById("goalList");
  if (goalInput.value.trim() !== "") {
    const li = document.createElement("li");
    li.textContent = goalInput.value;
    goalList.appendChild(li);
    goalInput.value = "";
  }
}

function addTask() {
  const taskInput = document.getElementById("taskInput");
  const taskList = document.getElementById("taskList");
  if (taskInput.value.trim() !== "") {
    const li = document.createElement("li");
    li.textContent = taskInput.value;
    taskList.appendChild(li);
    taskInput.value = "";
  }
}

function addSchedule() {
  const time = document.getElementById("scheduleTime").value;
  const content = document.getElementById("scheduleInput").value;
  const scheduleList = document.getElementById("scheduleList");
  if (time && content) {
    const li = document.createElement("li");
    li.textContent = `${new Date(time).toLocaleString()} - ${content}`;
    scheduleList.appendChild(li);
    document.getElementById("scheduleTime").value = "";
    document.getElementById("scheduleInput").value = "";
  }
}

function sendMessage() {
  const chatInput = document.getElementById("chatInput");
  const chatBox = document.getElementById("chatBox");
  if (chatInput.value.trim() !== "") {
    const userMsg = document.createElement("div");
    userMsg.textContent = `🧑 You: ${chatInput.value}`;
    chatBox.appendChild(userMsg);

    // Simulated AI response
    const aiMsg = document.createElement("div");
    aiMsg.textContent = `🤖 AI: Stay focused! Let's achieve one goal today.`;
    chatBox.appendChild(aiMsg);

    chatBox.scrollTop = chatBox.scrollHeight;
    chatInput.value = "";
  }
}
