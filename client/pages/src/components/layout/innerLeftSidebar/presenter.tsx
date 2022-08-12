import * as IL from "./style";
import { v4 as uuidv4 } from "uuid";
import React from "react";

interface IInnerLeftSideBarProps {
  inServer: boolean;
  serverName: string;
  opened: string[];
  onClickGroupOpen: (event: React.MouseEvent<HTMLDivElement>) => void;
}

const menu = [{ title: "Boost" }, { title: "친구" }];

const list = [
  { name: "백승재" },
  { name: "이수경" },
  { name: "김선우" },
  { name: "정하일" },
  { name: "김지수" },
  { name: "여명현" },
  { name: "송인호" },
  { name: "백인호" },
  { name: "조영래" },
  { name: "안우엽" },
  { name: "노원두" },
  { name: "안효경" },
  { name: "한주연" },
  { name: "이영주" },
  { name: "이승훈" },
  { name: "이재홍" },
];

const Group = [
  {
    id: "frontend",
    name: "프론트엔드",
    list: {
      voice: ["보이스채널1", "보이스채널2", "보이스채널3"],
      chatting: ["채팅채널1", "채팅채널2", "채팅채널3"],
    },
  },
  {
    id: "backend",
    name: "백엔드",
    list: {
      voice: ["보이스채널1", "보이스채널2", "보이스채널3"],
      chatting: ["채팅채널1", "채팅채널2", "채팅채널3"],
    },
  },
  {
    id: "DB",
    name: "DB",
    list: {
      voice: ["보이스채널1", "보이스채널2", "보이스채널3"],
      chatting: ["채팅채널1", "채팅채널2", "채팅채널3"],
    },
  },
  {
    id: "server",
    name: "서버",
    list: {
      voice: ["보이스채널1", "보이스채널2", "보이스채널3"],
      chatting: ["채팅채널1", "채팅채널2", "채팅채널3"],
    },
  },
];

export default function InnerLeftSideBarPresenter(
  props: IInnerLeftSideBarProps
) {
  return (
    <IL.HTML>
      <IL.Header>
        {props.inServer ? (
          <IL.ServerName>{props.serverName}</IL.ServerName>
        ) : (
          <IL.InnerText placeholder="대화찾기 또는 시작하기" />
        )}
      </IL.Header>
      <IL.Body>
        {props.inServer ? (
          <IL.GroupBox>
            {Group.map((el) => (
              <IL.ChannelGroup key={uuidv4()}>
                <IL.GropName onClick={props.onClickGroupOpen} id={el.id}>
                  # {el.name}
                </IL.GropName>
                {props.opened.includes(el.id) ? (
                  <div>
                    {el.list.voice.map((el) => (
                      <IL.channel key={uuidv4()}>{el}</IL.channel>
                    ))}
                    {el.list.chatting.map((el) => (
                      <IL.channel key={uuidv4()}>{el}</IL.channel>
                    ))}
                  </div>
                ) : (
                  <div></div>
                )}
              </IL.ChannelGroup>
            ))}
          </IL.GroupBox>
        ) : (
          <div>
            {menu.map((el: { title: string }) => (
              <IL.BodyUpperItemBox key={uuidv4()}>
                <IL.BodyUpperItem>{el.title}</IL.BodyUpperItem>
              </IL.BodyUpperItemBox>
            ))}

            <IL.MessageMenu>
              <IL.MessageMenuText>Direct Message</IL.MessageMenuText>
              <IL.AddMessageIcon>+</IL.AddMessageIcon>
            </IL.MessageMenu>
            {list.map((el: { name: string }) => (
              <IL.BodyUpperItemBox key={uuidv4()}>
                <IL.BodyUnderItem>{el.name}</IL.BodyUnderItem>
              </IL.BodyUpperItemBox>
            ))}
          </div>
        )}
      </IL.Body>
      <IL.Footer>
        <IL.ProgramArea>프로그램창</IL.ProgramArea>
        <IL.StatusArea>상태</IL.StatusArea>
        <IL.ProfileArea>프로필</IL.ProfileArea>
      </IL.Footer>
    </IL.HTML>
  );
}
