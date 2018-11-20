let countdownNumberEl = document.getElementById('countdown-number_left/right');
let countdown = 10;

countdownNumberEl.textContent = countdown;


setInterval(function() {
  countdown = --countdown <= 0 ? 10 : countdown;

  countdownNumberEl.textContent = countdown;
}, 1000);
