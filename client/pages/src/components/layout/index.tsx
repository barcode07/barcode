import { useState } from "react";
import styled from "styled-components";
import Body from "./body";
import Header from "./Header";
import InnerLeftSideBar from "./innerLeftSidebar";
import InnerRightSideBar from "./innerRightSidebar";
import OutSideBar from "./outsidebar";

// #23272A
// #4f545c;

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
  height: 100%;
  flex-direction: row;
`;

const Bar = styled.div`
  width: 100%;
  height: 35px;
  padding-top: 2px;
  padding-left: 15px;
  background-color: #23272a;
  font-weight: 500;
  color: rgba(255, 255, 255, 0.7);
`;

const BodyBox = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: row;
`;

const MainBox = styled.div`
  width: calc(100vw - 400px);
  height: calc(100% - 70px);
`;

export default function LayOut() {
  const [rightBarHide, setRightBarHide] = useState(false);
  const onClickMoveToChannel = () => {
    setRightBarHide(true);
  };
  const onClickMoveToMain = () => {
    setRightBarHide(false);
  };
  return (
    <HTML>
      <Bar>Bar code</Bar>
      <Wrapper>
        <OutSideBar
          onClickMoveToMain={onClickMoveToMain}
          onClickMoveToChannel={onClickMoveToChannel}
        />
        <InnerLeftSideBar />
        <MainBox>
          <Header />
          <BodyBox>
            <Body rightBarHide={rightBarHide} />
            {!rightBarHide ? <></> : <InnerRightSideBar />}
          </BodyBox>
        </MainBox>
      </Wrapper>
    </HTML>
  );
}
