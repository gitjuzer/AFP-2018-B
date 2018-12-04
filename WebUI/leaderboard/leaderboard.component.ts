import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { from } from 'rxjs';
import {leaderboard, playerID, player} from './phUsers';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css','./placeholder.css']
})
export class LeaderboardComponent implements OnInit {

  lb = leaderboard;
  ID = playerID;
  player = player;
  constructor() { }

  ngOnInit() {
  }
  // selectCurrentUser(user: User){
  //   leaderboard.forEach(element => {
  //     if(element.id === this.ID){
  //       //document.getElementById('top10').innerHTML = element.id.toString();
  //       return true;
  //     }
  //   });
  //}
}
