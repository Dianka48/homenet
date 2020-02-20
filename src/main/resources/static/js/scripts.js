window.onload = function() {
  const deleteButtons = document.getElementsByClassName('delete-button');
  for (let i = 0; i < deleteButtons.length; i++) {
    deleteButtons[i].addEventListener("click", function () {
      const deleteButton = this;

      fetch('http://localhost:8080/' + deleteButton.getAttribute('data-handler') + '/' + deleteButton.getAttribute('data-id'), {
      	method: 'delete'
      }).then(function(response) {
        if (response.ok) {
          const tr = deleteButton.parentNode.parentNode;
          tr.remove();
        } else {
          response.text().then(function(text) {
            console.log(text);
          })
        }
      }).catch(function(err) {
      	console.log(err);
      });
    });
  }
}

window.onload = function() {
    const totalH3 = document.getElementById('totalH3');
    const total = document.getElementById("total");
    console.log(total.innerHTML);
    total.innerHTML < 0 ? totalH3.style.color = "rgb(255, 0, 0)" : totalH3.style.color = "rgb(0, 204, 0)";
}

