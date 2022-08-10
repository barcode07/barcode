import styled from "styled-components";

export const Wrapper = styled.div`
  width: 100vw;
  height: 100vh;
  display: flex;
  align-items: center;
  background-image: url("/images/barcode.png");
  background-size: 1500px;
  background-repeat: no-repeat;
  background-position: center;
`;

export const LoginWrapper = styled.div`
  width: calc(100% - 30%);
  height: calc(100% - 40%);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  border: 1px solid #999999;
  border-radius: 40px;
  padding: 50px;
  background: #f5f5f5;
  margin-top: -100px;
  margin-left: auto;
  margin-right: auto;
  /* position: absolute;
  top: 120px;
  left: 240px; */
`;

export const Title = styled.h1``;

// 로그인
export const LoginEmailWrapper = styled.div`
  width: 100%;
`;
export const Label = styled.div`
  font-size: 20px;
  font-weight: 500;
`;
export const Input = styled.input`
  width: 100%;
  height: 50px;
  border: 1px solid #000000;
  border-radius: 20px;
`;
export const LoginPasswordWrapper = styled.div`
  width: 100%;
`;

// 회원가입 이동
export const SignUpWrapper = styled.div`
  width: 100%;
  display: flex;
`;
export const SignUpTitle = styled.div`
  font-size: 20px;
`;
export const SignUp = styled.div`
  font-size: 20px;
  margin-left: 30px;
  cursor: pointer;
`;

// 로그인 버튼
export const LoginButton = styled.button`
  width: calc(100% - 30%);
  height: 50px;
  border: none;
  border-radius: 20px;
  font-size: 20px;
  font-weight: 700;
  color: red;
  background: linear-gradient(
    to right,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white,
    black,
    white
  );
  cursor: pointer;
`;
