import styled from "styled-components";

export const HTML = styled.div`
  width: 300px;
  height: 100%;
  background-color: #23272a;
`;

export const Body = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  padding: 10px;
  background-color: #2f3136;
`;

export const MemberList = styled.div``;

export const MemberName = styled.div`
  height: 40px;
  padding-left: 10px;
  display: flex;
  flex-direction: row;
  align-items: center;
  font-size: 18px;
  color: rgba(255, 255, 255, 0.5);
  :hover {
    border-radius: 5px;
    background-color: rgba(255, 255, 255, 0.1);
  }
`;
