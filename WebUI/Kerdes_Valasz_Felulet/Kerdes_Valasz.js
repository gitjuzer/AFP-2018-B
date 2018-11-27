/*"use strict";
let countdownNumberEl = document.getElementsByClassName('countdown-number');
let animation = document.getElementsByClassName('run-animation');
let countdown = 30;
let Timer;
let helyes;
let Pontszam = 0;
let QuizContainer = document.getElementsByClassName('answer');
let questionOrder = [];
questionOrder.length = 10;
let questionCount = 0;
let questionAsked = 0;

/*
window.onload = function() {
  while (questionCount < questionOrder.length) {
    hideAllExcept(questionOrder[questionAsked]);
    questionCount++;
  }
};
function hideAllExcept(question) {
  $('div.ques').hide();
  $('#ques' + question).show();
}

let circles = document.getElementsByTagName('circle');
    circles[0].style.animation = 'none';
    circles[1].style.animation = 'none';
    setTimeout(function() {
        circles[0].style.animation = null;
        circles[1].style.animation = null;
    }, 100);


setInterval(function() {
  if (countdown = -- countdown < 0 ? 30 : countdown) {
    countdownNumberEl[0].textContent = countdown.toString();
    countdownNumberEl[1].textContent = countdown.toString();
  }
  else if (countdown === 0) {
    TimeRunsOut();
    countdownReset();
  }
}, 1000);



function TimeRunsOut() {
    clearInterval(Timer);

    if (Pontszam === 0) {
      Pontszam = 0;
      questionAsked++;
    }
    else if (Pontszam > 1000) {
      Pontszam -= 300;
      questionAsked++;
    }
    alert('Lejárt az időd! Kattints a továbblépéshez!');
    countdownReset();
    Answer();
}

function GoodAnswer() {
  clearInterval(Timer);
  if (countdown > 20) {
    Pontszam += 600;
    questionAsked++;
  }
  else if (countdown > 10) {
    Pontszam += 300;
    questionAsked++;
  }
  else if (countdown > 0) {
    Pontszam += 150;
    questionAsked++;
  }
  alert('Helyes válasz! Kattints a továbblépéshez!' + questionAsked + ':' + Pontszam);
  countdownReset();
  Answer();
}

function BadAnswer() {
  clearInterval(Timer);
  if (Pontszam === 0) {
    Pontszam = 0;
    questionAsked++;
  }
  else if (Pontszam > 1000) {
    Pontszam -= 500;
    questionAsked++;
  }
  alert('Helytelen válasz! Kattints a továbblépéshez!');
  countdownReset();
  Answer();
}

function Answer() {
  if (questionAsked === questionOrder.length) {
    alert('Végeztél a kvízzel!' + questionAsked + ':' + questionOrder.length);
  }
  {
    // hideAllExcept(questionOrder[questionAsked]);
  }
}



function countdownPause() {
  clearTimeout(countdown);
}
function countdownReset() {
  countdownPause();
  countdown = 30;
}

*/

'use strict'
let countdownNumberEl = document.getElementsByClassName('countdown-number');
let animation = document.getElementsByClassName('run-animation');
let countdown = 30;
let Timer;
let helyes;
let Pontszam = 0;
let QuizContainer = document.getElementsByClassName('answer');
let questionOrder = [];
questionOrder.length = 10;
let questionCount = 0;
let questionAsked = 0;


/*
window.onload = function() {
  while (questionCount < questionOrder.length) {
    hideAllExcept(questionOrder[questionAsked]);
    questionCount++;
  }
};
function hideAllExcept(question) {
  $('div.ques').hide();
  $('#ques' + question).show();
}*/
setInterval(function() {
  if (countdown = -- countdown < 0 ? 30 : countdown) {
    countdownNumberEl[0].textContent = countdown.toString();
    countdownNumberEl[1].textContent = countdown.toString();
  }
  else if (countdown === 0) {
    TimeRunsOut();
    countdownReset();
  }
}, 1000);



function TimeRunsOut() {
    clearInterval(Timer);

    if (Pontszam === 0) {
      Pontszam = 0;
      questionAsked++;
    }
    else if (Pontszam > 1000) {
      Pontszam -= 300;
      questionAsked++;
    }
    alert('Lejárt az időd! Kattints a továbblépéshez!');
    countdownReset();
    Circle();
    Answer();
}

function GoodAnswer() {
  clearInterval(Timer);
  if (countdown > 20) {
    Pontszam += 600;
    questionAsked++;
  }
  else if (countdown > 10) {
    Pontszam += 300;
    questionAsked++;
  }
  else if (countdown > 0) {
    Pontszam += 150;
    questionAsked++;
  }
  alert('Helyes válasz! Kattints a továbblépéshez!' + questionAsked + ':' + Pontszam);
  countdownReset();
  Circle();
  Answer();
}

function BadAnswer() {
  clearInterval(Timer);
  if (Pontszam === 0) {
    Pontszam = 0;
    questionAsked++;
  }
  else if (Pontszam > 1000) {
    Pontszam -= 500;
    questionAsked++;
  }
  alert('Helytelen válasz! Kattints a továbblépéshez!');
  countdownReset();
  Circle();
  Answer();
}

function Answer() {
  if (questionAsked === questionOrder.length) {
    alert('Végeztél a kvízzel!' + questionAsked + ':' + questionOrder.length);
  }
  {
    // hideAllExcept(questionOrder[questionAsked]);
  }
}

function countdownPause() {
  clearTimeout(countdown);
}
function countdownReset() {
  countdownPause();
  countdown = 30;
}


function Circle() {
  let circles = document.getElementsByTagName('circle');
  circles[0].style.animation = "none";
  circles[1].style.animation = "none";
  setTimeout(function(){
      circles[0].style.animation = null;
      circles[1].style.animation = null;
  }, 100);
}
