window.onload = function() {
    const total = document.getElementById("total");
    total.innerHTML < 0 ? total.style.color = "rgb(255, 0, 0)" : total.style.color = "rgb(0, 204, 0)";

    const costs = document.getElementsByClassName("costs");
    for (let i = 0; i < costs.length; i++) {
        if (costs[i].innerHTML < 0) {
            costs[i].style.backgroundColor = "rgb(255, 153, 153)";
        } else if (costs[i].innerHTML > 0) {
            costs[i].style.backgroundColor = "rgb(153, 255, 153)";
        }
    }
}

