import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { from } from 'rxjs';
//import { leaderboard, playerID, player } from './phUsers';
import { HttpClient } from '@angular/common/http';
import { UserService } from './user.service';
import { Key } from 'protractor';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css', './placeholder.css'],
  providers: [UserService]
})
export class LeaderboardComponent implements OnInit {

  users: User[];
  currentTask: string = "Feladat1";
  
  //ID = localStorage.getItem("username")
  ID = "teszt";
  top: User[];
  
  constructor(private userService: UserService) { }

  ngOnInit() {
    this
      .userService
      .getLb()
      .subscribe((data: User[]) => {
        this.users = data;
      });
      //console.log(this.users);
      this.top = this.getCurrentTaskTopTen(this.users);
      //player: any = this.users.find(user => user.username === this.ID);
     
  }
  getCurrentTaskTopTen(users: User[]) {
    //console.log(users);
    let tmp: User[] = users.filter(user => user.task === this.currentTask);
    var top: User[] = tmp.sort(function(a, b) { return a.score < b.score ? 1 : -1; })
    .slice(0, 10);
    
    return top;
  }
  
}
