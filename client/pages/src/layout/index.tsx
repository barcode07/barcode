import styled from "styled-components";
import Header from "./Header";
import InnerLeftSideBar from "./innerLeftSidebar";
import InnerRightSideBar from "./innerRightSidebar";
import OutSideBar from "./outsidebar";

const HTML = styled.div`
  width: 100%;
  height: 300px;
  display: flex;
  flex-direction: row;
  justify-content: center;
`;

const BodyBox = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: row;
`;

export default function LayOut() {
  return (
    <HTML>
      <OutSideBar />
      <InnerLeftSideBar />
      <div>
        <Header />
        <BodyBox>
          <div>바디</div>
          <InnerRightSideBar />
        </BodyBox>
      </div>
    </HTML>
  );
}
