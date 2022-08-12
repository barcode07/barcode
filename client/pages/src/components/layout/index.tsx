import React, { useState } from "react";
import styled from "styled-components";
import Body from "./body";
import Header from "./Header";
import InnerLeftSideBar from "./innerLeftSidebar";
import InnerRightSideBar from "./innerRightSidebar";
import OutSideBar from "./outsidebar";

// #23272A
// #4f545c;
// #2f3136(innerLeftSideBarBody)
// #36393f(body, bodyHeader)
// #454950
// #b9bbbe(icon)
// #292b2f(footer)
// #42464d(selected)
// #3c3f45(leftSideBarHover)

const HTML = styled.div`
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
  /* justify-content: center; */
  color: white;
`;

const Wrapper = styled.div`
  display: flex;
  height: calc(100% - 35px);
  flex-direction: row;
`;

const Bar = styled.div`
  width: 100%;
  height: 35px;
  /* padding-top: 2px; */
  /* padding-left: 15px; */
  background-color: #23272a;
  font-weight: 500;
  color: rgba(255, 255, 255, 0.7);
`;

const MainBox = styled.div`
  width: calc(100% - 400px);
  height: calc(100% - 60px);
`;

const BodyBox = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: row;
`;

const dummy = [
  {
    name: "귀찮다",
    member: ["백승재", "김지수", "이수경", "김선우", "정하일"],
  },
  {
    name: "어렵다",
    member: ["여명현", "이재홍", "백인호", "송인호", "조영래"],
  },
  {
    name: "구조가이게뭐냐",
    member: ["노원두", "안우엽", "안효경", "이승훈", "이영주"],
  },
];

export default function LayOut() {
  const [inServer, setInServer] = useState(false);
  const [serverName, setServerName] = useState("");
  const onClickMoveToChannel = (event: React.MouseEvent<HTMLDivElement>) => {
    setInServer(true);
    setServerName((event.target as HTMLDivElement).innerText);
  };
  const onClickMoveToMain = () => {
    setInServer(false);
  };
  return (
    <HTML>
      <Bar>Bar code</Bar>
      <Wrapper>
        <OutSideBar
          dummy={dummy}
          onClickMoveToMain={onClickMoveToMain}
          onClickMoveToChannel={onClickMoveToChannel}
        />
        <InnerLeftSideBar inServer={inServer} serverName={serverName} />
        <MainBox>
          <Header />
          <BodyBox>
            <Body inServer={inServer} />
            {!inServer ? (
              <></>
            ) : (
              <InnerRightSideBar serverName={serverName} dummy={dummy} />
            )}
          </BodyBox>
        </MainBox>
      </Wrapper>
    </HTML>
  );
}
