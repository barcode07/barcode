import styled from "@emotion/styled";
import { useEffect, useState } from "react";
import SockJS from "sockjs-client";
import { store } from "src/redux/store";
import Stomp from "stompjs";
/**
 * Author : Sukyung Lee
 * FileName: test2.tsx
 * Date: 2022-08-18 04:37:05
 * Description :
 */

export type message = {
  username: string;
  content: string;
};
// 아래 2줄은 컴포넌트 내부로 들어가면 배로 소켓이 생성되는것 같다.
let sockJS = new SockJS("http://localhost:8080/webSocket");
let stompClient: Stomp.Client = Stomp.over(sockJS);

const Test2 = () => {
  // 웹소켓 연결시 stomp에서 자동으로 연결되었다는 console을 보여주는데 그것을 보이지 않게 하는 용도
  stompClient.debug = () => {};

  const [contents, setContents] = useState<message[]>([]);
  const [username, setUsername] = useState(store.getState().user.nickname);
  const [message, setMessage] = useState("");
  const [roomId, setRoomId] = useState("1");

  store.subscribe(() => {
    setUsername(store.getState().user.nickname);
  });

  useEffect(() => {
    stompClient.connect({}, () => {
      stompClient.subscribe(`/topic/${roomId}`, (data: any) => {
        const newMessage: message = JSON.parse(data.body) as message;
        addMessage(newMessage);
      });
    });
  }, [contents]);

  useEffect(() => {
    return () => {
      stompClient.disconnect(() => {
        console.log("연결해제");
      });
    };
  }, []);

  const handleEnter = (username: string, content: string) => {
    const newMessage: message = { username, content };
    stompClient.send(`/hello/${roomId}`, {}, JSON.stringify(newMessage));
    setMessage("");
  };

  const addMessage = (message: message) => {
    setContents((prev) => [...prev, message]);
  };

  return (
    <Container>
      <Divider>
        <div className={"contents"}>
          {contents.map((message: any, index: number) => (
            <div key={index}>
              {message.username} : {message.content}{" "}
            </div>
          ))}
        </div>
        <div>
          {store.getState().user.nickname ? (
            <div> 닉네임 : {store.getState().user.nickname} </div>
          ) : (
            <div> 이름 없음 </div>
          )}
          <input
            placeholder="input your messages..."
            value={message}
            onChange={(e) => setMessage(e.target.value)}
          />
        </div>
        <button type="button" onClick={() => handleEnter(username, message)}>
          전송
        </button>
      </Divider>
      <button
        type="button"
        onClick={() => setRoomId(roomId === "1" ? "2" : "1")}
      >
        방 바꾸기 : {roomId}
      </button>
    </Container>
  );
};
export default Test2;
const Container = styled.div`
  width: 100%;
`;
const Divider = styled.div`
  border: 1px solid black;
  padding: 20px;
`;
