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
