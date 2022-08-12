import styled from "styled-components";
// #393939
// #2D2D2D

export const HTML = styled.div`
  width: 300px;
  height: 100%;
  background-color: #23272a;
`;

export const Header = styled.div`
  width: 100%;
  height: 60px;
  background-color: #2f3136;
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
  height: calc(100% - 300px);
  display: flex;
  flex-direction: column;
  background-color: #2f3136;
  padding: 8px;
  padding-top: 15px;
  overflow-y: scroll;
  ::-webkit-scrollbar {
    display: block;
    width: 8px;
  }
  ::-webkit-scrollbar-thumb {
    background: #23272a;
    border-radius: 20px;
  }
`;

export const GroupBox = styled.div`
  display: flex;
  flex-direction: column;
`;

export const ChannelGroup = styled.div`
  display: flex;
  flex-direction: column;
  color: rgba(255, 255, 255, 0.5);
  margin-bottom: 10px;

  ::-webkit-scrollbar {
    display: block;
    width: 8px;
  }
  ::-webkit-scrollbar-thumb {
    background: #23272a;
    border-radius: 20px;
  }
`;

export const GropName = styled.div`
  cursor: pointer;
  padding-bottom: 10px;
  :hover {
    color: white;
  }
`;

export const channel = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  height: 30px;
  padding-left: 10px;
  padding-bottom: 5px;
  cursor: pointer;
  :hover {
    color: white;
    border-radius: 5px;
    background-color: rgba(255, 255, 255, 0.1);
  }
`;

export const BodyUpperItemBox = styled.div``;

export const BodyUpperItem = styled.div`
  padding: 5px 10px;
  color: rgba(255, 255, 255, 0.5);
  font-size: 20px;
  margin-bottom: 10px;
  cursor: pointer;
  :hover {
    color: white;
    border-radius: 10px;
    background-color: rgba(255, 255, 255, 0.1);
  }
`;

export const MessageMenu = styled.div`
  color: rgba(255, 255, 255, 0.5);
  margin: 10px 0;
  padding: 10px;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  :hover {
    color: white;
  }
`;

export const MessageMenuText = styled.div`
  cursor: default;
  :hover {
    color: white;
  }
`;

export const AddMessageIcon = styled.div`
  color: rgba(255, 255, 255, 0.7);
  font-size: 30px;
  cursor: pointer;
  :hover {
    color: white;
  }
`;

export const BodyUnderItemBox = styled.div``;

export const BodyUnderIcon = styled.img``;

export const BodyUnderItem = styled.div`
  padding: 5px 10px;
  color: rgba(255, 255, 255, 0.5);
  font-size: 20px;
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

export const ServerName = styled.div`
  width: 100%;
  border-radius: 8px;
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

export const Footer = styled.div`
  height: 240px;
  background-color: #2f3136;
  border-top: 1px solid #4c4c4c;
  /* padding: 15px 10px; */
`;

export const ProfileArea = styled.div`
  height: 80px;
  padding: 5px 10px;
`;

export const StatusArea = styled.div`
  height: 80px;
  border-bottom: 1px solid #4c4c4c;
  padding: 5px 10px;
`;

export const ProgramArea = styled.div`
  height: 80px;
  border-bottom: 1px solid #4c4c4c;
  padding: 5px 10px;
`;
