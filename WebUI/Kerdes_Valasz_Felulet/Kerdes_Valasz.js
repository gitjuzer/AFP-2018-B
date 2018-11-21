var countdownNumberEl = document.getElementsByClassName("countdown-number");
var countdown = 30;

countdownNumberEl.textContent = countdown.toString();

setInterval(function() {
  countdown = --countdown <= 0 ? 30 : countdown;
  countdownNumberEl[0].textContent = countdown.toString();
  countdownNumberEl[1].textContent = countdown.toString();
}, 1000);
