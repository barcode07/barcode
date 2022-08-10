import styled from "styled-components";

export const HTML = styled.div`
  width: 100px;
  height: 100%;
  background-color: black;
`;

export const Header = styled.div`
  width: 100%;
  height: 50px;
  background-color: blue;
`;

export const Body = styled.div`
  width: 100%;
  height: calc(100% - 50px);
  display: flex;
  flex-direction: column;
  background-color: antiquewhite;
`;
