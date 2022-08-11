import styled from "styled-components";

export const HTML = styled.div`
  width: 100px;
  height: 100%;
  background-color: #23272a;
`;

export const Header = styled.div`
  width: 100%;
  height: 100px;
  background-color: #23272a;
  padding: 10px;
`;

export const Body = styled.div`
  width: 100%;
  height: calc(100% - 100px);
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #23272a;
  padding: 10px;
  border-top: 3px solid #4f545c;
`;

export const example = styled.div`
  width: 70px;
  height: 70px;
  border-radius: 50%;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  background-color: #4f545c;
  margin: 5px;
`;
