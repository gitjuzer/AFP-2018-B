var countdownNumberEl = document.getElementById('countdown-number_left');
var countdown = 30;

countdownNumberEl.textContent = countdown.toString();

setInterval(function() {
  countdown = --countdown <= 0 ? 10 : countdown;

  countdownNumberEl.textContent = countdown.toString();
}, 1000);
