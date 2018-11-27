'use strict'
let countdownNumberEl = document.getElementsByClassName('countdown-number');
let animation = document.getElementsByClassName('run-animation');
let countdown = 30;
let Timer;
let helyes;
let Pontszam = 0;
let score = document.getElementById('score');
let valasz1 = document.getElementById('valasz1');
let valasz2 = document.getElementById('valasz2');
let valasz3 = document.getElementById('valasz3');
let valasz4 = document.getElementById('valasz4');
let kerdes = document.getElementById('question_text');
let QuizContainer = document.getElementsByClassName('answer');
let questionOrder = [
  ['2. kérdés', '2K1. válasz', '2K2. válasz', '2K3. válasz', '2K4. válasz'],
  ['3. kérdés', '3K1. válasz', '3K2. válasz', '3K3. válasz', '3K4. válasz'],
  ['4. kérdés', '4K1. válasz', '4K2. válasz', '4K3. válasz', '4K4. válasz'],
  ['5. kérdés', '5K1. válasz', '5K2. válasz', '5K3. válasz', '5K4. válasz'],
  ['6. kérdés', '6K1. válasz', '6K2. válasz', '6K3. válasz', '6K4. válasz'],
  ['7. kérdés', '7K1. válasz', '7K2. válasz', '7K3. válasz', '7K4. válasz'],
  ['8. kérdés', '8K1. válasz', '8K2. válasz', '8K3. válasz', '8K4. válasz'],
  ['9. kérdés', '9K1. válasz', '9K2. válasz', '9K3. válasz', '9K4. válasz'],
  ['10. kérdés', '10K1. válasz', '10K2. válasz', '10K3. válasz', '10K4. válasz'],
];
let questionCount = 0;
questionOrder.length = 9; /*questionCount*/
let questionAsked = 0;
let i = 0;

function Kerdes_Valasz_Hozzaad() {
    kerdes.innerText = questionOrder[i][0];
    valasz1.innerText = questionOrder[i][1];
    valasz2.innerText = questionOrder[i][2];
    valasz3.innerText = questionOrder[i][3];
    valasz4.innerText = questionOrder[i][4];
}


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
      score.innerText = Pontszam.toString();
    }
    else if (Pontszam > 1000) {
      Pontszam -= 300;
      score.innerText = Pontszam.toString();
    }
    alert('Lejárt az időd! Kattints a továbblépéshez!');
    countdownReset();
    questionAsked++;
    Kerdes_Valasz_Hozzaad();
    i++;
    Circle();
    Answer();
}

function GoodAnswer() {
  clearInterval(Timer);
  if (countdown > 20) {
    Pontszam += 600;
    score.innerText = Pontszam.toString();
  }
  else if (countdown > 10) {
    Pontszam += 300;
    score.innerText = Pontszam.toString();
  }
  else if (countdown > 0) {
    Pontszam += 150;
    score.innerText = Pontszam.toString();
  }
  alert('Helyes válasz! Kattints a továbblépéshez!');
  countdownReset();
  Circle();
  questionAsked++;
  Kerdes_Valasz_Hozzaad();
  i++;
  Answer();
}

function BadAnswer() {
  clearInterval(Timer);
  if (Pontszam === 0) {
    Pontszam = 0;
    score.innerText = Pontszam.toString();
  }
  else if (Pontszam > 1000) {
    Pontszam -= 500;
    score.innerText = Pontszam.toString();
  }
  alert('Helytelen válasz! Kattints a továbblépéshez!');
  countdownReset();
  questionAsked++;
  Kerdes_Valasz_Hozzaad();
  i++;
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
  const circles = document.getElementsByTagName('circle');
  circles[0].style.animation = 'none';
  circles[1].style.animation = 'none';
  setTimeout(function() {
      circles[0].style.animation = null;
      circles[1].style.animation = null;
  }, 100);
}
