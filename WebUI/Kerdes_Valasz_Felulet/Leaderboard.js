var leaderboard = [
    { name: "Gipsz Jakab", score: 6969 },
    { name: "Kiss Pista", score: 5000 },
    { name: "Micimackó", score: 4800 },
    { name: "Kis Piroska", score: 3000 },
    { name: "Kis Piroska2", score: 2999 },
    { name: "Kis Piroska", score: 2995 },
    { name: "Kis Piroska", score: 2678 },
    { name: "Kis Piroska", score: 2587 },
    { name: "xxL33Tsniper420xx", score: 200 }
]
var player = { name: "Micimackó", score: 4800 };


function FillLeaderboard() {
    var table = document.getElementById("top10");
    for (let i = 0; i < leaderboard.length; i++) {
        const element = leaderboard[i];
        var tr = table.appendChild(document.createElement('TR'));
        var td0 = document.createElement('TD');
        var td = document.createElement('TD');
        var td2 = document.createElement('td');
        td.appendChild(document.createTextNode(element.name));
        td2.appendChild(document.createTextNode(element.score));
        tr.appendChild(td0);
        tr.append(td);
        tr.append(td2);
        if (element.name === player.name) {
            tr.classList.add('playerTable');
        }
    }
    AddResultScore();
}
function AddResultScore() {
    document.getElementById('player').append(player.score);
   
}