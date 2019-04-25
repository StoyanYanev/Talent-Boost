function checkInputIsCorrect(input) {
    if (input === "") {
        return false;
    }
    return true;
}
function checkLengthOfTheInput(input) {
    if (input.length > 50) {
        return false;
    }
    return true;
}
function showErrorMessage(message) {
    var invalideInput = document.getElementById("invalideInput");
    invalideInput.innerHTML = "The daily task can not be empty!";
    invalideInput.style.color = "red";
    invalideInput.style.fontWeight = "bold";
}
function coloringHandler(event) {
    if (event.target.classList.contains("tasks")) {
        event.target.style.color = "red";
    }
}
function decoloringHandler(event) {
    if (event.target.classList.contains("tasks")) {
        event.target.style.color = "black";
    }
}
function setStyleOnClickedLi(event) {
    if (event.target.classList.contains("tasks")) {
        var tar = event.target;
        if (tar.style.textDecoration === "") {
            tar.style.textDecoration = "line-through";
        } else {
            tar.style.textDecoration = "";
        }
    }
}
function hideErrorMessag() {
    var invalideInput = document.getElementById("invalideInput");
    if (invalideInput.innerHTML !== "") {
        invalideInput.innerHTML = ""
    }
}
function createButton() {
    var button = document.createElement("button");
    button.className = "deleteTask";
    button.innerHTML = "Delete";
    button.style.marginLeft = "20px";
    button.addEventListener("click", deleteTask, false);
    return button;
}
function createLi(input) {
    var li = document.createElement("li");
    var button = createButton();
    li.className = "tasks";
    li.style.marginBottom = "10px";
    li.appendChild(document.createTextNode(input));
    li.appendChild(button);
    return li;
}
function appendChildOfUl(input) {
    var ul = document.getElementById("allDailyTasks");
    var li = createLi(input);
    ul.appendChild(li);
}
function addTask() {
    var input = document.getElementById("dailyTask").value;
    if (checkInputIsCorrect(input)) {
        if (checkLengthOfTheInput(input)) {
            hideErrorMessag();
            appendChildOfUl(input);
        } else {
            showErrorMessage("The daily task is too long!");
        }
    } else {
        showErrorMessage("The daily task can not be empty!");
    }
}
function deleteTask(event) {
    var target = event.target;
    var parent = target.parentNode;
    parent.remove();
}
window.onload = function () {
    document.querySelector("#addTask").addEventListener("click", addTask, false);
    document.querySelector("#allDailyTasks").addEventListener("mouseover", coloringHandler, false);
    document.querySelector("#allDailyTasks").addEventListener("mouseout", decoloringHandler, false);
    document.querySelector("#allDailyTasks").addEventListener("click", setStyleOnClickedLi, false);
    document.onkeydown = function () {
        if (window.event.keyCode === 13) {
          addTask();
        }
    }
}