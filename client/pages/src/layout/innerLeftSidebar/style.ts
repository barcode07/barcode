import styled from "styled-components";

export const HTML = styled.div`
  width: 300px;
  height: 100%;
  background-color: #23272a;
`;

export const Header = styled.div`
  width: 100%;
  height: 70px;
  background-color: #4f545c;
  /* background-color: white; */
  border-top-left-radius: 15px;
  border-bottom: 1px solid rgba(0, 0, 0, 0.5);
  padding: 10px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
`;

export const Body = styled.div`
  width: 100%;
  height: calc(100% - 70px);
  display: flex;
  flex-direction: column;
  background-color: #4f545c;
  padding: 10px;
`;

export const BodyItemBox = styled.div``;

export const BodyItem = styled.div`
  padding: 5px 10px;
  color: rgba(255, 255, 255, 0.5);
  font-size: 22px;
  margin-bottom: 10px;
  cursor: pointer;
  :hover {
    color: white;
    border-radius: 10px;
    background-color: rgba(255, 255, 255, 0.1);
  }
`;

export const InnerText = styled.input`
  width: 100%;
  height: 40px;
  border-radius: 8px;
  background-color: #23272a;
  border: none;
  padding-left: 10px;
  color: white;
  font-weight: 500;
  outline: none;
  ::placeholder {
    color: white;
    opacity: 0.5;
  }
`;
