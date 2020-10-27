import { Component, OnDestroy, OnInit } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-chatroom',
  templateUrl: './chatroom.component.html',
  styleUrls: ['./chatroom.component.scss']
})
export class ChatroomComponent implements OnInit , OnDestroy {

  constructor() { }

  webSocketEndPoint = environment.wsURL;
  topic = '/topic/access';
  stompClient: any;
  public username: string;

  public messages = [];

  public message;

  public connected = false;

  public joined = false;

  ngOnInit() {
    const ws = new SockJS(this.webSocketEndPoint);
    this.stompClient = Stomp.over(ws);
    this.stompClient.connect({},  (frame) => {

      // TODO: Do somenthing when connecting ws
      console.log(frame);
   });
  }

  public connectWs() {
    this.stompClient.connect();
    this.connected = true;
  }

  public connectToChat() {
    this.joined = true;

    this.stompClient.subscribe('/topic/access',  (accessResponse) => {
      this.messages.push(JSON.parse(accessResponse.body));
    });
    this.stompClient.subscribe('/topic/chatroom', (chatResponse) => {
      this.messages.push(JSON.parse(chatResponse.body));
    });
    this.stompClient.send('/app/access', {}, JSON.stringify({username: this.username}));
  }

  public sendMessage() {
    this.stompClient.send('/app/chatroom', {}, JSON.stringify({username: this.username, content: this.message}));
    this.message = null;
  }

  public detectClass(message) {
    if (message.sender) { return 'text-center'; }
    if (message.username !== this.username) {return 'text-right'; }

  }

  ngOnDestroy(): void {
    this.stompClient.disconnect(() => console.log('disconnected'), {});
  }
}
