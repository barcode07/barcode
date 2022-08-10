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
  width: 100vw;
  height: 20px;
  background-color: #23272a;
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
  return (
    <HTML>
      <Bar />
      <Wrapper>
        <OutSideBar />
        <InnerLeftSideBar />
        <MainBox>
          <Header />
          <BodyBox>
            <Body />
            <InnerRightSideBar />
          </BodyBox>
        </MainBox>
      </Wrapper>
    </HTML>
  );
}
