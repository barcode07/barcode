import styled from "styled-components";

export const HTML = styled.div`
  width: 100px;
  height: 100%;
  background-color: #23272a;
  overflow: hidden;
`;

export const Header = styled.div`
  width: 100%;
  height: 100px;
  background-color: #23272a;
  padding: 10px;
  user-select: none;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
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
  transition: 0.2s;
  cursor: pointer;
  :hover {
    background-color: #5865f2;
    border-radius: 35%;
  }
  user-select: none;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
`;

export const ItemBox = styled.div`
  position: relative;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  width: 100px;
  height: 100px;
  :hover {
    border-left: 3px solid white;
  }
`;

export const Bar = styled.div`
  position: absolute;
  top: 30px;
  right: 94px;
  width: 8px;
  height: 40px;
  background-color: white;
  border-radius: 20px;
`;
