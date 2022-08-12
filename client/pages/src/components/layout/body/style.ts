import styled from "styled-components";

export const HTML = styled.div`
  width: ${(props: { inServer: boolean }) =>
    !props.inServer ? "100%" : "calc(100% - 300px)"};
  height: 100%;
  background-color: #36393f;
`;

export const Body = styled.div`
  width: 100%;
  padding: 10px;
`;
