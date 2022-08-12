import { useState } from "react";
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
  height: calc(100% - 80px);
`;

const BodyBox = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: row;
`;

export default function LayOut() {
  const [inServer, setInServer] = useState(false);
  const onClickMoveToChannel = () => {
    setInServer(true);
  };
  const onClickMoveToMain = () => {
    setInServer(false);
  };
  return (
    <HTML>
      <Bar>Bar code</Bar>
      <Wrapper>
        <OutSideBar
          onClickMoveToMain={onClickMoveToMain}
          onClickMoveToChannel={onClickMoveToChannel}
        />
        <InnerLeftSideBar inServer={inServer} />
        <MainBox>
          <Header />
          <BodyBox>
            <Body inServer={inServer} />
            {!inServer ? <></> : <InnerRightSideBar />}
          </BodyBox>
        </MainBox>
      </Wrapper>
    </HTML>
  );
}
