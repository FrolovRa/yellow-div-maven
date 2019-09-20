let intervalId;

function buttonPressed(button) {
  $.ajax({
    url: "/compute",
    type: "POST",
    data: {
      "operation": button.value,
      "digitOne": $('#digit-one').val(),
      "digitTwo": $('#digit-two').val()
    },
    cache: false
  }).done(function(data) {
    console.log(data);
    if(data.number > 999){
        alert("Число " + data.number);
        $("#display").html("+∞");
    } else if(data.number <= 0 ) {
        alert("Число получилось меньшим или равным 0");
        return false;
    } else {
        $("#display").html(data.number);
    }
    blinking(data.number, data.color);
  }).fail(function(xhr) {
    console.log(xhr);
    let errorMessage = xhr.status + ': ' + xhr.responseText;
    alert('Error ' + errorMessage);
  });
}

function blinking(count, blinkColor) {
  let display = $("#display");
  let changeColor;
  let x = 0;


  if(intervalId !== undefined){
      clearInterval(intervalId);
      display.removeClass();
  }

  if(blinkColor === "red"){
        changeColor = "background-red";
  } else {
        changeColor = "background-green";
  }

  intervalId =  window.setInterval(function () {
    if(++x === count * 2)
      clearInterval(intervalId);

    if(x % 2 === 0){
        display.removeClass(changeColor);
    } else {
      display.addClass(changeColor);
    }
  }, 300)
}

